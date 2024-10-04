package com.example.ud03_01_fragmentencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class WelcomeFragment : Fragment() {

    //inflater infla la vista, el que pinta
    //container indica donde se va a pintar
    //instanciar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //infla el diseño desde el fragmento y devuelve una vista inflada
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }
}