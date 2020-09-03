package com.fatihb.question.service

import com.fatihb.question.model.Result
import io.reactivex.Single
import retrofit2.http.GET

interface QuestionApi {

    //https://opentdb.com/api.php?amount=15&category=27&difficulty=medium&type=multiple

    @GET("api.php?amount=15&category=27&difficulty=medium&type=multiple")
    fun getQuestion():Single<Result>
}