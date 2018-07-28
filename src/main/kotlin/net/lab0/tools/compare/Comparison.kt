package net.lab0.tools.compare

class Comparison<B, C>(
    val onlyInB: Iterable<B>,
    val onlyInC: Iterable<C>,
    val commonFromB: Iterable<B>,
    val commonFromC: Iterable<C>
)
