package com.fatihb.question.view

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.fatihb.question.model.Quest
import com.fatihb.question.viewmodel.questionViewModel
import com.fatihb.questionapp.R
import kotlinx.android.synthetic.main.fragment_questions.*

class Questions : Fragment() {

    private lateinit var viewModel: questionViewModel
    private lateinit var questionList: List<Quest>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var category = ""
        var diff = ""
        arguments?.let {
            category = QuestionsArgs.fromBundle(it).categories
            diff = QuestionsArgs.fromBundle(it).diff
        }
        questionList = emptyList()
        viewModel = ViewModelProviders.of(this).get(questionViewModel::class.java)
        viewModel.refreshData(category,diff)
        observeLiveData()
        val handler = Handler()

        handler.postDelayed(Runnable {
            loadingData.visibility = View.GONE
            timer.visibility = View.VISIBLE
            ques.visibility = View.VISIBLE
            ans1.visibility = View.VISIBLE
            ans2.visibility = View.VISIBLE
            ans3.visibility = View.VISIBLE
            ans4.visibility = View.VISIBLE
            var i = 0
            var correctScore = 0
           val time = object : CountDownTimer(60000,1000){
                override fun onTick(millisUntilFinished: Long) {
                    timer.text = "Time: " + millisUntilFinished/1000
                }
                override fun onFinish() {
                    val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                    Navigation.findNavController(timer).navigate(action)
                }
            }.start()
            showDatas(ans1,ans2,ans3,ans4,ques,i)
            ans1.setOnClickListener {
                if (ans1.text == questionList[i].correct_answer){
                    correctScore += 1
                    i+=1
                }else{
                    i+=1
                }
                if (i == questionList.size - 1){
                    time.cancel()
                    val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                    Navigation.findNavController(it).navigate(action)
                }
                showDatas(ans1,ans2,ans3,ans4,ques,i)
            }
            ans2.setOnClickListener {
                if (ans2.text == questionList[i].correct_answer){
                    correctScore += 1
                    i+=1
                }else{
                    i+=1
                }
                if (i == questionList.size - 1){
                    time.cancel()
                    val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                    Navigation.findNavController(it).navigate(action)
                }
                showDatas(ans1,ans2,ans3,ans4,ques,i)
            }
            ans3.setOnClickListener {
                if (ans2.text == questionList[i].correct_answer){
                    correctScore += 1
                    i+=1
                }else{
                    i+=1
                }
                if (i == questionList.size -  1){
                    time.cancel()
                    val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                    Navigation.findNavController(it).navigate(action)
                }
                showDatas(ans1,ans2,ans3,ans4,ques,i)
            }
            ans4.setOnClickListener {
                if (ans2.text == questionList[i].correct_answer){
                    correctScore += 1
                }else{
                    i+=1
                }
                if (i == questionList.size - 1){
                    time.cancel()
                    val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                    Navigation.findNavController(it).navigate(action)
                }
                showDatas(ans1,ans2,ans3,ans4,ques,i)
            }
        },2000)
    }

    private fun observeLiveData(){
        viewModel.questionList.observe(viewLifecycleOwner, { questions ->
            questions?.let {
                questionList = it
            }
        })
    }

    private fun showDatas(ans1: Button,ans2: Button, ans3: Button, ans4: Button, ques: TextView, i: Int){
        ques.text = questionList[i].question
        ans4.text = questionList[i].incorrect_answers!![0]
        ans3.text = questionList[i].incorrect_answers!![1]
        ans2.text = questionList[i].incorrect_answers!![2]
        ans1.text = questionList[i].correct_answer
    }

}