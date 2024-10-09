package com.example.ud03_01_fragmentencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class FragmentMessage : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_message, container, false)

        val btnNext = view.findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {

            view.findNavController()
                .navigate(FragmentMessageDirections.actionFragmentMessageToFragmentEncrypt(
                    (view.findViewById<EditText>(R.id.text_secretMsg).toString())))
        }
        return view

    }

}