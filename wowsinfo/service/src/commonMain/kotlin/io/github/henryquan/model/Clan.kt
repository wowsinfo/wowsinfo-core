package io.github.henryquan.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

typealias ClanList = List<Clan>
typealias ClanDetailMap = Map<String, ClanDetail>
typealias ClanPlayerDataMap = Map<String, ClanPlayerData>
typealias ClanBattleSeasonStatsMap = Map<String, ClanBattleSeasonStats>

//region Clan

@JsExport
@Serializable
data class Clan(
    @SerialName("clan_id") val clanId: String,
    @SerialName("created_at") val createdAt: Long,
    @SerialName("members_count") val membersCount: Int,
    val name: String,
    val tag: String
)

//endregion

//region Clan details

@JsExport
@Serializable
data class ClanDetail(
    @SerialName("members_count") val membersCount: Int,
    val name: String,
    @SerialName("creator_name")
    val creatorName: String,
    @SerialName("created_at") val createdAt: Long,
    val tag: String,
    @SerialName("updated_at") val updatedAt: Long,
    @SerialName("leader_name") val leaderName: String,
    @SerialName("members_ids") val membersIds: List<Long>,
    @SerialName("creator_id") val creatorId: Long,
    @SerialName("clan_id") val clanId: Long,
    val members: Map<String, ClanMember>,
    @SerialName("old_name") val oldName: String,
    @SerialName("is_clan_disbanded") val isClanDisbanded: Boolean,
    @SerialName("renamed_at") val renamedAt: Long,
    @SerialName("old_tag") val oldTag: String,
    @SerialName("leader_id") val leaderId: Long,
    val description: String
)

@JsExport
@Serializable
data class ClanMember(
    val role: String,
    @SerialName("joined_at") val joinedAt: Long,
    @SerialName("account_id") val accountId: Long,
    @SerialName("account_name") val accountName: String
)

//endregion

//region Clan player data

@JsExport
@Serializable
data class ClanPlayerData(
    val role: String,
    @SerialName("clan_id") val clanId: Long,
    @SerialName("joined_at") val joinedAt: Long,
    @SerialName("account_id") val accountId: Long,
    @SerialName("account_name") val accountName: String
)

//endregion

//region Clan battles season stats

@JsExport
@Serializable
data class ClanBattleSeasonStats(
    val seasons: List<GeneralBattleStats>,
    @SerialName("account_id") val accountId: String,
)

//endregion