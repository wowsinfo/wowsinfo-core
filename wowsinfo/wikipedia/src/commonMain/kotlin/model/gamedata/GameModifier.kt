package model.gamedata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.absoluteValue

/**
 * Keys that should not be included in the description
 */
private val ignoreList = arrayOf(
    "affectedClasses"
)

/**
 * The value starts from 1.0. These modifiers can be something like 1.2, 0.8, etc.
 * - All keys starting with `coef` can be considered as a percentage.
 * - `Coef`, `Multiplier`, `Factor`, `Time`, `Prob` are included by default
 */
private val coeffList = arrayOf(
    "AAAuraDamage",
    "AABubbleDamage",
    "AAMaxHP",
    "GMIdealRadius",
    "GMMaxDist",
    "GMMaxHP",
    "GMRotationSpeed",
    "GMShotDelay",
    "GSIdealRadius",
    "GSMaxDist",
    "GSMaxHP",
    "GSShotDelay",
    "GTMaxHP",
    "GTRotationSpeed",
    "GTShotDelay",
    "afterBattleRepair",
    "torpedoBomberHealth",
    "skipBomberHealth",
    "planeHealth",
    "fighterHealth",
    "diveBomberHealth",
    "planeSpeed",
    "planeSpawnTime",
    "planeRegenerationRate",
    "shootShift",
    "gmShotDelay", // custom reload booster modifier
    "planeEmptyReturnSpeed",
    "collisionDamageApply",
    "collisionDamageNerf",
)

/**
 * The value starts with 0 and minus this modifier value
 */
private val negativeCoeff = arrayOf(
    "SGRepairTime"
)

/**
 * Similar to [coeffList] but the value starts from 0.
 * - `Coeff` will be included here, make sure to filter this first`
 */
private val coeffListZero = arrayOf(
    "buoyancyRudderResetTimeCoeff", // not sure about this one
    "damagedEngineCoeff", // not sure
    "lastChanceReloadCoefficient", // not sure
    "reloadBoostCoeff", // not sure
    "burnChanceFactorBig",
    "burnChanceFactorSmall",
    "rocketBurnChanceBonus",
    "regenerationRate",
    "boostCoeff", // engine boost
    "artilleryBurnChanceBonus",
)

/**
 * These modifiers add a percentage to the value, like +7%
 */
private val numberPercentage = arrayOf(
    "uwCoeffBonus"
)

/**
 * These modifiers are written as something like 0.005, but it should be 0.5%
 */
private val rawPercentage = arrayOf(
    "regenerationHPSpeed"
)

/**
 * These modifiers add one +1 to the value (e.g. consumable charges)
 * - `Additional` and `Extra` are included by default
 */
private val additionalList = arrayOf(
    "AAExtraBubbles",
    "AAInnerExtraBubbles",
    "additionalConsumables",
    "torpedoBomberAimingTime",
    "fighterAimingTime",
    "skipBomberAimingTime",
    "dcNumPacksBonus",
)

/**
 * `dist` is for distance in km
 */
private val distList = arrayOf(
    "radius"
)

/**
 * These modifiers are written in raw distance like 7500.0, convert it to 7.5km
 */
private val rawDistList = arrayOf(
    "acousticWaveRadius",
    "visionXRayTorpedoDist"
)

/**
 * `time` is for time in seconds
 */
private val timeList = arrayOf(
    "workTime",
    "torpedoReloadTime",
    "reloadTime",
    "preparationTime",
    "lifeTime"
)

