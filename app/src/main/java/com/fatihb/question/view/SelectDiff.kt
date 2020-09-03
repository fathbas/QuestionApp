package com.fatihb.question.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fatihb.questionapp.R
import kotlinx.android.synthetic.main.fragment_select_diff.*


class SelectDiff : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_diff, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        easyBut.setOnClickListener {
            navDirection(it)
        }
        mediumBut.setOnClickListener {
            navDirection(it)
        }
        hardBut.setOnClickListener {
            navDirection(it)
        }
    }


    fun navDirection(view: View){
        val action = SelectDiffDirections.actionSelectDiffToQuestions()
        Navigation.findNavController(view).navigate(action)

    }
}