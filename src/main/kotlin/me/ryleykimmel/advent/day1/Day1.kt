package me.ryleykimmel.advent.day1

fun parseModules() = ClassLoader.getSystemResourceAsStream("day1")
    .bufferedReader()
    .readLines()
    .map(String::toInt)
    .map(::Module)

fun part1(modules: List<Module>) = modules.sumBy(Module::requiredFuel)

fun part2(modules: List<Module>) = modules.sumBy { it.totalFuelRequirement() }

fun main() {
    val modules = parseModules()
    println("p1: ${part1(modules)}")
    println("p2: ${part2(modules)}")
}