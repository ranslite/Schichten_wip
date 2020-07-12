package com.example.schichten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ueber.*

class UeberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ueber)
        supportActionBar?.title = getString(R.string.info)

        buZurueck.setOnClickListener {
            val zurueck = Intent(this, MainActivity::class.java)
            startActivity(zurueck)
        }
    }
}