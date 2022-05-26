package com.ac.yeonsung.mj.retrofit_ex1

interface CompletionListener {
    fun loadComplete(data: DataModel)
    fun responseIsNotSuccesful(code: Int)
    fun loadFail()
}