fun main() {
    val myPhone = MobilePhone("Samsung", 5)

    myPhone.turnOn()

    println(myPhone.merk)

    myPhone.helderheid = 1
    myPhone.helderheid = 7

    myPhone.turnOff()
}

class Person(val phone: MobilePhone, val laptop: Laptop?)

class Laptop : Device()

class MobilePhone(merk: String, initieleHelderheid: Int) : Device(merk, initieleHelderheid) {
    var phoneNumber: String? = null

    override fun turnOn() {
        super.turnOn()
        println("Phone has been turned on.")
    }
}

open class Device(val merk: String, initieleHelderheid: Int = 5) {

    constructor() : this("Unknown")

    var helderheid = initieleHelderheid
        set(value) {
            if (value in 0..10) {
                field = value
            }
        }

    init {
        println("Device created")
    }


    open fun turnOn() {
        println("Device is turning on")
    }

    fun turnOff() {
        println("Device is turning off")
    }
}