@Serializable
data class GameModifier(
    @SerialName("AAAuraDamage") val aaAuraDamage: ModifierShipType?,
    @SerialName("AAAuraReceiveDamageCoeff") val aaAuraReceiveDamageCoeff: Double?,
    @SerialName("AABubbleDamage") val aaBubbleDamage: ModifierShipType?,
    @SerialName("AAExtraBubbles") val aaExtraBubbles: Int?,
    @SerialName("AAInnerExtraBubbles") val aaInnerExtraBubbles: Int?,
    @SerialName("AAMaxHP") val aaMaxHp: Int?,
    @SerialName("ConsumableReloadTime") val consumableReloadTime: ModifierShipType?,
    @SerialName("ConsumablesWorkTime") val consumablesWorkTime: Double?,
    @SerialName("GMAPDamageCoeff") val gmapDamageCoeff: Double?,
    @SerialName("GMBigGunVisibilityCoeff") val gmBigGunVisibilityCoeff: Double?,
    @SerialName("GMCritProb") val gmCritProb: Double?,
    @SerialName("GMHECSDamageCoeff") val gmhecsDamageCoeff: Double?,
    @SerialName("GMHeavyCruiserCaliberDamageCoeff") val gmHeavyCruiserCaliberDamageCoeff: Double?,
    @SerialName("GMIdealRadius") val gmIdealRadius: Double?,
    @SerialName("GMMaxDist") val gmMaxDist: Double?,
    @SerialName("GMMaxHP") val gmMaxHp: Double?,
    @SerialName("GMRepairTime") val gmRepairTime: Double?,
    @SerialName("GMRotationSpeed") val gmRotationSpeed: ModifierShipType?,
    @SerialName("GMShotDelay") val gmShotDelay: Double?,
    @SerialName("GSIdealRadius") val gsIdealRadius: Double?,
    @SerialName("GSMaxDist") val gsMaxDist: Double?,
    @SerialName("GSMaxHP") val gsMaxHp: Int?,
    @SerialName("GSShotDelay") val gsShotDelay: Double?,
    @SerialName("GTCritProb") val gtCritProb: Double?,
    @SerialName("GTMaxHP") val gtMaxHp: Int?,
    @SerialName("GTRepairTime") val gtRepairTime: Double?,
    @SerialName("GTRotationSpeed") val gtRotationSpeed: Double?,
    @SerialName("GTShotDelay") val gtShotDelay: Double?,
    @SerialName("PMDetonationProb") val pmDetonationProb: Double?,
    @SerialName("SGCritProb") val sgCritProb: Double?,
    @SerialName("SGCritRudderTime") val sgCritRudderTime: Double?,
    @SerialName("SGRepairTime") val sgRepairTime: Double?,
    @SerialName("SGRudderTime") val sgRudderTime: Double?,
    val absoluteBuff: String?,
    val acousticWaveRadius: Double?,
    val activationDelay: Double?,
    val additionalConsumables: Double?,
    val affectedClasses: List<String>?,
    val afterBattleRepair: Double?,
    val airDefenseDispReloadCoeff: Double?,
    val airDefenseDispWorkTimeCoeff: Double?,
    val allyAuraBuff: String?,
    val ammo: String?,
    val areaDamageMultiplier: Double?,
    val artilleryAlertEnabled: Boolean?,
    val artilleryAlertMinDistance: Double?,
    val artilleryBoostersReloadCoeff: Double?,
    val artilleryBurnChanceBonus: ModifierShipType?,
    val artilleryDistCoeff: Double?,
    val asMaxHealthCoeff: Double?,
    val asReloadTimeCoeff: Double?,
    val backwardEngineForsag: Double?,
    val backwardEngineForsagMaxSpeed: Double?,
    val batteryCapacityCoeff: Double?,
    val batteryRegenCoeff: Double?,
    val bombAlphaDamageMultiplier: Double?,
    val bombApAlphaDamageMultiplier: Double?,
    val bombBurnChanceBonus: Double?,
    val boostCoeff: Double?,
    val bubbleDamageMultiplier: Double?,
    val buoyancyRudderResetTimeCoeff: Double?,
    val buoyancyRudderTimeCoeff: Double?,
    val buoyancyState: Double?,
    val burnChanceFactorBig: Double?,
    val burnChanceFactorHighLevel: Double?,
    val burnChanceFactorLowLevel: Double?,
    val burnChanceFactorSmall: Double?,
    val burnProb: Double?,
    val burnTime: Double?,
    val callFightersAdditionalConsumables: Double?,
    val callFightersAirOnly: Boolean?,
    val callFightersAppearDelay: Double?,
    val callFightersRadiusCoeff: Double?,
    val callFightersTimeDelayAttack: Double?,
    val callFightersWorkTimeCoeff: Double?,
    val canUseOnEmpty: Boolean?,
    val climbAngle: Double?,
    val collisionDamageApply: Double?,
    val collisionDamageNerf: Double?,
    val condition: String?,
    val conditionalBuff: String?,
    val consumableType: String?,
    val crashCrewAdditionalConsumables: Double?,
    val crashCrewReloadCoeff: Double?,
    val crashCrewWorkTimeCoeff: Double?,
    val creditsFactor: Double?,
    val crewExpFactor: Double?,
    val critProbCoefficient: Double?,
    val criticalChance: Double?,
    val damagedEngineCoeff: Double?,
    val dcAlphaDamageMultiplier: ModifierShipType?,
    val dcNumPacksBonus: Double?,
    val dcSplashRadiusMultiplier: Double?,
    val descIDs: String?,
    val distShip: Int?,
    val distTorpedo: Int?,
    val distanceToKill: Int?,
    val diveBomberAccuracyIncRateCoeff: Double?,
    val diveBomberHealth: Double?,
    val diveBomberMaxSpeedMultiplier: Double?,
    val diveBomberMinSpeedMultiplier: Double?,
    val diveBomberSpeedMultiplier: Double?,
    val dogFightTime: Int?,
    val effectOnEndLongivity: Int?,
    val engineBackwardForsageMaxSpeed: Int?,
    val engineBackwardForsagePower: Double?,
    val engineBackwardUpTime: Double?,
    val engineCritProb: Double?,
    val engineForwardForsageMaxSpeed: Double?,
    val engineForwardForsagePower: Double?,
    val engineForwardUpTime: Double?,
    val engineRepairTime: Double?,
    val expFactor: Double?,
    val extraFighterCount: Int?,
    val fighterAccuracyIncRateCoeff: Double?,
    val fighterAimingTime: Int?,
    val fighterHealth: Double?,
    val fighterReloadCoeff: Double?,
    val fightersName: String?,
    val fightersNum: Int?,
    val fireResistanceEnabled: Boolean?,
    val firstSectorTimeCoeff: Double?,
    val floodChanceFactor: Double?,
    val floodChanceFactorPlane: Double?,
    val floodProb: Double?,
    val floodTime: Double?,
    val flyAwayTime: Int?,
    val forwardEngineForsag: Int?,
    val forwardEngineForsagMaxSpeed: Int?,
    val freeExpFactor: Int?,
    val healForsageReloadCoeff: Double?,
    val healthPerLevel: ModifierShipType?,
    val height: Int?,
    val hlCritTimeCoeff: Double?,
    val hydrophoneUpdateFrequencyCoeff: Double?,
    val hydrophoneWaveSpeedCoeff: Int?,
    val iconIDs: String?,
    val ignorePtzBonus: Int?,
    val lastChanceReloadCoefficient: Double?,
    val lifeTime: Int?,
    val logic: String?,
    val maxBuoyancySpeedCoeff: Double?,
    val nearEnemyIntuitionEnabled: Boolean?,
    val nearRlsEnabled: Boolean?,
    val numConsumables: Int?,
    val penetrationCoeffHe: Double?,
    val pingerCritProb: Double?,
    val pingerRepairTime: Double?,
    val pingerWaveSpeedCoeff: Double?,
    val planeBubbleArmorCoeff: Double?,
    val planeConsumablesWorkTime: Double?,
    val planeEmptyReturnSpeed: Double?,
    val planeEscapeHeightCoeff: Double?,
    val planeExtraHangarSize: Int?,
    val planeForsageTimeCoeff: Double?,
    val planeHealth: Double?,
    val planeHealthPerLevel: Int?,
    val planeMaxSpeedMultiplier: Double?,
    val planeRegenerationRate: Double?,
    val planeSpawnTime: Double?,
    val planeSpeed: Double?,
    val planeTorpedoArmingTimeCoeff: Double?,
    val planeTorpedoSpeedMultiplier: Double?,
    val planeVisibilityFactor: Double?,
    val preparationTime: Int?,
    val prioritySectorCooldownMultiplier: Double?,
    val prioritySectorStrengthBonus: Int?,
    val priorityTargetEnabled: Boolean?,
    val radius: Int?,
    val regenCrewAdditionalConsumables: Int?,
    val regenCrewReloadCoeff: Double?,
    val regenCrewWorkTimeCoeff: Double?,
    val regenerateHealthAdditionalConsumables: Int?,
    val regenerateHealthWorkTimeCoeff: Double?,
    val regenerationHpSpeed: Int?,
    val regenerationHpSpeedUnits: Int?,
    val regenerationRate: Double?,
    val reloadBoostCoeff: Double?,
    val reloadTime: Int?,
    val restoreForsage: Boolean?,
    val rlsWorkTimeCoeff: Double?,
    val rocketApAlphaDamageMultiplier: Double?,
    val rocketBurnChanceBonus: Double?,
    val scoutAdditionalConsumables: Int?,
    val scoutReloadCoeff: Double?,
    val scoutWorkTimeCoeff: Double?,
    val secondSectorTimeCoeff: Double?,
    val selfAuraBuff: String?,
    val shootShift: Double?,
    val skipBomberAccuracyIncRateCoeff: Double?,
    val skipBomberAimingTime: Int?,
    val skipBomberHealth: Double?,
    val skipBomberSpeedMultiplier: Double?,
    val smokeGeneratorLifeTime: Double?,
    val smokeGeneratorWorkTimeCoeff: Double?,
    val softCriticalEnabled: Boolean?,
    val sonarWorkTimeCoeff: Double?,
    val source: List<String>?,
    val spawnBackwardShift: Double?,
    val speedBoostersWorkTimeCoeff: Double?,
    val speedCoef: Double?,
    val speedLimit: Double?,
    val startDelayTime: Int?,
    val startDistance: Int?,
    val switchAmmoReloadCoef: Double?,
    val target: List<String>?,
    val targetBuff: String?,
    val timeDelayAttack: Int?,
    val timeFromHeaven: Int?,
    val timeToTryingCatch: Int?,
    val timeWaitDelayAttack: Int?,
    val titleIDs: String?,
    val torpedoBomberAccuracyIncRateCoeff: Double?,
    val torpedoBomberAimingTime: Int?,
    val torpedoBomberHealth: Double?,
    val torpedoDamageCoeff: Double?,
    val torpedoDetectionCoefficient: Double?,
    val torpedoDetectionCoefficientByPlane: Int?,
    val torpedoFullPingDamageCoeff: Double?,
    val torpedoReloadTime: Int?,
    val torpedoReloaderReloadCoeff: Double?,
    val torpedoSpeedMultiplier: Double?,
    val torpedoVisibilityFactor: Double?,
    val underwaterMaxRudderAngleCoeff: Int?,
    val updateFrequency: Int?,
    val uwCoeffBonus: Int?,
    val visibilityDistCoeff: ModifierShipType?,
    val visibilityFactor: Double?,
    val visibilityForSubmarineCoeff: Double?,
    val visionXRayTorpedoDist: Int?,
    val waveDistance: Int?,
    val waveParams: String?,
    val weaponTypes: List<String>?,
    val workTime: Int?,
    val zoneLifetime: Double?,
    val zoneRadius: Double?,
) {
    val consumableCount: String?
        get() {
            val count = numConsumables ?: return null
            if (count == -1) return "∞"
            return count.toString()
        }

    fun formatNumber(value: Double): String {
        if (value == 1.0) return "+1"
        var adjustedValue = value
        // TODO: need to find a better way, this is more or less a hack
        // TODO: we shouldn't adjust the value based on its value
        if (value < 0.35) {
            // if the number is too small, we need to add 1 to make it positive
            adjustedValue = value + 1
        }
        val positive = adjustedValue > 1
        val offset = ((adjustedValue - 1).absoluteValue * 100)
        return "${if (positive) "+" else "-"}$offset%"
    }
}

@Serializable
data class ModifierShipType(
    val airCarrier: Double?,
    val auxiliary: Double?,
    val battleship: Double?,
    val cruiser: Double?,
    val destroyer: Double?,
    val submarine: Double?,
)
