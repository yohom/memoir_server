package me.yohom.memoir

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MemoirApplication

fun main(args: Array<String>) {
    runApplication<MemoirApplication>(*args)
}
