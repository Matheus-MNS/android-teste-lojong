package com.matheus.testelojong.feature.home.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatusModel(
    var verified: Boolean,
    var sentCount: Int
):Parcelable

