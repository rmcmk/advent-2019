package me.ryleykimmel.advent.day2

import me.ryleykimmel.advent.intcode.IntcodeComputer

val memory = ClassLoader.getSystemResourceAsStream("day2")
    .bufferedReader()
    .readLine()
    .split(",")
    .map(String::toInt)
    .toMutableList()

fun createIntcodeComputer(): IntcodeComputer {
    return IntcodeComputer(memory.toMutableList())
}

fun IntcodeComputer.part1() = process(12, 2)

fun part2(expected: Int): Int {
    (0..99).forEach { noun ->
        (0..99).forEach { verb ->
            val computer = createIntcodeComputer()
            if (computer.process(noun, verb) == expected) {
                return 100 * noun + verb
            }
        }
    }
    error("Unable to find an answer!")
}

fun IntcodeComputer.process(noun: Int, verb: Int): Int {
    this.noun = noun
    this.verb = verb
    step()
    return peek(0)
}

fun main() {
    val computer = createIntcodeComputer()
    println("p1: ${computer.part1()}")
    println("p2: ${part2(19690720)}")
}