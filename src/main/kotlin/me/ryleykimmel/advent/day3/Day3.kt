package me.ryleykimmel.advent.day3

import me.ryleykimmel.advent.day3.Direction.Companion.toDirection

fun parseWire(name: String) = ClassLoader.getSystemResourceAsStream(name)
    .bufferedReader()
    .readLines()
    .map { line ->
        val moves = arrayListOf<Move>()
        line.split(",").forEach {
            val direction = it[0].toDirection()
            val steps = it.drop(1).toInt()
            moves += Move(direction, steps)
        }
        Wire(moves)
    }

fun part1(wires: List<Wire>): Int {
    val map = Map()
    wires.forEach(map::visit)

    return map.tiles.filter { it.value.intersects() }
        .map { it.key }
        .map(Position.ORIGIN::distance)
        .min() ?: error("Unable to find intersection!")
}

fun main() {
    part1(parseWire("day3"))
}