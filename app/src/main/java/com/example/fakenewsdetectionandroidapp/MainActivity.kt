package com.example.fakenewsdetectionandroidapp

//import android.app.ProgressDialog
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
//import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import org.tensorflow.lite.Interpreter
//import java.io.FileInputStream
//import java.nio.MappedByteBuffer
//import java.nio.channels.FileChannel
//import java.util.*
//import android.R
import android.os.Handler
import android.util.Log
//import android.view.View
import org.tensorflow.lite.support.label.Category


class MainActivity : AppCompatActivity() {

    //private val MODELASSETSPATH = "model.tflite"

    // Max Length of input sequence. The input shape for the model will be ( None , INPUT_MAXLEN ).
    //private val INPUT_MAXLEN = 171

    //private var tfLiteInterpreter: Interpreter? = null
    private var client: TextClassificationClient? = null
    private var handler: Handler? = null
    private var result: TextView = findViewById(R.id.result)


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val messagetext: EditText = findViewById(R.id.message_text)

        client = TextClassificationClient(applicationContext)
        //handler = Handler()
        val classifyButton = findViewById<Button>(R.id.button)
        classifyButton.setOnClickListener {
            classify(
                messagetext.text.toString()
            )
        }


    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart")
        handler!!.post { client!!.load() }
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onStop")
        handler!!.post { client!!.unload() }
    }


    private fun classify(text: String) {
        handler!!.post {

            // Run text classification with TF Lite.
            val results: List<Category> = client!!.classify(text)

            // Show classification result on screen
            showResult(results)
        }
    }

    private fun showResult(r: List<Category>){
        result.text = r[0].label
    }
}