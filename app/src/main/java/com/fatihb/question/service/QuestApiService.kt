package com.fatihb.question.service

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


    fun getData(category: String, diff: String): Single<Result>? {
        if (category == "9"){
            if (diff == "easy"){
                return api.getQuestionGeneralKnowledgeEasy()
            }
            if (diff == "medium"){
                return api.getQuestionGeneralKnowledgeMedium()
            }
            if (diff == "hard"){
                return api.getQuestionGeneralKnowledgeHard()
            }
        }
        if (category == "10"){
            if (diff == "easy"){
                return api.getQuestionBooksEasy()
            }
            if (diff == "medium"){
                return api.getQuestionBooksMedium()
            }
            if (diff == "hard"){
                return api.getQuestionBooksHard()
            }
        }
        if (category == "11"){
            if (diff == "easy"){
                return api.getQuestionFilmEasy()
            }
            if (diff == "medium"){
                return api.getQuestionFilmMedium()
            }
            if (diff == "hard"){
                return api.getQuestionFilmHard()
            }
        }
        if (category == "12"){
            if (diff == "easy"){
                return api.getQuestionMusicEasy()
            }
            if (diff == "medium"){
                return api.getQuestionMusicMedium()
            }
            if (diff == "hard"){
                return api.getQuestionMusicHard()
            }
        }
        if (category == "15"){
            if (diff == "easy"){
                return api.getQuestionVideoGamesEasy()
            }
            if (diff == "medium"){
                return api.getQuestionVideoGamesMedium()
            }
            if (diff == "hard"){
                return api.getQuestionVideoGamesHard()
            }
        }
        return null
    }
}