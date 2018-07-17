package net.lab0.tools

import org.junit.jupiter.api.Test
import java.nio.ByteBuffer

// TODO continue
internal class MoreByteArraysTest {

    @Test
    fun `long to byte array`() {
        fun Long.toByteArray() =
            ByteBuffer.allocate(java.lang.Long.BYTES).putLong(this).array()!!
    }

    @Test
    fun `returns the most appropriate size`() {

    }
}
