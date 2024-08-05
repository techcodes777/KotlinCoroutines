package com.eclatsol.kotlincoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModelActivity : AppCompatActivity() {
    //Simple concept che coroutines launch karvi shavi te particular scope ni andar launch karvi shavi

//    The main difference between val and const val is that val can be assigned a value at runtime, whereas const val must be assigned a value at compile time and cannot be changed afterward(their values are hardcoded).
//const val baseUrl  = "https://rickandmortyapi.com/api"
//val db = FirebaseDatabase.getInstance()

//    what is difference between normal class and dataclass in kotlin
//    what is difference between const val and normal val in kotlin


    lateinit var mainVewModel: MainVewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        mainVewModel = ViewModelProvider(this)[MainVewModel::class.java]

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,WithConstructorFragment("Hello")).commit()

//        lifecycleScope.launch {
//            delay(2000)
//            startActivity(Intent(this@ViewModelActivity, AnotherActivity::class.java))
//            finish()
//        }
        //Coroutine je potani rite cancel thay jay che automatically cancel thay jay che cancel karvani jarur rahti nathi



    }
}