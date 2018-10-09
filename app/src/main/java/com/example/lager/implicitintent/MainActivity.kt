package com.example.lager.implicitintent

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_button.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("lagerbof@hotmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Implicit intent test")
            intent.putExtra(Intent.EXTRA_TEXT, "Hello\nI send this mail to talk about " +
                    "something.\n Except I have forgotten.\n Bye and have a nice day")
            if (intent.resolveActivity(packageManager)!= null) {
                startActivity(intent)
            }
        }

    }
}
