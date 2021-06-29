package com.matheus.testelojong.common.extensions

import android.view.View
import com.airbnb.lottie.LottieAnimationView

fun LottieAnimationView.setVisible(){
    this.visibility = View.VISIBLE
}

fun LottieAnimationView.setGone(){
    this.visibility = View.GONE
}