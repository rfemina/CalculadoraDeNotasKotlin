package com.projetosrafaelfemina.calculadoradenotas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.projetosrafaelfemina.calculadoradenotas.databinding.ActivityMainBinding
import java.lang.Integer.parseInt


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btCalculate.setOnClickListener {
            val number1 = binding.note1
            val number2 = binding.note2
            val number3 = binding.note3
            val number4 = binding.note4
            val fouls = binding.fouls
            val result = binding.txtResult

            val note1 = parseInt(number1.text.toString())
            val note2 = parseInt(number2.text.toString())
            val note3 = parseInt(number3.text.toString())
            val note4 = parseInt(number4.text.toString())
            val foulsNumbers = parseInt(fouls.text.toString())

            val average = ((note1 + note2 + note3 + note4) / 4)

            if (average >= 5 && foulsNumbers < 20) {
                result.setText("Aluno foi Aprovado \n Média final: $average")
                result.setTextColor(getColor(R.color.green))
            } else if (average < 5){
                result.setText("Aluno foi reprovado por Nota \n Média final: $average")
                result.setTextColor(getColor(R.color.red))
            } else if (foulsNumbers > 20){
                result.setText("Aluno foi reprovado por Faltas \n Média final: $average")
                result.setTextColor(getColor(R.color.red))
            }
        }

    }
}