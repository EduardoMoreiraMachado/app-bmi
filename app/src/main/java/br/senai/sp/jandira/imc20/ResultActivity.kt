package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityCalculateBinding
import br.senai.sp.jandira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandira.imc20.utils.getBMI
import br.senai.sp.jandira.imc20.utils.getStatusBMI

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar!!.hide()

        // recuperar valores que estão na Intent
        val peso = intent.getIntExtra("peso", 0)
        val altura = intent.getDoubleExtra("altura", 0.0)

        val bmi = getBMI(peso, altura)
        val bmi2 = String.format("%.2f", bmi)
        binding.textViewResult.text = bmi2.toString()
        binding.textViewStatus.text = getStatusBMI(bmi, this)
    }
}