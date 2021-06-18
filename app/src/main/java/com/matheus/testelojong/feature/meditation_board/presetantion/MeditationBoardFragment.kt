package com.matheus.testelojong.feature.meditation_board.presetantion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matheus.testelojong.databinding.FragmentMeditationBoardBinding

class MeditationBoardFragment : Fragment() {

    private lateinit var binding: FragmentMeditationBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeditationBoardBinding.inflate(inflater, container, false)
        return binding.root
    }
}