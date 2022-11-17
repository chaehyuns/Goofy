package com.groom3.goofy.home
import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.groom3.goofy.api.GradeService
import com.groom3.goofy.api.RetrofitInstance
import com.groom3.goofy.databinding.FragmentMapBinding
import com.groom3.goofy.model.Grade
import retrofit2.Response


class MapFragment : Fragment() {
    private lateinit var binding: FragmentMapBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, com.groom3.goofy.R.layout.fragment_map,container,false)

        val retService = RetrofitInstance
            .getRetrofitInstance()
            .create(GradeService::class.java)

        fun liveDataOberserver(responseLiveData : LiveData<Response<Grade>>,beachName : String){
            responseLiveData.observe(viewLifecycleOwner, Observer{
                val airTemp = it.body()!!.airTemp
                val waterTemp = it.body()!!.waterTemp
                val waveGrade = it.body()!!.waveGrade
                val waveHeight = it.body()!!.waveHeight
                binding.beachName.text = beachName
                binding.airTemp.text = airTemp
                binding.waveHeight.text = waveHeight
                binding.waterTemp.text = waterTemp
                if (waveGrade =="1"){
                    binding.gradeDescription.text = "패들링"
                }
                else if (waveGrade == "2"){
                    binding.gradeDescription.text = "입문"
                }
                else if (waveGrade == "3"){
                    binding.gradeDescription.text = "초급"
                }else if (waveGrade == "4"){
                    binding.gradeDescription.text = "중급"
                }else if (waveGrade == "5"){
                    binding.gradeDescription.text = "가지마"
                }



            })
        }

        binding.beachButtonOne.setOnClickListener{
            val responseLiveDataOne : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(4)
                emit(response)
            }
            liveDataOberserver(responseLiveDataOne,"월정리 해변")
        }

        binding.beachButtonTwo.setOnClickListener {
            val responseLiveDataTwo : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(7)
                emit(response)
            }
            liveDataOberserver(responseLiveDataTwo, "함덕 해변")
        }

        binding.beachButtonThree.setOnClickListener {
            val responseLiveDataThree : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(9)
                emit(response)
            }
            liveDataOberserver(responseLiveDataThree, "표선 해변")
        }

        binding.beachButtonFour.setOnClickListener {
            val responseLiveDataFour : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(5)
                emit(response)
            }
            liveDataOberserver(responseLiveDataFour,"하효쇠소깍 해변")
        }

        binding.beachButtonFive.setOnClickListener {
            val responseLiveDataFive : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(6)
                emit(response)
            }
            liveDataOberserver(responseLiveDataFive,"삼양 검은모래 해변")
        }

        binding.beachButtonSix.setOnClickListener {
            val responseLiveDataSix : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(0)
                emit(response)
            }

            liveDataOberserver(responseLiveDataSix,"중문 해변")
        }

        binding.beachButtonSeven.setOnClickListener {
            val responseLiveDataSeven : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(8)
                emit(response)
            }
            liveDataOberserver(responseLiveDataSeven,"협재 해변")
        }

        binding.beachButtonEight.setOnClickListener {
            val responseLiveDataEight : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(1)
                emit(response)
            }
            liveDataOberserver(responseLiveDataEight,"사계 해변")
        }

        binding.beachButtonNine.setOnClickListener {
            val responseLiveDataNine : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(2)
                emit(response)
            }
            liveDataOberserver(responseLiveDataNine,"곽지 해변")
        }

        binding.beachButtonTen.setOnClickListener {
            val responseLiveDataTen : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(3)
                emit(response)
            }
            liveDataOberserver(responseLiveDataTen,"이호테우 해변")
        }

        return binding.root
    }
}

