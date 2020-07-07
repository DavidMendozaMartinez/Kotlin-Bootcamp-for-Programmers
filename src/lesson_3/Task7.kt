package lesson_3

fun main() {
    task7Step1()
    task7Step2()
}

fun task7Step1() {
    var dirtyLevel = 20
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter(dirtyLevel))
}

fun task7Step2() {
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))
    println(updateDirty(15, ::increaseDirty))

    var dirtyLevel = 19;
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23 }
    println(dirtyLevel)
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty(start: Int) = start + 1