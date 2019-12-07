package me.ryleykimmel.advent.day3

class Tile {
    private val visits = hashMapOf<Wire, Int>()

    fun visit(wire: Wire, delay: Int) = visits.put(wire, delay)
    fun clear() = visits.clear()
    fun intersects() = visits.size > 1
    fun delay() = visits.values.sum()
}