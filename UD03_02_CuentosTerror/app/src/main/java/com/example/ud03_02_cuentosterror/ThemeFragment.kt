package com.example.ud03_02_cuentosterror

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

class ThemeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_theme, container, false)
        val cardHouse = view.findViewById<CardView>(R.id.cardHaunted)
        cardHouse.setOnClickListener{
            view.findNavController().navigate(ThemeFragmentDirections.actionThemeFragmentToTale1Fragment(
                ThemeFragmentArgs.fromBundle(requireArguments()).nombre.toString()))
        }
        return view
    }


}