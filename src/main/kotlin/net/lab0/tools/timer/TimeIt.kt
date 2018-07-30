package net.lab0.tools.timer

import java.time.Duration
import java.time.temporal.ChronoUnit
import kotlin.system.measureNanoTime

class TimeIt(private val function: () -> Unit) {
    /**
     * @param n How many runs to do to measure the time it takes.
     * @return The average time for 1 run.
     */
    fun repeated(n: Int) =
        (1..n).map {
            measureNanoTime(function)
        }.sum() / n

    /**
     * @param duration For how long to run the tests.
     * This is the time allocated to testing the function,
     * doesn't take into account any measurement overhead.
     * @return The average time for 1 run.
     */
    fun during(duration: Duration): Long {
        val start = System.nanoTime()
        val runs = mutableListOf<Long>()
        while (runs.sum() < duration.toNanos()) {
            runs.add(
                measureNanoTime(function)
            )
        }
        return runs.sum() / runs.size
    }

    fun warmup(): TimeIt {
        this.during(Duration.of(10, ChronoUnit.SECONDS))
        return this
    }
}

