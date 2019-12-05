package me.ryleykimmel.advent.intcode

class AddInstruction : Instruction {
    override fun step(computer: IntcodeComputer) {
        val first = computer.dereference(1)
        val second = computer.dereference(2)
        val store = computer.get(3)
        computer.set(store, first + second)
        computer.skip(4)
    }
}