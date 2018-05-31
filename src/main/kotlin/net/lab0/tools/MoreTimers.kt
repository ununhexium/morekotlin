package net.lab0.tools


/**
 * Executes the given block and returns a pair of the elapsed time
 * in milliseconds and the result of the computing block.
 */
inline fun <T> measureBlockTimeMillis(block: () -> T): Pair<Long, T>
{
  val start = System.currentTimeMillis()
  val result = block()
  return Pair(System.currentTimeMillis() - start, result)
}
