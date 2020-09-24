package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {


    var scoreCount = 0
    private var currentPos: Int = 1
    var listOfQuestions = getQuestions() // Hämtar listan med frågor från Question klassen.
    private var endGame = 0



    private lateinit var myAnswer: String
    lateinit var questionText: TextView
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var quizScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionText = findViewById(R.id.questionView)
        quizScore = findViewById(R.id.scoreView)
        btn1 = findViewById<Button>(R.id.b1)
        btn2 = findViewById<Button>(R.id.b2)
        btn3 = findViewById<Button>(R.id.b3)
        btn4 = findViewById<Button>(R.id.b4)



        Log.d(
            "!!!",
            "List size = ${listOfQuestions.size}"
        ) // Kollar så att min lista med frågor fungerar och går att hämta.


        askQuestion()

        btn1.setOnClickListener() {

            if (btn1.text == myAnswer) {
                Log.d("!!!", "Correct answer!")
                scoreCount++
                checkPosition()
            } else {
                Log.d("!!!", "Wrong answer!")

                checkPosition()

            }

        }
        btn2.setOnClickListener() {

            if (btn2.text == myAnswer) {
                Log.d("!!!", "Correct answer!")
                scoreCount++

                checkPosition()

            } else {
                Log.d("!!!", "Wrong answer")

                checkPosition()

            }

        }

        btn3.setOnClickListener() {

            if (btn3.text == myAnswer) {
                Log.d("!!!", "Correct answer!")

                scoreCount++

                checkPosition()
            } else {
                Log.d("!!!", "Wrong answer!")

                checkPosition()
            }

        }
        btn4.setOnClickListener() {

            if (btn4.text == myAnswer) {
                Log.d("!!!", "Correct answer!")
                scoreCount++
                checkPosition()

            } else {
                Log.d("!!!", "Wrong answer!")

                checkPosition()


            }

        }
    }


    private fun checkPosition() {

        currentPos++

        when{
            currentPos <= listOfQuestions.size -> {
                askQuestion()
            }else -> {
               val intent = Intent(this, DisplayScoreActivity::class.java)
                startActivity(intent)

        }

        }


    }

    private fun askQuestion() {

        val question: Question = listOfQuestions[currentPos - 1]

        myAnswer = question.correctAnswer
        questionText.text = question.question
        btn1.text = question.answer1
        btn2.text = question.answer2
        btn3.text = question.answer3
        btn4.text = question.answer4
        quizScore.text = "Current score: $scoreCount"


        Log.d("!!!", "Current pos = $currentPos")

    }
}


























    /*
    private fun defaultOptions() {

        val options = ArrayList<Button>()
        options.add(0, btn1)
        options.add(1, btn2)
        options.add(2, btn3)
        options.add(3, btn4)

        for(option in options) {
            option.typeface = Typeface.DEFAULT
        }


    }


     */


