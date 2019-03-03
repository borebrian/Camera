package com.message.mycamerastartapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val CAMERA_REQUEST_CODE =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        camerabutton.setOnClickListener(){
            val callCamera =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(callCamera.resolveActivity(packageManager) != null){
                startActivityForResult(callCamera,CAMERA_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            CAMERA_REQUEST_CODE-> {
                if (requestCode == Activity.RESULT_OK && data != null) {
                    imageView.setImageBitmap(data.extras.get("data") as Bitmap)

                }
            }

            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()
            }

        }
    }
    }

