package com.wycrm.tyjpropertycompose.util

import android.util.Base64
import com.wycrm.tyjpropertycompose.constants.Constants
import com.wycrm.tyjpropertycompose.data.requests.LoginParams
import com.wycrm.tyjpropertycompose.util.RC4.encryptRC4String
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object DecodeUtils {
    fun RC4Base64Encry(pw: String): String {
        val result = encryptRC4String(pw, Constants.KEY)
        val m = Base64.encode(result.toByteArray(), Base64.DEFAULT)
        val str = String(m)
        return str.trim { it <= ' ' }
    }

    private fun md5Encode(sign: String): String {
        try {
            val bmd5 = MessageDigest.getInstance("MD5")
            bmd5.update(sign.toByteArray())
            var i: Int
            val stringBuilder = StringBuilder()

            val bytes = bmd5.digest()
            for (value in bytes) {
                i = value.toInt()
                if (i < 0) i += 256
                if (i < 16) stringBuilder.append("0")
                stringBuilder.append(Integer.toHexString(i))
            }
            return stringBuilder.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }


    fun getSign(token: String, data: String, time: String): String {
        val sign = "$data&$time&$token*1**everwing-cloud-wy-api**1*"
        return md5Encode(sign).uppercase()
    }
}