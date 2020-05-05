package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val userName = intent.getStringExtra(constants.USER_NAME)
        tv_name.text = userName
        val total = intent.getIntExtra(constants.TOTAL, 0)
        val correctA = intent.getIntExtra(constants.CORRECT, 0)
        tv_score.text = "Your Score is $correctA out of $total"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java ))
            finish()
        }
    }
}
