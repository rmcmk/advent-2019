package me.ryleykimmel.advent.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3 {

    @Test
    fun `test part 1 known solutions`() {
        assertEquals(6, part1(parseWire("day3-test1")))
        assertEquals(159, part1(parseWire("day3-test2")))
        assertEquals(135, part1(parseWire("day3-test3")))
    }

    @Test
    fun `test part 1 answer`() {
        assertEquals(2180, part1(parseWire("day3")))
    }

    @Test
    fun `test part 2 known solutions`() {
        assertEquals(30, part2(parseWire("day3-test1")))
        assertEquals(610, part2(parseWire("day3-test2")))
        assertEquals(410, part2(parseWire("day3-test3")))
    }

    @Test
    fun `test part 2 answer`() {
        assertEquals(112316, part2(parseWire("day3")))
    }
}