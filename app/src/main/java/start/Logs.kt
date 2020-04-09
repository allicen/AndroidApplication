package start

import android.annotation.SuppressLint
import android.os.Environment
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Logs {
    fun writeLogs(logText: String) {
        val logFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "logTwoActivity.txt")
        if (!logFile.exists()) {
            try {
                logFile.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        try {
            val buf = BufferedWriter(FileWriter(logFile, true))
            buf.append("${getDate()}    $logText")
            buf.newLine()
            buf.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun getDate(): String {
        return SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())
    }
}