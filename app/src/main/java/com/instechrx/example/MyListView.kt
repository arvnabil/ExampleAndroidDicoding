package com.instechrx.example

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MyListView : AppCompatActivity() {

//    private val dataName = arrayOf("Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Patimura", "R A Kartini", "Sukarno")

    private lateinit var adapter: HeroAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray

    private var heroes = arrayListOf<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list_view)

        val listView:ListView = findViewById(R.id.lv_list)
        adapter = HeroAdapter(this)
//        val adapter = ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
        listView.adapter = adapter

        prepare()

        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            Toast.makeText(this@MyListView, heroes[position].name, Toast.LENGTH_SHORT).show()
        }

    }

    private fun addItem() {
        for (position in dataName.indices){
            val hero = Hero(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
        heroes.add(hero)
        }
        adapter.heroes = heroes
    }

    private fun prepare(){
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)

    }
}
