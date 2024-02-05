package com.example.numbergame
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import com.example.numbergame.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding  : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        assignNumberToButtons()
        binding.btnLeft
            .setOnClickListener {
                Log.d("process", "This left button is clicked.")
                checkAnswer(true)
                assignNumberToButtons()
            }
        binding.btnRight.setOnClickListener{
            Log.d("process", "This Right button is clicked.")
            checkAnswer(false)
            assignNumberToButtons()
        }

    }
    private fun checkAnswer(isLeftButtonSelected : Boolean){
        val leftNum = binding.btnLeft.text.toString().toInt()
        val rightNum = binding.btnRight.text.toString().toInt()
        // line 35 is called ternary statement in kotlin
        val isAnswerCorrect : Boolean = if(isLeftButtonSelected) leftNum>rightNum else rightNum >leftNum
        if(isAnswerCorrect) {
            binding.backgroundView.setBackgroundColor(android.graphics.Color.GREEN)
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
        }else{
            binding.backgroundView.setBackgroundColor(android.graphics.Color.RED)
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
                }
    }

    private fun assignNumberToButtons() {
       Log.d("process" , "Assigning random numbers.")
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = r.nextInt(10)
        // while loop is helping to get rid of situation when left num and right num are equal.
        // ideally at every instance both of the number has to be unequal.
        while(rightNum == leftNum){
            rightNum = r.nextInt(10)
        }
        binding.btnLeft.text = leftNum.toString()
        binding.btnRight.text = rightNum.toString()
    }




    }
