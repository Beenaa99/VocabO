package com.example.myquizapp

data class Question(
    val id: Int,
    val Q: String,
    val word: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)

