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
            OnboardData("푸시알림으로\n많은 사람에게 나의 말을\n전해보세요", R.drawable.onboardimg),
            OnboardData("친구를 초대하고\n같은 관심사를 가진\n그룹을 만들어요", R.drawable.onboardimg),
            OnboardData("이모지를 남기고\n푸시알림에\n생각을 표현해보세요", R.drawable.onboardimg),
            OnboardData("이모지를 남기고\n푸시알림에\n생각을 표현해보세요", R.drawable.onboardimg),
            OnboardData("이모지를 남기고\n푸시알림에\n생각을 표현해보세요", R.drawable.onboardimg),
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