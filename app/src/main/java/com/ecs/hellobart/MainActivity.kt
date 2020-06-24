package com.ecs.hellobart

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: TrainCountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.trainCount.observe(this, Observer {
            Toast.makeText(this, "There are ${it.data.trainCount} trains right now :]", Toast.LENGTH_LONG).show()
        })
    }


}