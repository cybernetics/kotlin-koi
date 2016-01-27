package com.mcxiaoke.koi.samples

import android.os.Bundle
import com.mcxiaoke.koi.core.mainHandler
import com.mcxiaoke.koi.ext.startActivity
import com.mcxiaoke.koi.log.lv
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * User: mcxiaoke
 * Date: 15/11/5
 * Time: 15:43
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lv("onCreate() splashShowed: ${app.splashShowed}")
        if (app.splashShowed) {
            showMain()
        } else {
            setContentView(R.layout.activity_splash)
            label.text = "Hello, World!"
            mainHandler.postDelayed({ showMain() }, 3000)
        }
    }

    private fun showMain() {
        startActivity<MainActivity>()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        app.splashShowed = true
    }

}