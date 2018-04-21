package net.lab0.tools

fun <T> List<T>.moreLists() = MoreLists(this)

class MoreLists<T>(val element: List<T>)
{
    /**
     * Takes N items from the list at random.
     * The same item can be selected several times.
     *
     * @return 1 element chosen at random in this list.
     */
    fun pick(count: Int = 1): List<T> =
        (1..count).map { MoreRandom.pickOne(element) }
}
