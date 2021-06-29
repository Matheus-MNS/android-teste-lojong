package com.matheus.testelojong.feature.meditation_board.presetantion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.airbnb.lottie.LottieAnimationView
import com.matheus.testelojong.R
import com.matheus.testelojong.common.extensions.setGone
import com.matheus.testelojong.common.extensions.setVisible
import com.matheus.testelojong.common.extensions.showCustomToast
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
                handleElephantVisibility(elephantOne)
            }
            buttonNumberTwo.setOnClickListener {
                showToast(args.factsList[1].text)
                handleElephantVisibility(elephantTwo)
            }
            buttonNumberThree.setOnClickListener {
                showToast(args.factsList[2].text)
                handleElephantVisibility(elephantThree)
            }
            buttonNumberFour.setOnClickListener {
                showToast(args.factsList[3].text)
                handleElephantVisibility(elephantFour)
            }
            buttonNumberFive.setOnClickListener {
                showToast(args.factsList[4].text)
                handleElephantVisibility(elephantFive)
            }
        }
    }

    private fun handleElephantVisibility(elephant: LottieAnimationView) {

        with(binding) {
            when (elephant.id) {
                R.id.elephantOne -> {
                    elephantOne.setVisible()
                    elephantTwo.setGone()
                    elephantThree.setGone()
                    elephantFour.setGone()
                    elephantFive.setGone()
                }
                R.id.elephantTwo -> {
                    elephantOne.setGone()
                    elephantTwo.setVisible()
                    elephantThree.setGone()
                    elephantFour.setGone()
                    elephantFive.setGone()
                }
                R.id.elephantThree -> {
                    elephantOne.setGone()
                    elephantTwo.setGone()
                    elephantThree.setVisible()
                    elephantFour.setGone()
                    elephantFive.setGone()
                }
                R.id.elephantFour -> {
                    elephantOne.setGone()
                    elephantTwo.setGone()
                    elephantThree.setGone()
                    elephantFour.setVisible()
                    elephantFive.setGone()
                }
                R.id.elephantFive -> {
                    elephantOne.setGone()
                    elephantTwo.setGone()
                    elephantThree.setGone()
                    elephantFour.setGone()
                    elephantFive.setVisible()
                }
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