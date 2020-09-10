@file:Suppress("DEPRECATION")

package com.fatihb.question.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.fatihb.question.model.Quest
import com.fatihb.question.viewmodel.QuestionViewModel
import com.fatihb.questionapp.R
import kotlinx.android.synthetic.main.fragment_questions.*

class Questions : Fragment() {

    private lateinit var viewModel: QuestionViewModel
    private lateinit var time: CountDownTimer
    private lateinit var buttonList: Array<Button>
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(activity!!)
                builder.setTitle("Exit")
                builder.setMessage("Do you want to exit?")
                builder.setPositiveButton("Quit") { _, _ ->
                    activity?.moveTaskToBack(true)
                    activity?.finish()
                }
                builder.setNegativeButton("Categories") { _, _ ->
                    val action = QuestionsDirections.actionQuestionsToCategories()
                    Navigation.findNavController(timer).navigate(action)
                }
                builder.show()
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        buttonList = arrayOf(ans1,ans2,ans3,ans4)
        var category = ""
        var diff = ""
        arguments?.let {
            category = QuestionsArgs.fromBundle(it).categories
            diff = QuestionsArgs.fromBundle(it).diff
        }

        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
        viewModel.refreshData(category,diff)
        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.questionList.observe(viewLifecycleOwner, { questions ->
            questions?.let {
                takeDatas(it)
            }
        })
    }

    private fun showDatas(questionList: List<Quest>){

        replaceForData("&#039;","'", questionList)
        replaceForData("&quot;","", questionList)

        val randomNumber = (0..3).shuffled()

        ques.text = questionList[i].question
        buttonList[randomNumber[0]].text = questionList[i].incorrect_answers!![0]
        buttonList[randomNumber[1]].text = questionList[i].incorrect_answers!![1]
        buttonList[randomNumber[2]].text = questionList[i].incorrect_answers!![2]
        buttonList[randomNumber[3]].text = questionList[i].correct_answer
    }

    private fun replaceForData(s: String, new: String, questionList: List<Quest>){
        if (questionList[i].question!!.contains(s)){
            questionList[i].question = questionList[i].question!!.replace(s,new,true)
        }
        if (questionList[i].correct_answer!!.contains(s)){
            questionList[i].correct_answer = questionList[i].correct_answer!!.replace(s,new,true)
        }
        if (questionList[i].incorrect_answers!![0].contains(s)){
            questionList[i].incorrect_answers!![0] = questionList[i].incorrect_answers!![0].replace(s,new,true)
        }
        if (questionList[i].incorrect_answers!![1].contains(s)){
            questionList[i].incorrect_answers!![1] = questionList[i].incorrect_answers!![1].replace(s,new,true)
        }
        if (questionList[i].incorrect_answers!![2].contains(s)){
            questionList[i].incorrect_answers!![2] = questionList[i].incorrect_answers!![2].replace(s,new,true)
        }
    }

    private fun takeDatas(questionList: List<Quest>){
        loadingData.visibility = View.GONE
        timer.visibility = View.VISIBLE
        ques.visibility = View.VISIBLE
        ans1.visibility = View.VISIBLE
        ans2.visibility = View.VISIBLE
        ans3.visibility = View.VISIBLE
        ans4.visibility = View.VISIBLE

        var correctScore = 0

        time = object : CountDownTimer(90000,1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                timer.text = "Time: " + millisUntilFinished/1000
            }
            override fun onFinish() {
                val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                Navigation.findNavController(timer).navigate(action)
            }
        }.start()
        showDatas(questionList)
        ans1.setOnClickListener {
            if (ans1.text == questionList[i].correct_answer){
                correctScore += 1
                i+=1
            }else{
                i+=1
            }
            if (i == questionList.size){
                val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                Navigation.findNavController(it).navigate(action)
            }else{
                showDatas(questionList)
            }
        }
        ans2.setOnClickListener {
            if (ans2.text == questionList[i].correct_answer){
                correctScore += 1
                i+=1
            }else{
                i+=1
            }
            if (i == questionList.size){
                val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                Navigation.findNavController(it).navigate(action)
            }else{
                showDatas(questionList)
            }
        }
        ans3.setOnClickListener {
            if (ans3.text == questionList[i].correct_answer){
                correctScore += 1
                i+=1
            }else{
                i+=1
            }
            if (i == questionList.size){
                val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                Navigation.findNavController(it).navigate(action)
            }else{
                showDatas(questionList)
            }
        }
        ans4.setOnClickListener {
            if (ans4.text == questionList[i].correct_answer){
                correctScore += 1
                i+=1
            }else{
                i+=1
            }
            if (i == questionList.size){
                val action = QuestionsDirections.actionQuestionsToFinalScore(correctScore,questionList.size)
                Navigation.findNavController(it).navigate(action)
            }else{
                showDatas(questionList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        time.cancel()
    }
}