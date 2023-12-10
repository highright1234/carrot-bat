package io.github.highright1234.carrotbat

import java.util.*
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong


// millis
const val from = 1702129302707
const val to = 1702129304918

val fromNano = TimeUnit.MILLISECONDS.toNanos(from)
val toNano = TimeUnit.MILLISECONDS.toNanos(to) + 999

const val uniquifierCounts = 30

val data = listOf<Pair<Int, Result>>(
    1 to Result.POSITIVE_TWO,
    1 to Result.POSITIVE_FIVE,
    1 to Result.POSITIVE_SIX,
    1 to Result.POSITIVE_TWO,
    1 to Result.NEGATIVE_THREE,
    1 to Result.NEGATIVE_THREE,
    1 to Result.POSITIVE_SEVEN,
    1 to Result.NEGATIVE_FIVE,
    1 to Result.POSITIVE_TWO,
    1 to Result.NEGATIVE_FIVE,
    1 to Result.POSITIVE_SEVEN,
    1 to Result.NEGATIVE_THREE,
    1 to Result.POSITIVE_TWO,
    1 to Result.POSITIVE_TWO,
    1 to Result.POSITIVE_TWO,
)


// source from java.lang.Random
private fun seedUniquifier(): Long {
    // L'Ecuyer, "Tables of Linear Congruential Generators of
    // Different Sizes and Good Lattice Structure", 1999
    while (true) {
        val current = seedUniquifier.get()
        val next = current * 1181783497276652981L
        if (seedUniquifier.compareAndSet(current, next)) return next
    }
}

private val seedUniquifier = AtomicLong(8682522807148012L)

val originalList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
fun main() {
    val out = ArrayList<Random>()
    uniquifier@ for (u in 0 until uniquifierCounts) {
        val uniquifier = seedUniquifier()
        println("$u New start, uniquifier: $uniquifier")
        var logTime = System.currentTimeMillis()
        time@ for (t in fromNano..toNano) {
            if (System.currentTimeMillis() - logTime > 1000) {
                println("${((t - fromNano).toDouble() / (toNano - fromNano).toDouble()) * 100.0}%")
                logTime = System.currentTimeMillis()
            }
            val seed = uniquifier xor t
            val random = Random(seed)
            for ((n, result) in data) {
                val list = originalList.toMutableList()
                Collections.shuffle(list, random)
                if (Result.of(list.indexOf(n)) != result) continue@time
            }
            println("found seed: $seed")
            out += random
        }
    }

    println(out.joinToString())


}

