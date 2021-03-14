package com.kristiania.lecture.datastorage

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.kristiania.lecture.datastorage.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {

    private lateinit var sharedPreference: SharedPreferences
    private lateinit var binding: ActivitySharedPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        // Create a shared preference instance

        binding.btnSavePreference.setOnClickListener {
            // create editor and add the key value pair to the preference

        }

        binding.btnReadPreference.setOnClickListener {

        }

        binding.btnDeletePreference.setOnClickListener {
            // create editor and remove the key value pair from the preference
            // Remove all

        }
    }


}
