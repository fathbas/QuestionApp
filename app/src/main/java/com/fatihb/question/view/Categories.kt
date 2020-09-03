package com.fatihb.question.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fatihb.question.adapter.cateRecyleViewAdapter
import com.fatihb.questionapp.R
import kotlinx.android.synthetic.main.fragment_categories.*


class Categories : Fragment() {

    private lateinit var cateList: HashMap<String,String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cateList = HashMap()
        cateList["General Knowledge"] = "9"
        cateList["Sports"] = "21"
        cateList["Celebrities"] = "26"
        cateList["Books"] = "10"
        cateList["Film"] = "11"
        cateList["Music"] = "12"
        cateList["Video Games"] = "15"
        cateList["Animals"] = "27"
        cateList["Art"] = "25"
        cateList["Board Games"] = "16"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        listOfCate.layoutManager = layoutManager
        listOfCate.adapter = cateRecyleViewAdapter(cateList)

    }
}