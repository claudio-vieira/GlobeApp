package com.example.helloearth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloearth.databinding.FragmentGlobeBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentGlobeBinding.inflate(layoutInflater).run {
            setContentView(this.root)
        }
    }
}