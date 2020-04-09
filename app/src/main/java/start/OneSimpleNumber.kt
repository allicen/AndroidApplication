package start

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OneSimpleNumber: AppCompatActivity() {

    lateinit var button: Button
    lateinit var number: TextView
    val logs = Logs()
    var index: Int = 0
    var changeActivity: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_simple_number)
        changeActivity = false

        number = findViewById<TextView>(R.id.number)
        number.text = index.toString()

        button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            logs.writeLogs("Переход на 2е activity")

            val sendIntent = Intent(this, TwoSquareNumber::class.java)
                .apply {
                    putExtra("number", index)
                }
            startActivity(sendIntent)
            changeActivity = true
        }
        logs.writeLogs("Был запущен onCreate в 1-м activity")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (!changeActivity) {
            index += 1
        }

        outState?.putInt("NUMBER_VALUE", index)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        index = savedInstanceState.getInt("NUMBER_VALUE", 0)
        number.text = index.toString()
    }

    override fun onStart() {
        logs.writeLogs("Был запущен onStart в 1-м activity")
        changeActivity = false
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