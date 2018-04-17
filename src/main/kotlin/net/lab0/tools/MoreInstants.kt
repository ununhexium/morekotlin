package net.lab0.tools

import java.time.Instant
import java.time.format.DateTimeFormatter

fun Instant.more() = MoreInstants(this)

class MoreInstants(val instant: Instant)
{
  fun toISO8601UTC(): String =
      DateTimeFormatter.ISO_DATE_TIME.format(
          instant.atZone(java.time.ZoneOffset.UTC).toOffsetDateTime()
      )
}
