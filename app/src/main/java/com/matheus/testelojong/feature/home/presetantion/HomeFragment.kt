package com.matheus.testelojong.feature.home.presetantion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.matheus.testelojong.R
import com.matheus.testelojong.base_app.extensions.changeStatusBarColor
import com.matheus.testelojong.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        handleObserver()

        binding.meditationBoardButton.setOnClickListener {
            navigateToMeditationBoard()
        }
    }

    private fun navigateToMeditationBoard() {
        viewModel.factsList?.let {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToMeditationBoardFragment(it.toTypedArray())
            )
        }
    }

    private fun setupView() {
        changeStatusBarColor(R.color.background_color)
    }

    private fun handleObserver() {
        val factsListStates = Observer(
            ::validateFactsListStates
        )
        viewModel.factsListStates.observe(viewLifecycleOwner, factsListStates)
    }

    private fun validateFactsListStates(factsListStates: Pair<Boolean, Boolean>) {

        when {
            factsListStates.first && !factsListStates.second -> {
                Toast.makeText(context, R.string.local_list, Toast.LENGTH_SHORT).show()
            }
            !factsListStates.first && !factsListStates.second -> {
                Toast.makeText(context, R.string.failed_request, Toast.LENGTH_SHORT).show()
            }
            !factsListStates.first && factsListStates.second -> {
                Toast.makeText(context, R.string.success_request, Toast.LENGTH_SHORT).show()
            }
        }
    }
}