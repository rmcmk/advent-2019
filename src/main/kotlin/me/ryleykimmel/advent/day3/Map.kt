package me.ryleykimmel.advent.day3

class Map {
    val tiles = mutableMapOf<Position, Tile>()

    fun visit(wire: Wire) {
        var position = Position.ORIGIN
        var delay = 0
        wire.moves.forEach { move ->
            repeat(move.steps) {
                position = position.translate(move.direction)

                tiles.getOrPut(position) { Tile() }.apply {
                    delay += 1
                    visit(wire, delay)
                }
            }
        }
    }
}