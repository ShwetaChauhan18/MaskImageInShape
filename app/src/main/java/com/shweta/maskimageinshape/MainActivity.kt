package com.shweta.maskimageinshape

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        maskImage()
    }

    private fun maskImage() {
        maskedImageView.getMaskBitmap(mContent = R.drawable.hqdefault, mMaskedImage = R.drawable.mask_profile)
        maskedImageView2.getMaskBitmap(mContent = R.drawable.nature_2, mMaskedImage = R.drawable.mask_image_2)
    }
}