package com.example.ud6_03_hanged

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val words = listOf("Calamar", "Android", "Caballo", "Despiste", "Sabela", "Error")
    var targetWord = words.random().uppercase()
    var targetWordHidden = ""
    var lives = 7
    var totalAttemps = 0;
    var letter = mutableListOf<Char>()
    init {
        targetWordHidden = showTargetWordHidden(' ')
    }

    fun dieSlowly() {
        if
    }

    fun showTargetWordHidden(charAttempt: Char) =
        targetWord.map {
            if (it == charAttempt || letter.contains(it)) {
                letter.add(it)
                it
            } else {

                '_'
            }
        }.joinToString (" ")

    fun guess(charAttempt: Char){
        targetWordHidden = showTargetWordHidden(charAttempt)
    }



}