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
fun String.`has exactly one adjacent pair`() = this.groupBy { it }.any { it.value.size == 2 }

fun part1(range: IntRange) = range.filter {
    val password = it.toString()
    password.`is ascending`() && password.`has any adjacent pair`()
}.size

fun part2(range: IntRange) = range.filter {
    val password = it.toString()
    password.`is ascending`() && password.`has exactly one adjacent pair`()
}.size

fun main() {
    val range = parsePasswordRange("day4")
    println("p1: ${part1(range)}")
    println("p2: ${part2(range)}")
}