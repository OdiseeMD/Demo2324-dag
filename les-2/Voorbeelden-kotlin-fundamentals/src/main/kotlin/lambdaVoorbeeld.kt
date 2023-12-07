fun main() {

    val treinDisplayPrinter: () -> Unit

    val getDelayString: (String, Int) -> String

    getDelayString = { timeString, delay ->
        val delayString = "$timeString + $delay min"
        delayString
    }

    treinDisplayPrinter = printDisplay(false, getDelayString) { println(it) }

    treinDisplayPrinter()

}

fun printDisplay(
    isOnTime: Boolean,
    delayString: ((String, Int) -> String)? = null,
    printer: (String) -> Unit
): () -> Unit {
    val printOnTime = {
        printer("🚂 is op tijd")
    }

    val printToLate = {
        printer("🚂 heeft vertraging")
        if (delayString != null) {
            printer(delayString("13:00", 5))
        }
    }

    return if (isOnTime) {
        printOnTime
    } else {
        printToLate
    }
}
