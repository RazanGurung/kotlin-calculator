package com.Rajan.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var calculate : TextView
    private lateinit var answer : TextView

    private lateinit var zero : Button
    private lateinit var one : Button
    private lateinit var two : Button
    private lateinit var three : Button
    private lateinit var four : Button
    private lateinit var five : Button
    private lateinit var six : Button
    private lateinit var seven : Button
    private lateinit var eight : Button
    private lateinit var nine : Button
    private lateinit var dot : Button
    private lateinit var divide : Button
    private lateinit var multiply : Button
    private lateinit var plus : Button
    private lateinit var minus : Button
    private lateinit var back : Button
    private lateinit var equals : Button
    private lateinit var ce : Button
    private lateinit var c : Button

    private lateinit var hello : TextView
    var newValue = ""
    var oldValue = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hello = findViewById(R.id.hello)
        calculate = findViewById(R.id.calculate)
        answer = findViewById(R.id.answer)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        divide = findViewById(R.id.divide)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        dot = findViewById(R.id.dot)
        ce = findViewById(R.id.ce)
        c = findViewById(R.id.c)
        back = findViewById(R.id.back)

        zero.setOnClickListener(){appendValue("0", true)}
        one.setOnClickListener(){appendValue("1", true)}
        two.setOnClickListener(){appendValue("2", true)}
        three.setOnClickListener(){appendValue("3", true)}
        four.setOnClickListener(){appendValue("4", true)}
        five.setOnClickListener(){appendValue("5", true)}
        six.setOnClickListener(){appendValue("6", true)}
        seven.setOnClickListener(){appendValue("7", true)}
        eight.setOnClickListener(){appendValue("8", true)}
        nine.setOnClickListener(){appendValue("9", true)}
        dot.setOnClickListener(){appendValue(".", true)}
        
        divide.setOnClickListener(){
            appendValue("/", false)
        }
        multiply.setOnClickListener(){
            appendValue("*", false)
        }
        plus.setOnClickListener(){
            appendValue("+", false)
        }
        minus.setOnClickListener(){
            appendValue("-", false)
        }
        back.setOnClickListener(){
            var hellovalue = hello.text.toString()
            var calValue = calculate.text.toString()
            calculate.text = calValue.substring(0,calValue.length-1)
            hello.text = hellovalue.substring(0,hellovalue.length-1)
            answer.text=""
        }
        ce.setOnClickListener(){
            var calValue = calculate.text.toString()
            var hellovalue = hello.text.toString()
            calculate.text = calValue.substring(0,calValue.length-1)
            answer.text=""
            hello.text = hellovalue.substring(0,hellovalue.length-1)
        }
        c.setOnClickListener(){
            calculate.text=""
            answer.text=""
            hello.text = ""
        }

    }
    private fun appendValue(value:String, remove:Boolean){
        hello = findViewById(R.id.hello)
        calculate = findViewById(R.id.calculate)
        answer = findViewById(R.id.answer)
        if (answer.text.isNotEmpty()){
            calculate.text= ""
        }

        if(remove){
            answer.text =""
            calculate.append(value)
            hello.append(value)
        }
        else{
            calculate.append(answer.text)
            calculate.append(value)
            answer.text = ""
        }

        if (!remove){
            oldValue = hello.text.toString()
            hello.text = ""
        }
        else{
            newValue = hello.text.toString()
        }

        equals = findViewById(R.id.equals)
        if (value == "+"){
            equals.setOnClickListener(){
                var new = newValue.toInt()
                var old = oldValue.toInt()
                var ans = new + old
                answer.text = ans.toString()
            }
        }
        else if (value == "-"){
            equals.setOnClickListener(){
                var new = newValue.toInt()
                var old = oldValue.toInt()
                var ans =  old - new
                answer.text = ans.toString()
            }
        }
        else if (value == "*"){
            equals.setOnClickListener(){
                var new = newValue.toInt()
                var old = oldValue.toInt()
                var ans = new * old
                answer.text = ans.toString()
            }
        }
        else if (value == "/"){
            equals.setOnClickListener(){
                var new = newValue.toInt()
                var old = oldValue.toInt()
                var ans =  old / new
                answer.text = ans.toString()
            }
        }
    }

}

















