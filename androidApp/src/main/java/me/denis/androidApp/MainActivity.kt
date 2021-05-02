package me.denis.androidApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.Exception
import android.util.Log
import androidx.core.content.ContextCompat
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val zero: Button = findViewById(R.id.zero_btn)
        val one: Button = findViewById(R.id.one_btn)
        val two: Button = findViewById(R.id.two_btn)
        val three: Button = findViewById(R.id.three_btn)
        val four: Button = findViewById(R.id.four_btn)
        val five: Button = findViewById(R.id.five_btn)
        val six: Button = findViewById(R.id.six_btn)
        val seven: Button = findViewById(R.id.seven_btn)
        val eight: Button = findViewById(R.id.eight_btn)
        val nine: Button = findViewById(R.id.nine_btn)
        val division: Button = findViewById(R.id.division_btn)
        val multiplication: Button = findViewById(R.id.multiplication_btn)
        val plus: Button = findViewById(R.id.plus_btn)
        val minus: Button = findViewById(R.id.minus_btn)
        val ac: Button = findViewById(R.id.AC_btn)
        val math_operation: TextView = findViewById(R.id.math_operation)
        val result_text: TextView = findViewById(R.id.result_text)
        val back_btn: Button = findViewById(R.id.back_btn)
        val equally: Button = findViewById(R.id.equally_btn)
        val percent: Button = findViewById(R.id.percent_btn)
        val dot: Button = findViewById(R.id.dot_btn)
        var count = 0
        zero.setOnClickListener{ setTextFields("0")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        one.setOnClickListener{ setTextFields("1")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        two.setOnClickListener{ setTextFields("2")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        three.setOnClickListener{ setTextFields("3")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        four.setOnClickListener{ setTextFields("4")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        five.setOnClickListener{ setTextFields("5")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        six.setOnClickListener{ setTextFields("6")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        seven.setOnClickListener{ setTextFields("7")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        eight.setOnClickListener{ setTextFields("8")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        nine.setOnClickListener{ setTextFields("9")
            markButtonEnable(plus)
            markButtonEnable(minus)
            markButtonEnable(multiplication)
            markButtonEnable(division)
            count++
        }
        var k = 0
        division.setOnClickListener{ setTextFields("÷")
            markButtonDisable(division)
            k++
        }
        multiplication.setOnClickListener{ setTextFields("*")
            markButtonDisable(multiplication)
            k++
        }
        plus.setOnClickListener{ setTextFields("+")
            markButtonDisable(plus)
            k++
        }
        minus.setOnClickListener{ setTextFields("-")
            markButtonDisable(minus)
            k++
        }
        if ( count > 0 && k > 0) markButtonEnable(dot)
        if ( "${result_text.text}" != "" ) {
            markButtonEnable(percent)
            percent.setOnClickListener {
                if ("${math_operation.text}".toInt() > 0) math_operation.text =
                    ("${math_operation.text}".toInt() * -1).toString()
                else math_operation.text = "${math_operation.text}"
            }
        }
        else markButtonDisable(percent)
        ac.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }
        val orientation_btn: TextView = findViewById(R.id.orientation_btn)
        orientation_btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        back_btn.setOnClickListener{
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
            {
                math_operation.text = str.substring(0, str.length-1)
            }
            result_text.text = ""
        }
        dot.setOnClickListener {
            setTextFields(".")
            markButtonDisable(dot)
        }
        equally.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            } catch (e:Exception) {
                val log = Log.d("Ошибка", "сообщение: ${e.message}")
                Toast.makeText(this,log, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun setTextFields(str: String){
        val math_operation: TextView = findViewById(R.id.math_operation)
        val result_text: TextView = findViewById(R.id.result_text)
        if(result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }
    fun markButtonDisable(button: Button) {
        button.isEnabled = false
        button.setTextColor(ContextCompat.getColor(this, R.color.white))
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
    }
    fun markButtonEnable(button: Button) {
        button.isEnabled = true
        button.setTextColor(ContextCompat.getColor(this, R.color.orange))
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.whiter))
    }
}
