package lesson_2

fun main() {
    task2Step1()
    task2Step2()
    task2Step3()
    task2Step4()
}

fun task2Step1() {
    println(1 + 1)
    println(53 - 3)
    println(50 / 10)
    println(1.0 / 2.0)
    println(2.0 * 3.5)

    println(6 * 50)
    println(6.0 * 50.0)
    println(6.0 * 50)

    println(2.times(3))
    println(3.5.plus(4))
    println(2.4.div(2))
}

fun task2Step2() {
    val i: Int = 6
    val b1 = i.toByte()
    println(b1)

    val b2: Byte = 1 // OK, literals are checked statically
    println(b2)

    // val i1: Int = b2
    // error: type mismatch: inferred type is Byte but Int was expected

    // val i2: String = b2
    // error: type mismatch: inferred type is Byte but String was expected

    // val i3: Double = b2
    // error: type mismatch: inferred type is Byte but Double was expected

    val i4: Int = b2.toInt() // OK!
    println(i4)

    val i5: String = b2.toString()
    println(i5)

    val i6: Double = b2.toDouble()
    println(i6)

    val oneMillion = 1_000_000
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
}

fun task2Step3() {
    var fish = 1
    fish = 2

    val aquarium = 1
    // aquarium = 2
    // error: val cannot be reassigned

    var fishes: Int = 12
    var lakes: Double = 2.5
}

fun task2Step4() {
    val numberOfFish = 5
    val numberOfPlants = 12
    println("I have $numberOfFish fish" + " and $numberOfPlants plants")
    println("I have ${numberOfFish + numberOfPlants} fish and plants")
}