package com.fatihb.question.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.fatihb.question.viewmodel.questionViewModel
import com.fatihb.questionapp.R
import kotlinx.android.synthetic.main.fragment_questions.*

class Questions : Fragment() {

    private lateinit var viewModel: questionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(questionViewModel::class.java)
        viewModel.refreshData()
        observeLiveData()
    }


    fun observeLiveData(){
        viewModel.questionList.observe(viewLifecycleOwner, Observer {questions ->
            questions?.let {
                ques.text = it[1].incorrect_answers!![2]

            }

        })
    }

}