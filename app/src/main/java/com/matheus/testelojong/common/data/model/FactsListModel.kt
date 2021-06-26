package com.matheus.testelojong.common.data.model

import android.os.Parcelable
import com.matheus.testelojong.feature.home.data.model.FactsModel
import kotlinx.parcelize.Parcelize

@Parcelize
class FactsListModel: ArrayList<FactsModel>(), Parcelable