package com.thiagopaz.fitnesstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ImcActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        editWeight = findViewById(R.id.edit_imc_weight)
        editHeight = findViewById(R.id.edit_imc_height)

        val btnSend: Button = findViewById(R.id.btn_imc_send)
        btnSend.setOnClickListener {
            if (!validate()) {
                Toast.makeText(this, R.string.fields_message, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val weight = editWeight.text.toString().toInt()
            val height = editHeight.text.toString().toInt()

            val result = calculateImc(weight, height)
            Log.d("test", "resultant: $result")

            val imcResponseId = imcResponse(result)
            Toast.makeText(this, imcResponseId, Toast.LENGTH_SHORT).show()
        }
    }

    private fun imcResponse(imc: Double): Int {
        if (imc < 15.0) {
            return R.string.imc_severely_low_weight
        } else if (imc < 16.0) {
            return R.string.imc_very_low_weight
        } else if (imc < 18.5) {
            return R.string.imc_very_low_weight
        } else if (imc < 25.0) {
            return R.string.normal
        } else if (imc < 30.0) {
            return R.string.imc_high_weight
        } else if (imc < 35.0) {
            return R.string.imc_high_weight
        } else if (imc < 40.0) {
            return R.string.imc_severely_high_weight
        } else {
            return R.string.imc_extreme_weight
        }
    }

    private fun calculateImc(weight: Int, height: Int): Double {
        //peso /(altura *altura)
        return weight / ((height / 100.0) * (height / 100.0))
    }

    private fun validate(): Boolean {
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0"))
    }
}