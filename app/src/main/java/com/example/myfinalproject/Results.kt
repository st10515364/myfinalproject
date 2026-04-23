package com.example.myfinalproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Results : AppCompatActivity() {
    lateinit var finalScore : TextView
    lateinit var message : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)

        finalScore = findViewById(R.id.txtScores)
        message    = findViewById(R.id.txtMessage)

        val score = intent.getIntExtra("score", 0)
        finalScore.text=" Your Score: $score / 5 "

        if (score >= 3){
            message.text="Wonderful! Keep it up"
        }else{
            message.text= " Practise more to succseed "
        }




    }
}