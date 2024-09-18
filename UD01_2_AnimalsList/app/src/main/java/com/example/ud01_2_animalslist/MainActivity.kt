package com.example.ud01_2_animalslist

import android.os.Bundle
import android.widget.Button
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
        btnSend.listener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}