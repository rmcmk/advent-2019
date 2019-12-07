package me.ryleykimmel.advent.day3

class Tile {
    private val visits = hashSetOf<Wire>()

    fun visit(wire: Wire) = visits.add(wire)
    fun clear() = visits.clear()
    fun intersects() = visits.size > 1
}