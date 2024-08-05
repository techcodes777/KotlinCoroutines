package com.eclatsol.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity5 : AppCompatActivity() {

    //With Context
    //Run Blocking
    //Example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        GlobalScope.launch {
            executeWithContextTask()
//            executeTask()
        }
    }

    private suspend fun executeWithContextTask() {  //Sequence ma code execute thay che //Coroutines block thay che thread block thatu nathi
        //Suspend function che atle apnu coroutines suspend thay jashe
        Log.e("MainActivity5", "Before")
        withContext(Dispatchers.IO) {  //launch coroutines builder je che non blocking nature nu hoi che
            delay(1000)
            Log.e("MainActivity5", "Inside") //Inside vali line ek second pasi ave che
        }
        Log.e("MainActivity5", "After")
    }
    //Output : Before
    //         After
    //         Inside

    private suspend fun executeTask() {
        Log.e("MainActivity5", "Before")
        GlobalScope.launch {  //launch coroutines builder je che non blocking nature nu hoi che
            delay(1000)
            Log.e("MainActivity5", "Inside") //Inside vali line ek second pasi ave che
        }
        Log.e("MainActivity5", "After")
    }
    //Output : Before
    //         Inside
    //         After
}