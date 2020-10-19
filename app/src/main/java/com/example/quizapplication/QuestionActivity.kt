package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    var progression = 0
    var scoreCount = 0
    var listOfQuestions = getQuestions() // Hämtar listan med frågor från Question klassen.

    lateinit var myAnswer: String
    lateinit var questionText: TextView
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var progressionBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionText = findViewById(R.id.questionView)
        btn1 = findViewById<Button>(R.id.b1)
        btn2 = findViewById<Button>(R.id.b2)
        btn3 = findViewById<Button>(R.id.b3)
        btn4 = findViewById<Button>(R.id.b4)
        progressionBar = findViewById<ProgressBar>(R.id.progressBar)

        setQuestion()

        btn1.setOnClickListener() {

            if (btn1.text == myAnswer) {
                Log.d("!!!", "Correct answer!")
                scoreCount++
                progression++
                checkPosition()
            } else {
                Log.d("!!!", "Wrong answer!")
                progression++
                checkPosition()
            }
        }

        btn2.setOnClickListener() {

            if (btn2.text == myAnswer) {
                Log.d("!!!", "Correct answer!")
                scoreCount++
                progression++
                checkPosition()
            } else {
                Log.d("!!!", "Wrong answer")
                progression++
                checkPosition()
            }
        }

        btn3.setOnClickListener() {

            if (btn3.text == myAnswer) {
                Log.d("!!!", "Correct answer!")
                scoreCount++
                progression++
                checkPosition()
            } else {
                Log.d("!!!", "Wrong answer!")
                progression++
                checkPosition()
            }
        }

        btn4.setOnClickListener() {

            if (btn4.text == myAnswer) {
                Log.d("!!!", "Correct answer!")
                scoreCount++
                progression++
                checkPosition()
            } else {
                Log.d("!!!", "Wrong answer!")
                progression++
                checkPosition()
            }
        }
    }

    private fun checkPosition() {

        val getIntent = intent
        var username: String? = getIntent.getStringExtra("userName")

        when{
            listOfQuestions.size  != 0 -> {
                setQuestion()
            }else -> {
               val intent = Intent(this, DisplayScoreActivity::class.java)
                intent.putExtra("Score", scoreCount)
                intent.putExtra("userName", username)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
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
        progressionBar.progress = progression
        progressionBar.max = 25

        return qst
    }
}







