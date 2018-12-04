package com.wordpress.liliangmader.myfragment

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast
import com.wordpress.liliangmader.myfragment.Fragments.*


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener, SecondFragment.OnFragmentInteractionListener,
ThirdFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var blankFragment: BlankFragment
    lateinit var secondFragment: SecondFragment
    lateinit var thirdFragment: ThirdFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, BlankFragment.newInstance("par1", "par2"), "Blank").commit()
        }

        blankFragment = BlankFragment.newInstance("par1", "par2")
        secondFragment = SecondFragment.newInstance()
        thirdFragment = ThirdFragment.newInstance()


        fab.setOnClickListener { view ->
            if (savedInstanceState == null) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, SecondFragment(), "Second")
                    .commit()
            }
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            Toast.makeText(this, "click3", Toast.LENGTH_SHORT).show()
            if (savedInstanceState == null) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, ThirdFragment(), "Third")
                    .commit()
            }

        }

    }
/**
        val btn2 = findViewById<View>(R.id.btn_goto2) as Button

        btn2.setOnClickListener {
        if (savedInstanceState == null) {
        supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragment, SecondFragment(), "Second")
        .commit()
        }
        }


    fun goto3(view: View) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, ThirdFragment(), "Third")
                .commit()

            **/


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_blank -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, blankFragment)
                    .addToBackStack(blankFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return true
            }
            R.id.action_second -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, secondFragment)
                    .addToBackStack(secondFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return true
            }
            R.id.action_third -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, thirdFragment)
                    .addToBackStack(thirdFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
