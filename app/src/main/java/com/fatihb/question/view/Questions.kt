package com.fatihb.question.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
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
    }

    override fun onResume() {
        super.onResume()
            var i = 0
            var correctScore = 0
            ques.text = questionList[0].question
            ans4.text = questionList[0].incorrect_answers!![0]
            ans3.text = questionList[0].incorrect_answers!![1]
            ans2.text = questionList[0].incorrect_answers!![2]
            ans1.text = questionList[0].correct_answer
            ans1.setOnClickListener {
                if (ans1.text == questionList[i].correct_answer){
                    correctScore += 1
                    i+=1
                }else{
                    i+=1
                }
                ques.text = questionList[i].question
                ans4.text = questionList[i].incorrect_answers!![0]
                ans3.text = questionList[i].incorrect_answers!![1]
                ans2.text = questionList[i].incorrect_answers!![2]
                ans1.text = questionList[i].correct_answer
            }
            ans2.setOnClickListener {
                if (ans2.text == questionList[i].correct_answer){
                    correctScore += 1
                    i+=1
                }else{
                    i+=1
                }
                ques.text = questionList[i].question
                ans4.text = questionList[i].incorrect_answers!![0]
                ans3.text = questionList[i].incorrect_answers!![1]
                ans2.text = questionList[i].incorrect_answers!![2]
                ans1.text = questionList[i].correct_answer
            }
            ans3.setOnClickListener {
                if (ans2.text == questionList[i].correct_answer){
                    correctScore += 1
                    i+=1
                }else{
                    i+=1
                }
                ques.text = questionList[i].question
                ans4.text = questionList[i].incorrect_answers!![0]
                ans3.text = questionList[i].incorrect_answers!![1]
                ans2.text = questionList[i].incorrect_answers!![2]
                ans1.text = questionList[i].correct_answer
            }
            ans4.setOnClickListener {
                if (ans2.text == questionList[i].correct_answer){
                    correctScore += 1
                }else{
                    i+=1
                }
                ques.text = questionList[i].question
                ans4.text = questionList[i].incorrect_answers!![0]
                ans3.text = questionList[i].incorrect_answers!![1]
                ans2.text = questionList[i].incorrect_answers!![2]
                ans1.text = questionList[i].correct_answer
        }
    }


    private fun observeLiveData(){
        viewModel.questionList.observe(viewLifecycleOwner, { questions ->
            questions?.let {
                questionList = it
                println(questionList.size)
                println(it.size)
            }
        })
    }

}