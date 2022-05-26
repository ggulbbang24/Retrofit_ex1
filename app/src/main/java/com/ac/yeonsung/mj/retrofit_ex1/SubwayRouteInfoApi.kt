package com.ac.yeonsung.mj.retrofit_ex1

import com.ac.yeonsung.mj.retrofit_ex1.BuildConfig.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val endpoint_status = "trainUseInfo/subwayRouteInfo"
const val api_serviceKey = "\$2a\$10\$D2hkwqnakao1HkkyyI7qHueXVrS93alTWdMf2WyMIvKVuIJGS.JDa"

interface SubwayRouteInfoApi {
    @GET(endpoint_status)
    fun loadSubwayRoute(
        @Query("lnCd") lnCd: String,
        @Query("format") format: String = "json",
        @Query("serviceKey") serviceKey: String = api_serviceKey
    ): Call<Subway>
}
