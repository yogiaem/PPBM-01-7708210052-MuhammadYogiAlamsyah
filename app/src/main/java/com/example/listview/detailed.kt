package com.example.listview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.databinding.ActivityDetailedBinding

class detailed : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val desc = intent.getIntExtra("desc", R.string.salmonDesc)
            val image = intent.getIntExtra("image", R.drawable.salmon)
            binding.detailName.text = name
            binding.detailDesc.setText(desc)
            binding.detailImage.setImageResource(image)
        }
    }
}