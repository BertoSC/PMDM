package com.example.ud6_03_hanged

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.ud6_03_hanged.databinding.FragmentGameBinding
import com.example.ud6_03_hanged.databinding.FragmentResultBinding
class ResultFragment : Fragment() {
// acceso seguro a nulos > revisar Chronos
var _binding: FragmentResultBinding? = null;
val binding get() = _binding!!

    val model: GameViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    // return inflater.inflate(R.layout.fragment_game, container, false)
    _binding = FragmentResultBinding.inflate(inflater, container, false)
    val view = binding.root
    binding.btnRestart.setOnClickListener(){
        Toast.makeText(activity, model.targetWord, Toast.LENGTH_LONG).show()
    }
    return view
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}
