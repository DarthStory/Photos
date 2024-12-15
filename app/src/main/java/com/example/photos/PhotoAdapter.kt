package com.example.photos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photos.databinding.ItemPhotoBinding

class PhotoAdapter (private var photoList: List<Photo>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

        inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
                RecyclerView.ViewHolder(binding.root) {

                    fun bind(photo: Photo) {
                        Log.d("PhotoAdapter", "Binding photo: ${photo.imgSrc}")

                        Glide.with(binding.root.context)
                            .load(photo.imgSrc)
                            .placeholder(R.drawable.placeholder)
                            .error(R.drawable.error)
                            .into(binding.photoImageView)
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoViewHolder, position: Int) {
        Log.d("PhotoAdapter", "Binding photo at position: $position")
        holder.bind(photoList[position])
    }

    override fun getItemCount() = photoList.size

    fun updatePhotos(newPhotos: List<Photo>) {
        Log.d("PhotoAdapter", "Updating photos: ${newPhotos.size}")
        photoList = newPhotos
        notifyDataSetChanged()
    }
}