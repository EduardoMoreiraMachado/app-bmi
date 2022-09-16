package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivityCalculateBinding
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding

class CalculateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        binding = ActivityCalculateBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar!!.hide()

        loadProfile()


        binding.buttonCalculate.setOnClickListener {

            bmiCalculate()

        }
    }

    private fun bmiCalculate() {

        // abrir o arquivo SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        val openResult = Intent(this, ResultActivity::class.java)
        val editor = dados.edit()

        // enviar dados de uma activity para outra
        openResult.putExtra("peso", binding.editTextCalcWeight.text.toString().toInt())

        // atualizar o valor do peso nos dados do usuário
        editor.putInt("weight", binding.editTextCalcWeight.text.toString().toInt())

        if (binding.editTextCalcHeight.text.isEmpty()) {

            openResult.putExtra("altura", dados.getFloat("height", 0.0f).toDouble())

        } else {

            openResult.putExtra("altura", binding.editTextCalcHeight.text.toString().toDouble())
            editor.putFloat("height", binding.editTextCalcHeight.text.toString().toFloat())

        }

        if (editor.commit()) {

            finish() // fecha a activity

        } else {

            Toast.makeText(this, "Ocorreu um erro no cadastro!", Toast.LENGTH_SHORT).show()

        }

        startActivity(openResult)

    }

    private fun loadProfile() {

        // abrir o arquivo SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUserName.text = dados.getString("name", "")
        binding.textViewUserEmail.text = dados.getString("email", "")
        binding.textViewUserWeight.text = "${resources.getText(R.string.weight)} ${dados.getInt("weight", 0)} Kg"
        binding.textViewUserHeight.text = "${resources.getText(R.string.height)} ${dados.getFloat("height", 0.0f)} M"

    }
}