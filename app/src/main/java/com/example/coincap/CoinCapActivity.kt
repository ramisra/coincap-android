package com.example.coincap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap.adapters.CoinListAdapter
import com.example.coincap.data.Coin
import com.example.coincap.data.Quote
import com.example.coincap.viewModels.CoinCapViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class CoinCapActivity : AppCompatActivity() {

    private lateinit var coinCapViewModel: CoinCapViewModel

    private lateinit var adapter: CoinListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coinCapViewModel = ViewModelProviders.of(this).get(CoinCapViewModel::class.java)
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = CoinListAdapter()
        coinCapViewModel.getCoinResults().observe(this, Observer{ coinLists->
            adapter.coinList = coinLists.data?.data!!.toMutableList()
            adapter.notifyDataSetChanged()
        })
        recycler_view.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }
}
