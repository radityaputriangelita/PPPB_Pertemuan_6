package com.example.pppb_pertemuan_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pppb_pertemuan_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayOf(
            "Indonesia",
            "United States",
            "United Kingdom",
            "Germany",
            "France",
            "Australia",
            "Japan",
            "China",
            "Brazil",
            "Canada"
        )

        val provinces = resources.getStringArray(R.array.provinces)


        with(binding) {
            val countriesAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                countries
            )
            countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinCountries.adapter = countriesAdapter

            val provincesAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                provinces
            )
            provincesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinProvinces.adapter = provincesAdapter


            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
//
                timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
                    val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                    Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
// Gunakan selectedTime sesuai kebutuhan Anda
                }
            }
        }
    }
}