package com.matheus.testelojong.feature.home.data.remote.model

import com.google.gson.annotations.SerializedName


data class FactsResponse(
    @SerializedName("status")
    val status: StatusResponse?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("deleted")
    val deleted: Boolean?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("user")
    val user: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("__v")
    val v: Int?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("used")
    val used: Boolean?
)

