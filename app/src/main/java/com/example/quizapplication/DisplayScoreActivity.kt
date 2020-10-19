package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayScoreActivity : AppCompatActivity() {


    lateinit var goToMainMenu : Button
    lateinit var displayScore : TextView
    lateinit var displayName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_score)


        goToMainMenu = findViewById(R.id.mainMenuButton)
        displayScore = findViewById(R.id.scoreView)
        displayName = findViewById(R.id.nameView)

        val intent = intent
        var score: Int = intent.getIntExtra("Score", 0)
        var username : String? = intent.getStringExtra("userName")

        displayScore.text = "You scored: ${score}/25 points!"
        displayName.text = "Well done ${username.toString()}"

        goToMainMenu.setOnClickListener() {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            finish()
        }
    }
}