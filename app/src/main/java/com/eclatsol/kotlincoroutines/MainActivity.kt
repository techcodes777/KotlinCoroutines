package com.eclatsol.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.eclatsol.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Log.e("MainThread", "onCreate: ${Thread.currentThread().name}")

        binding.updateCounter.setOnClickListener {
            Log.e("MainThread", "onCreate: ${Thread.currentThread().name}")
            binding.counter.text = "${binding.counter.text.toString().toInt() + 1}"
        }

        binding.doAction.setOnClickListener {
            //Button per click karishu atle navu thread create thay che ,main thread free thay jashe
//            thread(start = true){
//                executeLongRunningTask()
//            }
            CoroutineScope(Dispatchers.IO).launch {
                Log.e("CoroutinesScope", "onCreate: ${Thread.currentThread().name}")
            }

            //Jem apni pase PreDefine Dispatcher che
            //Tevij rite PreDefine Scope che particular component ni sathe jodela che

            //Ek global scope che akhi application sathe jodelu hoi che
            GlobalScope.launch(Dispatchers.Main){
                //Lambda function define karishu je coroutines ni body hashe //Je pan code execute karavo che te apne lambda function per lakhishu
                Log.e("2 CoroutinesScope", "onCreate: ${Thread.currentThread().name}")

            }

            //MainScope hoi che te activity sathe jodelu hoi che
             MainScope().launch(Dispatchers.Default) {
                 Log.e("3 CoroutinesScope", "onCreate: ${Thread.currentThread().name}")
            }
            //el async function hi che
            //Aa rite different coroutines launch thay che //different thread per execute thay che
        }


        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

       CoroutineScope(Dispatchers.Main).launch {
           task2()
       }
    }

    suspend fun task1(){
        Log.e("SUSPENFUNCTION", "Starting Task 1: ")
//        yield()  //Coroutine ni library ma apni pase built in function hoi che   //Suspension point che
        delay(1000)
        Log.e("SUSPENFUNCTION", "Ending Task 1: ")
    }

    suspend fun task2(){
        Log.e("SUSPENFUNCTION", "Starting Task 2: ", )
         yield() //normal function ma tame yield function no use karo ne to nai chale error apshe kem te suspend function nathi
        Log.e("SUSPENFUNCTION", "Ending Task 2 ", )
        delay(2000)
    }

    private fun executeLongRunningTask(){
        for(i in 1..100000000L){

        }
    }


    //long running task che tene main thread run nahi kare koi biju thread run karshe
    //coroutines pela na jetla pan task che background thread ma run thay che
    // jem ke network call thay gayu,Database valu operation che
    //Jetla pan operation hata tene apne bg thread ma execute karta hata

    //Thread pan saru solution che //Thread vali implementation ma problem che
    //Thread limited quantity ma banavi shako shavo //Kem ke te os level na thread hoi che vadhare space le che
    //ek thread almost 2 mb ne around space le che //System per depend kare che
    //Tamari system ketla thread banavi shake che //limitation thread ni asthe ave che
    //Thread ma contact switching thay che
    //Contact switching no matlab e che ke thodo code tame bg thread ma run karo shavo
    //Baki bachelo code je che tene hu main thread ma execute karvi shavi
    //Thread ni switching thay ,Contact nu switch thay che te muskel hoi che thread na case ma


    //What's the solution in Java - No Solution
    //What's the solution in Kotlin? Coroutines
    //Coroutines are just like thread (lightweight threads) but no thread

    //Coroutines thread ni jem kam kare che pan te thread nathi tene lightweight thread kahvay che
    //Coroutines thread na behaviour ne memic kare che //Thread ni jem behave karvani try kare che pan te thread nathi
    //Coroutines thread ni uper kam che //threa per framwork lakhi dithi
    //framework ni sathe interact karvi shavi
    //framework behind the seen thread ni sathe interact kare che

    //Coroutines ni framework khali kotlin e provide karavi hati
    //Coroutines ni framework java e provide karavi nathi

    //Coroutines programmer j banavela che
    //Coroutines behind the seen thread no use kare che

    //Directly thread no use nahi karishu
    //Coroutines no use karishu

    //Coroutines define karva mete
    //Coroutines Scope - LifeTime
    //Coroutines Context

    //Simillary coroutines scope je che coroutines ni lifetime ne define kare che
    //Scope je che coroutines ni lifetime ne define kare che //coroutines ni ketli lifetime hashe te batave che

    //Coroutines Context batave che kaya thread per coroutines execute thya che

    //Jetla pan coroutines scope launch thay che te particular scope mate

    //Coroutines context batave che tamaru coroutines kaya thread launch thay che

    //Scope basically boundary define kare che //Boundary ni andar coroutines launch thay che
    //Different coroutines che particular scope ni andar launch thay che

    //Android Application ma different component hoi che jem ke activity component,fragment component, view model component
    //Badha component ni lifetime che

    //ek activity thi biji activity ma apne javi tyare first activity destroy thay jay che

    //Activity ni life cycle che
    //Fragment ni life cycle che
    //View model ni life cycle che

    //Jeva componet destroy thay jay atle coroutines pan cancel thay jay

    //Scope ne apne component ni sathe jodi deshu
    //Jevi activity destroy thashe atle coroutines scope ma jetla scope che te cancel thay jashe
    //automatically handle thay jay che

    //scope basically lifetime define kare che base on component

    //Coroutines ek tariko provide karave che //Boundary ma jetla coroutines che tene cancel kari shakvi shavi
    // Ka to wait kari shakvi complete thay tya sudhi

    //Jetla coroutines hashe te particular scope ma start thashe jethi life time define kari shakvi

    //Coroutines context che te information provide karave che kaya thread per coroutines execute thay che

    //Dispatcher
    //Coroutines run on top of threads
    //Dispatchers is a way to define thread on which Coroutines are executed
    //Coroutines ne dispatch karvi shavi thread per

    //Predefined Dispatchers -
    //Dispatchers.IO
    //Dispatchers.Main
    //Dispatchers.Default

    // Predefined Dispatchers che je thread pool define kare che
    //Io operation karva mate apni pase Dispatchers.IO che
    //Main thread per coroutines ne launch karvu che to Dispatchers.Main che

    //Dispatchers basically apnu thread pool che aa set of thread che ahiya coroutines ne execute karvana che


    //Dispatchers kam kare che coroutines ne dispatche kare che thread per

    //Dispatchers karvi shavi coroutines ne jethi thread per execute kari shakay

    //Dispatcher no use kari apne context define karvi shavi
}