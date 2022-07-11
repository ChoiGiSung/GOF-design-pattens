package com.pattern.gof.chapter1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GofApplication

fun main(args: Array<String>) {
	runApplication<GofApplication>(*args)
}
