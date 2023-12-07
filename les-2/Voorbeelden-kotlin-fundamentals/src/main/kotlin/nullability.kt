fun main() {
    var name: String? = "Matthias"

//    name = null
    printName3(name)
    printName3(null)
}

fun printName(name: String?) {
    println("naamlengte = ${name?.length}")
}

fun printName2(name: String?) {
    if (name != null) {
        println("naamlengte = ${name.length}")
    } else {
        println("Naam is null")
    }
}

fun printName3(name: String?) {
    val nameLength = name?.length ?: 0

    println("naamlengte = $nameLength")
}