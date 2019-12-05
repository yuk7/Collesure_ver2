package com.example.collesure2.ui.pick

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.collesure2.R
import com.example.collesure2.data.ImageItem

class PickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val imageView = findViewById<ImageView>(R.id.pickUpImage)
        val item = intent.getSerializableExtra("item") as ImageItem

        val circular = CircularProgressDrawable(this)
        circular.strokeWidth = 8f
        circular.centerRadius = 80f
        circular.start()

        Glide.with(this)
            .load(item.imageUrl)
            .placeholder(circular)
            .error(Glide.with(this).load(item.thumbIUrl)
                .error(R.drawable.ic_error_red_24dp))
            .into(imageView)
    }

}
