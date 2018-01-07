package com.howshea.transparentprogressdialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private val progressDialog = TransparentDialog()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressDialog.show(supportFragmentManager)
        timer("", false, 3000, 1) {
            progressDialog.dismiss()
        }

    }
}
