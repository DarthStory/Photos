package com.example.photos

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photos.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MainActivity", "MainActivity started")
        setupRecyclingView()
        fetchPhotos()
    }

    private fun setupRecyclingView() {
        binding.photoRecyclerView.layoutManager = GridLayoutManager(this, 2)
        photoAdapter = PhotoAdapter(emptyList())
        binding.photoRecyclerView.adapter = photoAdapter
    }


    private fun fetchPhotos() {
        lifecycleScope.launch {
            try {
                val photos = RetrofitInstance.api.getPhotos()
                Log.d("MainActivity", "Fetched Photos: $photos")
                photoAdapter.updatePhotos(photos)
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching photos: ${e.message}")
            }
        }
    }

}