package me.ryleykimmel.advent.day3

enum class Direction(val literal: Char) {
    UP('U'),
    DOWN('D'),
    LEFT('L'),
    RIGHT('R');

    fun translateX() = when (this) {
        LEFT -> -1
        RIGHT -> 1
        else -> 0
    }

    fun translateY() = when (this) {
        UP -> 1
        DOWN -> -1
        else -> 0
    }

    companion object {
        private val directions = values().associateBy(Direction::literal)
        fun Char.toDirection() = directions[this] ?: error("Invalid direction $this.")
    }
}