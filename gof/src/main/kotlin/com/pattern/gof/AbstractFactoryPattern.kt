package com.pattern.gof

//추상 팩토리 패턴


interface AbstractFactory {
    fun create(): AbstractProduct
}

interface AbstractProduct {
    val rightMirror: Right
    val leftMirror: Left
}

interface ProductPartsFactory {
    fun createRight(): Right
    fun createLeft(): Left

    class SampleProductPartsFactory : ProductPartsFactory {
        override fun createRight(): Right = Right.SampleRight()
        override fun createLeft(): Left = Left.SampleLeft()
    }
    class SampleProductPartsProFactory : ProductPartsFactory {
        override fun createRight(): Right = Right.SampleRightPro()
        override fun createLeft(): Left = Left.SampleLeftPro()
    }
    class DefaultProductPartsFactory : ProductPartsFactory{
        override fun createRight(): Right = Right.DefaultRight()
        override fun createLeft(): Left = Left.DefaultLeft()
    }
}

interface Right {
    class SampleRight : Right
    class SampleRightPro : Right
    class DefaultRight : Right
}

interface Left {
    class SampleLeft : Left
    class SampleLeftPro : Left
    class DefaultLeft : Left
}

class SampleProduct(
    override val rightMirror: Right,
    override val leftMirror: Left
) :
    AbstractProduct {
}

class SampleProductFactory(
    private val sampleProductPartsFactory: ProductPartsFactory,
    private val sampleProductPartsProFactory: ProductPartsFactory
) : AbstractFactory {
    override fun create(): SampleProduct {
        val sampleProduct = SampleProduct(
            sampleProductPartsFactory.createRight(),
            sampleProductPartsFactory.createLeft()
        )
        return sampleProduct
    }

    //구현체만 바꿔줘서 pro를 생산할 수 있다
    fun exampleCreate(): SampleProduct{
        val sampleProductPro = SampleProduct(
            sampleProductPartsProFactory.createRight(),
            sampleProductPartsProFactory.createLeft()
        )
        return sampleProductPro
    }
}

class DefaultProductFactory(
    private val defaultProductPartsFactory: ProductPartsFactory
): AbstractFactory{
    override fun create(): AbstractProduct {
        val defaultProductPro = SampleProduct(
            defaultProductPartsFactory.createRight(),
            defaultProductPartsFactory.createLeft()
        )
        return defaultProductPro
    }
}


class Main(
    private val abstractFactory: AbstractFactory
){
    fun main(){
        val product = abstractFactory.create()
    }
}