package me.ryleykimmel.advent.day1

data class Module(val mass: Int) {
    fun requiredFuel() = (mass / 3) - 2

    tailrec fun totalFuelRequirement(mass: Int = this.mass, total: Int = 0): Int {
        val required = Module(mass).requiredFuel()
        if (required > 0) return totalFuelRequirement(required, total + required)
        return total
    }
}