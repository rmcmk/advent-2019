package me.ryleykimmel.advent.day4

fun parsePasswordRange(name: String): IntRange {
    val parts = ClassLoader.getSystemResourceAsStream(name)
        .bufferedReader()
        .readLine()
        .split("-")
        .map { it.toInt() }
    return IntRange(parts[0], parts[1])
}

fun String.`is ascending`() = this.split("").sorted().joinToString("") { it } == this
fun String.`has any adjacent pair`() = this.filterIndexed { index, s -> s == this.elementAtOrNull(index + 1)}.isNotEmpty()

fun part1(range: IntRange) = range.filter {
    val password = it.toString()
    password.`is ascending`() && password.`has any adjacent pair`()
}.size

fun main() {
    println("p1: ${part1(parsePasswordRange("day4"))}")
}