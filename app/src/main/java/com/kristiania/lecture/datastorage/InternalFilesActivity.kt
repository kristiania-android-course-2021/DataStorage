package com.kristiania.lecture.datastorage

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.kristiania.lecture.datastorage.databinding.ActivityCacheBinding


class InternalFilesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCacheBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCacheBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fileContent =
            "Hi, How are you?\nThis is an android file demo \nfor internal private file\n"

        // button click listener to save the data to cache
        binding.btnSaveInternal.setOnClickListener {
            // Get file out stream
            // Write content to the file output stream
            // close the file stream
        }

        // Button click listener to read form the cache
        binding.btnReadInternal.setOnClickListener {
            // get all the files list from the internal folder
            // create an input stream for the file
            // Get the data

            //Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }

        // Button click listener to delete from the internal folder
        binding.btnDeleteInternal.setOnClickListener {
            // get all the files list from the internal folder and delete our
        }

    }
}
