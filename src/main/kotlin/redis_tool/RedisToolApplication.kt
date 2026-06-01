package redis_tool

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisToolApplication

fun main(args: Array<String>) {
    runApplication<RedisToolApplication>(*args)
}
