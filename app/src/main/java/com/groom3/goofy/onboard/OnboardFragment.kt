package com.groom3.goofy.onboard

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.groom3.goofy.R
import com.groom3.goofy.databinding.FragmentOnboardBinding
import com.groom3.goofy.db.UserDatabase
import com.groom3.goofy.db.UserRepository
import com.groom3.goofy.db.UserViewModel
import com.groom3.goofy.db.UserViewModelFactory
import com.groom3.goofy.home.HomeActivity


class OnboardFragment : Fragment() {
    private lateinit var binding : FragmentOnboardBinding
    private val onboardAdapter = OnboardAdapter(
        listOf(
            OnboardData("하나의 파도엔 한 사람만!\n" +
                    "가장 기본이 되는 서핑 룰이에요", R.drawable.onboard_img1),
            OnboardData("파도가 좋을수록 암초가 많아요!\n" +
                    "처음 가는 해변에서는 조심합시다", R.drawable.onboard_img2),
            OnboardData("위험한 해양생물도 있어요!\n"+
                    "출물지역과 시기를 확인해둡시다", R.drawable.onboard_img3),
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        val dao = UserDatabase.getInstance(requireContext()).userDAO
        val repository= UserRepository(dao)
        val factory = UserViewModelFactory(repository)
        val userViewModel = ViewModelProvider(this,factory).get(UserViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboard,container,false)
        val pref: SharedPreferences? = this.activity?.getSharedPreferences("isFirst", MODE_PRIVATE)
        val first = pref!!.getBoolean("isFirst", false)
        if (first == false) {
            Log.d("Is first Time?", "first")
            val editor = pref.edit()
            editor.putBoolean("isFirst", true)
            editor.commit()
            //앱 최초 실행시 하고 싶은 작업
        } else {
//            findNavController()?.navigate((R.id.action_onboardFragment_to_homeActivity))
//            Log.d("Is first Time?", "not first")

            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)

        }


        binding.introViewpager.adapter = onboardAdapter
        binding.springDotsIndicator.attachTo(binding.introViewpager)
        binding.startText.setOnClickListener{
            it.findNavController().navigate(R.id.action_onboardFragment_to_registerFragment)
//            activity?.let{
//                val intent = Intent(activity, HomeActivity::class.java)
//                startActivity(intent)
//            }
        }
        return binding.root

    }
}