package com.example.quizapplication

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity lagras i en tabell. Tabellnamnet blir i detta fall questions med 7 olika kolumner.
// Vår primary key är unik för varje question vi lagrar och den genereras automatiskt.

@Entity(tableName = "questions")
class Question(@PrimaryKey(autoGenerate = true) var id: Int,
               @ColumnInfo(name = "question") var question: String,
               @ColumnInfo(name = "ans1") var answer1: String,
               @ColumnInfo(name = "ans2") var answer2: String,
               @ColumnInfo(name = "ans3") var answer3: String,
               @ColumnInfo(name = "ans4") var answer4: String,
               @ColumnInfo(name = "correctAns") var correctAnswer: String)

// Lagrar alla våra questions i vår MutableList. Viktigt att listan är mutable så att vi kan
// lägga till nya frågor / ändra i listan.

class QuestionList(private val questions : MutableList<Question>) {

    fun getNewQuestion() : Question?{

        if(questions.size <= 0) {
            return null
        }

        val rnd = (0 until questions.size).random()
        val question = questions.removeAt(rnd)
        return question
    }
}







