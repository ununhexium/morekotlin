package net.lab0.tools

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoreIterablesTest {

    class Color(val name: String, val color: String)
    class Plant(val name: String, val height: Double)

    companion object {
        val red = Color("red", "#f00")
        val blue = Color("blue", "#00f")
        val orangeColor = Color("orange", "#f80")

        val colors = listOf(
            blue,
            red,
            orangeColor
        )

        val duplicatedColors = listOf(
            blue,
            red,
            red,
            red,
            orangeColor,
            orangeColor
        )

        val orangeFruit = Plant("orange", 0.1)
        val mushroom = Plant("mushroom", 0.05)
        val tree = Plant("tree", 30.1)

        val plants = listOf(
            orangeFruit,
            mushroom,
            tree
        )

        val duplicatedPlants = listOf(
            orangeFruit,
            orangeFruit,
            mushroom,
            mushroom,
            tree
        )
    }

    @Test
    fun `can build a CompareBy`() {
        val compareBy = colors.moreIterables().compareTo(plants)
        assertThat(compareBy).isNotNull
        assertThat(compareBy.iterableOfBs).isSameAs(colors)
        assertThat(compareBy.iterableOfCs).isSameAs(plants)
    }

    @Test
    fun `can find element in B only, in C only and common ones`() {
        val compareBy = colors.moreIterables().compareTo(plants)
        val result = compareBy.compareWith({ name }, { name })
        assertThat(result.commonFromB).containsExactly(orangeColor)
        assertThat(result.commonFromC).containsExactly(orangeFruit)
        assertThat(result.onlyInB).containsExactly(blue, red)
        assertThat(result.onlyInC).containsExactly(mushroom, tree)
    }

    @Test
    fun `compare works with duplicates`() {
        val compareBy = duplicatedColors.moreIterables().compareTo(duplicatedPlants)
        val result = compareBy.compareWith({ name }, { name })
        assertThat(result.commonFromB).containsExactly(orangeColor, orangeColor)
        assertThat(result.commonFromC).containsExactly(orangeFruit,orangeFruit)
        assertThat(result.onlyInB).containsExactly(blue, red, red, red)
        assertThat(result.onlyInC).containsExactly(mushroom,mushroom, tree)
    }
}
