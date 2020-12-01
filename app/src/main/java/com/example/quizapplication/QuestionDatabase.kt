package com.example.quizapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Singleton implementeras genom att man skapar en klass med en metod som skapar en instans om det inte redan finns en.
// Om det finns en instans av klassen, returnerar metoden en referens av det objektet.

@Database(entities = arrayOf(Question::class), version = 1)
abstract class QuestionDatabase : RoomDatabase() {

    abstract val questionDao : QuestionDao

    companion object {
        private var INSTANCE: QuestionDatabase? = null

        fun getInstance(context: Context) : QuestionDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, QuestionDatabase::class.java, "questions_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}