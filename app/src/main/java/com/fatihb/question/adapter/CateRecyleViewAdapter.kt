package com.fatihb.question.adapter

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fatihb.question.view.CategoriesDirections
import com.fatihb.questionapp.R
import kotlinx.android.synthetic.main.cate_row.view.*

class cateRecyleViewAdapter(private val list: HashMap<String,String>): RecyclerView.Adapter<cateRecyleViewAdapter.RowHolder>() {

    private val colorList: Array<String> = arrayOf("#F36E0C","#D2722B","#B7703C","#855D40","#6D523F")
    class RowHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(cateName: String, position: Int,colorList: Array<String>){

            itemView.cate.setBackgroundColor(Color.parseColor(colorList[position % 5]))
            itemView.cate.text = cateName
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RowHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cate_row,parent,false)

        return RowHolder(view)

    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.bind(list.keys.elementAt(position),position,colorList)

        holder.itemView.setOnClickListener {
            val action = CategoriesDirections.actionCategoriesToSelectDiff(list[list.keys.elementAt(position)].toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}