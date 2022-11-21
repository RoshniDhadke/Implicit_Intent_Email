package com.example.intent_email

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
     lateinit var send :EditText
    lateinit var subject :EditText
    lateinit var body :EditText
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send=findViewById(R.id.send)
        subject=findViewById(R.id.subject)
        body=findViewById(R.id.body)
        btn=findViewById(R.id.btn)

        btn.setOnClickListener {
             val a=send.text.toString().trim()
            val b=subject.text.toString().trim()
            val c=body.text.toString().trim()

            val intent=Intent(Intent.ACTION_SEND)
            intent.data= Uri.parse("Mail to ")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(a))
            intent.putExtra(Intent.EXTRA_SUBJECT,b)
            intent.putExtra(Intent.EXTRA_TEXT,c)
            intent.type="message/rfc822"
            startActivity(Intent.createChooser(intent,"Choose an Email client :"))
        }
    }
}