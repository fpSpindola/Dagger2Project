package com.filipe.dagger2project.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.filipe.dagger2project.MainActivity
import com.filipe.dagger2project.R
import com.filipe.dagger2project.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_random_user.view.*


class RandomUserAdapter(private val resultList: List<Result>? = null,
                        private val mainActivity: MainActivity?,
                        private var picasso: Picasso? = null): RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_random_user, parent, false)
        return RandomUserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList!!.size
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val result = resultList!![position]
        holder.RandomUserViewHolder(result)
        holder.name?.setText(String.format("%s %s", result.name.first, result.name.last))
        Picasso.with(holder.image?.context)
                .load(result.picture.large)
                .into(holder.image)
    }

    class RandomUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var image: ImageView? = null

        fun RandomUserViewHolder(result: Result) {
            name = itemView.name
            image = itemView.image
        }
    }
}