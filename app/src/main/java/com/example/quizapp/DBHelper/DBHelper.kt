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

        fun getQuestion(QuestionID: Int): MutableList<Question> {
            val db = instance!!.writableDatabase
            val questionList = ArrayList<Question>()
            val c = db.rawQuery("SELECT * FROM Question ORDER BY RANDOM() LIMIT 30", null)


            if (!c.moveToFirst()) {
                while (!c.isAfterLast) {
                    val question = Question()
                    question.getid(c.getInt(c.getColumnIndex("QuestionID")))
                    question.setquestionText(c.getString(c.getColumnIndex("QuestionText")))
                    question.setanswerA(c.getString(c.getColumnIndex("AnswerA")))
                    question.setanswerB(c.getString(c.getColumnIndex("AnswerB")))
                    question.setanswerC(c.getString(c.getColumnIndex("AnswerC")))
                    question.setanswerD(c.getString(c.getColumnIndex("AnswerD")))
                    question.setcorrectAnswer(c.getInt(c.getColumnIndex("CorrectAnswer")))
                    questionList.add(question)
                    c.moveToNext()
                }

            }
            c.close()

            return questionList

        }
        return questionSetsList

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
