package lesson_2

fun main() {
    task4Step1()
    task4Step2()
}

fun task4Step1() {
    // var rocks: Int = null
    // error: null can not be a value of a non-null type Int

    var marbles: Int? = null
}

fun task4Step2() {
    var fishFoodTreats = 6
    if (fishFoodTreats != null) {
        fishFoodTreats = fishFoodTreats.dec()
    }

    fishFoodTreats = fishFoodTreats?.dec()

    fishFoodTreats = fishFoodTreats?.dec() ?: 0

    // val len = s!!.length
    // throws NullPointerException if s is null
}