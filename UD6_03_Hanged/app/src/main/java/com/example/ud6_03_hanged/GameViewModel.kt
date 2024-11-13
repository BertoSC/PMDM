package com.example.ud6_03_hanged

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val words = listOf("Calamar", "Android", "Caballo", "Despiste", "Sabela", "Error")
    var targetWord = words.random().uppercase()
    var targetWordHidden = MutableLiveData<String>()
    var lives = MutableLiveData<Int>(7)
    var totalAttemps = 0;
    var attemps = mutableListOf<Char>()

    init {
        targetWordHidden.value = showTargetWordHidden(' ')
    }

    fun showTargetWordHidden(charAttempt: Char) =
        targetWord.map {
            if (it in attemps) {

                it
            } else {

                '_'
            }
        }.joinToString(" ")

    fun guess(charAttempt: Char) {
        attemps.add(charAttempt)
        targetWordHidden.value = showTargetWordHidden(charAttempt)

        if (!targetWord.contains(charAttempt)) lives.value = lives.value?.minus(1) //controlando nulos
    }

    fun resultMessage():String {
        if (win()){
            return "YOU WIN"
        }else {
            return "YOU LOSE \n \n La palabra secreta era ${targetWord}"
        }

    }
    //fun win() = targetWord == targetWordHidden.value.toString()
    fun win() = targetWord == targetWordHidden.value?.replace(" ", "")
    fun lost() = lives.value?.compareTo(0)

    fun restart() {
        attemps.clear()
        lives.value = 7
        targetWord = words.random().uppercase()
        targetWordHidden.value = showTargetWordHidden(' ')
    }
}




