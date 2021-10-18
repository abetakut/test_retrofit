package jp.abetakuto.test_retrofit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import jp.abetakuto.test_retrofit.model.Channel
import jp.abetakuto.test_retrofit.model.CourseInfo
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFragment : Fragment() {
    val TAG = "MainFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: start")
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        Log.d(TAG, "onCreateView: set channelInfoApi")
        val channelInfoApi = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://native-team-code-test-api.herokuapp.com")
            .build()
            .create(ChannelApiInterface::class.java)

        Log.d(TAG, "onCreateView: set listData")
//        val listData = arrayListOf<CourseInfo>()

        //APIデータ取得
        lifecycleScope.launch {
            Log.d(TAG, "onCreateView: get APIdata")
            val channelList = channelInfoApi.getChannelList()
//            Log.d(TAG, "size=${channelList.channel.size}, res=${channelList.channel}")

            Log.d(TAG, "onCreateView: set recyclerView")
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

            Log.d(TAG, "onCreateView: set layoutManager")
            val layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = layoutManager
            Log.d(TAG, "onCreateView: set MainViewAdapter")
            recyclerView.adapter = MainViewAdapter(channelList)
        }

        Log.d(TAG, "onCreateView: end")
        return view
    }

}