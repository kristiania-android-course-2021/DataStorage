package com.kristiania.lecture.datastorage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kristiania.lecture.datastorage.databinding.ActivityCacheBinding


class InternalFilesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCacheBinding

    val internalFileName = "my-internal-file"

    // First lets make a function to manipulate files

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCacheBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fileContent =
            "Hi, How are you?\nThis is an android file demo \nfor internal private file\n"

        // button click listener to save the data to cache
        binding.btnSaveInternal.setOnClickListener {
            // Get file out stream

            val fout = openFileOutput("my-internal-file", Context.MODE_PRIVATE)
            fout.write(fileContent.toByteArray())
            fout.close()
            // Write content to the file output stream

            // close the file stream

        }

        // Button click listener to read form the cache
        binding.btnReadInternal.setOnClickListener {
            // get all the files list from the internal folder
            val list = fileList()
            val myFile = list[0]
            // create an input stream for the file
            val fIn = openFileInput(myFile)
            // Get the data
            val string = fIn.bufferedReader().useLines { lines ->
                lines.fold("") { append, text ->
                    "$append\n$text"
                }
            }

            Toast.makeText(this, string, Toast.LENGTH_LONG).show()
        }

        // Button click listener to delete from the internal folder
        binding.btnDeleteInternal.setOnClickListener {
            // get all the files list from the internal folder and delete our
            val list = fileList()
            val myFile = list[0]
            deleteFile(myFile)

        }

    }
}
