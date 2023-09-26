package com.example.tugaspertemuan6

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tugaspertemuan6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kelas = arrayOf(
            "Ekonomi",
            "Bisnis",
            "Eksekutif",
            "VIP",
        )
        var waktu = ""
        var tanggal = ""
        with(binding){
            val kelasAdapter = ArrayAdapter(this@MainActivity,
                R.layout.simple_spinner_dropdown_item,
                kelas)
            kelasAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinnerKelas.adapter = kelasAdapter
            datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth)
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                tanggal = selectedDate
            }
            timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                waktu = selectedTime
            }
            btnPesan.setOnClickListener {
                if (waktu == "" || tanggal == ""){
                    Toast.makeText(this@MainActivity, "Belum Memilih Tanggal atau Waktu", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Berhasil Membeli Tiket " + spinnerKelas.selectedItem.toString() + ", " + tanggal + ", " + waktu, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}