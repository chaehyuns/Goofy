package com.groom3.goofy.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.groom3.goofy.R
import com.groom3.goofy.databinding.ActivityPaddlingBinding
import com.groom3.goofy.databinding.FragmentMapBinding

class PaddlingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaddlingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_paddling)
    }
}