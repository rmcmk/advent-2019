package me.ryleykimmel.advent.day2

import me.ryleykimmel.advent.intcode.IntcodeComputer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2 {

    private fun test(expected: List<Int>, input: List<Int>) {
        val computer = IntcodeComputer(input.toMutableList())
        computer.step()
        assertEquals(expected, computer.memory)
    }

    @Test
    fun `test part 1 known solutions`() {
        test(
            expected = arrayListOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50),
            input = mutableListOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50)
        )

        test(
            expected = arrayListOf(2, 0, 0, 0, 99),
            input = mutableListOf(1, 0, 0, 0, 99)
        )

        test(
            expected = arrayListOf(2, 3, 0, 6, 99),
            input = mutableListOf(2, 3, 0, 3, 99)
        )

        test(
            expected = arrayListOf(2, 4, 4, 5, 99, 9801),
            input = mutableListOf(2, 4, 4, 5, 99, 0)
        )

        test(
            expected = arrayListOf(30, 1, 1, 4, 2, 5, 6, 0, 99),
            input = mutableListOf(1, 1, 1, 4, 99, 5, 6, 0, 99)
        )
    }

    @Test
    fun `test part 1 answer`() {
        val computer = createIntcodeComputer()
        assertEquals(3516593, computer.part1())
    }

    @Test
    fun `test part 2 known solutions`() {
        assertEquals(1202, part2(3516593))
    }

    @Test
    fun `test part 2 answer`() {
        assertEquals(7749, part2(19690720))
    }

}