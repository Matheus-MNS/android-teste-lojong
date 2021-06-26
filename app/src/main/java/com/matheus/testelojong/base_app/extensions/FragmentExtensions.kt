package com.matheus.testelojong.base_app.extensions

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.matheus.testelojong.R

fun Fragment.changeStatusBarColor(color: Int) {
    activity?.changeStatusBarColor(color)
}

fun Toast.showCustomToast(menssage: String, activity: Activity?) {

    val layout = activity?.layoutInflater?.inflate(
        R.layout.customer_toast, activity.findViewById(R.id.toastContainer)
    )

    val textView = layout?.findViewById<TextView>(R.id.toastText)
    textView?.text = menssage

    this.apply {
        setGravity(Gravity.BOTTOM, 0,40)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}
