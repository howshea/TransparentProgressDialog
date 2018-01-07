package com.howshea.transparentprogressdialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.view.WindowManager
import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 * Created by haipo
 * on 2018/1/7.
 */
class TransparentDialog() : DialogFragment() {

    private lateinit var reference: Reference<FragmentManager>

    @SuppressLint("ValidFragment")
    constructor(fm: FragmentManager) : this() {
        reference = WeakReference(fm)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context!!, R.style.TransparentDialog)
            .setView(R.layout.dialog_transparent)
            .create()
    }

    override fun onStart() {
        super.onStart()
        isCancelable = true
        dialog.setCanceledOnTouchOutside(false)
        val params = dialog.window.attributes.apply {
            width = WindowManager.LayoutParams.WRAP_CONTENT
            height = WindowManager.LayoutParams.WRAP_CONTENT
        }
        dialog.window.attributes = params
    }

    fun show(fm: FragmentManager) = show(fm, "")
}