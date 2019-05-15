package com.example.whatmoviesnow.scenes.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.whatmoviesnow.R
import com.example.whatmoviesnow.data.Constants
import com.example.whatmoviesnow.scenes.Scenes
import com.example.whatmoviesnow.scenes.actionList.ActionListFragment
import com.example.whatmoviesnow.scenes.dramaList.DramaListFragment
import com.example.whatmoviesnow.scenes.fantasyList.FantasyListFragment
import com.example.whatmoviesnow.scenes.fictionList.FictionListFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager, val view: Scenes.View) : FragmentPagerAdapter(fm) {

    private val actionListFragment by lazy { ActionListFragment.newInstance(Constants.actionId) }
    private val dramaListFragment by lazy { DramaListFragment.newInstance(Constants.dramaId) }
    private val fantasyListFragment by lazy { FantasyListFragment.newInstance(Constants.fantasyId) }
    private val fictionListFragment by lazy { FictionListFragment.newInstance(Constants.fictionId) }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> actionListFragment
            1 -> dramaListFragment
            2 -> fantasyListFragment
            3 -> fictionListFragment
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> view.getViewContext()?.getString(R.string.tab_action)
            1 -> view.getViewContext()?.getString(R.string.tab_drama)
            2 -> view.getViewContext()?.getString(R.string.tab_fantasy)
            3 -> view.getViewContext()?.getString(R.string.tab_fiction)
            else -> null
        }
    }
}