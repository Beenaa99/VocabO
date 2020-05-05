package com.example.myquizapp

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*
import java.util.ArrayList

@RequiresApi(Build.VERSION_CODES.N)

class Questions : AppCompatActivity(), View.OnClickListener {
    private var currentPosition: Int = 1
    private var questionsList : ArrayList<Question>? = null
    private var selected : Int = 0
    private var correctAns: Int = 0
    private var userName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        userName = intent.getStringExtra(constants.USER_NAME)
        questionsList = constants.getQuestions()


        setQuestion()

        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)
        submit.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_optionOne -> {
                selectedOptionView(tv_optionOne, 1)
            }
            R.id.tv_optionTwo -> {
                selectedOptionView(tv_optionTwo, 2)
            }
            R.id.tv_optionThree -> {
                selectedOptionView(tv_optionThree, 3)
            }
            R.id.tv_optionFour -> {
                selectedOptionView(tv_optionFour, 4)
            }
            R.id.submit -> {
                if(selected == 0){
                    currentPosition ++

                    when{
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }else -> {
                       val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(constants.USER_NAME, userName)
                        intent.putExtra(constants.CORRECT, correctAns)
                        intent.putExtra(constants.TOTAL, questionsList!!.size)
                        startActivity(intent)
                    }
                    }

                }else{
                    val quest = questionsList?.get(currentPosition-1)
                    if(quest!!.correctAnswer != selected){
                        answerView(selected, R.drawable.wrong)
                    }
                    else{
                        correctAns++
                    }
                    answerView(quest.correctAnswer, R.drawable.correct)

                    if(currentPosition == questionsList!!.size){
                        submit.text = "Finish"
                    }else{
                        submit.text = "Go to the next question"
                    }
                    selected = 0
                }

            }
        }
    }
    private fun setQuestion(){

        val currQue = questionsList!!.get(currentPosition-1)
        defaultOptions()
        if(currentPosition == questionsList!!.size) {
            submit.text = "End The Attempt"
        }else{
            submit.text = "Submit"
        }
        progressBar.progress = currentPosition
        tv_progress.text = "$currentPosition"+ "/" + progressBar.max
        tv_question.text = currQue!!.Q
        tv_word.text = currQue!!.word
        tv_optionOne.text = currQue!!.optionOne
        tv_optionTwo.text = currQue!!.optionTwo
        tv_optionThree.text = currQue!!.optionThree
        tv_optionFour.text = currQue!!.optionFour



    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tv_optionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_optionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_optionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_optionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptions()
        selected = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)


        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)

    }
    private fun defaultOptions() {
        val options = ArrayList<TextView>()
        options.add(0, tv_optionOne)
        options.add(1, tv_optionTwo)
        options.add(2, tv_optionThree)
        options.add(3, tv_optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.option_border)
        }

    }




}