package model.gamedata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameSkill(
    @SerialName("LogicTrigger")
    val logicTrigger: LogicTrigger,
    val canBeLearned: Boolean,
    val isEpic: Boolean,
    val modifiers: GameModifier,
    val skillType: Int,
    val uiTreatAsTrigger: Boolean,
    val name: String,
    val description: String,
)

@Serializable
data class LogicTrigger(
    val burnCount: Double,
    val changePriorityTargetPenalty: Double,
    val consumableType: String,
    val coolingDelay: Double,
    val coolingInterpolator: List<List<Double>>,
    val dividerType: String,
    val dividerValue: Double,
    val duration: Double,
    val energyCoeff: Double,
    val floodCount: Double,
    val heatInterpolator: List<List<Double>>,
    val modifiers: GameModifier,
    val triggerDescIds: String,
    val triggerType: String
)
