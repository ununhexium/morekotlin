package net.lab0.tools

import net.lab0.tools.compare.CompareBy

fun <T> List<T>.moreIterables() = MoreIterables(this)

class MoreIterables<T>(val element: Iterable<T>) {
    /**
     * Prepare this and another iterator to be compared by a key.
     *
     * @return A comparator of iterables.
     */
    fun <C> compareTo(cs: Iterable<C>) = CompareBy(this.element, cs)

}
