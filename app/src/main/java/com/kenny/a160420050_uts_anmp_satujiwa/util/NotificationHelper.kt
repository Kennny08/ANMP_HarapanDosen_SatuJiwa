package com.kenny.a160420050_uts_anmp_satujiwa.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.view.MainActivity

class NotificationHelper(val context: Context) {
    private val CHANNEL_ID = "todo_channel_id"
    private val CHANNEL_NAME = "todo_channel_name"
    private val NOTIFICATION_ID = 1

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = "Todo channel description"

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun createNotification(title:String, message:String){
        createNotificationChannel()
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val icon = BitmapFactory.decodeResource(context.resources, R.drawable.logosatujiwa)

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.logosatujiwa)
            .setLargeIcon(icon)
            .setContentTitle(title)
            .setContentText(message)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(icon).bigLargeIcon(null))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
    }
}