package com.fatihb.question.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("response_code")
    val response_code: Int?,
    @SerializedName("results")
    val results: List<Quest>?
)