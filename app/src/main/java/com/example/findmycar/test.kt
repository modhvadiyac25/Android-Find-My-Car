package com.example.findmycar

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import java.lang.System.err
import kotlin.random.Random.Default.Companion

class test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        image_chooser.setOnClickListener {
            Toast.makeText(this,"Button clicked",Toast.LENGTH_LONG).show()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    //Permission deny
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions,PERMISSION_CODE)
                } else {
                    //permission already granted
                    picImageFromGallary()
                }
            } else {
                //System os < Marshmello
                picImageFromGallary()
            }
        }

    }

    companion object {
        private val IMAGE_PIC_CODE = 1000
        private val PERMISSION_CODE = 1001
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){ PERMISSION_CODE->
        {
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                picImageFromGallary()
            }else{
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_LONG).show()
            }
        }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == IMAGE_PIC_CODE){
            image_view1.setImageURI(data?.data)
        }
        else{
            Toast.makeText(this,"resultCode : ${resultCode} Activity.RESULT_OK ",Toast.LENGTH_LONG).show()
        }

    }
    private fun picImageFromGallary(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,IMAGE_PIC_CODE)
    }
}
