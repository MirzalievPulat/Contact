package com.example.lesson8task3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson8task3kotlin.Fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()

    }
}