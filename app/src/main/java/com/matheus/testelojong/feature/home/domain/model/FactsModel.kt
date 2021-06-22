package com.matheus.testelojong.feature.home.domain.model

data class FactsModel(
    var status: StatusModel,
    var type: String,
    var deleted: Boolean,
    var id: String,
    var user: String,
    var text: String,
    var v: Int,
    var source: String,
    var updatedAt: String,
    var createdAt: String,
    var used: Boolean
)

