package com.example.dima.req.model

import com.example.dima.req.extensions.AdvancedJsonDeserializer
import com.example.dima.req.extensions.GsonDeserializable
import com.google.gson.JsonElement


data class ParseOrganization(
       val organizationID : Int,
       val title: String,
       val address:String,
       val latitude: Double,
       val longitude: Double,
       val type: String,
       val openTime: String,
       val info: String,
       val updatedAt: Long,
       val published: Int,
       val work_monday: String,
       val work_tuesday: String,
       val work_thursday: String,
       val work_friday: String,
       val work_saturday: String,
       val work_sunday: String,
       val work_always: Int,
       val highlight: Int,
       val promoted: Int,
       val pos: Int,
       val is_deleted: Int,
       val image:String,
       val source_name:String,
       val source_id:String,
       val votes_rating:String,
       val votes_count:Int,
       val discount_title:String,
       val has_discount:Int,
       val discount_body:String,
       val bg_color_id:String,
       val email:String,
       val video_url:String,
       val is_video_hidden:Int
) : GsonDeserializable {
    companion object {
        fun deserializer() = Deserializer()
    }
}

    class Deserializer : AdvancedJsonDeserializer<ParseOrganization>(){
        override fun deserialize(json: JsonElement) = json.asJsonObject.let {
            ParseOrganization(
                    organizationID=it["organizationID "].asInt,
                    title=it["title"].asString,
                    address=it["address"].asString,
                    latitude=it["latitude"].asDouble,
                    longitude=it["longitude"].asDouble,
                    type=it["type"].asString,
                    openTime=it["openTime"].asString,
                    info=it["info"].asString,
                    updatedAt=it["updatedAt"].asLong,
                    published=it["published"].asInt,
                    work_monday=it["work_monday"].asString,
                    work_tuesday=it["work_tuesday"].asString,
                    work_thursday=it["work_thursday"].asString,
                    work_friday=it["work_friday"].asString,
                    work_saturday=it["work_saturday"].asString,
                    work_sunday=it["work_sunday"].asString,
                    work_always=it["work_always"].asInt,
                    highlight=it["highlight"].asInt,
                    promoted=it["promoted"].asInt,
                    pos=it["pos"].asInt,
                    is_deleted=it["is_deleted"].asInt,
                    image=it["image"].asString,
                    source_name=it["source_name"].asString,
                    source_id=it["source_id"].asString,
                    votes_rating=it["votes_rating"].asString,
                    votes_count=it["votes_count"].asInt,
                    discount_title=it["discount_title"].asString,
                    has_discount=it["has_discount"].asInt,
                    discount_body=it["discount_body"].asString,
                    bg_color_id=it["bg_color_id"].asString,
                    email=it["email"].asString,
                    video_url=it["video_url"].asString,
                    is_video_hidden=it["is_video_hidden"].asInt
            )
        }
}
