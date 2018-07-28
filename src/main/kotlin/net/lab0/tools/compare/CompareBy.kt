package net.lab0.tools.compare

/**
 * Holds to iterables in order to compare them by a common key.
 */
class CompareBy<T1, T2>(val iterableOfBs: Iterable<T1>, val iterableOfCs: Iterable<T2>) {
    /**
     * @param selectFromB Builds a key to be used when comparing this object to objects of type [T2]
     * @param selectFromB Builds a key to be used when comparing this object to objects of type [T1]
     */
    fun <X> compareWith(selectFromB: T1.() -> X, selectFromC: T2.() -> X): Comparison<T1, T2> {
        val mapped1 = iterableOfBs.map { ComparisonDelegator(it, selectFromB(it)) }
        val mapped2 = iterableOfCs.map { ComparisonDelegator(it, selectFromC(it)) }

        val common1 = mapped1.filter {
            mapped2.contains<ComparisonDelegator<*, *>>(it)
        }

        val common2 = mapped2.filter {
            mapped1.contains<ComparisonDelegator<*, *>>(it)
        }

        val firstOnly = mapped1.filterNot {
            common1.contains<ComparisonDelegator<*, *>>(it)
        }

        val secondOnly = mapped2.filterNot {
            common1.contains<ComparisonDelegator<*, *>>(it)
        }

        return Comparison(firstOnly.unwrapped(), secondOnly.unwrapped(), common1.unwrapped(), common2.unwrapped())
    }

    private fun <A, X> List<ComparisonDelegator<A, X>>.unwrapped() =
        this.map { it.element }
}
