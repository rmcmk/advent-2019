package me.ryleykimmel.advent.intcode

class IntcodeComputer(private val memory: MutableList<Int>) {
    private val instructions = hashMapOf(
        OP_ADD to AddInstruction(),
        OP_MULTI to MultiplyInstruction()
    )

    private var position = 0

    fun peek(position: Int) = memory[position]
    fun get(offset: Int) = memory[position + offset]
    fun set(position: Int, value: Int) {
        memory[position] = value
    }
    fun dereference(offset: Int) = memory[get(offset)]
    fun skip(positions: Int) {
        position += positions
    }

    fun memoryCopy() = memory.toMutableList()

    fun step() {
        while (true) {
            val opcode = peek(position)
            if (opcode == OP_EXIT) break
            val instruction = instructions[opcode] ?: error("Unexpected opcode: $opcode")

            instruction.step(this)
        }
    }

    companion object {
        const val OP_ADD = 1
        const val OP_MULTI = 2
        const val OP_EXIT = 99
    }
}