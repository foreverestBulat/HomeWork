package com.example.homework

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var clickButton: Button? = null
    private var key: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton = findViewById(R.id.button)

        val textView = findViewById<TextView>(R.id.et_view)
        val editTextName = findViewById<EditText>(R.id.et_text_name)
        val editTextAge = findViewById<EditText>(R.id.et_text_age)
        val editTextWeight = findViewById<EditText>(R.id.et_text_weight)
        val editTextHeight = findViewById<EditText>(R.id.et_number_height)

        editTextName.text.clear()
        editTextHeight.text.clear()
        editTextWeight.text.clear()
        editTextAge.text.clear()
        textView.text = ""

        clickButton?.setOnClickListener {
            var str = checkCorrectnessOfEnteredData(
                editTextName.text.toString(),
                editTextHeight.text.toString(),
                editTextWeight.text.toString(),
                editTextAge.text.toString())

            if (key){
                textView.setTextColor(Color.parseColor("#FF0000"))
                textView.text = str
            }
            else{
                textView.setTextColor(Color.parseColor("#000000"))
                textView.text = str
            }
        }
    }

    // я сделал ограничение на количество символов в name на constrait поэтому не вижу смысла здесь проверять на 50 символов
    // в полях height, weight, age можно записывать только цифры, а в weight еще и точку чтобы можно было записать double

    fun checkCorrectnessOfEnteredData(name: String, heightString: String, weightString: String, ageString: String): String {

        var res = resources.getString(R.string.textError)
            //"Data entered incorrectly:\n"
        try{
            var height = heightString.toInt()
            var weight = weightString.toDouble()
            var age = ageString.toInt()


            if (name.isEmpty()){
                res += resources.getString(R.string.emptyError)
            }
            if ((250 < height) or (0 > height)){
                res += resources.getString(R.string.heightError)
            }
            if ((250 < weight) or (0 > weight)){
                res += resources.getString(R.string.widthError)
            }
            if ((age > 150) or (age < 0)) {
                res += resources.getString(R.string.ageError)
            }

            if (res.length > 30){
                key = true
            } else {
                key = false
                val amountCalories = getAmountOfCalories(height, weight)
                return "${resources.getString(R.string.ageError)} $amountCalories"
            }
            return res

        } catch(e: NumberFormatException) {
            key = true
            return res
        }
    }

    // Количество калорий = вес (в кг) * 1.375 * 0.85
    fun getAmountOfCalories(height: Int, weight: Double): Double {
        return weight * 1.375 * 0.85
    }
}