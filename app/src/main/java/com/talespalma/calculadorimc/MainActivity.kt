package com.talespalma.calculadorimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalcular: Button
    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var layoutAltura: TextInputLayout
    private lateinit var layoutPeso: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular = findViewById(R.id.btnCalcularImc)
        editTextAltura = findViewById(R.id.editTextAltura)
        editTextPeso = findViewById(R.id.editTextPeso)
        layoutPeso = findViewById(R.id.textInputLayoutPeso)
        layoutAltura = findViewById(R.id.textInputLayoutAltura)

        buttonCalcular.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val peso = editTextPeso.text.toString()
            val altura = editTextAltura.text.toString()

            if (altura.isNotEmpty() && peso.isNotEmpty()) {
                intent.putExtra("altura", altura.toFloat())
                intent.putExtra("peso", peso.toFloat())
                startActivity(intent)
            } else {
                layoutPeso.error = null
                layoutAltura.error = null
                when {
                    peso.isEmpty() -> layoutPeso.error = "Preenha o campo"
                    altura.isEmpty() -> layoutAltura.error = "Preencha o campo"
                }
            }
        }


    }
}