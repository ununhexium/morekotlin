package net.lab0.tools

import java.nio.ByteBuffer

fun ByteArray.moreByteArrays() = MoreByteArrays(this)

class MoreByteArrays(val element: ByteArray) {

    companion object {
        private val hexArray = "0123456789abcdef".toCharArray()

        @JvmStatic
        fun Long.toByteArray() =
            ByteBuffer.allocate(java.lang.Long.BYTES).putLong(this).array()!!
    }

    fun ByteArray.toHex(): String {
        val result = StringBuffer()

        this.forEach {
            val octet = it.toInt()
            val firstIndex = (octet and 0xF0).ushr(4)
            val secondIndex = octet and 0x0F
            result.append(hexArray[firstIndex])
            result.append(hexArray[secondIndex])
        }

        val string = result.toString()
        return string
    }
}
