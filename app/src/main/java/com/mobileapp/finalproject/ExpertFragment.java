package com.mobileapp.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileapp.finalproject.databinding.FragmentBeginnerBinding;
import com.mobileapp.finalproject.databinding.FragmentExpertBinding;


public class ExpertFragment extends Fragment {
    private FragmentExpertBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExpertBinding.inflate(inflater,container, false);
        View view = binding.getRoot();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expert, container, false);
    }
}