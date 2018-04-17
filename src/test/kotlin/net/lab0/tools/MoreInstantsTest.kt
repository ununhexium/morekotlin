package net.lab0.tools

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Instant

internal class MoreInstantsTest
{
  @Test
  fun `epoch is converted to ISO 8601 string`()
  {
    Assertions.assertThat(Instant.EPOCH.more().toISO8601UTC()).isEqualTo(
        "1970-01-01T00:00:00Z"
    )
  }
}