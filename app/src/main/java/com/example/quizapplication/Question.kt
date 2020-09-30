package com.example.quizapplication

class Question(
               var question: String,
               var answer1: String,
               var answer2: String,
               var answer3: String,
               var answer4: String,
               var correctAnswer: String)


fun getQuestions(): ArrayList<Question> {

    val listOfQuestions = ArrayList<Question>()

    val q1 = Question( "Where is Dejan from?", "Sweden", "Germany", "Denmark", "Norway", "Sweden")
    listOfQuestions.add(q1)
    val q2 = Question( "How tall is Dejan?", "175cm", "177cm", "180cm", "185cm", "177cm")
    listOfQuestions.add(q2)
    val q3 = Question( "How far is it from Sweden to Bosnia with car?", "2000km", "2200km", "2400km", "2500km", "2500km")
    listOfQuestions.add(q3)
    val q4 = Question( "Where does Dejan live?", "Skarpnäck", "Kärrtorp", "Bagis", "Enskede", "Bagis")
    listOfQuestions.add(q4)
    return listOfQuestions
}

