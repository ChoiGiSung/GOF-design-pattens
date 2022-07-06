package com.pattern.gof

import org.springframework.beans.factory.BeanFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

interface Factory {
    fun createProduct(): Product
}

open class Product(val name: String) {

    class SampleProduct(name: String) : Product(name)
    class DefaultProduct(name: String) : Product(name)

}


class SampleFactory : Factory{
    override fun createProduct(): Product {
        return Product.SampleProduct("샘플입니다")
    }
}

class DefaultFactory: Factory{
    override fun createProduct(): Product {
        return Product.DefaultProduct("디폴트입니다")
    }

}



class Client(
    //todo 주입 가능
    private val factory: Factory,
    private val factory2: Factory
){

    fun main(){
        val sampleProduct = SampleFactory().createProduct()
        val defaultProduct = DefaultFactory().createProduct()
    }
}


class SimpleFactory{
    fun createProduct(name:String): Product{
        return when(name){
            "sample" -> Product.SampleProduct(name)
            "default" -> Product.DefaultProduct(name)
            else -> throw IllegalArgumentException(name)
        }
    }
}

class SpringFactory{

    fun main(){
        val xmlFactory:BeanFactory = ClassPathXmlApplicationContext()
        val javaFactory:BeanFactory = AnnotationConfigApplicationContext()
    }
}