package app.superesenou.ru.webrand.main.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.superesenou.ru.webrand.R
import app.superesenou.ru.webrand.main.model.WebrandContact
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_selectionmain.view.*
import android.R.attr.src
import android.support.design.R.attr.cornerRadius
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawable
import app.superesenou.ru.webrand.ui.main.MainActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_description.*


class WebrandAdapter(private var list: MutableList<WebrandContact>, val listener: Listener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_selectionmain,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return   list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WebrandAdapter.ViewHolder).bind(list.get(position))
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(position: WebrandContact){

            itemView.web_name.text=position.web_name
            itemView.web_price.text=position.web_price
            Picasso.get().load("http://webrand.kg/admin/image/webimg/"+position.web_img).into(itemView.web_img)

            itemView.tag = position
            itemView.setOnClickListener { v ->
                val position = v.tag as WebrandContact
                listener.setOnItemClick(position)
            }

        }
    }

    interface Listener{
        fun setOnItemClick(position: WebrandContact)

    }
}