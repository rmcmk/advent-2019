package me.ryleykimmel.advent.day2

import me.ryleykimmel.advent.intcode.IntcodeComputer

fun createIntcodeComputer() = IntcodeComputer(
    ClassLoader.getSystemResourceAsStream("day2")
        .bufferedReader()
        .readLine()
        .split(",")
        .map(String::toInt)
        .toMutableList()
)

fun IntcodeComputer.part1(): Int {
    set(1, 12)
    set(2, 2)
    step()
    return peek(0)
}

fun main() {
    val computer = createIntcodeComputer()
    println("p1: ${computer.part1()}")
}