package com.example.myfinalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quiz : AppCompatActivity() {

    lateinit var questions : TextView
    lateinit var comments : TextView
    lateinit var nextB : Button
    lateinit var hack : Button
    lateinit var myth : Button
    var currentQuestion = 0
    var score = 0
    var answered = false

    val quizQuestions =arrayOf(
        " Putting your phone in rice fixe's water damage.",
        " Drinking water help's concentraion.",
        " Cracking knuckles causes arthritis.",
        " Sleeping 8 hours improves memory.",
        " Eating carrots improves night vision."
    )

    val quizAnswers = arrayOf(
        false,
        true,
        false,
        true,
        false
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)


        questions= findViewById(R.id.txtQuestions)
        comments = findViewById(R.id.txtComment)
        nextB= findViewById(R.id.btnNext)
        hack= findViewById(R.id.btnHack)
        myth= findViewById(R.id.btnMyth)


        loadQuestion()
        hack.setOnClickListener { checkAnswer(true) }
        myth.setOnClickListener { checkAnswer(false) }

        nextB.setOnClickListener {

            currentQuestion++
            if (currentQuestion < quizQuestions.size){
                loadQuestion()
                comments.text = ""
            }else{
                val intent = Intent(this, Results::class.java)
                intent.putExtra("Score", score)
                startActivity(intent)
                finish()

            }
        }



    }
    fun loadQuestion(){
        questions.text= quizQuestions[currentQuestion]
        answered = false
        hack.isEnabled = true
        myth.isEnabled= true

    }
    fun checkAnswer(userAnswer : Boolean){

        if (answered) return
        answered = true

        hack.isEnabled=false
        myth.isEnabled=false

        if (userAnswer == quizAnswers[currentQuestion]){
            comments.text =" Correct! That's a real time-saver! "
            score++
        }
        else{
            comments.text= "Wrong! That's just a myth!"}


    }
}