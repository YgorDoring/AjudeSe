package dev.ygordoring.ajude_se.view

import android.content.Intent
import android.os.Bundle
import android.view.View                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ygordoring.ajude_se.model.MainItem
import dev.ygordoring.ajude_se.model.OnItemClickListener
import dev.ygordoring.ajude_se.R
import dev.ygordoring.ajude_se.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var rvMain: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val syncDataUser: ImageView = findViewById(R.id.imgAddInfo)
        syncDataUser.setOnClickListener() {
            val intent = Intent(this, DataUsersActivity::class.java)
            startActivity(intent)
        }
        recoveryDataUser()

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.imc,
                textStringId = R.string.label_imc,
            )
        )
        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.tmb,
                textStringId = R.string.label_tmb,
            )
        )
        mainItems.add(
            MainItem(
                id = 3,
                drawableId = R.drawable.water,
                textStringId = R.string.label_water,
            )
        )
        mainItems.add(
            MainItem(
                id = 4,
                drawableId = R.drawable.pharm,
                textStringId = R.string.label_pharm,
            )
        )
        mainItems.add(
            MainItem(
                id = 5,
                drawableId = R.drawable.sugest,
                textStringId = R.string.label_sugest,
            )
        )

        val adapter = MainAdapter(mainItems) { id ->
            when (id) {
                1 -> {
                    val intent = Intent(this@MainActivity, ImcActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this@MainActivity, TmbActivity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this@MainActivity, WaterCountActivity::class.java)
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(this@MainActivity, PharmaciesActivity::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val intent = Intent(this@MainActivity, SugestionsActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 3)

    }

    private fun recoveryDataUser(){
        val name = intent.getStringExtra("name") ?: "Ygor Doring"
        val age = intent.getStringExtra("age") ?: "26"
        val height = intent.getStringExtra("height") ?: "180"
        val weight = intent.getStringExtra("weight") ?: "72"

        binding.txtViewNameUser.text = name
        binding.txtViewAgeNumberUser.text = age
        binding.txtViewHeightNumberUser.text = height
        binding.txtViewWeightNumberUser.text = weight
    }

    override fun onClick(id: Int) {}

    private inner class MainAdapter(
        private val mainItems: List<MainItem>,
        private val onItemClickListener: (Int) -> Unit,
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)
        }

        override fun getItemCount(): Int {
            return mainItems.size
        }

        private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: MainItem) {
                val img: ImageView = itemView.findViewById(R.id.item_img_imc)
                val name: TextView = itemView.findViewById(R.id.item_txt_name)
                val container: LinearLayout = itemView.findViewById(R.id.item_container_imc)
                img.setImageResource(item.drawableId)
                name.setText(item.textStringId)

                container.setOnClickListener {
                    onItemClickListener.invoke(item.id)
                }
            }

        }


    }

}
