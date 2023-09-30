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
    val burnCount: Float,
    val changePriorityTargetPenalty: Float,
    val consumableType: String,
    val coolingDelay: Float,
    val coolingInterpolator: List<List<Float>>,
    val dividerType: String,
    val dividerValue: Float,
    val duration: Float,
    val energyCoeff: Float,
    val floodCount: Float,
    val heatInterpolator: List<List<Float>>,
    val modifiers: GameModifier,
    val triggerDescIds: String,
    val triggerType: String
)
