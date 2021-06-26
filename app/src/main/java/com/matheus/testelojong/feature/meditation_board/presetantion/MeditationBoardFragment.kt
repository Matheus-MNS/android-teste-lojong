package com.matheus.testelojong.feature.meditation_board.presetantion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.matheus.testelojong.base_app.extensions.showCustomToast
import com.matheus.testelojong.databinding.FragmentMeditationBoardBinding

class MeditationBoardFragment : Fragment() {

    private lateinit var binding: FragmentMeditationBoardBinding
    private val args: MeditationBoardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeditationBoardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scrollToBottom()
        handleOnClickListener()
    }

    private fun handleOnClickListener() {

        with(binding) {
            buttonNumberOne.setOnClickListener {
                showToast(args.factsList[0].text)
            }
            buttonNumberTwo.setOnClickListener {
                showToast(args.factsList[1].text)
            }
            buttonNumberThree.setOnClickListener {
                showToast(args.factsList[2].text)
            }
            buttonNumberFour.setOnClickListener {
                showToast(args.factsList[3].text)
            }
            buttonNumberFive.setOnClickListener {
                showToast(args.factsList[4].text)
            }
        }
    }

    private fun showToast(message: String) {
        Toast(context).showCustomToast(message, activity)
    }

    private fun scrollToBottom() {
        with(binding) {
            scrollView.post { scrollView.fullScroll(View.FOCUS_DOWN) }
        }
    }
}