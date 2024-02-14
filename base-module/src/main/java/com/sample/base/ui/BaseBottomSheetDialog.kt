package com.sample.base.ui

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.FrameLayout
import com.example.myapplication.base.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheetDialog: BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) setWhiteNavigationBar(dialog)
        return dialog
    }


    private fun setWhiteNavigationBar(dialog: Dialog) {
        val window = dialog.window
        if (window != null) {
            val metrics = DisplayMetrics()
            window.windowManager.defaultDisplay.getMetrics(metrics)
            val dimDrawable = GradientDrawable()
            val navigationBarDrawable = GradientDrawable()
            navigationBarDrawable.shape = GradientDrawable.RECTANGLE
            val backgroundColor: Int = resources.getColor(R.color.primary_black)
            navigationBarDrawable.setColor(backgroundColor)
            val layers = arrayOf<Drawable>(dimDrawable, navigationBarDrawable)
            val windowBackground = LayerDrawable(layers)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                windowBackground.setLayerInsetTop(1, metrics.heightPixels)
            }
            window.setBackgroundDrawable(windowBackground)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            dialog.setOnShowListener { dialog1: DialogInterface ->
                val d = dialog1 as BottomSheetDialog
                val bottomSheet =
                    d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
                if (bottomSheet != null) {
                    BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
                }
            }
        }
    }
}