package com.example.ud03_01_fragmentencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentEncrypt : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        val mensaje = FragmentEncryptArgs.fromBundle(requireArguments()).message
        return view

    }

}