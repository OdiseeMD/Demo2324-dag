fun main() {

    val people = listOf(
        Persoon("John", "Doe", 12),
        Persoon("Jane", "Doe", 23),
        Persoon("Frans", "Peters", 34),
        Persoon("Mia", "Peters", 45)
    )

    people.forEach {
        println(it)
    }

    val fullnames = people.map {
        "${it.voornaam} ${it.familieNaam}"
    }

    println(fullnames)

    val meerderjarigen = people.filter { it.leeftijd > 18 }
    println(meerderjarigen)

    val families = people.groupBy { it.familieNaam }

    families.forEach {
        println(it)
    }

    val leeftijdCategory = people.groupBy { it.leeftijd > 18 }

    leeftijdCategory.forEach {
        println(it)
    }

    val totaalLeeftijd = people.fold(0) { acc, persoon ->
        acc + persoon.leeftijd
    }

    val totaalLeeftijd2 = people.sumOf { it.leeftijd }

    val sortedNames = people.sortedBy { it.voornaam }
}

data class Persoon(val voornaam: String, val familieNaam: String, val leeftijd: Int)