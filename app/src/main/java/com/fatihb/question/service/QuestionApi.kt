package com.fatihb.question.service

import com.fatihb.question.model.Result
import io.reactivex.Single
import retrofit2.http.GET

interface QuestionApi {

    @GET("api.php?amount=15&category=9&difficulty=hard&type=multiple")
    fun getQuestionGeneralKnowledgeHard():Single<Result>
    @GET("api.php?amount=15&category=9&difficulty=medium&type=multiple")
    fun getQuestionGeneralKnowledgeMedium():Single<Result>
    @GET("api.php?amount=15&category=9&difficulty=easy&type=multiple")
    fun getQuestionGeneralKnowledgeEasy():Single<Result>
    @GET("api.php?amount=15&category=10&difficulty=hard&type=multiple")
    fun getQuestionBooksHard():Single<Result>
    @GET("api.php?amount=15&category=10&difficulty=medium&type=multiple")
    fun getQuestionBooksMedium():Single<Result>
    @GET("api.php?amount=15&category=10&difficulty=easy&type=multiple")
    fun getQuestionBooksEasy():Single<Result>
    @GET("api.php?amount=15&category=11&difficulty=hard&type=multiple")
    fun getQuestionFilmHard():Single<Result>
    @GET("api.php?amount=15&category=11&difficulty=medium&type=multiple")
    fun getQuestionFilmMedium():Single<Result>
    @GET("api.php?amount=15&category=11&difficulty=easy&type=multiple")
    fun getQuestionFilmEasy():Single<Result>
    @GET("api.php?amount=15&category=12&difficulty=hard&type=multiple")
    fun getQuestionMusicHard():Single<Result>
    @GET("api.php?amount=15&category=12&difficulty=medium&type=multiple")
    fun getQuestionMusicMedium():Single<Result>
    @GET("api.php?amount=15&category=12&difficulty=easy&type=multiple")
    fun getQuestionMusicEasy():Single<Result>
    @GET("api.php?amount=15&category=15&difficulty=hard&type=multiple")
    fun getQuestionVideoGamesHard():Single<Result>
    @GET("api.php?amount=15&category=15&difficulty=medium&type=multiple")
    fun getQuestionVideoGamesMedium():Single<Result>
    @GET("api.php?amount=15&category=15&difficulty=easy&type=multiple")
    fun getQuestionVideoGamesEasy():Single<Result>


}