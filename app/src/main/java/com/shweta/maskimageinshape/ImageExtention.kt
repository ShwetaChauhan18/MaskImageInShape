package com.shweta.maskimageinshape

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.widget.ImageView

fun ImageView.getMaskBitmap(imageUrl: String? = null, mContent: Int, mMaskedImage : Int) {
    runOnBackground {
        // if you have https image url then use below line
        //val original: Bitmap = BitmapFactory.decodeStream(URL(imageUrl).openConnection().getInputStream())

        // if you have png or jpg image then use below line
        val original: Bitmap = BitmapFactory.decodeResource(resources, mContent)

        val mask = BitmapFactory.decodeResource(resources, mMaskedImage) // mMaskedImage Your masking image
        val result: Bitmap = Bitmap.createBitmap(mask.width, mask.height, Bitmap.Config.ARGB_8888, true)
        val tempCanvas = Canvas(result)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        tempCanvas.apply {
            drawBitmap(original, 0f, 0f, null)
            drawBitmap(mask, 0f, 0f, paint)
        }
        paint.xfermode = null

        //Draw result after performing masking
        runOnBackground(onMainThread = {
            this.apply {
                setImageBitmap(result)
                scaleType = ImageView.ScaleType.FIT_CENTER
            }
        })
    }
}