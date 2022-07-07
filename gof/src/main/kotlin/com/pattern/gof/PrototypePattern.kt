package com.pattern.gof

class SamplePrototype(
    val name: String
) : Cloneable {
    public override fun clone(): SamplePrototype {
        return super.clone() as SamplePrototype
    }
}

data class SampleDataPrototype(val name: String)

class ClientPrototype {
    fun main() {
        val samplePrototype = SamplePrototype("name")
        val clone = samplePrototype.clone()

        val sampleDataPrototype = SampleDataPrototype("name")

        sampleDataPrototype.copy()
    }
}