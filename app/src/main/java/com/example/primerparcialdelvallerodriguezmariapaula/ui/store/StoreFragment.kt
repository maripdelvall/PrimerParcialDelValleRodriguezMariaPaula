package com.example.primerparcialdelvallerodriguezmariapaula.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.primerparcialdelvallerodriguezmariapaula.R
import com.example.primerparcialdelvallerodriguezmariapaula.databinding.FragmentStoreBinding
import com.example.primerparcialdelvallerodriguezmariapaula.viewmodel.StoreViewModel

class StoreFragment : Fragment() {

    private lateinit var storeViewModel: StoreViewModel
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        storeViewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        _binding = FragmentStoreBinding.inflate(inflater, container, false)

        binding.addProductFabButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_store_to_addProductFragment)
        }



        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}