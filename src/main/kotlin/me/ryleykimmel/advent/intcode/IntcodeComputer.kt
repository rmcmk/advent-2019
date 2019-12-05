package me.ryleykimmel.advent.intcode

class IntcodeComputer(private val _memory: MutableList<Int>) {
    private val instructions = hashMapOf(
        OP_ADD to AddInstruction(),
        OP_MULTI to MultiplyInstruction()
    )

    private var position = 0

    var memory: MutableList<Int>
        get() = _memory.toMutableList()
        set(value) {
            value.toMutableList()
        }

    var noun: Int
        get() = get(NOUN_ADDR)
        set(value) = set(NOUN_ADDR, value)

    var verb: Int
        get() = get(VERB_ADDR)
        set(value) = set(VERB_ADDR, value)

    fun peek(position: Int) = _memory[position]
    fun get(offset: Int) = _memory[position + offset]
    fun set(position: Int, value: Int) {
        _memory[position] = value
    }
    fun dereference(offset: Int) = _memory[get(offset)]
    fun skip(positions: Int) {
        position += positions
    }

    fun step() {
        while (true) {
            val opcode = peek(position)
            if (opcode == OP_EXIT) break
            val instruction = instructions[opcode] ?: error("Unexpected opcode: $opcode")

            instruction.step(this)
        }
    }

    companion object {
        const val NOUN_ADDR = 1
        const val VERB_ADDR = 2
        const val OP_ADD = 1
        const val OP_MULTI = 2
        const val OP_EXIT = 99
    }
}