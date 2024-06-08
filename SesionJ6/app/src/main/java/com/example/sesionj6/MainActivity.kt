package com.example.sesionj6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sesionj6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.BtnEvaluar.setOnClickListener {
            val num = binding.TfNumber.editText!!.text.toString().toDouble()
            var msn = isPositive(num)
            Toast.makeText(this, msn, Toast.LENGTH_LONG).show()
        }

        binding.Btnispar.setOnClickListener {
            val number = binding.TfNumber.editText!!.text.toString().toDouble()
            val msn = isPar(number.toInt())
            Toast.makeText(this, msn, Toast.LENGTH_LONG).show()
        }

        binding.Btnfibonacci.setOnClickListener {
            val number = binding.TfNumber.editText!!.text.toString().toDouble()
            val msn = fibonacci(number.toInt())
            Toast.makeText(this, msn, Toast.LENGTH_LONG).show()
        }
    }

    fun isPositive(number:Double):String{
        return if (number>0) "El $number es Positivo"
        else if(number<0) "El $number es Negativo"
        else "El $number es Neutro"
    }

    fun isPar(number:Int):String{
        return if (number % 2 == 0) "El $number es par"
        else "El $number es Impar"
    }

    fun fibonacci(num:Int):String{
        var n1 = 0
        var n2 = 1
        var suma:Int
        var msn = "0 1"
        for(i in 3 .. num){
            suma = n1 + n2
            msn += suma
            n1 = n2
            n2 = suma
        }
        return msn
    }
}