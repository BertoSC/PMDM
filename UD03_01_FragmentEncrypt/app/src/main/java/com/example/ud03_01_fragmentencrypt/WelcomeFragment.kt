package com.example.ud03_01_fragmentencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import kotlin.math.E

class WelcomeFragment : Fragment() {

    //inflater infla la vista, el que pinta
    //container indica donde se va a pintar
    //instanciar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {//infla el diseño desde el fragmento y devuelve una vista inflada
        //return super.onCreateView(inflater, container, savedInstanceState)
        //lo metemos en una variable
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        //recuperamos el boton asociado a la vista
        val btnStart = view.findViewById<Button>(R.id.btn_start)
        //añadimos un listener al botón y recuperamos el controlador de navegacion
                btnStart.setOnClickListener{
        //con el método navigate pillamos el id de la transicion
            view.findNavController().navigate(R.id.action_welcomeFragment_to_fragmentMessage)
        }
        return view
    }
}