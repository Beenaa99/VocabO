package com.example.myquizapp

object constants{
    const val USER_NAME: String = "UserName"
    const val TOTAL: String = "Total Quest"
    const val CORRECT: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(1,
            "What is the synonym of the given word?",
            "PENSIVE",
            "Wistful",
            "Incognitant",
            "Morose",
            "Defensive",
            1 )

        questionList.add(que1)

        val que2 = Question(
            2,
            "What is the closest meaning the word: ",
            "verisimilitude",
            "Honest",
            "Naive",
            "the appearance of being real",
            "belie",
            3)
        questionList.add(que2)

        val que3 = Question(
            3,
            "What is the antonym of:" ,
            "serendipity",
            "bad luck",
            "Positivity",
            "Serene atmosphere",
            "beneficial occurrence of events",
            4)
        questionList.add(que3)
        val que4 = Question(
            4,
            "What is the antonym of:" ,
            "Astute",
            "Brilliant",
            "Canny",
            "Ingenious",
            "dim-wit",
            4)
        questionList.add(que4)
        val que5 = Question(
            5,
            "Which of the following is not the synonym of :" ,
            "Diatribe",
            "Harangue",
            "Tirade",
            "Diaspora",
            "Vituperation",
            3)
        questionList.add(que5)

        return questionList
    }
}