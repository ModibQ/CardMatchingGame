package com.mobileapp.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileapp.finalproject.databinding.FragmentExpertBinding;
import com.mobileapp.finalproject.databinding.FragmentResultsBinding;


public class ResultsFragment extends Fragment {
    private FragmentResultsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultsBinding.inflate(inflater,container, false);
        View view = binding.getRoot();
        // Inflate the layout for this fragment
        int turnTaken = ResultsFragmentArgs.fromBundle(requireArguments()).getNumTurns();
        binding.textView5.setText(String.valueOf(turnTaken));
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_resultsFragment_to_welcomeFragment);
            }
        });
        return view;
    }
}