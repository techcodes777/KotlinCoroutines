package com.eclatsol.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

class MainActivity3 : AppCompatActivity() {

    //Job hierarchy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        GlobalScope.launch(Dispatchers.Main) {
//            execute()
            executeTwo()
            executeChildJob()
        }
    }

    private suspend fun executeChildJob(){
        val parentJob = GlobalScope.launch(Dispatchers.Main) {

            Log.e("ExecuteTwo", "Parent started")

            val childJob = launch(Dispatchers.IO) {
                try {
                    Log.e("ExecuteTwo", "Child Job Started")
                    delay(5000)
                    Log.e("ExecuteTwo", "Child Job End")
                } catch (e: CancellationException) {
                    Log.e("ExecuteTwo", "Child Job Cancelled")
                }
            }

            delay(3000)
//            Log.e("ExecuteTwo", "Child Job Cancelled")
            childJob.cancel() //Directly tame child job ne cancel kari shako shavo
            Log.e("ExecuteTwo", "Parent End")

            //ChildJob ne cancel karo atle coroutines ek exception throw kare che cancellation exception
            //Cancellation exception je che te parent job ni pase pohche che
            //Parent job check kare che te kya type ni cancellation exception che child
            //Biji exception hoi to akha coroutines ne cancel kari de che
        }

//        delay(1000)
//        parentJob.cancel() //User first mathi second activity ma gayo second mathi first activity ma avo tyare activity destroy thay gai //activity na badha coroutines cancel thay jay che
        parentJob.join()
        Log.e("ExecuteTwo", "Parent Complete")
    }

    private suspend fun executeTwo(){
        val parentJob = GlobalScope.launch(Dispatchers.Main) {

            Log.e("ExecuteTwo", "Parent started")

            val childJob = launch(Dispatchers.IO) {
                Log.e("ExecuteTwo", "Child Job Started")
                delay(5000)
                Log.e("ExecuteTwo", "Child Job End")
            }

            delay(3000)
            Log.e("ExecuteTwo", "Parent End")
        }

        delay(1000)
        parentJob.cancel() //User first mathi second activity ma gayo second mathi first activity ma avo tyare activity destroy thay gai //activity na badha coroutines cancel thay jay che
        parentJob.join()
        Log.e("ExecuteTwo", "Parent Complete")
    }

    private suspend fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) { //Parent coroutines //Parent job je che main thread ma execute thay che
            Log.e("MainActivity3", "execute: $coroutineContext")


            val childJob = launch(Dispatchers.IO) { //Child coroutines //Explicity pan define karvi shavi aa thread ne io thread per execute karvu
                //Child job che te parent job thi coroutineContext ne inherite kari le che //Child job che te IO thread ma execute thay che
                Log.e("MainActivity3", "execute: $coroutineContext")
            }

//            val childJob = launch {//Without explicit type coroutines context
//                Log.e("MainActivity3", "execute: $coroutineContext")
//            }
        }
    }
}