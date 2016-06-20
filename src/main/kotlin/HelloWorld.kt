import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 * Created by piyushchauhan on 7/06/2016.
 */

fun <T> maxH(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (it in collection)
        if (max == null || less(max, it))
            max = it
    return max
}

data class ClassWithPair(val name: Pair<String, String>, val age: Int)

fun main(args: Array<String>) {
    println("Hello, World!")
    val greeting = Greeting("Piyush", 25);
    println(greeting)

    val anotherGreeting = greeting.copy(name = "Kartikey")
    anotherGreeting.age = 23
    println("another greeting $anotherGreeting")
    println("original greeting unchanged $greeting")

    val greetingCopy = greeting.copy()
    println("new greeting copy: $greetingCopy")

    val list = listOf(7, 5, 3, 2)
    list.reversed()
    val newList = list.sortedBy { it % 3 }
    println("newList $newList");

    println(sum(2, 3))
    printSum(5, 9)
    println()
    println("Greeting is $greeting")

    println("max is ${max(2,3)}")

    val x = parseInt("1")
    val y = parseInt("null")

    if ( x != null && y != null) {
        println(max(x, y))
    }

    cases(23)
    cases("Hello")
    cases("Piyush")
    cases(4L)
    cases(1)
    cases(false)

    for(i in 1..10)
        println("i is $i")

    val names = listOf("KPiyush", "Kartikey", "Mithun", "KPMG")
    names
        .filter { it.startsWith("K") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    val point = Pair("Piyush", 25)
    println(point)

    println("Resource ${Resource.name}")

    val tuple = Triple("Piyush", 25, 98.5)
    println(tuple)

    val people = listOf(Person("Piyush", 26), Person("Mithun", 25), Person("Kartikey", 24))
    val sortedPeople = people.sorted()
    println(sortedPeople)

    val sortedByPeople = people.sortedBy { -it.age }
    println(sortedByPeople)

    val strings = listOf("Piyush", "Kartikey", "Mithun")
    val result = strings.maxBy { it.length }
    println("result $result")

    val maxString = maxH(strings, { a, b -> a.length < b.length })
    println("maxString $maxString")

    var me = BruceWayne(Batman(), RichyRich())
    me.inWater()
    print("Is awesomely rich? ${me.isAwesomelyRich()}")

    val mapper: ObjectMapper = jacksonObjectMapper()

    val json = """{"name":{"first":"John","second":"Smith"},"age":30}"""
    val expected = ClassWithPair(Pair("John", "Smith"), 30)

    println(mapper.writeValueAsString(expected))
    val stateObj = mapper.readValue<ClassWithPair>(json)
    println(stateObj)

    val doc: Document = Jsoup.connect("http://en.wikipedia.org/").get();
    val newsHeadlines: Elements = doc.select("#mp-itn b a");
    println(newsHeadlines)
}

object Resource {
    val name = "Name"
}

fun sum(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    print(sum(a, b))
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? = try { str.toInt() } catch (e: Exception) { null }

fun cases(obj: Any): Unit {
    when(obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

interface Superpower {
    fun inWater()
    fun onAir()
    fun onSoil()
}

interface Wealth {
    fun isAwesomelyRich(): Boolean
}

class Batman(): Superpower {
    companion object {
        fun create() = Batman()
    }

    override fun inWater() {
        println("Ack, cannot swim")
    }

    override fun onAir() {
        println("Requires vehicle")
    }

    override fun onSoil() {
        println("Awesome")
    }

    fun isFun(): Boolean {
        return false
    }
}

class RichyRich : Wealth {
    override fun isAwesomelyRich(): Boolean {
        return true
    }
}

class BruceWayne(a: Batman, b: RichyRich) : Superpower by a, Wealth by b