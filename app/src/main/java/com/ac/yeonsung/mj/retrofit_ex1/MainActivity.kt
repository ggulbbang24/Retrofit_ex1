package com.ac.yeonsung.mj.retrofit_ex1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.recyclerview.widget.LinearLayoutManager
import com.ac.yeonsung.mj.retrofit_ex1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), CompletionListener {
    private lateinit var subwayAdapter: SubwayAdapter
    private lateinit var binding: ActivityMainBinding
    private var incd = "1"
    lateinit var retrofit: Retrofit
    lateinit var myAPI: SubwayRouteInfoApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.subwayRouteInfo.apply {
            binding.subwayRouteInfo.layoutManager = LinearLayoutManager(context)
            subwayAdapter = SubwayAdapter()
            binding.subwayRouteInfo.adapter = subwayAdapter
        }

        //retrofit setting
        retrofit = SubwayRouteClient.getInstnace() // instance를 불러옴
        myAPI =
            retrofit.create(SubwayRouteInfoApi::class.java) // 여기서 retrofit이 interface를 구현 -> 사용 가능해짐

        Runnable {
            myAPI.loadSubwayRoute("1").enqueue(object : Callback<Subway> {

                override fun onResponse(call: Call<Subway>, response: Response<Subway>) {
                        if(response.isSuccessful){
                            response.body()!!.DataModel?.let { loadComplete(it) }
                        } else {
                            responseIsNotSuccesful(response.code())
                        }
                }

                override fun onFailure(call: Call<Subway>, t: Throwable) {
                    loadFail()
                    Log.d(TAG, "실패 >> $t")
                }
            })
        }.run()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun loadComplete(dataModel: DataModel) {
        subwayAdapter.setList(dataModel.content)
        subwayAdapter.notifyDataSetChanged()
    }

    override fun responseIsNotSuccesful(code: Int) {
        Toast.makeText(this, "사이트가 응답하지 않습니다", Toast.LENGTH_SHORT).show()
        Log.v("로그", code.toString())
    }

    override fun loadFail() {
        Toast.makeText(this, "인터넷 연결을 확인하세요", Toast.LENGTH_SHORT).show()
    }

}