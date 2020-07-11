package com.example.schichten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.schichten.R.string.*
import kotlinx.android.synthetic.main.activity_einstellung.*

class EinstellungActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_einstellung)
        supportActionBar?.title = getString(einstellung)

        //ohne speichern zurück
        buAbbrechen.setOnClickListener {
            val zurueck = Intent(this, MainActivity::class.java)
            startActivity(zurueck)
            Toast.makeText(this, getString(einstellung_verwerfen),Toast.LENGTH_SHORT).show()
        }

        //speichern und zurück
        buSpeichern.setOnClickListener {
            val speichern = Intent(this, MainActivity::class.java)
            startActivity(speichern)
            Toast.makeText(this, getString(einstellung_gespeichert), Toast.LENGTH_SHORT).show()
        }
    }
}