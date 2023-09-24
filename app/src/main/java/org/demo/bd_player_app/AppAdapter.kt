package org.demo.bd_player_app

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AppAdapter(private val appList:List<AppModel>, private val clickListener: (AppModel)->Unit):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val appItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(appItem)

    }

    override fun getItemCount(): Int {
        return appList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val app = appList[position]
        holder.bind(app,clickListener)

    }
}

class MyViewHolder (val view:View):RecyclerView.ViewHolder(view){
    fun bind(app:AppModel, clickListener: (AppModel) -> Unit){
        val name = view.findViewById<TextView>(R.id.name1)
        val position = view.findViewById<TextView>(R.id.position1)
        val img = view.findViewById<CircleImageView>(R.id.img1)

        name.text = app.name
        position.text = app.position.toString()
        img.setImageResource(app.img)

        view.setOnClickListener {
            clickListener(app)
        }
    }

}
