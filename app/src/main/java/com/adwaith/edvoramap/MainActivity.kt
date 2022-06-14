package com.adwaith.edvoramap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
//import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        layoutManager = LinearLayoutManager(this)
        rvPlaces.layoutManager = layoutManager

        run("https://assessment.api.vweb.app/rides")



    }

    private fun run(url: String) {
        val request = Request.Builder().get()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {

                val gson = GsonBuilder().create()

                val body = response.body()?.string()

               val adlist = gson.fromJson(body, Array<MapCard>::class.java).toList()

                runOnUiThread {
                    adapter = RecycleViewAdapter(adlist)

                    rvPlaces.adapter = adapter

                    println(body)
                }


            }
        })
    }
}