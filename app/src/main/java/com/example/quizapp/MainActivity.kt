package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.*
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
        }

    //private fun startQuiz() {
    //    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    //}
}