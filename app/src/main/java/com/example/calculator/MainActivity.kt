package com.example.calculator

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btncal.setOnClickListener {
            val firstnumber = binding.etfirst.text.toString().toDoubleOrNull()
            val secondnumber = binding.etsecond.text.toString().toDoubleOrNull()
            val opeartor = binding.etoperator.text.toString()

            if(firstnumber!=null && secondnumber!=null){
                val result = when (opeartor) {
                    "+" -> firstnumber + secondnumber
                    "-" -> firstnumber - secondnumber
                    "*" -> firstnumber * secondnumber
                    "/"->{
                        if(secondnumber!=0.0) firstnumber/ secondnumber
                        else {
                            Toast.makeText(this, "Cannot Divide by zero", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                    }
                    else ->{
                        Toast.makeText(this , "Valid Operations Are Only +, -, * and /", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                }

                binding.tvoutput.text = result.toString()
            }
            else {
                Toast.makeText(this, "Please Enter Valid Numbers", Toast.LENGTH_SHORT).show()
            }
            }


        }



    }

