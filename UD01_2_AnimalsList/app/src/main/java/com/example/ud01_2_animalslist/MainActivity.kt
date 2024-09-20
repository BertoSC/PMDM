package com.example.ud01_2_animalslist

import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {  //se ejecuta al compilar/crear
        super.onCreate(savedInstanceState) //llama al método superior
        enableEdgeToEdge()  //por defecto hace toda la pantalla
        setContentView(R.layout.activity_main)
        //busca por id, que le añadimos en el paréntesis
        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener{
            val spinnerAnimalType = findViewById<Spinner>(R.id.animalsList)
            val textKindAnimals = findViewById<TextView>(R.id.textKindsAnimals)
            textKindAnimals.text =getAnimalKind(spinnerAnimalType.selectedItemId).joinToString("\n")



        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    // nombre, tipo de dato entre parantesis, podemos poner un return con =
    // en este caso el código es un when hola
    fun getAnimalKind(id: Long) = when (id) {
        0L -> listOf("Lareta", "Tali")
        1L -> listOf("Pastor Alemán", "Chiguagua")
        2L -> listOf("Águila", "Petirrojo")
        else -> listOf()

    }
}