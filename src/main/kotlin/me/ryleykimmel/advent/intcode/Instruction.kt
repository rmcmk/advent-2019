package me.ryleykimmel.advent.intcode

interface Instruction {
    fun step(computer: IntcodeComputer)
}