package com.example.ud03_02_cuentosterror

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val btnNext = view.findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener{
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToThemeFragment(
                view.findViewById<EditText>(R.id.editWhatName).text.toString()))
        }

        return view
    }

}