package net.lab0.tools

import com.google.common.collect.Sets
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows

internal class MoreIterableOfIterableTest {
  private fun iterableOfSize(size: Int): Iterable<Any?> {
    return (0 until size)
  }

  @TestFactory
  fun `lists have the same size`(): List<DynamicTest> {
    val sizes = listOf(0, 1, 2, 10, MoreListOfListsTest.BIG_VALUE)
    return sizes.map { size ->
      val lists = (1..MoreListOfListsTest.LISTS_COUNT).map {
        iterableOfSize(size)
      }
      DynamicTest.dynamicTest(
          "For size $size",
          { assertThat(lists.moreIterOfIters().sameSizes()).isTrue() }
      )
    }
  }

  @TestFactory
  fun `lists have different sizes`(): List<DynamicTest> {
    val sizes = listOf(0, 1, 2, 10, MoreListOfListsTest.BIG_VALUE).toSet()
    val combinations = Sets.combinations(sizes, MoreListOfListsTest.LISTS_COUNT)
    return combinations.map {
      val lists = it.map {
        iterableOfSize(it)
      }
      DynamicTest.dynamicTest(
          "For sizes ${it.joinToString()}",
          { assertThat(lists.moreIterOfIters().sameSizes()).isFalse() }
      )
    }
  }

  @Test
  fun `can get the first element of a matrix`() {
    val input = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )

    val result = input.moreIterOfIters().first { it == 5 }
    assertThat(result).isEqualTo(5)

    assertThrows<NoSuchElementException> {
      input.moreIterOfIters().first { it == 0 }
    }
  }
}