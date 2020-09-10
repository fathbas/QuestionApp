package com.fatihb.question.service

import com.fatihb.question.model.Result
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuestApiService {
    private val baseUrl = "https://opentdb.com/"
    private val api = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(QuestionApi::class.java)


    fun getData(category: String, diff: String, type: String): Single<Result>? {
        return api.getQuestion(category, diff, type)
    }
}