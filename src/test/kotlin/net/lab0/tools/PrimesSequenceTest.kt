package net.lab0.tools

import com.google.common.io.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets

class PrimesSequenceTest
{
  @Test
  fun `check that we actually get the right sequence for a few prime numbers`()
  {
    val rawData = Resources.toString(
        Resources.getResource(javaClass, "/data/primes.txt"),
        StandardCharsets.UTF_8
    )
    val knownPrimes = rawData
        .replace("\n", "\t")
        .split("\t")
        .map { it.toLong() }

    val computedPrimes = primes.take(knownPrimes.size).toList()
    assertThat(computedPrimes).isEqualTo(knownPrimes)
  }

  @Test
  fun `getting primes again starts from the beginning`()
  {
    val firstTake = primes.take(100)
    val secondTake = primes.take(100)

    firstTake.zip(secondTake).forEach {
      assertThat(it.first).isEqualTo(it.second)
    }
  }
}