package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayScoreActivity : AppCompatActivity() {

    lateinit var checkScore : TextView
    lateinit var goToMainMenu : Button
    lateinit var exitApplication : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_score)

        checkScore = findViewById(R.id.scoreView)
        goToMainMenu = findViewById(R.id.mainMenuButton)
        exitApplication = findViewById(R.id.exitApplicationButton)


        val intent = intent
        var score: Int = intent.getIntExtra("Score", 0)
        checkScore.text = "You scored: ${score}/50 points!"

        goToMainMenu.setOnClickListener() {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }



}