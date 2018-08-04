package net.lab0.tools

fun <T> Iterable<Iterable<T>>.moreIterOfIters() = MoreIterableOfIterable(this)

open class MoreIterableOfIterable<out T, out E>(internal val element: E)
    where E : Iterable<Iterable<T>> {
  /**
   * @return true if all the lists have the same size
   */
  fun sameSizes(): Boolean {
    return element.groupBy { it.count() }.size == 1
  }

  fun first(predicate: (T) -> Boolean): T {
    for (line in this.element)
      for(t in line)
        if(predicate(t))
          return t

    throw NoSuchElementException("Collection contains no element matching the predicate.")
  }
}