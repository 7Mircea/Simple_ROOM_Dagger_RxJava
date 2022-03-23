package com.example.myapplication.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.MyApplication
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.di.DaggerSingletonComponent
import com.example.myapplication.di.RoomModule
import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.persistence.AppRepository
import com.example.myapplication.persistence.Plant
import com.example.myapplication.ui.MainActivity_MembersInjector.create
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var repo: AppRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val component = (application as MyApplication).getComponent()
        component.inject(this)

        binding.addPlant.setOnClickListener() { _ ->
            repo.insertOne(
                Plant(
                    (Math.random() * 100).toString(),
                    "planta" + Math.random().toString(),
                    "ceva",
                    Math.random().toInt(),
                    3,
                    ""
                )
            )

        }

    }
}