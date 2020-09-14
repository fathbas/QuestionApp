package com.fatihb.question.service

import com.fatihb.question.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionApi {

    @GET("api.php?amount=15")
    fun getQuestion(@Query("category") cate: String, @Query("difficulty") diff: String, @Query("type") type: String = "multiple"):Call<Result>
}