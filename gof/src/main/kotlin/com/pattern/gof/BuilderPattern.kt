package com.pattern.gof

interface Builder {
    fun setName(name: String): Builder
    fun setColor(color: String): Builder
    fun build(): BuildProduct
}

class BuildProduct(
    val name: String,
    val color: String
) {
}

class SampleBuilder : Builder {

    var name: String? = null
    var color: String? = null

    override fun setName(name: String): Builder {
        this.name = name
        return this
    }

    override fun setColor(color: String): Builder {
        this.color = color
        return this
    }

    override fun build(): BuildProduct {
        return BuildProduct(this.name!!, this.color!!)
    }

}


class Director(
    private val builder: Builder
) {

    fun getRobot() = builder
        .setColor("red")
        .setName("마징가")
        .build()

    fun getKey() = builder
        .setColor("black")
        .setName("kekey")
        .build()
}


    class BuilderClient {
    fun main() {
        val sampleBuilder = SampleBuilder()
        sampleBuilder.setColor("color")
        sampleBuilder.setName("name")
        val sampleProduct = sampleBuilder.build()

        val director = Director(sampleBuilder)
        val robot = director.getRobot()
    }
}