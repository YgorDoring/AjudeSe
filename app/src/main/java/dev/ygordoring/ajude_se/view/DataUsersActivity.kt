package dev.ygordoring.ajude_se.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import dev.ygordoring.ajude_se.databinding.ActivityDataUsersBinding

class DataUsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDataUser.setOnClickListener { dataUser() }
    }

    private fun dataUser () {
        val name = binding.edtDataUserName.text.toString()
        val age = binding.edtDataUserAge.text.toString()
        val height = binding.edtDataUserHeight.text.toString()
        val weight = binding.edtDataUserWeight.text.toString()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("age", age)
        intent.putExtra("height", height)
        intent.putExtra("weight", weight)
        startActivity(intent)
        finish()
    }

}