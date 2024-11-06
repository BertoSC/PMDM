package com.example.ud5_1_justit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ud5_1_justit.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {
       // generamos dos variables, para que una gestione los nulos
       // _binding es nula y permite acceder al operador ? > dice hazme la operación solo si o es nulo
       var _binding: FragmentOrderBinding? = null
       val binding: FragmentOrderBinding
           get() = _binding!!
       // en este caso inicializamos la variable que no va a ser nula
       // lo hacemos con un getter del _binding solo en el caso de que no sea nulo
       // sobre escribimos el método get()
       // así, en onCreateView, inflamos primero la vista en _binding

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        //val view = inflater.inflate(R.layout.fragment_order, container, false)
        val view = binding.root
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)

        // quermeos hacerla por defecto, y por eso necesitamos acceder a setsupport action bar
        // el problmea es que el método solo esta en activity, por eso llamamos a la actividad, pero  es necesario castearlo
        // dado que el main es del tipo AppCompatActivity Por ello, se usa activity as AppCompatActivity

        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fab = view.findViewById<FloatingActionButton>(R.id.fabSend)
        fab.setOnClickListener(){

            val burguerGroup = view.findViewById<RadioGroup>(R.id.burguerType)
            var burguerType = burguerGroup.checkedRadioButtonId
            val chipGroup = view.findViewById<ChipGroup>(R.id.chipgroup_extras)
            var chipType = chipGroup.checkedChipIds

            if (burguerType == -1) {
                Toast.makeText(activity, R.string.alert_select_type, Toast.LENGTH_SHORT).show()
            } else {

                var msn = getString(R.string.burguer_selected) + " "
                msn += when(burguerType){
                    R.id.burguerCompleta -> getString(R.string.burguer1)
                    R.id.burguerBacon -> getString(R.string.burguer2)
                    R.id.burguerPollo -> getString(R.string.burguer3)
                    else -> "Error"

                }

                for (i in chipType){
                    msn += " con "
                    msn += view.findViewById<Chip>(i).text
                }


                val snackbar = Snackbar.make(fab, msn, Snackbar.LENGTH_SHORT)
                snackbar.setAction("Undo"){
                   burguerGroup.clearCheck()   // para quitar lo elegido cuando se le da a undo

                }
                snackbar.show()
            }
        }

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}