package start

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

@Suppress("SameParameterValue")
class TwoSquareNumber : AppCompatActivity() {

    lateinit var back: Button
    lateinit var square: TextView
    val logs = Logs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_square_number)

        square = findViewById<TextView>(R.id.square)
        back = findViewById<Button>(R.id.back)

        val args: String = intent.getStringExtra("number") ?: "0"
        square.text = getPowNumber(args)

        back.setOnClickListener {
            logs.writeLogs("Переход на 1 activity")

            val backActivity = Intent(this, OneSimpleNumber::class.java)
                .apply {
                    putExtra("numberValBack", args)
                }
            startActivityForResult(backActivity, 0)
            finish()
        }

        logs.writeLogs("Был запущен onCreate во 2-м activity")
    }

    private fun getPowNumber(value: String): String {
        return value.toDouble().pow(2.0).toInt().toString()
    }

    override fun onStart() {
        logs.writeLogs("Был запущен onStart во 2-м activity")
        super.onStart()
    }

    override fun onResume() {
        logs.writeLogs("Был запущен onResume во 2-м activity")
        super.onResume()
    }

    override fun onPause() {
        logs.writeLogs("Был запущен onPause во 2-м activity")
        super.onPause()
    }

    override fun onStop() {
        logs.writeLogs("Был запущен onStop во 2-м activity")
        super.onStop()
    }

    override fun onDestroy() {
        logs.writeLogs("Был запущен onDestroy во 2-м activity")
        super.onDestroy()
    }
}