package lesson_5_1

fun main() {
    println("Does it have spaces?".hasSpaces())

    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // what will it print?

    println(aquariumPlant.isGreen)

    val plant2: AquariumPlant? = null
    plant2.pull()
}

fun String.hasSpaces() = find { it == ' ' } != null

open class AquariumPlant(val color: String, private val size: Int)

fun AquariumPlant.isRed() = color == "red"    // OK
// fun AquariumPlant.isBig() = size > 50      // gives error
// error: cannot access 'size': it is private in 'AquariumPlant'

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}