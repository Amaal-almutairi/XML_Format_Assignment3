package com.example.xmlformatassignment3
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)

        var students: List<Students>? = null


        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open("StudentDetails.xml")
            students=  parser.parse(istream)

            recyclerView.adapter = MyAdapter(students)
            recyclerView.layoutManager = LinearLayoutManager(this)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}