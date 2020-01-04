package com.example.quizapp.Model

class Question {
    private var id:Int? = null
    private var questionText: String? = null
    private var answerA: String? = null
    private var answerB: String? = null
    private var answerC: String? = null
    private var answerD: String? = null
    private var correctAnswer: String? = null


    constructor() {}

    constructor(id: Int, questionText: String, answerA: String, answerB: String, answerC: String, answerD: String, correctAnswer: String) {
    this.questionText = questionText
    this.answerA = answerA
    this.answerB = answerB
    this.answerC = answerC
    this.answerD = answerD
    this.correctAnswer = correctAnswer
    }
    //pobieranie id
    fun getid(int: Int): Int? {
        return id
    }
    fun setid(id: Int){
        this.id = id
    }



    //pobieranie zapytania
    fun getquestionText(): String? {
        return questionText
    }
    fun setquestionText(questionText: String){
        this.questionText = questionText
    }

    //pobieranie A
    fun getanswerA(): String?{
        return answerA
    }
    fun setanswerA(answerA: String) {
        this.answerA = answerA
    }

    //pobieranie B
    fun getanswerB(): String?{
        return answerB
    }
    fun setanswerB(answerB: String){
        this.answerB = answerB
    }

    //pobieranie C
    fun getanswerC(): String?{
        return answerC
    }
    fun setanswerC(answerC: String){
        this.answerC = answerC
    }

    //pobieranie D
    fun getanswerD(): String?{
        return answerD
    }
    fun setanswerD(answerD: String){
        this.answerD = answerD
    }
    //pobieranie odpowiedz
    fun getcorrectAnswer(): String?{
        return correctAnswer
    }
    fun setcorrectAnswer(correctAnswer: String){
        this.correctAnswer = correctAnswer
    }
}


