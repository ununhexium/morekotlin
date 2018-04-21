package net.lab0.tools

fun <T> List<List<T>>.moreListOfLists() = MoreListOfLists(this)

class MoreListOfLists<out T, out E>(element: E) :
    MoreIterableOfIterable<T, List<List<T>>>(element)
    where E : List<List<T>>
{
    /**
     * Zips the elements of the lists.
     * Same as matrix transposition.
     *
     * The list
     * `[
     * [A1, B1, C1, D1, E1]
     * [A2, B2, C2, D2, E2]
     * [A3, B3, C3, D3, E3]
     * ]`
     *
     * becomes
     * `[
     * [A1, A2, A3]
     * [B1, B2, B3]
     * [C1, C2, C3]
     * [D1, D2, D3]
     * [E1, E2, E3]
     * ]`
     *
     * @throws IllegalArgumentException If the lists don't all have the same size.
     */
    @Throws(IllegalArgumentException::class)
    fun zip(): List<List<T>>
    {
        if (!this.sameSizes())
        {
            throw IllegalArgumentException("The lists must be the same sizes")
        }

        return (0 until element[0].size).map { x ->
            (0 until element.count()).map { y ->
                element[y][x]
            }
        }
    }
}
