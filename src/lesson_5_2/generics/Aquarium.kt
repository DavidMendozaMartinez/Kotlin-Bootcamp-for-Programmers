package lesson_5_2.generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        // check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        println("water added")
    }
}

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) = waterSupply.addChemicalCleaners()
}

fun main() {
    genericsExample()
}

fun genericsExample() {
    val aquarium = Aquarium(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")

    // val aquarium2 = Aquarium("string")
    // inferred type String is not a subtype of WaterSupply
    // println(aquarium2.waterSupply)

    // val aquarium3 = Aquarium(null)
    // inferred type Nothing? is not a subtype of WaterSupply
    // if (aquarium3.waterSupply == null) {
    //    println("waterSupply is null")
    //}

    // val aquarium4 = Aquarium(LakeWater())
    // aquarium4.addWater()
    // Exception in thread "main" java.lang.IllegalStateException: water supply needs processing first at
    // Aquarium.generics.Aquarium.addWater(Aquarium.kt:21)
    // aquarium4.waterSupply.filter()
    // aquarium4.addWater()

    val aquarium5 = Aquarium(TapWater())
    addItemTo(aquarium5)

    val cleaner = TapWaterCleaner()
    aquarium5.addWater(cleaner)

    val aquarium6 = Aquarium(TapWater())
    isWaterClean(aquarium6)

    println(aquarium6.hasWaterSupplyOfType<TapWater>())   // true

    println(aquarium6.waterSupply.isOfType<TapWater>())

    println(aquarium6.hasWaterSupplyOfType<TapWater>())
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R