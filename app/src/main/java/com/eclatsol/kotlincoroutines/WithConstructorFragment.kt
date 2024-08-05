package com.eclatsol.kotlincoroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class WithConstructorFragment(private val data : String) : Fragment() {


//    Passing data directly in a fragment constructor is generally discouraged in Android development. Here are the main reasons:
//
//    Fragment Re-Creation: Fragments can be destroyed and re-created by the Android framework during configuration changes (like screen rotations) or when the app is put in the background. If data is passed via the constructor, it might be lost during these re-creations because the system will use the default constructor to re-instantiate the fragment.
//
//    Fragment Lifecycle: Fragments have their own lifecycle which is managed by the system. Passing data via a constructor can bypass some of the lifecycle management mechanisms, leading to potential issues such as memory leaks or improper initialization.
//
//    Best Practices: The recommended approach is to use Bundle arguments to pass data to fragments. This is done using the setArguments and getArguments methods. This way, the data can be preserved and restored by the system across configuration changes.
//
//    Here's an example of how to pass data to a fragment using a Bundle:



//    In Android, FragmentTransaction provides different methods to manage fragments within an activity. Two commonly used methods are add and replace. Here are the differences between them:
//
//    add Method
//    Functionality: The add method adds a fragment to the specified container without removing any existing fragments.
//
//    Use Case: This method is useful when you want to display multiple fragments simultaneously, such as in a multi-pane layout or a master-detail layout.
//
//    Back Stack: When you add a fragment and add the transaction to the back stack, the previous fragment(s) remain in the view hierarchy and the new fragment is added on top.
//
//    Example:
//
//    java
//    Copy code
//    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//    transaction.add(R.id.fragment_container, newFragment);
//    transaction.addToBackStack(null); // Optional, adds this transaction to the back stack
//    transaction.commit();
//    replace Method
//    Functionality: The replace method removes any existing fragments in the specified container and adds the new fragment.
//
//    Use Case: This method is useful when you want to replace one fragment with another, such as when navigating between different sections of the app.
//
//    Back Stack: When you replace a fragment and add the transaction to the back stack, the current fragment is removed and replaced by the new fragment. If the transaction is later popped from the back stack, the previous fragment is re-added to the container.
//
//    Example:
//
//    java
//    Copy code
//    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//    transaction.replace(R.id.fragment_container, newFragment);
//    transaction.addToBackStack(null); // Optional, adds this transaction to the back stack
//    transaction.commit();
//    Key Differences
//    Fragment Lifecycle:
//
//    add: The added fragment goes through the onAttach, onCreate, onCreateView, onActivityCreated, and onStart lifecycle methods.
//    replace: The fragment being replaced goes through onPause, onStop, onDestroyView, and onDetach. The new fragment goes through the lifecycle methods starting from onAttach.
//    UI Overlap:
//
//    add: The new fragment is added on top of the existing fragments in the container, which may lead to UI overlap if not managed properly.
//    replace: The existing fragment is removed, and the new fragment takes its place, ensuring there is no UI overlap.
//    Back Stack Behavior:
//
//    add: When navigating back, the newly added fragment is removed, and the previous fragment(s) remain visible.
//    replace: When navigating back, the new fragment is removed, and the previous fragment (which was replaced) is re-added to the container.
//    Summary
//    Use add when you want to show multiple fragments at the same time.
//    Use replace when you want to replace one fragment with another, ensuring no overlap and a clean switch between fragments.
//    By understanding these differences, you can better manage fragment transactions in your Android application to create a more intuitive and efficient user experience.


    public constructor() : this("hello")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_w_ith_constructor, container, false)
    }

}