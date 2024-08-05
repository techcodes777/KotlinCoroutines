package com.eclatsol.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        CoroutineScope(Dispatchers.Main).launch {
            execute()
        }



    }

    private suspend fun execute(){
        var parentJob = CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..1000){
                if (isActive){ //Cancel check lagavelo che //Coroutines active hoi tyare j executeLongRunningTask run thay che
                     //Cancellable banavano matlab e che ke active state and cancel state check karvi padshe
                    executeLongRunningTask()
                    Log.e("MainActivity4", i.toString())
                }

            }
        }

        delay(100)
        Log.e("MainActivity4", "Cancelling Job")
        parentJob.cancel()
        parentJob.join()
        Log.e("MainActivity4", "Parent Completed")

        //Ahiya atyare thay che evu ke coroutines ne cancel karu to te cancel state ma pohchi gayu
        //Apdu je thread che haji busy che long running task ne execute karva ma

        //Thread ne khbar nathi coroutines cancel thay gayu che apne ahiya check lagavu padshe
        //Jetla pan apna coroutines che tene cancellable banava che
    }

    private fun executeLongRunningTask(){
        for (i in 1..10000000){

        }
    }
}