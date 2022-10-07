package ir.golriz.amirhosein.cryptoapp.utils

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler

val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->

    Log.e("Coroutine Exception", "Error -> " + throwable.message)

}