package com.kilvish.autoassign.binding

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("goneUnless")
    fun goneUnlessWithSlideUp(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("enableRotation")
    fun enableRotation(view: ImageView, enable: Boolean) {
        if (enable) {
            val objectAnimator = ObjectAnimator.ofFloat(view, View.ROTATION, 0.0f, 360.0f)
            objectAnimator.duration = 2000
            objectAnimator.repeatCount = Animation.INFINITE
            objectAnimator.start()
        }
    }
}