package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {


    open var scoreCount = 0
    var listOfQuestions = getQuestions() // Hämtar listan med frågor från Question klassen.

    lateinit var myAnswer: String
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

        Log.d("!!!",
            "List size = ${listOfQuestions.size}"
        ) // Kollar så att min lista med frågor fungerar och går att hämta, kollar även listans storlek.


        setQuestion()

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

        when{
            listOfQuestions.size  != 0 -> {
                setQuestion()
            }else -> {
               val intent = Intent(this, DisplayScoreActivity::class.java)
                intent.putExtra("Score", scoreCount)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setQuestion() : Question {


        val rnd = (0 until listOfQuestions.size).random()
        var qst : Question = listOfQuestions.removeAt(rnd)


        myAnswer = qst.correctAnswer
        questionText.text = qst.question
        btn1.text = qst.answer1
        btn2.text = qst.answer2
        btn3.text = qst.answer3
        btn4.text = qst.answer4
        quizScore.text = "Current score: ${scoreCount}"

        //Log.d("!!!", "Current pos = $currentPos")
        return qst

    }
}







