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
import com.google.common.collect.Iterables.size
import com.google.common.collect.Iterators.size
import kotlinx.coroutines.*
import java.nio.file.Files.size
import java.util.*
import kotlin.coroutines.CoroutineContext

class QuestionActivity : AppCompatActivity(), CoroutineScope {

    var progression = 0
    var scoreCount = 0
    //var listOfQuestions: ArrayList<Question> = ArrayList<Question>() // Hämtar listan med frågor från Question klassen.

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var db: QuestionDatabase
    var currentQuestion : Question? = null
    lateinit var myAnswer: String
    lateinit var questionText: TextView
    lateinit var btn1: TextView
    lateinit var btn2: TextView
    lateinit var btn3: TextView
    lateinit var btn4: TextView
    lateinit var progressionBar: ProgressBar
    var questionList : QuestionList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        //listOfQuestions = getQuestions()
        questionText = findViewById(R.id.questionView)
        btn1 = findViewById<TextView>(R.id.b1)
        btn2 = findViewById<TextView>(R.id.b2)
        btn3 = findViewById<TextView>(R.id.b3)
        btn4 = findViewById<TextView>(R.id.b4)
        progressionBar = findViewById<ProgressBar>(R.id.progressBar)
        job = Job()
        db = QuestionDatabase.getInstance(this)

/*
        addNewQuestion(Question(0,"Which one of these characters is not friends with Harry Potter?", "Ron Weasley", "Neville Longbottom", "Draco Malfoy", "Hermione Granger", "Draco Malfoy"))
        addNewQuestion(Question(0,"What is the color of Donald Duck's bowtie?", "Red", "Yellow", "Blue", "White", "Red"))
        addNewQuestion(Question(0,"Which planet is the hottest?", "Venus", "Saturn", "Mercury", "Mars", "Venus"))
        addNewQuestion(Question(0,"What does the D in D-day stand for?", "Dooms", "Dark", "Denmark", "Dunkirk", "Dunkirk"))
        addNewQuestion(Question(0,"In Pirates of the Carribean, what was the name of Captain Jack Sparrow's ship?", "The Marauder", "The Black Pearl", "The Black Python", "The Slytherin", "The Black Pearl"))
        addNewQuestion(Question(0,"According to Forrest Gump, 'life was like...'?", "A bag of lemons", "A handful of roses", "A lollipop", "A box of chocolates", "A box of chocolates"))
        addNewQuestion(Question(0,"Which is the rarest blood type?", "O", "A", "B", "AB-negative", "AB-negative"))
        addNewQuestion(Question(0,"How many bones are there in the human body?", "206", "205", "201", "209", "206"))
        addNewQuestion(Question(0,"Fe is the chemical symbol for what?", "Zinc", "Hydrogen", "Fluorine", "Iron", "Iron"))
        addNewQuestion(Question(0,"Which is the longest river in the world?", "Amazon", "Congo", "Nile", "Hudson", "Nile"))
        addNewQuestion(Question(0,"As an adult, how many teeth should you have in your mouth?", "35", "32", "30", "42", "32"))
        addNewQuestion(Question(0,"Which olympic sport is Michael Phelps known for?", "Snowboarding", "Skiing", "Running", "Swimming", "Swimming"))
        addNewQuestion(Question(0,"In what year did women get the right to vote?", "1910", "1920", "1930", "1940", "1920"))
        addNewQuestion(Question(0,"Which one of these snakes is the deadliest?", "Python", "Cobra", "Black Mamba", "Saw-scaled Viper", "Saw-scaled Viper"))
        addNewQuestion(Question(0,"What is a group of lions called?", "Squad", "Pack", "Herd", "Pride", "Pride"))
        addNewQuestion(Question(0,"How many feet are there in a mile?", "1037", "5288", "5280", "6201", "5280"))
        addNewQuestion(Question(0,"'I see dead people', is a line from which movie? ", "The Grudge", "The Shining", "Scary Movie", "The Exorcist", "Scary Movie"))
        addNewQuestion(Question(0,"What animal is associated with ancient egypt?", "Lion", "Cat", "Hummingbird", "Rabbit", "Cat"))
        addNewQuestion(Question(0,"How many time zones are there in the world?", "7", "24", "23", "9", "24"))
        addNewQuestion(Question(0,"What is the first book of the Old Testament in the Bible", "Matthew", "Proverbs", "Genesis", "Exodus", "Genesis"))
        addNewQuestion(Question(0,"Which water sport if the official sport for the state of Hawaii?", "Water Polo", "Swimming", "Water skiing", "Surfing", "Surfing"))
        addNewQuestion(Question(0,"What is the lowest temperature we have ever measured on earth?", "-89 degrees celcius", "-79 degrees celcius", "-63 degrees celcius", "-93 degrees celcius", "-89 degrees celcius"))
        addNewQuestion(Question(0,"Which astrological sign is a crab?", "Pisces", "Aquarius", "Cancer", "Virgo", "Cancer"))
        addNewQuestion(Question(0,"In which decade does the netflix series 'Stranger Things' take place?", "'70s'", "'80s'", "'90s'", "early 2000s", "'80s'"))
        addNewQuestion(Question(0,"Which country gifted the Statue of Liberty to the U.S.?", "Germany", "China", "France", "Italy", "France"))


 */

