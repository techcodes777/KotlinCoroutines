package com.eclatsol.kotlincoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =   runBlocking {//Run blocking mari mate coroutines scope banave che
    launch { //Runblocking kam kare che jya sudhi coroutines complete nai thay jay tya sudhi thread ne block kari de che
        delay(1000)
        println("World")
    }
}

//    GlobalScope.launch {
//        delay(1000)
//        println("World")
//    }
//    println("Hello")
//    Thread.sleep(2000) //Manually block karu che thread ne 2000 mili scond mate
    //Coroutines time le che tya sudhi tame application ne roki rakhje

class RunBlocking {
}