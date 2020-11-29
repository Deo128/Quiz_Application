package com.example.quizapplication

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
class Question(@PrimaryKey(autoGenerate = true) var id: Int,
               @ColumnInfo(name = "question") var question: String,
               @ColumnInfo(name = "ans1") var answer1: String,
               @ColumnInfo(name = "ans2") var answer2: String,
               @ColumnInfo(name = "ans3") var answer3: String,
               @ColumnInfo(name = "ans4") var answer4: String,
               @ColumnInfo(name = "correctAns") var correctAnswer: String)


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

/*
fun getQuestions(): ArrayList<Question> {

    val listOfQuestions = ArrayList<Question>()

    val q1 = Question( 0,"Which one of these characters is not friends with Harry Potter?", "Ron Weasley", "Neville Longbottom", "Draco Malfoy", "Hermione Granger", "Draco Malfoy")
    listOfQuestions.add(q1)
    val q2 = Question( 0,"What is the color of Donald Duck's bowtie?", "Red", "Yellow", "Blue", "White", "Red")
    listOfQuestions.add(q2)
    val q3 = Question( 0,"Which planet is the hottest?", "Venus", "Saturn", "Mercury", "Mars", "Venus")
    listOfQuestions.add(q3)
    val q4 = Question( 0,"What does the D in D-day stand for?", "Dooms", "Dark", "Denmark", "Dunkirk", "Dunkirk")
    listOfQuestions.add(q4)
    val q5 = Question(0,"In Pirates of the Carribean, what was the name of Captain Jack Sparrow's ship?", "The Marauder", "The Black Pearl", "The Black Python", "The Slytherin", "The Black Pearl")
    listOfQuestions.add(q5)
    val q6 = Question( 0,"According to Forrest Gump, 'life was like...'?", "A bag of lemons", "A handful of roses", "A lollipop", "A box of chocolates", "A box of chocolates")
    listOfQuestions.add(q6)
    val q7 = Question( 0,"Which is the rarest blood type?", "O", "A", "B", "AB-negative", "AB-negative")
    listOfQuestions.add(q7)
    val q8 = Question( 0,"How many bones are there in the human body?", "206", "205", "201", "209", "206")
    listOfQuestions.add(q8)
    val q9 = Question( 0,"Fe is the chemical symbol for what?", "Zinc", "Hydrogen", "Fluorine", "Iron", "Iron")
    listOfQuestions.add(q9)
    val q10 = Question( 0,"Which is the longest river in the world?", "Amazon", "Congo", "Nile", "Hudson", "Nile")
    listOfQuestions.add(q10)
    val q11 = Question( 0,"As an adult, how many teeth should you have in your mouth?", "35", "32", "30", "42", "32")
    listOfQuestions.add(q11)
    val q12 = Question( 0,"Which olympic sport is Michael Phelps known for?", "Snowboarding", "Skiing", "Running", "Swimming", "Swimming")
    listOfQuestions.add(q12)
    val q13 = Question( 0,"In what year did women get the right to vote?", "1910", "1920", "1930", "1940", "1920")
    listOfQuestions.add(q13)
    val q14 = Question( 0,"Which one of these snakes is the deadliest?", "Python", "Cobra", "Black Mamba", "Saw-scaled Viper", "Saw-scaled Viper")
    listOfQuestions.add(q14)
    val q15 = Question( 0,"What is a group of lions called?", "Squad", "Pack", "Herd", "Pride", "Pride")
    listOfQuestions.add(q15)
    val q16 = Question( 0,"How many feet are there in a mile?", "1037", "5288", "5280", "6201", "5280")
    listOfQuestions.add(q16)
    val q17 = Question(0,"'I see dead people', is a line from which movie? ", "The Grudge", "The Shining", "Scary Movie", "The Exorcist", "Scary Movie")
    listOfQuestions.add(q17)
    val q18 = Question(0,"What animal is associated with ancient egypt?", "Lion", "Cat", "Hummingbird", "Rabbit", "Cat")
    listOfQuestions.add(q18)
    val q19 = Question(0,"How many time zones are there in the world?", "7", "24", "23", "9", "24")
    listOfQuestions.add(q19)
    val q20 = Question(0,"What is the first book of the Old Testament in the Bible", "Matthew", "Proverbs", "Genesis", "Exodus", "Genesis")
    listOfQuestions.add(q20)
    val q21 = Question(0,"Which water sport if the official sport for the state of Hawaii?", "Water Polo", "Swimming", "Water skiing", "Surfing", "Surfing")
    listOfQuestions.add(q21)
    val q22 = Question(0,"What is the lowest temperature we have ever measured on earth?", "-89 degrees celcius", "-79 degrees celcius", "-63 degrees celcius", "-93 degrees celcius", "-89 degrees celcius")
    listOfQuestions.add(q22)
    val q23 = Question(0,"Which astrological sign is a crab?", "Pisces", "Aquarius", "Cancer", "Virgo", "Cancer")
    listOfQuestions.add(q23)
    val q24 = Question(0,"In which decade does the netflix series 'Stranger Things' take place?", "'70s'", "'80s'", "'90s'", "early 2000s", "'80s'")
    listOfQuestions.add(q24)
    val q25 = Question(0,"Which country gifted the Statue of Liberty to the U.S.?", "Germany", "China", "France", "Italy", "France")
    listOfQuestions.add(q25)

    return listOfQuestions
}

 */





