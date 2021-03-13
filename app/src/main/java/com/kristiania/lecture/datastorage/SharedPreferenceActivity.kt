package com.kristiania.lecture.datastorage

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kristiania.lecture.datastorage.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferenceBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        // Create a shared preference instance
        sharedPreferences =
            getSharedPreferences("no.kristainia.android.preference", Context.MODE_PRIVATE)

        binding.btnSavePreference.setOnClickListener {
            // create editor and add the key value pair to the preference
            val editor = sharedPreferences.edit()
            editor.putString("KEY_STR", "Well it may work!")
            editor.apply()
        }

        binding.btnReadPreference.setOnClickListener {
            val str = sharedPreferences.getString("KEY_STR", null)
            Toast.makeText(this, str, Toast.LENGTH_LONG).show()
        }

        binding.btnDeletePreference.setOnClickListener {
            // create editor and remove the key value pair form the preference
            val editor = sharedPreferences.edit()
            editor.remove("KEY_STR")
            editor.apply()
        }
    }


}
