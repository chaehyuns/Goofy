package com.groom3.goofy.onboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.groom3.goofy.R
import com.groom3.goofy.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    private lateinit var kakaoAuthViewModel: KakaoAuthViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register,container,false)
        kakaoAuthViewModel = ViewModelProvider(this).get(KakaoAuthViewModel::class.java)
        binding.kakaoRegisterViewModel = kakaoAuthViewModel
        binding.kakaoRegisterButton.setOnClickListener{
            kakaoAuthViewModel.handleKakaoLogin()
        }

        kakaoAuthViewModel.accessToken.observe(viewLifecycleOwner) {
            Log.d("MYTAG", "token is ${it}")

        }
        return binding.root

    }
}