package com.wycrm.tyjpropertycompose.network

import android.util.Log
import com.wycrm.tyjpropertycompose.data.BaseResponse
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure

class BaseSerializer<T>(
    private val serializer: KSerializer<T>
) : KSerializer<BaseResponse<T>> {
    override val descriptor: SerialDescriptor
        get() = TODO("Not yet implemented")

    /*
        companion object {
            const val TAG = "BaseSerializer"
        }

        override val descriptor: SerialDescriptor = serializer.descriptor

        override fun deserialize(decoder: Decoder): BaseResponse<T> =
            decoder.decodeStructure(descriptor) {
                var data: T? = null
                var code = ""
                var message = ""
                while (true) {
                    when (val index = decodeElementIndex(descriptor)) {
                        0 -> data = serializer.deserialize(decoder)
                        1 -> code = decodeStringElement(descriptor, 1)
                        2 -> message = decodeStringElement(descriptor, 2)
                        CompositeDecoder.DECODE_DONE -> break
                        else -> error("Unexpected index: $index")
                    }
                }
                BaseResponse(data = serializer.deserialize(decoder), code = code, message = message).also {
                    when (code) {
                        "000000",
                        "0",
                        "200000" -> {
                            Log.i(TAG, "deserialize: success code : $code")
                        }

                        else -> {
                            Log.i(TAG, "deserialize: failed code : $code")

                        }
                    }
                }

            }


        override fun serialize(encoder: Encoder, value: BaseResponse<T>) =
            serializer.serialize(encoder, value.data)*/
    override fun deserialize(decoder: Decoder): BaseResponse<T> {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: BaseResponse<T>) {
        TODO("Not yet implemented")
    }
}