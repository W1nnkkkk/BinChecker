package com.w1nkkkk.binchecker.presentation.components

import android.content.Context
import android.content.Intent
import android.net.Uri

fun startActivity(context: Context, intent: Intent) {
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}

fun dialPhoneNumber(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:$phoneNumber")) // not working(
    startActivity(context, intent)
}

fun openLocation(context: Context, latitude: Int, longitude: Int, countryName: String? = null) {
    val uri = if (countryName == null) {
        Uri.parse("geo:$latitude,$longitude")
    } else {
        Uri.parse("geo:0,0?q=$latitude,$longitude($countryName)")
    }

    val intent = Intent(Intent.ACTION_VIEW, uri)
    startActivity(context, intent)
}

fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(context, intent)
}