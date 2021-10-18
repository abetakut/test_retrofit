package jp.abetakuto.test_retrofit

import jp.abetakuto.test_retrofit.model.ChannelInfo
import jp.abetakuto.test_retrofit.model.CourseInfo
import retrofit2.Call
import retrofit2.http.GET

interface ChannelApiInterface {
//    @GET("/contents/allchannellist.php")
    @GET("/api/courses")
    suspend fun getChannelList(): Array<CourseInfo>
}