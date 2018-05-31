package net.lab0.tools

import com.google.common.io.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets
import kotlin.system.measureNanoTime

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

  @Test
  @Tag("performance")
  fun `show the execution speed for primes finder`()
  {
    val size = 1000
    val samples = 100
    val chunks = primes.chunked(size).iterator()

    (1..samples).forEach { index ->
      val (time, lastPrimes) = measureBlockTimeMillis {
        val tmp = chunks.next()
        val message = "Chunk $index found ${tmp.size} between ${tmp.first()} and ${tmp.last()}"
        print(message)
        tmp
      }
      println(" @ ${lastPrimes.size / (time / 1000.0)} per second (took $time ms)")
    }
  }
}