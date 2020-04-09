package start

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OneSimpleNumber: AppCompatActivity() {

    lateinit var button: Button
    lateinit var number: TextView
    var textLog: String = ""
    val logs = Logs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_simple_number)

        number = findViewById<TextView>(R.id.number)
        number.text = "0"

        button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            logs.writeLogs("Переход на 2е activity")

            val sendIntent = Intent(this, TwoSquareNumber::class.java)
                .apply {
                    putExtra("number", number.text.toString())
                }
            startActivityForResult(sendIntent, 0)
        }

        number.text = intent.getStringExtra("numberValBack") ?: "0"

        logs.writeLogs("Был запущен onCreate в 1-м activity")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        var numberVal = 0
        if (number.text != null) {
            numberVal = number.text.toString().toInt()
            numberVal += 1
        }
        outState?.putString("NUMBER_VALUE", numberVal.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        number.text = savedInstanceState?.getString("NUMBER_VALUE")
    }


    override fun onStart() {
        logs.writeLogs("Был запущен onStart в 1-м activity")
        super.onStart()
    }

    override fun onResume() {
        logs.writeLogs("Был запущен onResume в 1-м activity")
        super.onResume()
    }

    override fun onPause() {
        logs.writeLogs("Был запущен onPause в 1-м activity")
        super.onPause()
    }

    override fun onStop() {
        logs.writeLogs("Был запущен onStop в 1-м activity")
        super.onStop()
    }

    override fun onDestroy() {
        logs.writeLogs("Был запущен onDestroy в 1-м activity")
        super.onDestroy()
    }
}