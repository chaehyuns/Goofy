package com.groom3.goofy.onboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.groom3.goofy.R

data class OnboardData(
    val description: String,
    val onboardImgPath : Int
)

class OnboardAdapter(private val onboardData: List<OnboardData>) :
    RecyclerView.Adapter<OnboardAdapter.OnboardViewHolder>() {
    inner class OnboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val descriptionText = view.findViewById<TextView>(R.id.description_text)
        private val onboardImgSrc = view.findViewById<ImageView>(R.id.onboard_img)

        fun bind(onboardData: OnboardData) {
            descriptionText.text = onboardData.description
            onboardImgSrc.setImageResource(onboardData.onboardImgPath)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardViewHolder {
        return OnboardViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboard_container,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: OnboardViewHolder, position: Int) {
        holder.bind(onboardData[position])
    }

    override fun getItemCount(): Int {
        return onboardData.size
    }
}