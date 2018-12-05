package com.wordpress.liliangmader.myfragment

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast
import com.wordpress.liliangmader.myfragment.Fragments.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BlankFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(info: String) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "click activity $info", Toast.LENGTH_SHORT).show()
        //goes to second fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, SecondFragment(), secondFragmentTag)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(secondFragment.toString())
            .commit()


    }

    var btnNext: Button? =null
    lateinit var blankFragment: BlankFragment
    lateinit var secondFragment: SecondFragment
    lateinit var thirdFragment: ThirdFragment

    val blankFragmentTag = "Blank"
    val secondFragmentTag = "Second"
    val thirdFragmentTag = "Third"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        blankFragment = BlankFragment.newInstance("par1", "par2")
        secondFragment = SecondFragment.newInstance()
        thirdFragment = ThirdFragment.newInstance()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, blankFragment, "Blank").commit()
        }


        btnNext = findViewById(R.id.btn_next)
        btnNext?.setOnClickListener {
            var currentFragmentTag: String =getCurrentFragment().tag.toString()
           Toast.makeText(this, getCurrentFragment().toString(), Toast.LENGTH_SHORT).show()
            //  Toast.makeText(this, "current fragment =$currentFragmentTag", Toast.LENGTH_SHORT).show()
            displayNextFragment(currentFragmentTag)

        }

    }

    fun getCurrentFragment(): Fragment {
       val currentFragment:Fragment = getSupportFragmentManager()
            .findFragmentById(R.id.fragment)
        return currentFragment
    }

    private fun displayNextFragment(tag: String){
        when (tag) {
            "Blank" -> {
                //goes to second fragment
                 supportFragmentManager
                     .beginTransaction()
                     .replace(R.id.fragment, SecondFragment(), secondFragmentTag)
                     .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                     .addToBackStack(secondFragment.toString())
                     .commit()
            }
            "Second" -> {
                //goes to second fragment
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, ThirdFragment(),thirdFragmentTag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(thirdFragment.toString())
                    .commit()
            }
            "Third" ->{
                //goes to second fragment
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, BlankFragment(), blankFragmentTag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(blankFragment.toString())
                    .commit()
            }
        }

    }

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
                    .replace(R.id.fragment, blankFragment, blankFragmentTag)
                    .addToBackStack(blankFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return true
            }
            R.id.action_second -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, secondFragment, "Second")
                    .addToBackStack(secondFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return true
            }
            R.id.action_third -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, thirdFragment, "Third")
                    .addToBackStack(thirdFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
