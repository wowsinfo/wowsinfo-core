package utility

fun Double?.toFixedString(fractionDigits: Int): String {
    if (this == null) return "-"
    if (isNaN() || isInfinite()) return "-"
    return "%.${fractionDigits}f".format(this)
}

fun Number.toDecimalString(): String {
    // Overall, NumberFormat is the best
    val formatter = NumberFormat.getInstance()
    formatter.minimumFractionDigits = 0
    formatter.maximumFractionDigits = 2
    return formatter.format(this)
}

fun Number.asPercentString(): String {
    return "${toDecimalString()}%"
}

fun Number.toPercentString(): String {
    return (this.toDouble() * 100).asPercentString()
}