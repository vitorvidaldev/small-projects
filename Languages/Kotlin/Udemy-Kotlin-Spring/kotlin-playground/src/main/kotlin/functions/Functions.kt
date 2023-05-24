package functions

fun main() {
    printName("Vitor")
    val result = addition(1, 2)
    println("Result is $result")
}

fun addition(a: Int, b: Int): Int {
    return a + b
}

fun printName(name: String) {
    println("Name is: $name")
}
