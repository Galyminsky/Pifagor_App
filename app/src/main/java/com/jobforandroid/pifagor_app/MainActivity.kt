package com.jobforandroid.pifagor_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jobforandroid.pifagor_app.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun onClickResult (view : View) {
        if (!isFieldEmpty()) {
            val result = getString(R.string.tvresult) + getResult()
            binding.tvResult.text = result
        }


    }

    private fun isFieldEmpty () : Boolean {
        binding.apply {
           if (edA.text.isNullOrEmpty()) edA.error = "ПОле не должно быть пустым!"
            if (edB.text.isNullOrEmpty()) edB.error = "ПОле не должно быть пустым!"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult() : String {
        val a : Double
        val b : Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt((a.pow(2) + b.pow(2))).toString()           // Корень!!!!
    }
}