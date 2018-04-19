package net.lab0.tools


fun String.more() = MoreStrings(this)

class MoreStrings(private val string: String)
{
  fun collapseWhiteSpaces() =
      string.replace(Regex("""\s+"""), " ")
}