        loadAllQuestions()

        btn1.setOnClickListener() {

            if (btn1.text == myAnswer) {
                btn1.background = ContextCompat.getDrawable(this, R.drawable.correct_option_button)
                Log.d("!!!", "Correct answer!")
                Handler().postDelayed({
                    scoreCount++
                    progression++
                    loadNewQuestion()
                }, 1000)
            } else {
                btn1.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    loadNewQuestion()
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
                    loadNewQuestion()
                }, 1000)
            } else {
                btn2.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    loadNewQuestion()
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
                    loadNewQuestion()
                }, 1000)
            } else {
                btn3.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    loadNewQuestion()
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
                    loadNewQuestion()
                     }, 1000)

            } else {
                btn4.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_button)
                Log.d("!!!", "Wrong answer!")
                Handler().postDelayed({
                    progression++
                    loadNewQuestion()
                }, 1000)
            }
        }

    }

/*
    private fun checkPosition() {

        val getIntent = intent
        var username: String? = getIntent.getStringExtra("userName")
        val mutableList = mutableListOf<Question>()
        val classList = QuestionList(mutableList)

        when{

            }{
               val intent = Intent(this, DisplayScoreActivity::class.java)
                intent.putExtra("Score", scoreCount)
                intent.putExtra("userName", username)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                finish()
            }
        }
    }


 */




    fun loadNewQuestion() {
        currentQuestion = questionList?.getNewQuestion()
        val getIntent = intent
        var username: String? = getIntent.getStringExtra("userName")

        if (currentQuestion == null) {
            val intent = Intent(this, DisplayScoreActivity::class.java)
            intent.putExtra("Score", scoreCount)
            intent.putExtra("userName", username)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }else{
            setButtonDefault()
            myAnswer = currentQuestion!!.correctAnswer
            questionText.text = currentQuestion!!.question
            btn1.text = currentQuestion!!.answer1
            btn2.text = currentQuestion!!.answer2
            btn3.text = currentQuestion!!.answer3
            btn4.text = currentQuestion!!.answer4
            progressionBar.progress = progression
            progressionBar.max = 25
        }

    }

    fun loadAllQuestions() {
        val questions = async(Dispatchers.IO) {
            db.questionDao.getAll()
        }

        launch {
            val list = questions.await().toMutableList()
            questionList = QuestionList(list)
            loadNewQuestion()
        }
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

    /*
    fun addNewQuestion(question: Question) {

        launch(Dispatchers.IO) {
            db.questionDao.insert(question)
        }
    }

     */
}







