package com.wyk.runtime_annatation

import android.os.Bundle
import com.wyk.ioc_annotation.ContentView

@ContentView(R.layout.activity_main)
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
    }
}
