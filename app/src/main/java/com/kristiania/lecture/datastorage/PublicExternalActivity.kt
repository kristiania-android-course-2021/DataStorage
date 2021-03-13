package com.kristiania.lecture.datastorage

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.kristiania.lecture.datastorage.databinding.ActivityPublicExternalBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class PublicExternalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPublicExternalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicExternalBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val fileContent =
            "Hi, How are you?\nThis is an android file demo \nfor External public file"

        //Check and ask for permission
        executePermission()

        binding.btnSavePublic.setOnClickListener {
            // Get the public folder
            val folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            val file = File(folder, "my_external_public_file")
            Log.d("", file.absolutePath)

            // create file
            writeToFile(fileContent, file)
            // Write in the file

            // create an image
            /*val imageFile = File(folder, "my_image.png")
            storeImage(imageFile)*/

        }

        binding.btnReadPublic.setOnClickListener {
            // Get the public folder
            val folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            val file = File(folder, "my_external_public_file")
            // create file
            readFromFile(file)
            // read from the file
        }

    }

    private fun readFromFile(file: File) {
        val fIn = FileInputStream(file)
        val string = fIn.bufferedReader().useLines { lines ->
            lines.fold("") { append, line ->
                "$append\n$line"
            }
        }

        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    private fun writeToFile(fileContent: String, file: File) {
        val fOut = FileOutputStream(file, true)
        fOut.write(fileContent.toByteArray())
        fOut.close()
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


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // make sure we have  valid permission
        if (requestCode == 1234
            && grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "All need permissions are granted.", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                this,
                "You don't have permission to use external storage.",
                Toast.LENGTH_LONG
            ).show()
        }

    }


    // Permission handling
    private fun executePermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat
                .requestPermissions(
                    this,
                    arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1234
                )
        }
    }


}
