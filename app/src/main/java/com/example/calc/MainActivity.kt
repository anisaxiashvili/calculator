package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.calc.R

class MainActivity : AppCompatActivity() {


    private lateinit var tvResult: TextView
    private lateinit var tvClear: TextView
    private var operand = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        tvClear = findViewById(R.id.tvResult)
    }


    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {

            var text = tvResult.text.toString()
            val number = clickedView.text.toString()
            if (tvResult.text.toString() == ""){
                tvResult.text = "0."
            }else if ("." !in text){
                tvResult.text = "."
            }
            if (text == "0" && number != ".") {
                text = ""
            }
            val result = text + number
            tvResult.text = result

        }



        }
        fun clearClick(clickedView: View) {

            if (clickedView is TextView){

                if (tvResult.text != ""){

                    operation = ""
                    operand = 0.0
                    tvResult.text = "0"

                }
            }
        }
    fun operationClick(clickedView: View) {
        if (clickedView is TextView) {
            if (tvResult.text.toString() != "") {

                operand = tvResult.text.toString().toDouble()
                operation = clickedView.text.toString()
                tvResult.text = ""
            }else{
                operation = clickedView.text.toString()

            }



        }
    }

    fun equalsClick(clickedView: View) {


        if (tvResult.text.toString() != "" && tvResult.text.toString() != "." && operation != "") {
            var finalResult = ""
            val secondOperand = tvResult.text.toString().toDouble()
            when (operation) {
                "+" -> finalResult = (operand + secondOperand).toString()
                "-" -> finalResult = (operand - secondOperand).toString()
                "*" -> finalResult = (operand * secondOperand).toString()
                "/" -> finalResult = (operand / secondOperand).toString()

            }

            if (finalResult.toString().slice(finalResult.toString().length - 2 until finalResult.toString().length) == ".0") {
                tvResult.text = finalResult.toString().slice(0 until finalResult.toString().length - 2)
            } else {
                tvResult.text = finalResult.toString()
            }

}


    }
    fun delClick(clickedView: View) {
        if (clickedView is TextView) {
            if (tvResult.text.toString() != "Infinity") {
                if (tvResult.text.toString() != "0") {
                    tvResult.text = tvResult.text.toString().dropLast(1)
                }
                if (tvResult.text.toString() == "") {
                    tvResult.text = "0"
                }
            }
        }
    }

    fun dotclick(clickedView: View) {
        if ("." !in tvResult.text.toString()) {
            if (clickedView is TextView) {
                var dot = clickedView.text.toString()
                var num = tvResult.text.toString()

                val result = num + dot
                tvResult.text = result
            }
        }
    }


}



