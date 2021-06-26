package com.matheus.testelojong.feature.home.data.remote.mapper

import com.matheus.testelojong.feature.home.data.remote.model.FactsResponse
import com.matheus.testelojong.feature.home.data.remote.model.StatusResponse
import com.matheus.testelojong.feature.home.data.model.FactsModel
import com.matheus.testelojong.feature.home.data.model.StatusModel

object FactsMapper {

    fun toDomain(factsResponseList: List<FactsResponse>?): List<FactsModel> {
        return if (factsResponseList.isNullOrEmpty()) {
            emptyList()
        } else {
            parseFactsList(factsResponseList)
        }
    }

    private fun parseFactsList(factsResponseList: List<FactsResponse>): List<FactsModel> =
        factsResponseList.map {
            FactsModel(
                status = parseStatus(it.status),
                type = it.type ?: "",
                deleted = it.deleted ?: false,
                id = it.id ?: "",
                user = it.user ?: "",
                text = it.text ?: "",
                v = it.v ?: 0,
                source = it.source ?: "",
                updatedAt = it.updatedAt ?: "",
                createdAt = it.createdAt ?: "",
                used = it.used ?: false,
            )
        }

    private fun parseStatus(statusResponse: StatusResponse?): StatusModel =
        StatusModel(
            verified = statusResponse?.verified ?: false,
            sentCount = statusResponse?.sentCount ?: 0
        )
}