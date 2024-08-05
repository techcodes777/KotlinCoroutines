package com.eclatsol.kotlincoroutines.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eclatsol.kotlincoroutines.R
import com.eclatsol.kotlincoroutines.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    lateinit var binding : FragmentFirstBinding
    lateinit var dataTransferCommunicator: DataTransferCommunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataTransferCommunicator = requireActivity() as DataTransferCommunicator
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSendData.setOnClickListener {
            dataTransferCommunicator.sendData(binding.etUserInput.text.toString().trim())
        }
    }

}