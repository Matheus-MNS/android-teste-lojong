package com.matheus.testelojong.base_app.common.domain.model

import android.os.Parcelable
import com.matheus.testelojong.feature.home.domain.model.FactsModel
import kotlinx.parcelize.Parcelize

@Parcelize
class FactsListModel: ArrayList<FactsModel>(), Parcelable