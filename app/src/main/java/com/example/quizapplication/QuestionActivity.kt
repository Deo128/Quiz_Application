package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.*

class QuestionActivity : AppCompatActivity() {

    var progression = 0
    var scoreCount = 0
    var listOfQuestions: ArrayList<Question>? = null // Hämtar listan med frågor från Question klassen.

    lateinit var myAnswer: String
    lateinit var questionText: TextView
    lateinit var btn1: TextView
    lateinit var btn2: TextView
    lateinit var btn3: TextView
    lateinit var btn4: TextView
    lateinit var progressionBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        listOfQuestions = getQuestions()
        questionText = findViewById(R.id.questionView)
        btn1 = findViewById<TextView>(R.id.b1)
        btn2 = findViewById<TextView>(R.id.b2)
        btn3 = findViewById<TextView>(R.id.b3)
        btn4 = findViewById<TextView>(R.id.b4)
        progressionBar = findViewById<ProgressBar>(R.id.progressBar)

        setQuestion()

        btn1.setOnClickListener() {

            if (btn1.text == myAnswer) {
                btn1.background = ContextCompat.getDrawable(this, R.drawable.correct_option_button)
                Log.d("!!!", "Correct answer!")
                Handler().postDelayed({
                    scoreCount++
                    progression++
                    checkPosition()
                }, 1000)
            } else {
                btn1.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    checkPosition()
                }, 1000)
            }
        }

        btn2.setOnClickListener() {

            if (btn2.text == myAnswer) {
                btn2.background = ContextCompat.getDrawable(this, R.drawable.correct_option_button)
                Log.d("!!!", "Correct answer!")
                Handler().postDelayed({
                    scoreCount++
                    progression++
                    checkPosition()
                }, 1000)
            } else {
                btn2.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    checkPosition()
                }, 1000)
            }
        }

        btn3.setOnClickListener() {

            if (btn3.text == myAnswer) {
                btn3.background = ContextCompat.getDrawable(this, R.drawable.correct_option_button)
                Log.d("!!!", "Correct answer!")
                Handler().postDelayed({
                    scoreCount++
                    progression++
                    checkPosition()
                }, 1000)
            } else {
                btn3.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    checkPosition()
                }, 1000)
            }
        }

        btn4.setOnClickListener() {

            if (btn4.text == myAnswer) {
                btn4.background = ContextCompat.getDrawable(this, R.drawable.correct_option_button)
                Log.d("!!!", "Correct answer!")
                Handler().postDelayed({
                    scoreCount++
                    progression++
                    checkPosition()
                     }, 1000)

            } else {
                btn4.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    checkPosition()
                }, 1000)
            }
        }

    }

    private fun checkPosition() {

        val getIntent = intent
        var username: String? = getIntent.getStringExtra("userName")

        when{
            listOfQuestions!!.size  != 0 -> {
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

        val rnd = (0 until listOfQuestions!!.size).random()
        var qst : Question = listOfQuestions!!.removeAt(rnd)

        setButtonDefault()

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

    private fun setButtonDefault() {

        val options = arrayListOf<TextView>()
        options.add(0, btn1)
        options.add(1, btn2)
        options.add(2, btn3)
        options.add(3, btn4)

        for(option in options) {
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.my_button)
        }
    }
}







