package com.codebaron.netflixclone.utilities

import android.content.Context
import android.net.ConnectivityManager
import java.util.*

fun isNetworkAvailable(context: Context): Boolean {
    val connectMgr: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectMgr.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

fun subString(value: String): String {
    val startIndex = 6
    val endIndex = 15
    return value.subSequence(startIndex, endIndex).toString()
}

fun getHeaderMap(): Map<String, String> {
    val headerMap = mutableMapOf<String, String>()
    headerMap[RequestHeaderKeys.HEADER_1.type] = RequestHeaderKeys.HEADER_1.key
    headerMap[RequestHeaderKeys.HEADER_2.type] = RequestHeaderKeys.HEADER_2.key
    return headerMap
}

fun getYearMonth(date: Date): Int {
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.MONTH)
}

fun getCurrentMonthNumber(): Int {
    val cal = Calendar.getInstance()
    /*val year = cal[Calendar.YEAR]
    val dow = cal[Calendar.DAY_OF_WEEK]
    val dom = cal[Calendar.DAY_OF_MONTH]
    val doy = cal[Calendar.DAY_OF_YEAR]*/
    return cal[Calendar.MONTH] + 1
}

fun getCurrentDayNumber(): Int {
    val cal = Calendar.getInstance()
    return cal[Calendar.DATE]
}
