package com.example.app_imc

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val peso = edtPeso.text.toString().toFloatOrNull()
            val altura = edtAltura.text.toString().toFloatOrNull()

            if (peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)
                val resultado = when {
                    imc < 18.5 -> "Abaixo do peso"
                    imc in 18.5..24.9 -> "Peso normal"
                    imc in 25.0..29.9 -> "Sobrepeso"
                    imc in 30.0..34.9 -> "Obesidade grau I"
                    imc in 35.0..39.9 -> "Obesidade grau II"
                    else -> "Obesidade grau III"
                }

                txtResultado.text = "IMC: %.2f - %s".format(imc, resultado)
                txtResultado.setTextColor(Color.parseColor("#B71C1C")) // Vermelho escuro
            } else {
                txtResultado.text = "Por favor, insira valores válidos."
                txtResultado.setTextColor(Color.parseColor("#D32F2F")) // Vermelho mais claro para erro
            }
        }
    }
}
