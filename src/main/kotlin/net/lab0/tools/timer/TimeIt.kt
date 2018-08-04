package net.lab0.tools.timer

import java.time.Duration
import java.time.temporal.ChronoUnit
import kotlin.system.measureNanoTime

class TimeIt(private val function: () -> Unit) {
    companion object {
      val defaultWarmupDuration = Duration.of(10, ChronoUnit.SECONDS)
    }

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
        val nanos = duration.toNanos()
        var total = 0L
        var runs = 0L
        while (total < nanos) {
            total += measureNanoTime(function)
            runs++
        }
        return total / runs
    }

    fun warmup(duration:Duration = defaultWarmupDuration): TimeIt {
        this.during(duration)
        return this
    }

    fun autoTimeRepeat(n: Int, warmupDuration:Duration = defaultWarmupDuration): TimingReport {
        val before = this.repeated(n)
        this.warmup(warmupDuration)
        val after = this.repeated(n)
        return TimingReport(before, after)
    }
}

