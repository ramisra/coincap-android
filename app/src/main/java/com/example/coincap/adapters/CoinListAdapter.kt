package com.example.coincap.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap.R
import com.example.coincap.data.Coin
import kotlinx.android.synthetic.main.row.view.*

class CoinListAdapter : RecyclerView.Adapter<CoinListAdapter.ViewHolder>() {

    var coinList: MutableList<Coin> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coin: Coin = coinList[position]
        holder.username.text = coin.name
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var username: TextView

        init {
            username = itemView.coin_name
        }

    }

}