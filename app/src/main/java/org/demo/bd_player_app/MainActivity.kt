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
            AppModel("Sakib-Al Hasan", resources.getString(R.string.player1), R.drawable.sakib),
            AppModel("Mashrafe Mortoza", resources.getString(R.string.player3), R.drawable.mashrafe),
            AppModel("Nazmul Hasan Shanto", resources.getString(R.string.player2), R.drawable.shanto),
            AppModel("Tamim Iqbal", resources.getString(R.string.player5), R.drawable.tamim),
            AppModel("Mohammad Saifuddin", resources.getString(R.string.player6), R.drawable.saifuddin),
            AppModel("Mehedi Hasan Miraz", resources.getString(R.string.player8), R.drawable.miraz),
            AppModel("Naim Sheikh", resources.getString(R.string.player9), R.drawable.naim),
            AppModel("Liton Das", resources.getString(R.string.player10), R.drawable.liton),
            AppModel("Musfiqur Rahim", resources.getString(R.string.player4), R.drawable.musfiqur),
            AppModel("Mahmudullah Riyad", resources.getString(R.string.player11), R.drawable.mahmudullah),
            AppModel("Mustafizur Rahman", resources.getString(R.string.player7), R.drawable.mustafizur)
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