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
import com.example.quizapp.DBHelper.DBHelper
import com.example.quizapp.Model.Question
import kotlinx.android.synthetic.main.activity_quiz.*

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
    private var mSubmit: RadioButton? = null




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


        val questionDb = DBHelper(this)
        questionSetsList = questionDb.questionSet.


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
        radio1!!.setTextColor(colorStateList)
        radio2!!.setTextColor(colorStateList)
        radio3!!.setTextColor(colorStateList)
        radio4!!.setTextColor(colorStateList)

        radioGroup!!.clearCheck()

    }

    private fun check(){
        ans = true

        val radioSelected = findViewById<View>(radioGroup!!.checkedRadioButtonId) as RadioButton
        val answer = radioGroup!!.indexOfChild(radioSelected) + 1

        if (answer == currQuestion!!.getcorrectAnswer()){
            score ++
            textScore!!.text = "Score: $score"
        }
        showRightAns()
    }

    private fun showRightAns(){

        radio1!!.setTextColor(Color.RED)
        radio2!!.setTextColor(Color.RED)
        radio3!!.setTextColor(Color.RED)
        radio4!!.setTextColor(Color.RED)

        when(currQuestion!!.getcorrectAnswer()){
            1 -> {
                radio1!!.setTextColor(Color.GREEN)
                questionText!!.text = "Odpowiedz A jest poprawna"
            }
            2 -> {
                radio2!!.setTextColor(Color.GREEN)
                questionText!!.text = "Odpowiedz A jest poprawna"
            }
            3 -> {
                radio3!!.setTextColor(Color.GREEN)
                questionText!!.text = "Odpowiedz A jest poprawna"
            }
            4 -> {
                radio4!!.setTextColor(Color.GREEN)
                questionText!!.text = "Odpowiedz A jest poprawna"
            }
        }
        mSubmit!!.text="finish"
    }
}
