package com.example.helloearth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.helloearth.R
import com.example.helloearth.databinding.FragmentGlobeHomeBinding


class GlobeHomeFragment : Fragment() {

    private lateinit var binding: FragmentGlobeHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGlobeHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() {
        binding.apply {
            stamenWatercolorButton.setOnClickListener {
                findNavController().navigate(R.id.action_globeHomeFragment_to_stamenWaterColorGlobeFragment)
            }
            shapesButton.setOnClickListener {
                findNavController().navigate(R.id.action_globeHomeFragment_to_sphereGlobeFragment)
            }
        }
    }

}