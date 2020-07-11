package lesson_6.example

data class Fish(var name: String)

fun main() {
    fishExamples()
    runExample()
}

fun fishExamples() {
    val fish = Fish("splashy")  // all lowercase
    myWith(fish.name) {
        println(capitalize())
    }

    fish.run {
        name
    }

    val fish2 = Fish(name = "splashy").apply {
        name = "sharky"
    }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })
    println(fish)
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun runExample() {
    JavaRun.runNow {
        println("Last parameter is a lambda as a Runnable")
    }
}