package net.lab0.tools

import kotlin.coroutines.experimental.buildSequence

val primes = buildSequence {
  val previousPrimes = mutableListOf(2L)
  var lastPrime = 2L
  yield(2L)

  while (true)
  {
    val seq = generateSequence(lastPrime, { it + 1 })
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
