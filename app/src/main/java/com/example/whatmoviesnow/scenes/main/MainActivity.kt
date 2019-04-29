package com.example.whatmoviesnow.scenes.main

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.widget.Toast
import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.scenes.Scenes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Scenes.View {

    private var sectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, this)

        container.adapter = sectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
//colocar o search
    }

    override fun getViewContext(): Context? {
        return this
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
