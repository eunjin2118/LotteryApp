package com.example.lotteryapp_study

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var currentNums: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("nums", Context.MODE_PRIVATE)
//        val rnds = (1..45).random()
//        val nums= mutableListOf<Int>()
//
//        for(i in 1..6){
//            nums.add((1..45).random())
//        }
//        val lottoNum = nums.joinToString("-")
//        Log.d("mytag", lottoNum.toString())

        val lottoNumView = findViewById<TextView>(R.id.lotto_num)
        currentNums = generateRandomLottoNum(6, "-")
        lottoNumView.text = currentNums

        val generateNumberBtn = findViewById<Button>(R.id.gen_num)
        generateNumberBtn.setOnClickListener {
            currentNums = generateRandomLottoNum(6, "-")
            lottoNumView.text = currentNums
        }

        val saveNumberBtn = findViewById<Button>(R.id.save_num)
        saveNumberBtn.setOnClickListener {
            var currentNums = pref.getString("lottonums", "")
        }
    }


    fun generateRandomLottoNum(count: Int, sep: String): String {
        val nums = mutableListOf<Int>()
        for (i in 1..count) nums.add((1..45).random())
        return nums.joinToString(sep)
    }

}



