package com.example.findmycar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.ByteArrayOutputStream

class UserProfile : AppCompatActivity() {


    private lateinit var imageUri: Uri
    private val REQUEST_IMAGE_CAPTURE = 100
    var database: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")
    var uid = FirebaseAuth.getInstance().currentUser?.uid



    // private var activity = getActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        //load profile image from the firebase
        var imageref = FirebaseStorage.getInstance().reference.child("pics/" + uid!!)
        imageref.downloadUrl.addOnSuccessListener { Uri ->

            val imageURL = Uri.toString()
            var IV = findViewById<ImageView>(R.id.image_view)
            Glide.with(this)
                .load(imageURL)
                .into(IV)
        }

        image_view.setOnClickListener {
          takePictureIntent()
        }

        //logout
        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        //edit profile
        edit_prifile.setOnClickListener {

            val intent =
                Intent(this, UpdateProfile::class.java)
            intent.putExtra(
                "user_id",
                FirebaseAuth.getInstance().currentUser!!.uid
            )
            startActivity(intent)
        }

        //retriving data from the database

        // show profile
        val id = intent.getStringExtra("user_id").toString()

        var getdata = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                //var sb = StringBuilder()
                for (i in snapshot.children) {
                    if (id.equals(i.child("uid").getValue())) {
                        findViewById<TextView>(R.id.text_email).setText(
                            i.child("email").getValue().toString()
                        )
                        findViewById<TextView>(R.id.text_name).setText(
                            i.child("fname").getValue().toString() + " " + i.child("lname")
                                .getValue().toString()
                        )
                        findViewById<TextView>(R.id.text_phone).setText(
                            i.child("mobile_no").getValue().toString()
                        )
                    }
                }
            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            uploadImageAndSaveUri(imageBitmap)
        }
    }

    private fun takePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { pictureIntent ->
            pictureIntent.resolveActivity(this@UserProfile.packageManager!!)?.also {
                startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    private fun uploadImageAndSaveUri(imageBitmap: Bitmap) {
        var baos = ByteArrayOutputStream()
        val storageRef =
            FirebaseStorage.getInstance().reference.child("pics/${FirebaseAuth.getInstance().currentUser?.uid}" + ".jpg")
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()
        val upload = storageRef.putBytes(image)

        progressbar_pic.visibility = View.VISIBLE
        upload.addOnCompleteListener { uploadTask ->
            progressbar_pic.visibility = View.INVISIBLE

            if (uploadTask.isSuccessful) {

                storageRef.downloadUrl.addOnCompleteListener { uriTask ->
                    uriTask.result?.let {
                        imageUri = it
                        database.child(uid!!).child("imageUrl").setValue(imageUri.toString())
                        Toast.makeText(this, "${imageUri.toString()}", Toast.LENGTH_LONG).show()
                        image_view.setImageBitmap(imageBitmap)
                    }
                }
            } else {
                uploadTask.exception?.let {
                    Toast.makeText(this, "${it.message!!}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}