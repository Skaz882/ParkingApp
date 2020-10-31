package com.example.parkingapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private val costPerHour = 1.50
    private var numberOfHours: Int = 0
    private var totalCharges: Double = 0.00
    private var lotChoice = ""
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hours: EditText = findViewById(R.id.idHours)
        val group: Spinner = findViewById(R.id.idSpinGroup)
        val charges: Button = findViewById(R.id.idCharges)
        val result: TextView = findViewById(R.id.idResults)

        charges.setOnClickListener{
            numberOfHours = hours.text.toString().toInt()
            val currency = DecimalFormat("$###,###.00")
            totalCharges = costPerHour * numberOfHours.toDouble()
            lotChoice = group.selectedItem.toString()
            val totalChargesFormatted = currency.format(totalCharges)

            result.text = "Cost for parking in $lotChoice for $numberOfHours is $totalChargesFormatted"
        }
    }
}