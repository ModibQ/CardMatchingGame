package com.mobileapp.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
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
    int lastScore;
    int highScore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultsBinding.inflate(inflater,container, false);
        View view = binding.getRoot();
        //gets the turns from the GameFragment
        int turnTaken = ResultsFragmentArgs.fromBundle(requireArguments()).getNumTurns();
        SharedPreferences settings = getContext().getSharedPreferences("GAME_DATA",Context.MODE_PRIVATE);
        //presets the high score to 1000000 since you want the lowest score so you cant set it to something low to
        //the best score possible.
        int highscore = settings.getInt("HIGH_SCORE",1000000);
        //Checks if current score is better than high score and sets new highscore if needed
        if(highscore > turnTaken){
            binding.textView12.setText(String.valueOf(turnTaken));
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", turnTaken);
            editor.commit();
        }else{
            binding.textView12.setText(String.valueOf(highscore));
        }
        //Tells the amount of turns taken
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