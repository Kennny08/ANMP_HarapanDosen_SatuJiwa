package com.kenny.a160420050_uts_anmp_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.kenny.a160420050_uts_anmp_satujiwa.R
import com.kenny.a160420050_uts_anmp_satujiwa.databinding.FragmentEditProfileBinding
import com.kenny.a160420050_uts_anmp_satujiwa.model.User
import com.kenny.a160420050_uts_anmp_satujiwa.util.loadImage
import com.kenny.a160420050_uts_anmp_satujiwa.viewmodel.ProfileViewModel


class EditProfileFragment : Fragment() , ProfileEditInterface{
    private lateinit var viewModel: ProfileViewModel
    private lateinit var dataBinding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentEditProfileBinding>(
            inflater, R.layout.fragment_edit_profile, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgEditProfilePengguna = view.findViewById<ImageView>(R.id.imgEditProfilePengguna)
        val progressBarImageEditProfilPengguna = view.findViewById<ProgressBar>(R.id.progressBarImageEditProfilPengguna)

        imgEditProfilePengguna.loadImage("https://projectfspf.000webhostapp.com/projectutsanmp/images/kenny.jpg", progressBarImageEditProfilPengguna)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        dataBinding.simpanListener = this

        val uuid = EditProfileFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer
        {
            dataBinding.user = it
        })
    }

    override fun simpanClick(v: View, user: User) {
        viewModel.update(user.phoneNumber, user.address, user.uuid)
        Toast.makeText(v.context, "Profile updated", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(v).popBackStack()
    }
}