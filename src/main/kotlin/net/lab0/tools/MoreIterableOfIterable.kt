package net.lab0.tools

fun <T> Iterable<Iterable<T>>.more() = MoreIterableOfIterable(this)

open class MoreIterableOfIterable<out T, out E>(internal val element: E)
    where E : Iterable<Iterable<T>>
{
  /**
   * @return true if all the lists have the same size
   */
  fun sameSizes(): Boolean
  {
    return element.groupBy { it.count() }.size == 1
  }
}