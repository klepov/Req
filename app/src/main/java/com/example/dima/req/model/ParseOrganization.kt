package com.example.dima.req.model

import com.google.gson.JsonElement
import io.workup.workup.extensions.AdvancedJsonDeserializer
import io.workup.workup.extensions.GsonDeserializable

data class ParseOrganization(
       val organizationID : Int,
       val title: String,
       val site: String,
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
       val work_wednesday: String,
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
) : GsonDeserializable{
    companion object {
    }

//    class Deserializer : AdvancedJsonDeserializer<ComfortableTime>() {
//        override fun deserialize(json: JsonElement) = json.asJsonObject.let {
//            val day = it["day"].asJsonObject
//            ComfortableTime(
//                    id = day["id"].asInt,
//                    title = day["title"].asString,
//                    end = it["end"].asString,
//                    start = it["start"].asString
//            )
//        }
//    }


    class Deserializer : AdvancedJsonDeserializer<ParseOrganization>(){
        override fun deserialize(json: JsonElement) = json.asJsonObject.let {
            ParseOrganization(

                    organizationID  = "organization_id": 409520,
                    title = "title": "Зелёная шина",
                    site = "site": "http://www.greentyre.ru",
                    address = "address": "Санкт-Петербург, Таллинское ш., 163",
                    latitude = "latitude": "59.805301",
                    longitude = "longitude": "30.160055",
                    type = "type": "org",
                    openTime = "open_time": "ежедневно, 9:00-21:00",
                    info = "info": "",
                    updatedAt = "updated_at": 1474142573,
                    published = "published": 1,
                    work_monday = "work_monday": "09:00-21:00",
                    work_tuesday = "work_tuesday": "09:00-21:00",
                    work_wednesday = "work_wednesday": "09:00-21:00",
                    work_thursday = "work_thursday": "09:00-21:00",
                    work_friday = "work_friday": "09:00-21:00",
                    work_saturday = "work_saturday": "09:00-21:00",
                    work_sunday = "work_sunday": "09:00-21:00",
                    work_always = "work_always": 0,
                    highlight = "highlight": 0,
                    promoted = "promoted": 0,
                    pos = "pos": 409520,
                    is_deleted = "is_deleted": 0,
                    image = "image": "",
                    source_name = "source_name": "yandex_maps",
                    "source_id": "1205249151",
                    "votes_rating": "0.0000",
                    "votes_count": 0,
                    "discount_title": null,
                    "has_discount": 0,
                    "pictures": [],
                    "discount_body": null,
                    "bg_color_id": null,
                    "email": null,
                    "video_url": null,
                    "is_video_hidden": 0,
                    "categories": [],
                    "phones": [
                    id = day["id"].asInt
            )
        }
    }
}
