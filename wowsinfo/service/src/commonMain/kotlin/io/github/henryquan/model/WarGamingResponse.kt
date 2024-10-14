package io.github.henryquan.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport
@Serializable
data class WarGamingResponse<T>(
    val status: String,
    val meta: WarGamingMeta? = null,
    val data: T? = null,
) {
    val isOk: Boolean
        get() = status == "ok" && data != null

    val getOrThrow: T
        get() = data ?: throw IllegalStateException("Data is invalid")
}

@JsExport
@Serializable
data class WarGamingMeta(
    val count: Int,
    val hidden: Int? = null,
    @SerialName("page_total") val pageTotal: Int? = null,
    val total: Int? = null,
    val limit: Int? = null,
    val page: Int? = null,
)
