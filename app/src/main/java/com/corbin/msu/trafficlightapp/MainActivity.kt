package com.corbin.msu.trafficlightapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.corbin.msu.trafficlightapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lightSwitch = binding.switchButton
        val trafficLightGreen = binding.greenLightImage
        val trafficLightYellow = binding.yellowLightImage
        val trafficLightRed = binding.redLightImage

        var lightState: String = "STOP"

        lightSwitch.setOnClickListener {

            when (lightState) {
                "STOP" -> {
                    setSwtich(lightSwitch,"GO", Color.GREEN)
                    toggleLight(trafficLightRed)
                    toggleLight(trafficLightGreen)
                    lightState = "GO"
                }
                "GO" -> {
                    setSwtich(lightSwitch,"WAIT", Color.YELLOW, Color.BLACK)
                    toggleLight(trafficLightGreen)
                    toggleLight(trafficLightYellow)
                    lightState = "WAIT"
                }
                "WAIT" -> {
                    setSwtich(lightSwitch,"STOP", Color.RED)
                    toggleLight(trafficLightYellow)
                    toggleLight(trafficLightRed)
                    lightState = "STOP"
                }
            }

        }

    }


    private fun setSwtich(switch: Button, text: String, tintColor: Int, fontColor: Int = Color.WHITE) {
        switch.text = text
        switch.setTextColor(fontColor)
        switch.backgroundTintList = ColorStateList.valueOf(tintColor)
    }

    private fun toggleLight(light: ImageView) {
        light.visibility = if (light.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
    }

}