package com.example.quizapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.quizapp.DBHelper.DBHelper
import com.example.quizapp.Model.Question
import kotlinx.android.synthetic.main.activity_quiz.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*


class QuizActivity : AppCompatActivity() {


    private var ans: Boolean = false
    private var questionSetsList: List<Question>?=null
    private var currQuestion: Question? = null
    private var score: Int = 0
    private var colorStateList: ColorStateList? = null





    private var questionText: TextView? = null
    private var textScore: TextView? = null
    private var textCounter: TextView? = null
    private var radioGroup: RadioGroup? = null
    private var radio1: RadioButton? = null
    private var radio2: RadioButton? = null
    private var radio3: RadioButton? = null
    private var radio4: RadioButton? = null
    private var mSubmit: AppCompatButton? = null

    private val fragmentManager = supportFragmentManager




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.text_view_question)
        textScore = findViewById(R.id.text_view_score)
        textCounter = findViewById(R.id.text_view_countdown)
        radioGroup = findViewById(R.id.radio_group)
        radio1 = findViewById(R.id.radio_button1)
        radio2 = findViewById(R.id.radio_button2)
        radio3 = findViewById(R.id.radio_button3)
        radio4 = findViewById(R.id.radio_button4)
        mSubmit = findViewById(R.id.button_confirm_next)


        val questionDb = DBHelper.getInstance(this)
        questionSetsList = questionDb.getQuestions()


        showQuestion()

        mSubmit!!.setOnClickListener{
            if(!ans){
                if(radio1!!.isChecked || radio2!!.isChecked || radio3!!.isChecked || radio4!!.isChecked){
                    check()
                }else{
                    Toast.makeText(this@QuizActivity, "Wybierz odpowiedz", Toast.LENGTH_SHORT).show()
                }
            } else {
                showQuestion()
            }
        }
    }


    private fun showQuestion(){
        currQuestion = questionSetsList!![0]

        questionText!!.text = currQuestion!!.getquestionText()

        radio1!!.text = currQuestion!!.getanswerA()
        radio2!!.text = currQuestion!!.getanswerB()
        radio3!!.text = currQuestion!!.getanswerC()
        radio4!!.text = currQuestion!!.getanswerD()

        radio1!!.setTextColor(Color.BLACK)
        radio2!!.setTextColor(Color.BLACK)
        radio3!!.setTextColor(Color.BLACK)
        radio4!!.setTextColor(Color.BLACK)

        radioGroup!!.clearCheck()


    }

    private fun check(){
        ans = true

        val radioSelected = findViewById<View>(radioGroup!!.checkedRadioButtonId) as RadioButton
        val answer = radioGroup!!.indexOfChild(radioSelected)

        if (currQuestion!!.getcorrectAnswer()!!.split(",").contains(('A' + answer).toString())){
            loadNextQuestion()
            score ++
            textScore!!.text = "Score: $score"


        }else {
            showRightAns()
            finishQuizActivity()
        }

    }
    private fun loadNextQuestion() {
        currQuestion = questionSetsList!![+1]
        questionText!!.text = currQuestion!!.getquestionText()

        radio1!!.text = currQuestion!!.getanswerA()
        radio2!!.text = currQuestion!!.getanswerB()
        radio3!!.text = currQuestion!!.getanswerC()
        radio4!!.text = currQuestion!!.getanswerD()

        radio1!!.setTextColor(Color.BLACK)
        radio2!!.setTextColor(Color.BLACK)
        radio3!!.setTextColor(Color.BLACK)
        radio4!!.setTextColor(Color.BLACK)

        radioGroup!!.clearCheck()
    }




    private fun showRightAns(){
        radio1!!.setTextColor(Color.RED)
        radio2!!.setTextColor(Color.RED)
        radio3!!.setTextColor(Color.RED)
        radio4!!.setTextColor(Color.RED)

        currQuestion!!.getcorrectAnswer()!!.split(",").forEach {
            when(it){
                "A" -> {
                    radio1!!.setTextColor(Color.GREEN)
                    questionText!!.text = "Odpowiedz A jest poprawna"

                }
                "B" -> {
                    radio2!!.setTextColor(Color.GREEN)
                    questionText!!.text = "Odpowiedz B jest poprawna"

                }
                "C" -> {
                    radio3!!.setTextColor(Color.GREEN)
                    questionText!!.text = "Odpowiedz C jest poprawna"

                }
                "D" -> {
                    radio4!!.setTextColor(Color.GREEN)
                    questionText!!.text = "Odpowiedz D jest poprawna"

                }
            }
            mSubmit!!.text="Finish"

        }
        //mSubmit!!.text="Next"
        //finishQuizActivity()
    }
    private fun finishQuizActivity(){
        finish()
    }

}