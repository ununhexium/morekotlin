package net.lab0.tools.compare

/**
 * Wrapper to compare elements by a different key.
 */
class ComparisonDelegator<E, X>(val element: E, val delegate: X) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ComparisonDelegator<*, *>

        if (delegate != other.delegate) return false

        return true
    }

    override fun hashCode(): Int {
        return delegate?.hashCode() ?: 0
    }
}
