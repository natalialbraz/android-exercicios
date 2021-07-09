package com.example.shrine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.shrine.databinding.FragmentCalculadoraBinding

class CalculadoraFragment : Fragment() {

    private var binding: FragmentCalculadoraBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalculadoraBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btCalculate?.setOnClickListener {
            val peso = binding?.etWeight?.editText?.text.toString()
            val altura = binding?.etHeight?.editText?.text.toString()
            if ((peso.isBlank()) || (altura.isBlank()) ){
                Toast.makeText(context, "Forneça os seus dados corretamente!", Toast.LENGTH_SHORT).show()
            }
            val imc: Float = peso.toFloat()/(altura.toFloat()*altura.toFloat())
            if (imc<16){
                Toast.makeText(context, "Sua classificação é Magreza Grau III", Toast.LENGTH_SHORT).show()
            }else if(imc>=16 && imc<17){
                Toast.makeText(context, "Sua classificação é Magreza Grau II", Toast.LENGTH_SHORT).show()
            }else if(imc>=17 && imc<18.5){
                Toast.makeText(context, "Sua classificação é Magreza Grau I", Toast.LENGTH_SHORT).show()
            }else if(imc>= 18.5 && imc<25){
                Toast.makeText(context, "Sua classificação é Peso Ideal", Toast.LENGTH_SHORT).show()
            }else if(imc>= 25 && imc<30){
                Toast.makeText(context, "Sua classificação é Pré-Obeso", Toast.LENGTH_SHORT).show()
            }else if (imc>=30 && imc<35){
                Toast.makeText(context, "Sua classificação é Obesidade Grau I", Toast.LENGTH_SHORT).show()
            }else if(imc>=35 && imc<40){
                Toast.makeText(context, "Sua classificação é Obesidade Graus II", Toast.LENGTH_SHORT).show()
            }else if (imc>= 40){
                Toast.makeText(context, "Sua classificação é Obesidade Grau III", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}