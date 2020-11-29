package com.example.quizapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuestionDao {

    @Insert
    fun insert(question: Question)

    @Delete
    fun delete(question: Question)

    @Query("SELECT * FROM questions")
    fun getAll() : List<Question>
}