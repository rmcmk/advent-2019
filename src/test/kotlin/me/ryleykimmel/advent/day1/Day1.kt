package me.ryleykimmel.advent.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1 {

    @Test
    fun `test part 1 known solutions`() {
        assertEquals(2, Module(12).requiredFuel())
        assertEquals(2, Module(14).requiredFuel())
        assertEquals(654, Module(1969).requiredFuel())
        assertEquals(33583, Module(100756).requiredFuel())
    }

    @Test
    fun `test part 1 answer`() {
        val modules = parseModules()
        assertEquals(3239890, part1(modules))
    }

    @Test
    fun `test part 2 known solutions`() {
        assertEquals(2, Module(14).totalFuelRequirement())
        assertEquals(966, Module(1969).totalFuelRequirement())
        assertEquals(50346, Module(100756).totalFuelRequirement())
    }

    @Test
    fun `test part 2 answer`() {
        val modules = parseModules()
        assertEquals(4856963, part2(modules))
    }
}