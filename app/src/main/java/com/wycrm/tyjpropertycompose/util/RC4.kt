package com.wycrm.tyjpropertycompose.util

object RC4 {

    fun encryptRC4String(data: String, key: String): String {
        return  toHexString(asString(encryptRc4Byte(data, key)))
    }

    private fun toHexString(s: String): String {
        var str = ""
        for (element in s) {
            val ch = element.code
            var s4 = Integer.toHexString(ch and 0xFF)
            if (s4.length == 1) {
                s4 = "0$s4"
            }
            str += s4
        }
        return str // 0x表示十六进制
    }

    private fun asString(buf: ByteArray?): String {
        val struct = StringBuffer(buf!!.size)
        for (i in buf.indices) {
            struct.append(Char(buf[i].toUShort()))
        }
        return struct.toString()
    }

    private fun encryptRc4Byte(data: String?, key: String?): ByteArray? {
        if (data == null || key == null) {
            return null
        }
        val bData = data.toByteArray()
        return rc4Base(bData, key)
    }

    private fun rc4Base(input: ByteArray, mKey: String): ByteArray {
        var x = 0
        var y = 0
        val key = initKey(mKey)
        var xorIndex: Int
        val result = ByteArray(input.size)
        for (i in input.indices) {
            x = x + 1 and 0xff
            y = (key!![x].toInt() and 0xff) + y and 0xff
            val tmp = key[x]
            key[x] = key[y]
            key[y] = tmp
            xorIndex = (key[x].toInt() and 0xff) + (key[y].toInt() and 0xff) and 0xff
            result[i] = (input[i].toInt() xor key[xorIndex].toInt()).toByte()
        }
        return result
    }
    private fun initKey(aKey: String): ByteArray? {
        val bKey = aKey.toByteArray()
        val state = ByteArray(256)
        (0.rangeTo(255)).forEachIndexed { _, i -> state[i] = i.toByte() }
        var index1 = 0
        var index2 = 0
        if (bKey.isEmpty()) {
            return null
        }
        for (i in 0.rangeTo(255)) {
            index2 = (bKey[index1].toInt() and 0xff) + (state[i].toInt() and 0xff) + index2 and 0xff
            val tmp = state[i]
            state[i] = state[index2]
            state[index2] = tmp
            index1 = (index1 + 1) % bKey.size
        }
        return state
    }

}