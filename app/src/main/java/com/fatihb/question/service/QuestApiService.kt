package com.fatihb.question.service

import com.fatihb.question.model.Quest
import com.fatihb.question.model.Result
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuestApiService {
    private val BASE_URL = "https://opentdb.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(QuestionApi::class.java)


    fun getData(): Single<Result>{
        return api.getQuestion()
    }
}