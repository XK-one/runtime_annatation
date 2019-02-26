package com.wyk.runtime_annatation

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.wyk.ioc_annotation.ContentView

open class BaseActivity: AppCompatActivity() {

    val TAG = "runtime_annatation_wyk"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        annotationContentView()
    }

    private fun annotationContentView() {
        var javaClass = this.javaClass
        while(true){
            Log.i(TAG,"superClass.name==${javaClass.name}")
            if(javaClass == Context::class.java) break
            val contentView = javaClass.getAnnotation(ContentView::class.java)
            if(contentView != null){
                Log.i(TAG, "layout==${contentView.layout}")
                try {
                    this.setContentView(contentView.layout)
                }catch (e: RuntimeException){
                    e.printStackTrace()
                }
            }
            javaClass = javaClass.superclass as Class<BaseActivity>
        }

    }
}