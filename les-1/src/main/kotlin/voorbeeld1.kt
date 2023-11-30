fun main() {
    val naam = "Matthias"
    var age = 21

    age = 12
    println("Hello $naam, je bent geboren op ${2023 - age}, Je naam telt ${naam.count()} karakters")
    printHelloWorld()
    println(getHelloWorld())

    printNaam(age = age, naam = naam)
    printNaam(age = age)
    printNaam(34)

}

fun printHelloWorld() {
    println("Hello World!")
}

fun getHelloWorld(): String {
    return "Hello World"
}

fun printNaam(age: Int, naam: String = "World") {
    println("$naam - $age")
}