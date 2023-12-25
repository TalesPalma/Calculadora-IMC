package com.talespalma.calculadorimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {
    private lateinit var textImc: TextView
    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        textImc = findViewById(R.id.textViewImc)
        textPeso = findViewById(R.id.textViewPeso)
        textAltura = findViewById(R.id.textViewAltura)
        textResult = findViewById(R.id.textViewResult)

        val intent = intent.extras

        var peso: Float = intent?.getFloat("peso") ?: 0F
        var altura: Float = intent?.getFloat("altura") ?: 0F
        val calculo: Float = peso / (altura * altura)


        textPeso.text = "A altura fornecida foi ${peso.toString()}"
        textAltura.setText("O peso fornecido foi ${altura.toString()}")
        textImc.setText(" O seu imc é ${calculo.toString()}")

        when {
            calculo <= 18.5 -> textResult.setText("Abaixo do peso")
            calculo > 18.5 && calculo <= 24.9 -> textResult.setText("Peso normal")
            calculo >= 25 && calculo <= 29.9 -> textResult.setText("Sobrepeso")
            calculo >= 30 && calculo <= 34 -> textResult.setText("Obesidade grau 1")
            calculo >= 35 && calculo <= 39.9 -> textResult.setText("Obesidade grau 2")
            calculo > 40 -> textResult.setText("Obesidade grau 3")
        }


    }
}