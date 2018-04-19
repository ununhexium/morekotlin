package net.lab0.tools

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoreStringsTest
{
  @Test
  fun `more !!!`()
  {
    val more = "sample".more()
    assertThat(more).isNotNull
  }

  @Test
  fun `collapses white spaces like "white-space normal" CSS property`()
  {
    val more = """
          |ABC
          |          XYZ
          |      FOO
          |
          |
          |
          |
          |BAR
        """.trimMargin().more()
    assertThat(more.collapseWhiteSpaces()).isEqualTo("ABC XYZ FOO BAR")
  }
}
