fun main() {
    var intPakket: Pakket<Int>? = Pakket<Int>(42)
    val stringPakket = Pakket<String>("Demo", PakketGrootte.LARGE)
    val booleanPakket = Pakket<Boolean>(true, PakketGrootte.SMALL)

    println(intPakket)
    println(stringPakket)
    println(booleanPakket)

    if (intPakket == Pakket<Int>(42)) {
        println("Gelijk")
    } else {
        println("Niet gelijk")
    }

    val intPakketCopy = intPakket?.copy(grootte = PakketGrootte.SMALL)

    val postbodeJan = Postbode("Jan")
    val postbodeTom = Postbode("Tom")

    postbodeTom.leverPakketAf(intPakket!!, success = true)
    postbodeJan.leverPakketAf(booleanPakket, success = false)
    postbodeJan.leverPakketAf(stringPakket, success = true)


    println("Er zijn ${Postbode.Statistieken.afgeleverdePakketten} correct geleverd")
    println("Er zijn ${Postbode.nietAfgeleverdePakketten} niet correct geleverd")

    println("percentage ${Postbode.percentageAfgeleverdePakketten}")

    println(5.isOdd)
    println("Hello World".duplicate(5))

    5.print()

    intPakket.print()


    intPakket = getNullPacket()
    println(intPakket?.inhoud)
    println(intPakket?.grootte)

    intPakket?.let {
        println(it.inhoud)
        println(it.grootte)
    }
}

fun getNullPacket(): Pakket<Int>? {
    return null
}

data class Pakket<T>(val inhoud: T, val grootte: PakketGrootte = PakketGrootte.MEDIUM)

enum class PakketGrootte {
    SMALL,
    MEDIUM,
    LARGE
}

interface PostService {
    fun GaNaarVolgendAddress()
}

class Postbode(val name: String) : PostService {

    companion object Statistieken {
        var afgeleverdePakketten: Int = 0
        var nietAfgeleverdePakketten: Int = 0
    }

    override fun GaNaarVolgendAddress() {

    }

    fun <T> leverPakketAf(pakket: Pakket<T>, success: Boolean) {
        if (success) {
            afgeleverdePakketten++
        } else {
            Statistieken.nietAfgeleverdePakketten++
        }
    }
}

val Postbode.Statistieken.percentageAfgeleverdePakketten: Int
    get() {
        return afgeleverdePakketten * 100 / (afgeleverdePakketten + nietAfgeleverdePakketten)
    }

val Int.isOdd: Boolean
    get() {
        return this % 2 == 1
    }

fun String.duplicate(number: Int): String {
    var s = ""
    repeat(number) {
        s += this
    }
    return s
}

fun Any.print() {
    println(this)
}
/*object Statistieken {
    var afgeleverdePakketten: Int = 0
    var nietAfgeleverdePakketten: Int = 0
}*/


/*
class IntPakket(val inhoud: Int)

class StringPakket(val inhoud: String)

class BooleanPakket(val inhoud: Boolean)

class DoublePakket(val inhoud: Double)*/
