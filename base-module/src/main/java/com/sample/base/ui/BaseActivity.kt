package com.sample.base.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.base.R
import com.google.android.material.snackbar.Snackbar
import com.sample.base.utils.NetworkConnectivityUtils
import com.sample.base.utils.getColorRes
import com.sample.base.utils.hide
import com.sample.base.utils.show

abstract class BaseActivity : AppCompatActivity() {
    abstract fun initWidget()
    abstract fun getConnectivityTxtId(): TextView?
    abstract fun getConnectivityLayoutId(): LinearLayout?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideKeyboard(this)
        initWidget()
        getConnectivityLayoutId()
        getConnectivityTxtId()
        handleNetworkChanges()
    }


    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    @Suppress("DEPRECATION")
    fun overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    @Suppress("DEPRECATION")
    fun overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransitionExit()
    }

    fun dismissKeyboard(activity: Activity) {
        val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (null != activity.currentFocus) imm.hideSoftInputFromWindow(activity.currentFocus!!.applicationWindowToken, 0)
    }


    fun showSoftKeyboard(context: Context, view: View) {
        if (view.requestFocus()) {
            val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideKeyboard(activity: Activity) {
        try {
            val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            var view = activity.currentFocus
            if (view == null) {
                view = View(activity)
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (_: Exception) {}
    }

    fun showToast(root: View, messageRes: String, length: Int = Snackbar.LENGTH_LONG) {
        val snackBar = Snackbar.make(root, messageRes, length)
        snackBar.show()
    }

    private fun handleNetworkChanges() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NetworkConnectivityUtils.getNetworkLiveData(applicationContext).observe(this) { isConnected ->
                if (!isConnected) {
                        getConnectivityTxtId()?.text = resources.getString(R.string.text_no_connectivity)
                        getConnectivityLayoutId()?.apply {
                            show()
                            setBackgroundColor(getColorRes(R.color.color_red))
                        }
                } else {
                        getConnectivityTxtId()?.text = resources.getString(R.string.text_connectivity)
                        getConnectivityLayoutId()?.apply {
                            setBackgroundColor(getColorRes(R.color.color_green))

                            animate()
                                .alpha(1f)
                                .setStartDelay(ANIMATION_DURATION)
                                .setDuration(ANIMATION_DURATION)
                                .setListener(object : AnimatorListenerAdapter() {
                                    override fun onAnimationEnd(animation: Animator) {
                                        hide()
                                    }
                                })
                        }
                }
            }
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 1000L
    }
}