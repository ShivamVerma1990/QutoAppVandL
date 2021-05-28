package com.candroid.qutoappvandl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
   private val quoteText:TextView
   get() = findViewById(R.id.quoteText)
    private val quoteAuthor:TextView
        get() = findViewById(R.id.quoteAuthor)
    lateinit var myViewModels: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    myViewModels=ViewModelProvider(this,ViewModelFactory(application)).get(MyViewModel::class.java)
setQuote(myViewModels.getQuote())


    }
fun setQuote(quotes: Quotes){
    quoteText.text=quotes.text
    quoteAuthor.text=quotes.author
}

    fun share(view: View) {

        val intent=Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
intent.putExtra(Intent.EXTRA_TEXT,myViewModels.getQuote().text)

startActivity(intent)
    }
    fun previous(view: View) {

        setQuote(myViewModels.nextQuote())
    }
    fun next(view: View) {
        setQuote(myViewModels.nextQuote())

    }

}