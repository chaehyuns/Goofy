package com.groom3.goofy.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.groom3.goofy.R
import com.groom3.goofy.databinding.FragmentLv1Binding
import com.groom3.goofy.databinding.FragmentMapBinding


class lv1Fragment : Fragment() {
    private lateinit var binding: FragmentLv1Binding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, com.groom3.goofy.R.layout.fragment_lv1,container,false)
        binding.stanceButton.setOnClickListener{
            val intent = Intent(activity, PaddlingActivity::class.java)
                startActivity(intent)
        }
        binding.paddlingButton.setOnClickListener{
            val intent = Intent(activity, PaddlingActivity::class.java)
            startActivity(intent)
        }
        binding.popupButton.setOnClickListener{
            val intent = Intent(activity, PaddlingActivity::class.java)
            startActivity(intent)
        }
        binding.takeoffButton.setOnClickListener{
            val intent = Intent(activity, PaddlingActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

}