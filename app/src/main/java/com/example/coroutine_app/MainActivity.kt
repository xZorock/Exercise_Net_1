package com.example.coroutine_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.coroutine_app.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    private var currentValue = 0
    private var inputValue: Int? = null
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mainBinding.root)
    }

    override fun onResume() {
        super.onResume()
        mainBinding.button.setOnClickListener {
            if (inputValue == null) {
                inputValue = mainBinding.editText.text.toString().toIntOrNull()
                currentValue = (inputValue?.plus(1)) ?: 0
            } else {
                currentValue++
            }
            runBlocking {
                delay(2000)
                mainBinding.textView.text = currentValue.toString()
            }

        }
    }
}