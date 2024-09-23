package com.example.ud01_3_chronos

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //lateinit se usa para indicar que se iniciará la variable creada más tarde
    val RUNNING_KEY = "RUNNING"
    val OFFSET_KEY= "offset"
    val BASE_KEY= "base"

    lateinit var chrono: Chronometer
    var running = false
    var offset = 0L

    override fun onSaveInstanceState(outState: Bundle) {
        //guarda las variables cuando se cambia de estado, por ejemplo, cuando entra llamada, o se gira la pantalla
        outState.putBoolean(RUNNING_KEY, running)
        outState.putLong(OFFSET_KEY, offset)
        outState.putLong(BASE_KEY, chrono.base)
        super.onSaveInstanceState(outState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //recuerda: hasta que se ejecute esta línea no se carga
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        chrono = findViewById<Chronometer>(R.id.chrTemporizador) // buscamos por id

        if (savedInstanceState!=null){
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running= savedInstanceState.getBoolean(RUNNING_KEY)
            if (running){
                chrono.base = savedInstanceState.getLong(BASE_KEY)
                chrono.start()
            }


        }

        // BOTONES BÁSICOS DE LA APP (START, PAUSE, RESTART)

        val btnStart= findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener{
            if (!running){
                chrono.base = SystemClock.elapsedRealtime() - offset//le decimos que acceda al reloj sistema en tiempo real
                chrono.start()
                running = true
            }
        }
        val btnStop = findViewById<Button>(R.id.btnPause)
        btnStop.setOnClickListener{
            if (running){
                offset = SystemClock.elapsedRealtime()-chrono.base

                chrono.stop()
                running = false

            }
        }

        val btnRestart = findViewById<Button>(R.id.btnRestart)
        btnRestart.setOnClickListener{
            chrono.base = SystemClock.elapsedRealtime()
            offset = 0L
        }




    }
}