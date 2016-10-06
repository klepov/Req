package io.workup.workup.extensions

import com.google.gson.*
import java.lang.reflect.Type

abstract class AdvancedJsonDeserializer<T> : JsonDeserializer<T> {
    lateinit var context: JsonDeserializationContext

    abstract fun deserialize(json: JsonElement): T

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): T {
        this.context = context
        return deserialize(json)
    }

    inline fun <reified R : GsonDeserializable> JsonElement.fromJson(): R = context.deserialize<R>(this, R::class.java)
}

abstract class AdvancedJsonSerializer<T> : JsonSerializer<T> {
    lateinit var context: JsonSerializationContext

    abstract fun serialize(model: T): JsonElement

    override fun serialize(src: T, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        this.context = context
        return serialize(src)
    }

    inline fun <reified R : GsonSerializable> GsonSerializable.toJson(): JsonElement = context.serialize(this, R::class.java)
}

interface GsonSerializable
interface GsonDeserializable

inline fun <reified T : Any> GsonBuilder.registerDeserializer(deserializer: JsonDeserializer<T>): GsonBuilder = registerTypeAdapter(T::class.java, deserializer)
inline fun <reified T : Any> GsonBuilder.registerSerializer(serializer: JsonSerializer<T>): GsonBuilder = registerTypeAdapter(T::class.java, serializer)