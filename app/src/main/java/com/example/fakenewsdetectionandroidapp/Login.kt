package com.example.fakenewsdetectionandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import com.example.fakenewsdetectionandroidapp.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener{
           val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}