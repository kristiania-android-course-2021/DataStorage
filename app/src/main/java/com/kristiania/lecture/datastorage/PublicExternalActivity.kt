package com.kristiania.lecture.datastorage

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.kristiania.lecture.datastorage.databinding.ActivityPublicExternalBinding
import java.io.File
import java.io.FileOutputStream

class PublicExternalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPublicExternalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicExternalBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val fileContent =
                "Hi, How are you?\nThis is an android file demo \nfor External public file\n"

        //Check and ask for permission
        executePermission()

        binding.btnSavePublic.setOnClickListener {
            // Get the public folder
            // create file
            // Write in the file -fileOutputStream

        }

        binding.btnReadPublic.setOnClickListener {
            // Get the public folder

            // create file
            // read from the file

            //Snackbar.make(binding.root, data, Snackbar.LENGTH_SHORT).show()
        }

    }

    // Permission handling
    private fun executePermission() {

    }


    // How to store an image in a file
    private fun storeImage(file: File) {
        // Get the drawable from the drawable folder
        // convert it to bitmap
        val bitmap = ContextCompat
                .getDrawable(this, R.drawable.android12)?.toBitmap(988, 478)

        FileOutputStream(file, true)
                .use { fileOutStream ->
                    // Compress and save to file output stream
                    bitmap?.compress(Bitmap.CompressFormat.PNG, 100, fileOutStream)
                    // close the stream
                    fileOutStream.close()
                }
    }


}
