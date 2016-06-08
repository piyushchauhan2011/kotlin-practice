/**
 * Created by piyushchauhan on 7/06/2016.
 */

fun main(args: Array<String>) {
    println("Hello, World!")
    val greeting = Greeting("Piyush", 25);
    println(greeting)

    val greetingCopy = greeting.copy()
    println("new greeting copy: $greetingCopy")

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