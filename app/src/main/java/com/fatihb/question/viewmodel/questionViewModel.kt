package com.fatihb.question.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fatihb.question.model.Quest
import com.fatihb.question.model.Result
import com.fatihb.question.service.QuestApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class QuestionViewModel: ViewModel() {

    private val questApiService = QuestApiService()
    private val compositeDisposable = CompositeDisposable()
    val questionList = MutableLiveData<List<Quest>>()

    fun refreshData(category: String, diff: String){
        getDataFromApi(category,diff)
    }

    private fun getDataFromApi(category: String, diff: String){
        compositeDisposable.add(
            questApiService
                .getData(category,diff)
                !!.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Result>(){
                    override fun onSuccess(t: Result) {
                        questionList.value = t.results
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }


}