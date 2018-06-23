package net.lab0.tools

fun <T> List<T>.moreLists() = MoreLists(this)

class MoreLists<T>(val element: List<T>) {
    /**
     * Takes N items from the list at random.
     * The same item can be selected several times.
     *
     * @return 1 element chosen at random in this list.
     */
    fun pick(count: Int = 1): List<T> =
            (1..count).map { MoreRandom.pickOne(element) }

    /**
     * Given a list, returns all sublists, starting from index 0,
     * increasing in length by 1, until reaching the size of the original list.
     *
     * Example:
     *
     * Given the list
     *
     * ```[0,1,2]```
     *
     * it will return the list of lists:
     *
     * ```
     * [
     * [],
     * [0],
     * [0,1],
     * [0,1,2]
     * ]
     * ```
     */
    fun listProgression() = listOf(this.element)
            .flatMap { list ->
                (0..list.size).map { quantity ->
                    list.take(quantity)
                }
            }
}
