package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var startGame : Button
    lateinit var exitApp :  Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startGame = findViewById(R.id.startButton)
        exitApp = findViewById(R.id.exitButton)



        startGame.setOnClickListener() {
            StartQuestionActivity()

        }

        exitApp.setOnClickListener() {
            finishAndRemoveTask()

        }
    }

    fun StartQuestionActivity()  {

        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)

    }






}