package net.lab0.tools.timer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.temporal.ChronoUnit

class TimeItTest {
    private fun compute() {
        (0..1000).map {
            Math.hypot(it.toDouble(), 2 * it.toDouble())
        }
    }

    companion object {
      val duration = Duration.of(1, ChronoUnit.SECONDS)
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
        timeIt.warmup(duration)
        val after = timeIt.repeated(100)
        assertTrue(before > after)
    }

    @Test
    fun `can test and report automatically`(){
        val report = timeIt().autoTimeRepeat(10)
        assertTrue(report.beforeWarmUp > report.afterWarmup)
    }
}
