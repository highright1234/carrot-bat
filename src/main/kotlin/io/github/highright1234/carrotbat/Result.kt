package io.github.highright1234.carrotbat

enum class Result(vararg numbers: Int) {
    NEGATIVE_SIX(0),
    NEGATIVE_FIVE(1, 2),
    NEGATIVE_THREE(3, 4),
    POSITIVE_TWO(5, 6),
    POSITIVE_FIVE(7),
    POSITIVE_SIX(8),
    POSITIVE_SEVEN(9);

    val values = numbers

    companion object {

        fun of(n: Int): Result {
            return values().first { n in it.values }
        }

        fun named(n: Int): Result {
            return when (n) {
                -6 -> NEGATIVE_SIX
                -5 -> NEGATIVE_FIVE
                -3 -> NEGATIVE_THREE
                2 -> POSITIVE_TWO
                5 -> POSITIVE_FIVE
                6 -> POSITIVE_SIX
                7 -> POSITIVE_SEVEN
                else -> error("Wrong input $n")
            }
        }
    }
}