package jp.abetakuto.test_retrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ChannelInfo(
//        val link:String,
//        val is_adult:Int,
//        val time:String,
//        val channel:List<Channel>
        val channel:List<CourseInfo>
)

//data class Channel(
//    val id: String,
//    val name: String,
//    val title: String,
//    val image: String
//)

data class CourseInfo(
    var id: String,
    var name: String,
    val icon_url: String,
    val number_of_topics: Int,
    val teacher_name: String,
    val last_attempted_ts: Long
)
