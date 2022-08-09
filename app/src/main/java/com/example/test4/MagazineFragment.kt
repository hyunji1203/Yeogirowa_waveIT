package com.example.test4

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.ViewPager

class MagazineFragment : Fragment() {

    lateinit var ourtown_btn : ImageButton
    lateinit var job_btn : ImageButton

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_magazine, container, false)

        ourtown_btn = view.findViewById(R.id.ourtown_btn)
        job_btn = view.findViewById(R.id.job_btn)

        // viewpager 어댑터
        val viewPager_magazine = view.findViewById<ViewPager>(R.id.viewPager_magazine)
        // 슬라이드를 위한 어댑터 설정
        val pagerAdapter_middle = ViewPagerAdapter_magazine(childFragmentManager)
        viewPager_magazine.adapter = pagerAdapter_middle

        // 옆으로 넘어갈 때 이미지가 어떻게 보이는지 설정
        val dpValue: Int = 80
        val d: Float = getResources().getDisplayMetrics().density
        val margin: Int = dpValue * d.toInt()
        viewPager_magazine.setClipToPadding(false)
        viewPager_magazine.setPadding(margin, 0, margin, 0);
        viewPager_magazine.setPageMargin(60);

        ourtown_btn.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout, ourtownFragment())
            transaction?.commit()
        }
        job_btn.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout, jobFragment())
            transaction?.commit()
        }

        return view
    }
}