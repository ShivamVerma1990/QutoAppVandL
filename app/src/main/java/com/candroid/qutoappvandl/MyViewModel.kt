package com.candroid.qutoappvandl

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.charset.Charset

class MyViewModel(val context: Context): ViewModel() {
    private var quoteList: Array<Quotes> = emptyArray()
    private var index=0
    init{
            quoteList=launchData()

        }

    fun getQuote()=quoteList[index]
    fun nextQuote()=quoteList[++index]
    fun previous()=quoteList[--index]


    private fun launchData(): Array<Quotes> {
val inputStream=context.assets.open("quotes.json")
        val size=inputStream.available()
val buffer=ByteArray(size)
inputStream.read(buffer)
inputStream.close()
val json= String(buffer,Charsets.UTF_8)
        val gson = Gson()
  return      gson.fromJson(json,Array<Quotes>::class.java)
    }


}