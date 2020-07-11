package lesson_6

data class Fish(val name: String)

fun main() {
    task4Step1()
    task4Step2()
}

fun task4Step1() {
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(30))
}

fun task4Step2() {
    val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))
    println(myFish.filter { it.name.contains("i") })
    println(myFish.filter { it.name.contains("i") }.joinToString(", ") { it.name })
}