package com.groom3.goofy.home
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.HandlerCompat.postDelayed
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.groom3.goofy.R
import com.groom3.goofy.api.GradeService
import com.groom3.goofy.api.RetrofitInstance
import com.groom3.goofy.databinding.FragmentMapBinding
import com.groom3.goofy.model.Grade
import retrofit2.Response


class MapFragment : Fragment() {
    private lateinit var binding: FragmentMapBinding
    var buttonOneClicked = true
    var buttonTwoClicked = false
    var buttonThreeClicked = false
    var buttonFourClicked = false
    var buttonFiveClicked = false
    var buttonSixClicked = false
    var buttonSevenClicked = false
    var buttonEightClicked = false
    var buttonNineClicked = false
    var buttonTenClicked = false

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
                binding.airTemp.text = "기온 ${airTemp}'c"
                binding.waveHeight.text = "${waveHeight}m"
                binding.waterTemp.text = "수온 ${waterTemp}'c"
                if (waveGrade =="1"){
                    binding.gradeDescription.text = "패들링"
                }
                else if (waveGrade == "2"){
                    binding.gradeDescription.text = "입문"
                }
                else if (waveGrade == "3"){
                    binding.gradeDescription.text = "초급용 파도"
                }else if (waveGrade == "4"){
                    binding.gradeDescription.text = "중급용 파도"
                }else if (waveGrade == "5"){
                    binding.gradeDescription.text = "가지마 제발"
                }
            })
        }

        val responseLiveDataOne : LiveData<Response<Grade>> = liveData {
            val response = retService.getGrade(4)
            emit(response)
        }
        liveDataOberserver(responseLiveDataOne,"월정리 해변")
        Handler().postDelayed(Runnable {
            if (binding.gradeDescription.text == "패들링"){
                if(buttonOneClicked) {
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone_stroke)
                }
                else{
                    Log.d("MYTAG","setting button")
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
            }
            if (binding.gradeDescription.text == "입문"){
                if(!buttonOneClicked) {
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                else{
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo_stroke)
                }
            }
            if (binding.gradeDescription.text == "초급용 파도"){
                if(!buttonOneClicked) {
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                else{
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree_stroke)
                }
            }
            if (binding.gradeDescription.text == "중급용 파도"){
                if(!buttonOneClicked) {
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                else{
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour_stroke)
                }
            }
            if (binding.gradeDescription.text == "가지마 제발"){
                if(!buttonOneClicked) {
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
                else{
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive_stroke)
                }
            }
        }, 500)

        binding.beachButtonOne.setOnClickListener{
            buttonOneClicked = !buttonOneClicked
            val responseLiveDataOne : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(4)
                emit(response)
            }
            liveDataOberserver(responseLiveDataOne,"월정리 해변")
            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonOne.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)

        }

        binding.beachButtonTwo.setOnClickListener {
            val responseLiveDataTwo : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(7)
                emit(response)
            }
            liveDataOberserver(responseLiveDataTwo, "함덕 해변")
            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonTwo.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonTwo.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonTwo.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonTwo.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonTwo.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)


        }

        binding.beachButtonThree.setOnClickListener {
            val responseLiveDataThree : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(9)
                emit(response)
            }
            liveDataOberserver(responseLiveDataThree, "표선 해변")
            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonThree.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonThree.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonThree.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonThree.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonThree.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        binding.beachButtonFour.setOnClickListener {
            val responseLiveDataFour : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(5)
                emit(response)
            }
            liveDataOberserver(responseLiveDataFour,"하효쇠소깍 해변")
            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonFour.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonFour.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonFour.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonFour.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonFour.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        binding.beachButtonFive.setOnClickListener {
            val responseLiveDataFive : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(6)
                emit(response)
            }
            liveDataOberserver(responseLiveDataFive,"삼양 검은모래 해변")

            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonFive.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonFive.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonFive.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonFive.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonFive.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        binding.beachButtonSix.setOnClickListener {
            val responseLiveDataSix : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(0)
                emit(response)
            }

            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonSix.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonSix.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonSix.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonSix.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonSix.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        binding.beachButtonSeven.setOnClickListener {
            val responseLiveDataSeven : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(8)
                emit(response)
            }
            liveDataOberserver(responseLiveDataSeven,"협재 해변")
            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonSeven.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonSeven.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonSeven.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonSeven.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonSeven.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        binding.beachButtonEight.setOnClickListener {
            val responseLiveDataEight : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(1)
                emit(response)
            }
            liveDataOberserver(responseLiveDataEight,"사계 해변")
            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonEight.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonEight.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonEight.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonEight.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonEight.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        binding.beachButtonNine.setOnClickListener {
            val responseLiveDataNine : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(2)
                emit(response)
            }
            liveDataOberserver(responseLiveDataNine,"곽지 해변")
            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonNine.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonNine.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonNine.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonNine.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonNine.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        binding.beachButtonTen.setOnClickListener {
            val responseLiveDataTen : LiveData<Response<Grade>> = liveData {
                val response = retService.getGrade(3)
                emit(response)
            }
            liveDataOberserver(responseLiveDataTen,"이호테우 해변")

            Handler().postDelayed(Runnable {
                if (binding.gradeDescription.text == "패들링"){
                    binding.beachButtonTen.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradeone)
                }
                if (binding.gradeDescription.text == "입문"){
                    binding.beachButtonTen.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradetwo)
                }
                if (binding.gradeDescription.text == "초급용 파도"){
                    binding.beachButtonTen.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradethree)
                }
                if (binding.gradeDescription.text == "중급용 파도"){
                    binding.beachButtonTen.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefour)
                }
                if (binding.gradeDescription.text == "가지마 제발"){
                    binding.beachButtonTen.setBackgroundResource(com.groom3.goofy.R.drawable.circle_gradefive)
                }
            }, 1500)
        }

        return binding.root
    }
}

