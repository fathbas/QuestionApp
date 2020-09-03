package com.fatihb.question.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fatihb.questionapp.R
import java.lang.Exception

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Create variable for when later user can see login screen
        val background = object : Thread(){
            override fun run() {
                super.run()
                try {
                    sleep(2000)
                        val intent = Intent(this@SplashScreen, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                }catch (e : Exception){
                    e.printStackTrace()
                }

            }
        }
        background.start()
    }
}