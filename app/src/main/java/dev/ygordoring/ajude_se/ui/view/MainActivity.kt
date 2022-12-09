package dev.ygordoring.ajude_se.ui.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import dev.ygordoring.ajude_se.data.model.MainItem
import dev.ygordoring.ajude_se.databinding.ActivityMainBinding
import dev.ygordoring.ajude_se.data.model.QuickAccess
import dev.ygordoring.ajude_se.ui.viewmodel.DataUsersActivity
import dev.ygordoring.ajude_se.ui.viewmodel.MainAdapter
import dev.ygordoring.ajude_se.ui.viewmodel.getActivity
import dev.ygordoring.ajude_se.ui.viewmodel.mountItems

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: SharedPreferences
    private val mainItems = mutableListOf<MainItem>()
    private lateinit var mAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            initPrefs()
            mountItems(mainItems)
            setListeners()
            initViews()
        }
    }

    private fun ActivityMainBinding.setListeners(){
        imgAddInfo.setOnClickListener() {
            startActivity(Intent(root.context, DataUsersActivity::class.java))
        }
        mAdapter = MainAdapter(mainItems) { id ->
            startActivity(Intent(this@MainActivity, getActivity(QuickAccess.values().first { it.id == id })))
        }
    }

    private fun ActivityMainBinding.initViews() {
        rvMain.adapter = mAdapter
        rvMain.layoutManager = GridLayoutManager(root.context, SPAN_COUNT)
    }

    private fun ActivityMainBinding.initPrefs() {
        preferences = root.context.getSharedPreferences("userData", Context.MODE_PRIVATE)
    }

    private fun recoveryDataUser(){
        with(binding) {
            preferences.apply {
                txtViewNameUser.text = getString("name", "Ygor Doring")
                txtViewAgeNumberUser.text = getString("age", "26")
                txtViewHeightNumberUser.text = getString("height", "180")
                txtViewWeightNumberUser.text = getString("weight", "72")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        recoveryDataUser()
    }

    companion object {
        const val SPAN_COUNT = 3
    }
}
