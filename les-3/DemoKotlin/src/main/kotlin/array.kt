fun main() {
    array()
    map()
}

fun array() {
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(numbers[5])
    numbers[5] = 100
    println(numbers[5])
    // numbers[20] = 1000 => Werkt niet

    for (number in numbers) {
        println(number)
    }
}

fun lists() {
    val list1 = listOf(1, 2, 3, 4, 5)
    val list2 = mutableListOf(1, 2, 3, 4, 5)

    list2[1] = 100

}


fun set() {
    val voorbeeld = setOf(1, 2, 3, 3)
    println(voorbeeld)

    val voorbeeld2 = mutableSetOf<String>()

    voorbeeld2.add("Demo")
    voorbeeld2.add("omed")
    voorbeeld2.add("Demo")

    println(voorbeeld2)
}

fun map() {

    val scores = mapOf("Jonas" to 12, "Bart" to 20, "Marie" to 15)
    println(scores["Jonas"])

    val scores2 = mutableMapOf<String, Double>()

    for (score in scores) {
        println(score.key)
        println(score.value)
    }

    for ((student, score) in scores) {
        println(student)
        println(score)
    }
}
// List => geen vaste lengte, niet aanpasbaar
// Array => heeft vaste lengte, wel aanpasbaar
// MutableList => geen vaste lengte, wel aanpasbaar