package org.demo.bd_player_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.demo.bd_player_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bdApp.layoutManager = LinearLayoutManager(this)
        val appList = listOf<AppModel>(
            AppModel("Sakib-Al Hasan", resources.getString(R.string.player1), R.drawable.sakib)
        )

        binding.bdApp.adapter = AppAdapter(appList,){
            selectItem: AppModel -> listItemClicked(selectItem)
        }
    }
    private fun listItemClicked(app:AppModel){
        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        intent.putExtra("name", app.name)
        intent.putExtra("position", app.position)
        intent.putExtra("img", app.img)
        startActivity(intent)
    }
}