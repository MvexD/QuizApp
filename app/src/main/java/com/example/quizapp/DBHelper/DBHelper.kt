package com.example.quizapp.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.quizapp.Model.Question
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DBHelper(context: Context):SQLiteAssetHelper(context, DB_NAME,null,DB_VER){
    private var db: SQLiteDatabase? = null
    val questionSet: List<Question>

        get() {
            val questionSetsList = ArrayList<Question>()

            db = readableDatabase

            return questionSetsList
        }

    fun getQuestions(): MutableList<Question> {
        val db = instance!!.writableDatabase
        val questionList = ArrayList<Question>()
        val c = db.rawQuery("SELECT * FROM Question ORDER BY RANDOM() LIMIT 30", null)

        while (c.moveToNext()) {
            val question = Question()
            question.getid(c.getInt(c.getColumnIndex("ID")))
            question.setquestionText(c.getString(c.getColumnIndex("QuestionText")))
            question.setanswerA(c.getString(c.getColumnIndex("AnswerA")))
            question.setanswerB(c.getString(c.getColumnIndex("AnswerB")))
            question.setanswerC(c.getString(c.getColumnIndex("AnswerC")))
            question.setanswerD(c.getString(c.getColumnIndex("AnswerD")))
            question.setcorrectAnswer(c.getString(c.getColumnIndex("CorrectAnswer")))
            questionList.add(question)
        }
        c.close()

        return questionList
    }

    companion object {
        private var instance: DBHelper? = null

        private val DB_NAME = "EDMTQuiz2019.db"
        private val DB_VER = 1

        @Synchronized
        fun getInstance(context: Context): DBHelper {
            if (instance == null)
                instance = DBHelper(context)
            return instance!!
        }
    }
}