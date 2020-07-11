package com.example.schichten

import android.content.Context
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

        //Variablen für Einstellungen
        val speicher = getSharedPreferences(getString(setting), Context.MODE_PRIVATE)
        //Reinfolge 0 = Schicht/Stellwerk; 1 = Stellwerk/Schicht
        //Einstellung laden, ggf erzeugen
            @Suppress("IMPLICIT_CAST_TO_ANY", "ControlFlowWithEmptyBody") val saveReinfolge  = if (speicher.contains(getString(reinfolge))) speicher.getInt(getString(
                reinfolge), 0) else{}
            if (saveReinfolge == 0) rbSchicht.isChecked = true
            else rbStellwerk.isChecked = true

        //ohne speichern zurück
        buAbbrechen.setOnClickListener {
            val zurueck = Intent(this, MainActivity::class.java)
            startActivity(zurueck)
        }

        //speichern und zurück
        buSpeichern.setOnClickListener {
            try {
                val auswahlSchichtStellwerk = if (rbSchicht.isChecked) 0 else 1
                try {
                    val schreiber = speicher.edit()
                    schreiber.putInt(getString(reinfolge),auswahlSchichtStellwerk)
                    if (!schreiber.commit()) Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                }catch (ex:java.lang.Exception){Toast.makeText(this, error, Toast.LENGTH_LONG).show()}

                val speichern = Intent(this, MainActivity::class.java)
                startActivity(speichern)
            }
            catch (ex:Exception){}


        }
    }
}