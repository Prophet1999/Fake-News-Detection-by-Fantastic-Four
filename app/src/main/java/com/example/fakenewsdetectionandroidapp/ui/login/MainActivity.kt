package com.example.fakenewsdetectionandroidapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fakenewsdetectionandroidapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
           var intent=Intent(this@MainActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}