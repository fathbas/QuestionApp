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
        var cate = ""
        arguments?.let {
             cate = SelectDiffArgs.fromBundle(it).cate
        }
        easyBut.setOnClickListener {
            navDirection(it,cate, easyBut.text.toString())
        }
        mediumBut.setOnClickListener {
            navDirection(it,cate, mediumBut.text.toString())
        }
        hardBut.setOnClickListener {
            navDirection(it,cate, hardBut.text.toString())
        }
    }


    fun navDirection(view: View,category: String, diff: String){
        val action = SelectDiffDirections.actionSelectDiffToQuestions(category,diff)
        Navigation.findNavController(view).navigate(action)
    }
}