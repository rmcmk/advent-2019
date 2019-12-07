package me.ryleykimmel.advent.day3

import kotlin.math.abs

data class Position(private val x: Int, private val y: Int) {
    fun distance(other: Position) = abs(x - other.x) + abs(y - other.y)
    fun translate(direction: Direction) = Position(
        x + direction.translateX(),
        y + direction.translateY()
    )

    companion object {
        val ORIGIN = Position(0, 0)
    }
}