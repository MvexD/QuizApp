package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_scores.*
import android.content.SharedPreferences
import android.content.Context
import kotlin.random.Random


class ScoresActivity : AppCompatActivity() {
    private var finalScore: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)


        finalScore = findViewById(R.id.EndScore)
        loadFinalScore()
    }


    private fun loadFinalScore(){
        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        finalScore!!.text = preferences.getString(QuizActivity.FINAL_SCORE, "$score")

    }


    companion object {

        private val REQUEST_CODE = 1
        val PREFS = "shared_prefs"
        val HIGH_SCORE = "high_score"
    }


}

