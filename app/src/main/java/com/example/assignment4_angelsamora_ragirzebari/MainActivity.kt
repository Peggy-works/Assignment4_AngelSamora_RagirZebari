package com.example.assignment4_angelsamora_ragirzebari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment4_angelsamora_ragirzebari.API.APIInterface
import com.example.assignment4_angelsamora_ragirzebari.RecyclerView.RVAdapter
import com.example.assignment4_angelsamora_ragirzebari.fragments.ApiFragment
import com.example.assignment4_angelsamora_ragirzebari.fragments.DisplayFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(APIInterface::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creating fragment instances
        val APIFragment = ApiFragment()
        val DisplayFragment = DisplayFragment()

        changeFragment(DisplayFragment)

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.ic_api -> {
                    changeFragment(APIFragment)
                    true
                }
                R.id.ic_display -> {
                    changeFragment(DisplayFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fContainer, fragment)
            commit()
        }
    }

}