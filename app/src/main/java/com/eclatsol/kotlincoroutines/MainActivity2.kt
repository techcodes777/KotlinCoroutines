package com.eclatsol.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.IO).launch {
            printFollower()
//            printFollowerLaunch()
//            printFollowerAsync2()
//            printFollowerAsync1()
        }


//        GlobalScope.launch(Dispatchers.Main) {
//
//        }
//
//        MainScope().launch(Dispatchers.Default) {
//
//        }
    }

    private suspend fun printFollower() {
        CoroutineScope(Dispatchers.IO).launch {
            val fb =
                async { getFbFollowers() }  //Result expect karvi shavi //Output expect karvi shavi
            val insta = async { getInstaFollowers() }
            Log.e("CoroutinesMain", "printFollower: ${fb.await()} , ${insta.await()}")
        }
    }

    private suspend fun printFollowerAsync2() {
        var fb = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
        }

        var insta = CoroutineScope(Dispatchers.IO).async {
            getInstaFollowers()
        }

        Log.e("CoroutinesMain", "printFollowerASync: ${fb.await()},  ${insta.await()}")
    }

    private suspend fun printFollowerLaunch() {
        var fbFollowers = 0
        var instaFollower = 0
        val fb = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFbFollowers()
        }

        val insta = CoroutineScope(Dispatchers.IO).launch {
            instaFollower = getInstaFollowers()
        }
        fb.join()   //job.loin no atle use karvi shavi jya sudhi coroutines complete and execute no thay tya sudhi agal nu statement(Line) run nahi thay
        insta.join()            //Join thi apnu coroutines suspend state ma rahshe
        Log.e(
            "CoroutinesMain",
            "FB - ${fbFollowers.toString()},Insta - ${instaFollower.toString()}"
        )
    }

    private suspend fun printFollowerAsync() {
        //Data expected che tya async no use kari levo
        //Data expected nathi tya apne launch use kari leshu
        //Output, Result expect karta hoi tyare
        //Async deferred object return kare che teni typr che T //Generic type che
        val job = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
            "Hello"
        }
        //job.loin no atle use karvi shavi jya sudhi coroutines complete and execute no thay tya sudhi agal nu statement(Line) run nahi thay
        //Join thi apnu coroutines suspend state ma rahshe
        Log.e("CoroutinesMain", "printFollower: ${job.await()}")
    }

    private suspend fun getFbFollowers(): Int {
        delay(1000)
        return 54
    }

    private suspend fun getInstaFollowers(): Int {
        delay(1000)
        return 113
    }
}