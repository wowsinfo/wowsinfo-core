package io.github.henryquan.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport
@Serializable
data class WarGamingResponse<T>(
    val status: String,
    val meta: WarGamingMeta?,
    val data: T?
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
    val hidden: Int?,
    @SerialName("page_total")
    val pageTotal: Int?,
    val total: Int?,
    val limit: Int?,
    val page: Int?,
)

@JsExport
@Serializable
data class Player(
    @SerialName("account_id")
    val accountId: Int,  // numeric field for account ID
    val nickname: String   // string field for player name
)
