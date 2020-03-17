package com.trainingtrack.volleypractice

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainText.setOnClickListener {
            val que: RequestQueue? = Volley.newRequestQueue(this)
            val url: String = "https://jsonplaceholder.typicode.com/todos"
            val jsonArrayRequest: JsonArrayRequest = JsonArrayRequest(
                    Request.Method.GET, url, null,
                    Response.Listener { response ->
                        Log.d("JSON", "onResponse: $response")
                        mainText.text = "Response: %s".format(response.toString())
                    },
                    Response.ErrorListener { error ->
                        Log.d("Error", "errorMesage: ${error.message}")
                        mainText.text = "Error: %s".format(error.toString())
                    }
            )
            que?.add(jsonArrayRequest)
        }


    }



}
