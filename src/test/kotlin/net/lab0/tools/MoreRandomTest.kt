package net.lab0.tools

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Percentage
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import java.util.*

internal class MoreRandomTest
{
    @Test
    @RepeatedTest(5)
    fun `select 1 random element from a list`()
    {
        val list = (0..10).toList()
        val stats = IntSummaryStatistics()
        val MAX = 10000L

        (1..MAX).forEach { stats.accept(MoreRandom.pickOne(list)) }

        assertThat(stats.average)
            .isCloseTo(5.0, Percentage.withPercentage(5.0))

        assertThat(stats.count).isEqualTo(MAX)
        assertThat(stats.min).isEqualTo(0)
        assertThat(stats.max).isEqualTo(10)
    }
}
