package com.trainingtrack.volleypractice

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val que = Volley.newRequestQueue(this)
    val url = "https://jsonplaceholder.typicode.com/todos/1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainText.setOnClickListener {
            val jsonObjectRequest: JsonObjectRequest = JsonObjectRequest(
                    Request.Method.GET, url, null,
                    Response.Listener { response ->
                        mainText.text = "Response: %s".format(response.toString())
                    },
                    Response.ErrorListener { error ->
                        mainText.text = "Error: %s".format(error.toString())
                    }
            )
            que.add(jsonObjectRequest)
        }


    }



}
