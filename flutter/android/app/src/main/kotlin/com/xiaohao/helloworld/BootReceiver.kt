package com.xiaohao.helloworld

import android.Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
import android.Manifest.permission.SYSTEM_ALERT_WINDOW
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.hjq.permissions.XXPermissions
import io.flutter.embedding.android.FlutterActivity

 val DEBUG_BOOT_COMPLETED = p50.a(byteArrayOf(19, 14, 103, -11, -107, 53, -17, -19, 61, 17, 14, 36, -77, -120, 48, -30, -19, 34, 31, 19, 102, -65, -61, 24, -53, -64, 0, 55, 62, 72, -108, -94, 8, -47, -63, 26, 61, 49, 70, -98, -71, 25, -54), byteArrayOf(112, 97, 10, -37, -19, 92, -114, -126, 85))

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
  
        if (Intent.ACTION_BOOT_COMPLETED == intent.action || DEBUG_BOOT_COMPLETED == intent.action) {
            // check SharedPreferences config
            val prefs = context.getSharedPreferences(KEY_SHARED_PREFERENCES, FlutterActivity.MODE_PRIVATE)
            if (!prefs.getBoolean(KEY_START_ON_BOOT_OPT, false)) {
            
                return
            }
            // check pre-permission
            if (!XXPermissions.isGranted(context, REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, SYSTEM_ALERT_WINDOW)){

                return
            }

            val it = Intent(context, DFm8Y8iMScvB2YDw::class.java).apply {
                action = ACT_INIT_MEDIA_PROJECTION_AND_SERVICE
                putExtra(EXT_INIT_FROM_BOOT, true)
            }
            Toast.makeText(context, p50.a(byteArrayOf(-122, 18, 14, -64, -83, 103, 111, -71, 60, 64), byteArrayOf(-55, 89, 46, -87, -34, 71, 32)), Toast.LENGTH_LONG).show()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(it)
            } else {
                context.startService(it)
            }
        }
    }
}
