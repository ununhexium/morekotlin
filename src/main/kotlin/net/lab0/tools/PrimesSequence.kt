package net.lab0.tools

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.atomic.AtomicLong
import kotlin.coroutines.experimental.buildSequence

/**
 * The sequence of prime numbers, computed on a single core.
 */
val primes = buildSequence {
  val previousPrimes = mutableListOf(2L, 3L)
  var lastPrime = 3L
  yield(2L)
  yield(3L)

  while (true)
  {
    val seq = generateSequence(lastPrime, { it + 2 })
    val nextPrime = seq.first { candidate ->
      previousPrimes.none { prime ->
        candidate % prime == 0L
      }
    }
    lastPrime = nextPrime
    previousPrimes.add(nextPrime)
    yield(nextPrime)
  }
}
