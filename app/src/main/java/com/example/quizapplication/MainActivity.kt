package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var startGame: Button
    lateinit var exitApp: Button
    lateinit var enterName: TextView
    lateinit var username : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startGame = findViewById(R.id.startButton)
        exitApp = findViewById(R.id.mainMenuButton)
        enterName = findViewById(R.id.nameTextView)

        startGame.setOnClickListener() {

            if (enterName.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_LONG).show()

            } else {
                username = enterName.text.toString()
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("userName", username)
                startActivity(intent)
            }
        }

        exitApp.setOnClickListener() {
            finishAndRemoveTask()
        }
    }


}