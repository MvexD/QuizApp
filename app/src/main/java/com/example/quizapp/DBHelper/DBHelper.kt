package com.example.quizapp.DBHelper

import android.content.Context
import android.renderscript.Script
import com.example.quizapp.Model.Question
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DBHelper(context: Context):SQLiteAssetHelper(context, DB_NAME,null,DB_VER){
    companion object{
        private var instance:DBHelper?=null

        private val DB_NAME = "EDMTQuiz2019.db"
        private val DB_VER = 1

        @Synchronized
        fun getInstance(context: Context):DBHelper{
            if(instance == null)
                instance = DBHelper(context)
            return instance!!
        }
    }
    fun getQuestion(Questionid:Int):MutableList<Question>{
        val db = instance!!.writableDatabase
        val questionList = ArrayList<Question>()
        val cursor = db.rawQuery("SELECT * FROM Question ORDER BY RANDOM() LIMIT 30", null)


        if(!cursor.moveToFirst()){
            while(!cursor.isAfterLast){
                val question = Question(cursor.getInt(cursor.getColumnIndex("ID")),
                    cursor.getString(cursor.getColumnIndex("QuestionText")),
                    cursor.getString(cursor.getColumnIndex("AnswerA")),
                    cursor.getString(cursor.getColumnIndex("AnswerB")),
                    cursor.getString(cursor.getColumnIndex("AnswerC")),
                    cursor.getString(cursor.getColumnIndex("AnswerD")),
                    cursor.getString(cursor.getColumnIndex("CorrectAnswer"))
                    )
                questionList.add(question)
                cursor.moveToNext()
            }

        }
        cursor.close()
        db.close()


        return questionList
    }
}