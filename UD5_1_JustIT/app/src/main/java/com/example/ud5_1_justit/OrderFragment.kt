package com.example.ud5_1_justit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar


class OrderFragment : Fragment() {

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)

        // quermeos hacerla por defecto, y por eso necesitamos acceder a setsupport action bar

        // el problmea es que el método solo esta en activity, por eso llamamos a la actividad, pero  es necesario castearlo
           // dado que el main es del tipo AppCompatActivity Por ello, se usa activity as AppCompatActivity


           (activity as AppCompatActivity).setSupportActionBar(toolbar)

        return view

    }


}