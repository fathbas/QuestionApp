package com.fatihb.question.service

import com.fatihb.question.model.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestApiService {
    private val baseUrl = "https://opentdb.com/"
    private val api = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuestionApi::class.java)

      fun getData(category: String, diff: String): Call<Result>? {
        return api.getQuestion(category, diff)
    }
}