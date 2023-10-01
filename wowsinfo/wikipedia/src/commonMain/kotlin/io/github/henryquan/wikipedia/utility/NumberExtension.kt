package io.github.henryquan.wikipedia.utility

import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Round the number to the given number of digits
 * - If the number is null, NaN, or infinite, return "-"
 * - 1.2345.toFixedDigits(2) -> "1.23"
 * - 1.toFixedDigits(2) -> "1.00"
 */
fun Number?.toFixedDigits(fractionDigits: Int): String {
    if (this == null) return "-"
    when (this) {
        is Double -> if (isNaN() || isInfinite()) return "-"
        is Float -> if (isNaN() || isInfinite()) return "-"
    }

    val original = this.toDouble()
    val multiplier = 10.0.pow(fractionDigits)
    val roundedString = ((original * multiplier).roundToInt() / multiplier).toString()
    val dotIndex = roundedString.indexOf('.')
    return if (dotIndex == -1) {
        roundedString + "." + "0".repeat(fractionDigits)
    } else {
        val missingDigits = fractionDigits - (roundedString.length - dotIndex - 1)
        if (missingDigits > 0) {
            roundedString + "0".repeat(missingDigits)
        } else {
            roundedString
        }
    }
}

/**
 * Convert the number to a display string with 2 digits
 */
fun Number?.toDisplayString(): String {
    return toFixedDigits(2)
}

/**
 * Convert the number as it is to a percent string
 * - Use [toPercentString] to convert the number with a multiplier, then convert to a percent string
 */
fun Number?.asPercentString(): String {
    if (this == null) return "-"
    return "${toDisplayString()}%"
}

fun Number?.toPercentString(multiplier: Int = 100): String {
    if (this == null) return "-"
    return (toDouble() * multiplier).asPercentString()
}
