import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

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

class RangeRegulator(initialValue: Int, private val minRange: Int, private val maxRange: Int) :
    ReadWriteProperty<Any?, Int> {
    private var _value: Int = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return _value
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minRange..maxRange) {
            _value = value
        }
    }
}

open class Device(val merk: String, initieleHelderheid: Int = 5) {

    constructor() : this("Unknown")

    var helderheid by RangeRegulator(5, 1, 10)

    var batterijPercentage by RangeRegulator(100, 0, 100)

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