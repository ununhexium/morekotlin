package net.lab0.tools

import java.util.*

object MoreRandom
{
    val random by lazy { Random() }

    /**
     * @return an element selected randomly in the collection or
     * `null` if the collection is empty
     */
    fun <T> pickOne(list: List<T>): T
    {
        return list[random.nextInt(list.size)]
    }
}
