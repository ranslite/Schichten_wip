package com.example.schichten

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.schichten.R.string.*
import kotlinx.android.synthetic.main.activity_einstellung.*

class EinstellungActivity : AppCompatActivity() {
    @Suppress("ControlFlowWithEmptyBody", "IMPLICIT_CAST_TO_ANY")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_einstellung)
        supportActionBar?.title = getString(einstellung)

        //Variablen für Einstellungen
        val speicher = getSharedPreferences(getString(setting), Context.MODE_PRIVATE)
        //Reinfolge 0 = Schicht/Stellwerk; 1 = Stellwerk/Schicht
        //Einstellung laden, ggf erzeugen
        val saveReinfolge  = if (speicher.contains(getString(reinfolge))) speicher.getInt(getString(
                reinfolge), 0) else 0
        if (saveReinfolge == 0) rbSchicht.isChecked = true else rbStellwerk.isChecked = true

        //Abfrage der Angezeigten Stellwerke
        val saveLinsburg = if (speicher.contains(getString(linsburg))) speicher.getInt(getString(
            linsburg),1) else 1
        cbLinsburg.isChecked = saveLinsburg == 1

        val saveNienburg = if (speicher.contains(getString(nienburg))) speicher.getInt(getString(
            nienburg),1) else 1
        cbNienburg.isChecked = saveNienburg == 1

        val saveRohrsen = if (speicher.contains(getString(rohrsen))) speicher.getInt(getString(
            rohrsen),1) else 1
        cbRohrsen.isChecked = saveRohrsen == 1

        val saveEystrup = if (speicher.contains(getString(eystrup))) speicher.getInt(getString(
            eystrup), 1) else 1
        cbEystrup.isChecked = saveEystrup == 1

        val saveDoerverden = if (speicher.contains(getString(d_rverden))) speicher.getInt(getString(
            d_rverden), 1) else 1
        cbDoerverden.isChecked = saveDoerverden == 1

        val saveVerden = if (speicher.contains(getString(verden))) speicher.getInt(getString(verden), 1) else 1
        cbVerden.isChecked = saveVerden == 1

        val saveLangwedel = if (speicher.contains(getString(langwedel))) speicher.getInt(getString(
            langwedel), 1) else 1
        cbLangwedel.isChecked = saveLangwedel == 1

        //ohne speichern zurück
        buAbbrechen.setOnClickListener {
            //Startseite aufrufen
            val zurueck = Intent(this, MainActivity::class.java)
            startActivity(zurueck)
        }

        //speichern und zurück
        buSpeichern.setOnClickListener {
            try {
                //Abfrage der ausgewählten Einstellungen
                val auswahlSchichtStellwerk = if (rbSchicht.isChecked) 0 else 1
                val auswahlLinsburg = if (cbLinsburg.isChecked) 1 else 0
                val auswahlNienburg = if (cbNienburg.isChecked) 1 else 0
                val auswahlRohrsen = if (cbRohrsen.isChecked) 1 else 0
                val auswahlEystrup = if (cbEystrup.isChecked) 1 else 0
                val auswahlDoerverden = if (cbDoerverden.isChecked) 1 else 0
                val auswahlVerden = if (cbVerden.isChecked) 1 else 0
                val auswahlLangwedel = if (cbLangwedel.isChecked) 1 else 0
                try {
                    //Einstellungen in setting.cfg speichern
                    val schreiber = speicher.edit()
                    schreiber.putInt(getString(reinfolge),auswahlSchichtStellwerk)
                    schreiber.putInt(getString(linsburg), auswahlLinsburg)
                    schreiber.putInt(getString(nienburg), auswahlNienburg)
                    schreiber.putInt(getString(rohrsen), auswahlRohrsen)
                    schreiber.putInt(getString(eystrup), auswahlEystrup)
                    schreiber.putInt(getString(d_rverden), auswahlDoerverden)
                    schreiber.putInt(getString(verden), auswahlVerden)
                    schreiber.putInt(getString(langwedel), auswahlLangwedel)
                    //Fehlerbehandlung
                    if (!schreiber.commit()) Toast.makeText(this, error, Toast.LENGTH_LONG).show()
                }catch (ex:java.lang.Exception){Toast.makeText(this, error, Toast.LENGTH_LONG).show()}

                //Startseite aufrufen
                val speichern = Intent(this, MainActivity::class.java)
                startActivity(speichern)
            }
            catch (ex:Exception){}


        }
    }
}