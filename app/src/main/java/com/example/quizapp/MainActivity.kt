package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        button_start_quiz.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            //startQuiz();
            }
        button_quick_start_quiz.setOnClickListener{
            val intent = Intent(this, QuickQuizActivity::class.java)
            startActivity(intent)
        }
        }

    //private fun startQuiz() {
    //    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    //}
}