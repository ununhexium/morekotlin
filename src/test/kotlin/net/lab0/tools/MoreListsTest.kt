package net.lab0.tools

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MoreListsTest {
  @Test
  fun `pick returns N elements from the list`() {
    val list = listOf("a", "b", "c")
    val items = list.moreLists().pick(10)
    items.forEach {
      assertThat(it).isIn(list)
    }
  }

  @Test
  fun `list progression returns all the sub-lists`() {
    val list = (0..4).toList()
    val expected = listOf(
        listOf(),
        listOf(0),
        listOf(0, 1),
        listOf(0, 1, 2),
        listOf(0, 1, 2, 3),
        listOf(0, 1, 2, 3, 4)
    )

    val result = list.moreLists().listProgression()

    assertThat(result).isEqualTo(expected)
    result.zip(expected).forEach { (r, e) ->
      assertThat(r).isEqualTo(e)
      r.zip(e).forEach { (a, b) ->
        assertThat(a).isEqualTo(b)
      }
    }
  }
}
