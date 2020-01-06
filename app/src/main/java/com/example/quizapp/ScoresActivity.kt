package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_scores.*
import android.content.SharedPreferences
import android.content.Context
import android.content.Intent
import androidx.appcompat.widget.AppCompatButton
import com.example.quizapp.QuizActivity.Companion.score
import kotlinx.android.synthetic.*
import kotlin.random.Random


class ScoresActivity : AppCompatActivity() {
    private var finalScore: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)


        finalScore = findViewById(R.id.EndScore)
        loadFinalScore()

        RestartButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            score = 0



        }
    }

    private fun loadFinalScore(){
        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        finalScore!!.text = preferences.getString(QuizActivity.FINAL_SCORE, "$score")
    }

    companion object {
        val PREFS = "shared_prefs"
        val HIGH_SCORE = "high_score"
    }
}

