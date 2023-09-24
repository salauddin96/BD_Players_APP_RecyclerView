package org.demo.bd_player_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.demo.bd_player_app.databinding.ActivityHomeBinding
import org.demo.bd_player_app.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.title1.text = intent.getStringExtra("name")
        binding.detail1.text = intent.getStringExtra("position")
        binding.img1.setImageResource(intent.getIntExtra("img", 0))
    }
}