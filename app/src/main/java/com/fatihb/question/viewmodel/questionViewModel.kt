package com.fatihb.question.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatihb.question.model.Quest
import com.fatihb.question.model.Result
import com.fatihb.question.service.QuestApiService
import retrofit2.Call
import retrofit2.Response

class QuestionViewModel: ViewModel() {

    private val questApiService = QuestApiService()
    val questionList = MutableLiveData<List<Quest>>()


    fun refreshData(category: String, diff: String){
            getDataFromApi(category,diff)
    }

    private fun getDataFromApi(category: String, diff: String) {
            val response = questApiService.getData(category, diff)

            response?.enqueue(object : retrofit2.Callback<Result> {
                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    if (response.isSuccessful){
                        response.body()?.let {
                            questionList.value = response.body()?.results
                        }
                    }
                }
                override fun onFailure(call: Call<Result>, t: Throwable) {
                }
            })
    }
}


