package net.lab0.tools

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MoreListsTest
{
    @Test
    fun `pick returns N elements from the list`()
    {
        val list = listOf("a", "b", "c")
        val items = list.moreLists().pick(10)
        items.forEach {
            assertThat(it).isIn(list)
        }
    }
}
