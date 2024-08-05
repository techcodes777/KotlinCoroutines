package com.eclatsol.kotlincoroutines.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.eclatsol.kotlincoroutines.R

class HomeActivity : AppCompatActivity() , DataTransferCommunicator{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        replaceFragment(FirstFragment())
    }

    private fun replaceFragment(firstFragment: FirstFragment) {
        supportFragmentManager.beginTransaction().replace(R.id.homeContainer,firstFragment).commit()
    }

    override fun sendData(data: String) {
        val bundle = Bundle()
        bundle.putString("inputText",data)

        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        secondReplaceFragment(secondFragment)
    }

    private fun secondReplaceFragment(secondFragment: SecondFragment) {
        supportFragmentManager.beginTransaction().replace(R.id.homeContainer,secondFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit()
    }
}