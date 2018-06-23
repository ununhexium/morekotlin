package net.lab0.tools

import net.lab0.tools.delegated.SetOnce
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class SetOnceTest {
    @Test
    fun `can set the value only once`() {
        class Container {
            var v: Int by SetOnce()
        }

        val c = Container()
        assertThrows<IllegalStateException> { c.v }
        c.v = 1
        assertThat(c.v).isEqualTo(1)
        c.v=2
        assertThat(c.v).isEqualTo(1)
    }
}
