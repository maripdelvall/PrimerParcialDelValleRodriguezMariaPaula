package com.example.primerparcialdelvallerodriguezmariapaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.primerparcialdelvallerodriguezmariapaula.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializar binding//
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Inicializar firebase//
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth


        // Métodos para los botones//

        binding.loginBut.setOnClickListener {
            login()
        }

        binding.registerBut.setOnClickListener {
            register()
        }
    }

    private fun login() {

        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                task ->
            if (task.isSuccessful) {
                Log.d("Login user", "Success")
                val user = auth.currentUser

            } else {
                Log.d("Login user", "Failed")
                Toast.makeText(baseContext, "Fail", Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun register() {

        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                task ->
            if (task.isSuccessful) {
                Log.d("Register user", "Success")
                val user = auth.currentUser

            } else {
                Log.d("Register user", "Failed")
                Toast.makeText(baseContext, "Fail", Toast.LENGTH_LONG).show()

            }
        }

    }
}