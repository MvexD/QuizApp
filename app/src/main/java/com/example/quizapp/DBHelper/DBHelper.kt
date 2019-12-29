package com.example.quizapp.DBHelper

import android.content.Context
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
}