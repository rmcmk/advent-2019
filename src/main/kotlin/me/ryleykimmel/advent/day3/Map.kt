package me.ryleykimmel.advent.day3

class Map {
    val tiles = mutableMapOf<Position, Tile>()

    fun visit(wire: Wire) {
        var position = Position.ORIGIN
        wire.moves.forEach { move ->
            repeat(move.steps) {
                position = position.transform(move.direction)

                val tile = tiles.getOrPut(position) { Tile() }
                tile.visit(wire)
            }
        }
    }
}