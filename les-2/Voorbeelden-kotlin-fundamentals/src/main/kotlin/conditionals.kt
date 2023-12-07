import java.time.LocalDateTime

fun main() {
    // ifElseExample()
    // ifElseIfExample()
    // trafficLightExample()
    // weekdaysExample()
    // weatherExample()
    ifSelectieAlsExpressie()
    whenSelectieAlsExpressie()
}

fun whenSelectieAlsExpressie() {
    val isFreezing = true
    val isRaining = false

    val textToPrint = when {
        isFreezing && isRaining -> "Pas op voor ijzel"
        isFreezing && !isRaining -> "Doe een dikke jas, het is koud"
        !isFreezing && isRaining -> "Neem een paraplu mee"
        else -> "Het is mooi weer"
    }

    println(textToPrint)
}

fun ifSelectieAlsExpressie() {
    val time = LocalDateTime.now()

    val result = if (time.hour >= 6 && time.hour < 11) {
        "Goeiemorgen"
    } else if (time.hour >= 11 && time.hour < 17) {
        "Goeiemiddag"
    } else if (time.hour >= 17 && time.hour < 23) {
        "Goeieavond"
    } else {
        "Goeienacht"
    }

    println(result)
}

fun weatherExample() {
    val isFreezing = true
    val isRaining = false

    when {
        isFreezing && isRaining -> println("Pas op voor ijzel")
        isFreezing && !isRaining -> println("Doe een dikke jas, het is koud")
        !isFreezing && isRaining -> println("Neem een paraplu mee")
        else -> println("Het is mooi weer")
    }
}

fun weekdaysExample() {
    val dayNumber = 4

    when (dayNumber) {
        in 1..5 -> println("Weekdag")
        6, 7 -> println("Weekend")
    }
}

fun trafficLightExample() {
    val trafficLightColor = "Groen"

    when (trafficLightColor) {
        "Rood" -> println("Stop")
        "Oranje" -> {
            println("Begin maar te remmen")
        }

        "Groen" -> {
            println("Rijden maar!")
        }

        else -> println("Onmogelijke status")

    }
}

private fun ifElseIfExample() {
    val time = LocalDateTime.now()

    if (time.hour >= 6 && time.hour < 11) {
        println("Goeiemorgen")
    } else if (time.hour >= 11 && time.hour < 17) {
        println("Goeiemiddag")
    } else if (time.hour >= 17 && time.hour < 23) {
        println("Goeieavond")
    } else {
        println("Goeienacht")
    }
}

private fun ifElseExample() {
    val isEvening = false

    if (isEvening) {  // == , > , < , >=, <=, !=, &&, ||, !
        println("Het is donker buiten")
    } else {
        println("De zon schijnt")
    }
}