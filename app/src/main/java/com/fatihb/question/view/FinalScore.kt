package com.fatihb.question.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.fatihb.questionapp.R
import kotlinx.android.synthetic.main.fragment_final_score.*

class FinalScore : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                    activity?.moveTaskToBack(true)
                    activity?.finish()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_final_score, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var correctAnswer: String
        correctAnswer = ""
        var totalAnswer: String
        totalAnswer = ""
        var success: Int
        success = 0
        arguments?.let {
            success = if (FinalScoreArgs.fromBundle(it).correctScore == 0){
                3
            }else{
                FinalScoreArgs.fromBundle(it).totalScore / FinalScoreArgs.fromBundle(it).correctScore
            }
            correctAnswer = FinalScoreArgs.fromBundle(it).correctScore.toString()
            totalAnswer = FinalScoreArgs.fromBundle(it).totalScore.toString()
        }

        if (success <= 2){
            congMsg.text = "Congratulations!"
        }else{
            congMsg.text = "Try one more!"
        }
        score.text = "$correctAnswer/$totalAnswer"

        goBackCate.setOnClickListener {
            val action = FinalScoreDirections.actionFinalScoreToCategories()
            Navigation.findNavController(it).navigate(action)
        }
        exit.setOnClickListener {
            activity?.moveTaskToBack(true)
            activity?.finish()
        }
    }
}