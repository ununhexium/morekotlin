package net.lab0.tools.timer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.temporal.ChronoUnit

class TimeItTest {
    fun compute() {
        (0..1000).map {
            Math.hypot(it.toDouble(), 2 * it.toDouble())
        }
    }

    private fun timeIt() = TimeIt(::compute)

    @Test
    fun `Can time with iterations`() {
        val time = timeIt().repeated(100)
        assertThat(time).isNotZero()
    }

    @Test
    fun `Can time with duration`() {
        val time = timeIt().during(Duration.of(100, ChronoUnit.MILLIS))
        assertThat(time).isNotZero()
    }

    @Test
    fun `can warmup the JVM`() {
        val timeIt = timeIt()
        val before = timeIt.repeated(100)
        timeIt.warmup()
        val after = timeIt.repeated(100)
        assertTrue(before > after)
    }
}
