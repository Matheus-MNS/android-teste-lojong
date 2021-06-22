package com.matheus.testelojong.feature.home.data.remote.model

import com.google.gson.annotations.SerializedName

data class StatusResponse(
    @SerializedName("verified")
    val verified: Boolean?,
    @SerializedName("sentCount")
    val sentCount: Int?
)

