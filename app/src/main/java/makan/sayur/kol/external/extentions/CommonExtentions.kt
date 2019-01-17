package makan.sayur.kol.external.extentions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Yoga C. Pranata on 17/01/2019.
 * Android Engineer
 */
infix fun ViewGroup.inflate(layoutResId: Int): View =
    LayoutInflater.from(context).inflate(layoutResId, this, false)