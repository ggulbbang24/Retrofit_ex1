package com.ac.yeonsung.mj.retrofit_ex1

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body

data class Subway(
//    val resultCnt: Integer,
//    val resultCode: String,
//    val resultMsg: String,
    val DataModel: DataModel?
)

data class DataModel(
    val content: ArrayList<BodyModel>
)

data class BodyModel (@Body
//    val mreaWideCd: String, // 권역코드
//    val routCd: String, // 노선코드
//    val routNm: String, // 노선이름

//    @SerializedName("stinConsOrdr")
//    val stinConsOrdr: Integer, // 역구성순서

//    val railOprIsttCd: String, // 철도운영기관코드

    @SerializedName("lnCd")
    val lnCd: String?, // 선코드

    @SerializedName("stinCd")
    val stinCd: String?, // 역코드

    @SerializedName("stinNm")
    val stinNm: String? // 역명
)