package com.filipe.dagger2project.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.filipe.dagger2project.R
import com.filipe.dagger2project.model.Result
import com.squareup.picasso.Picasso


class RandomUserAdapter: RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder>() {

    var resultList: List<Result> = ArrayList()

    fun RandomUserAdapter() {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_random_user, parent, false)
        return RandomUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val result = resultList.get(position)
        holder.textView.setText(String.format("%s %s", result.name.first, result.name.last))
        Picasso.with(holder.imageView.context)
                .load(result.picture.large)
                .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    fun setItems(results: List<Result>) {
        resultList = results
        notifyDataSetChanged()
    }

    inner class RandomUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var textView: TextView
        lateinit var imageView: ImageView

        fun RandomUserViewHolder(itemView: View) {
            textView = itemView.findViewById(R.id.name)
            imageView = itemView.findViewById<View>(R.id.image) as ImageView
        }
    }
}