package com.example.calculatrice

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input1 = findViewById<EditText>(R.id.input)
        val input2 = findViewById<EditText>(R.id.input2)
        val result = findViewById<TextView>(R.id.result)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)

        fun getNumbers(): Pair<Double, Double>? {
            val n1 = input1.text.toString()
            val n2 = input2.text.toString()
            if (n1.isEmpty() || n2.isEmpty()) return null
            return Pair(n1.toDouble(), n2.toDouble())
        }

        btnAdd.setOnClickListener {
            getNumbers()?.let {
                result.text = (it.first + it.second).toString()
            }
        }

        btnSub.setOnClickListener {
            getNumbers()?.let {
                result.text = (it.first - it.second).toString()
            }
        }

        btnMul.setOnClickListener {
            getNumbers()?.let {
                result.text = (it.first * it.second).toString()
            }
        }

        btnDiv.setOnClickListener {
            getNumbers()?.let {
                if (it.second == 0.0) {
                    result.text = "Erreur"
                } else {
                    result.text = (it.first / it.second).toString()
                }
            }
        }
    }
}
