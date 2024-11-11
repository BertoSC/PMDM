package com.example.ud6_03_hanged

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ud6_03_hanged.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    // acceso seguro a nulos > revisar Chronos
    var _binding: FragmentGameBinding? = null;
    val binding get() = _binding!!

    val model: GameViewModel by viewModels(
        ownerProducer = {this.requireActivity()}

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return inflater.inflate(R.layout.fragment_game, container, false)
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnNext.setOnClickListener(){

            var attempt = binding.editText.text[0]
            model.guess(attempt.uppercaseChar())
            var textoShow = binding.secretWord.setText(model.targetWordHidden)

            //view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}