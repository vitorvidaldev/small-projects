package dev.vitorvidal.jpakotlinexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaKotlinExampleApplication

fun main(args: Array<String>) {
	runApplication<JpaKotlinExampleApplication>(*args)
}
