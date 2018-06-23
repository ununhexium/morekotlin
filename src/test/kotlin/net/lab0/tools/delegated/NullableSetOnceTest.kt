package net.lab0.tools.delegated

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NullableSetOnceTest {
    class Container {
        var v: Int? by NullableSetOnce()
    }

    @Test
    fun `can set the value only once`() {

        val c = Container()
        assertThat(c.v).isNull()

        c.v = 1
        val t = c.v
        assertThat(t).isEqualTo(1)

        c.v = 2
        val t2 = c.v
        assertThat(t2).isEqualTo(1)
    }

    @Test
    fun `can be set to null`() {
        val c = Container()
        c.v = null
        val t1 = c.v
        assertThat(t1).isNull()
        c.v = 1
        val t2 = c.v
        assertThat(t2).isNull()
    }
}
