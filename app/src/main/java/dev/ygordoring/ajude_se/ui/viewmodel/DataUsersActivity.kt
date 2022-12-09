package dev.ygordoring.ajude_se.ui.viewmodel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.ygordoring.ajude_se.R
import dev.ygordoring.ajude_se.databinding.ActivityDataUsersBinding
import dev.ygordoring.ajude_se.ui.view.MainActivity

class DataUsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataUsersBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDataUser.setOnClickListener { dataUser() }
        binding.edtDataUserName.error = "Digite seu nome e seus dados abaixo"

        validate()
    }


    private fun dataUser() {
        val name = binding.edtDataUserName.text.toString()
        val age = binding.edtDataUserAge.text.toString()
        val height = binding.edtDataUserHeight.text.toString()
        val weight = binding.edtDataUserWeight.text.toString()
        preferences = binding.root.context.getSharedPreferences("userData", Context.MODE_PRIVATE)
        preferences.edit().apply {
            putString("name", name)
            putString("age", age)
            putString("height", height)
            putString("weight", weight)
        }.apply()
        startActivity(Intent(this, MainActivity::class.java)).also { finish() }
    }

    private fun validate() {
        binding.edtDataUserName.setOnClickListener {
            if (binding.edtDataUserName.text.toString().isNullOrBlank()) {
                Toast.makeText(this, R.string.fields_messages, Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
        }

    }

}

