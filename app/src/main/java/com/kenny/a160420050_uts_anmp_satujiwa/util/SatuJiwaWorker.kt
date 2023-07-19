package com.kenny.a160420050_uts_anmp_satujiwa.util

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class SatuJiwaWorker(val context: Context, val params: WorkerParameters): Worker(context, params) {
    override fun doWork(): Result {
        NotificationHelper(context).createNotification(inputData.getString("title").toString(), inputData.getString("message").toString())

        return Result.success()
    }
}