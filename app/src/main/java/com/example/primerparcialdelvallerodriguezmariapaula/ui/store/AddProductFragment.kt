package com.example.primerparcialdelvallerodriguezmariapaula.ui.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.primerparcialdelvallerodriguezmariapaula.R
import com.example.primerparcialdelvallerodriguezmariapaula.databinding.FragmentAddProductBinding
import com.example.primerparcialdelvallerodriguezmariapaula.model.Store
import com.example.primerparcialdelvallerodriguezmariapaula.viewmodel.StoreViewModel


class AddProductFragment : Fragment() {

    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!

    //creamos esta variable//
    private lateinit var storeViewModel: StoreViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View {
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)


        //Para inicializar la variable storeViewModel//
        storeViewModel = ViewModelProvider(this).get(storeViewModel::class.java)

        //Hacemos el llamado al botón creado//
        binding.submitBtn.setOnClickListener { addProduct() }

        return binding.root
    }

    //Voy a darle funcionalidad al formulario creado//
    //Hago el llamado de cada uno de los plain text creados en fragment_add_product//
    private fun addProduct() {
        val nombre = binding.productName.text.toString()
        val precio = binding.productPrice.text.toString()
        val cantidad = binding.productQuantity.text.toString()
        val color = binding.productColor.text.toString()
        val descuento = binding.productDiscount.text.toString()

        if(validation(nombre,precio,cantidad,color,descuento)) {
            //Para guardar el producto
            val store = Store(0, nombre, precio, cantidad, color, descuento)
            storeViewModel.addStore(store)
            Toast.makeText(requireContext(), getString(R.string.msg_store_added), Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addProductFragment_to_nav_store)
        } else {
            //En caso de que no funcione el validation
            Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }

    private fun validation (nombre: String, precio: String, cantidad: String, color: String, descuento: String): Boolean {
        return !(nombre.isEmpty()) //Si está vacío me retorna un true//
    }
}


