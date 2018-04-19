package net.lab0.tools

import com.google.common.collect.Sets
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

internal class MoreListOfListsTest
{
  companion object
  {
    val BIG_VALUE = Int.MAX_VALUE / 100
    val LISTS_COUNT = 3
  }

  @Test
  fun `can zip lists == transpose matrix`()
  {
    val original = listOf(
        listOf(1, 2, 3, 4),
        listOf(5, 6, 7, 8),
        listOf(9, 10, 11, 12)
    )

    val expected = listOf(
        listOf(1, 5, 9),
        listOf(2, 6, 10),
        listOf(3, 7, 11),
        listOf(4, 8, 12)
    )

    assertThat(original.more().zip()).isEqualTo(expected)
  }

  @Test
  fun `zip throws IllegalArgument when lists have different sizes`()
  {
    val original = listOf(
        listOf(null),
        listOf(null,null)
    )

    assertThrows<IllegalArgumentException> {
      original.more().zip()
    }
  }
}