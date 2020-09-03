package com.fatihb.question.model

import com.google.gson.annotations.SerializedName


data class Quest(

    @SerializedName("category")
    val category: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("difficulty")
    val difficulty: String?,
    @SerializedName("question")
    val question: String?,
    @SerializedName("correct_answer")
    val correct_answer: String?,
    @SerializedName("incorrect_answers")
    val incorrect_answers: ArrayList<String>?

)