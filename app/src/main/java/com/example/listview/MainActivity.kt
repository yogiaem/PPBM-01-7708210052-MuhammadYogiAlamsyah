package com.example.listview

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageList = intArrayOf(
            R.drawable.salmon,
            R.drawable.burger,
            R.drawable.jameson,
            R.drawable.coffee,
            R.drawable.milk,
            R.drawable.mineral,
            R.drawable.icecream,
            R.drawable.chips
        )
        val descList = intArrayOf(
            R. string.salmonDesc,
            R. string.burgerDesc,
            R. string.jamesonDesc,
            R. string.milkDesc,
            R. string.mineralDesc,
            R. string.iceCreamDesc,
            R. string.donutDesc,
            R. string.chipsDesc
        )
        val nameList = arrayOf("Salmon With Salad", "Burger", "Jameson Irish Whiskey", "Coffee", "Milk", "Mineral", "Ice Cream", "Donut", "Chips")

        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                descList[i],
                imageList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener = AdapterView.OnItemClickListener() { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, detailed::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("desc", descList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }
    }
}