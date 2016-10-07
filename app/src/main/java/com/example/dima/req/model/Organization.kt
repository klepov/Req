package com.example.dima.req.model

import com.example.dima.req.extensions.AdvancedJsonDeserializer
import com.example.dima.req.extensions.GsonDeserializable
import com.example.dima.req.model.ParseOrganization
import com.google.gson.JsonElement

data class Organizations(
        val organization: Collection<ParseOrganization>?
): GsonDeserializable {
    companion object {
        fun deserializer() = Deserializer()
    }
    class Deserializer : AdvancedJsonDeserializer<Organizations>() {
        override fun deserialize(json: JsonElement) = json.asJsonObject.let {
            Organizations(
                    organization = it["organization"]?.asJsonArray?.map { it.fromJson<ParseOrganization>() }
            )
        }
    }

//    {
//
//    }
}