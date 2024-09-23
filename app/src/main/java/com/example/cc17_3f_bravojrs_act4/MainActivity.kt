package com.example.cc17_3f_bravojrs_act4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cc17_3f_bravojrs_act4.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{calculateTip()}
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun calculateTip(){
        val cost = binding.cost.text.toString().toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId){
            R.id.amazing_twenty -> 0.2
            R.id.good_eighteen -> 0.18
            else -> 0.1
        }
        var tip = cost*tipPercentage
        val roundUp = binding.switchButton.isChecked
        if (roundUp){
            tip = ceil(tip)
        }
        binding.results.text = "Tip Amount: ₱${tip.toString()}"

    }
}