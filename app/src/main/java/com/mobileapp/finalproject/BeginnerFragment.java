package com.mobileapp.finalproject;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.mobileapp.finalproject.databinding.FragmentBeginnerBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BeginnerFragment extends Fragment {

    private FragmentBeginnerBinding binding;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBeginnerBinding.inflate(inflater,
                container, false);
        View view = binding.getRoot();

        List<Integer> img = Arrays.asList(R.drawable.chef, R.drawable.chef,
                R.drawable.cop,R.drawable.cop,
                R.drawable.hero,R.drawable.hero,
                R.drawable.king,R.drawable.king);

        ImageButton[] buttons= new ImageButton[]{binding.beginner1,binding.beginner2,binding.beginner3,binding.beginner4,
                binding.beginner5,binding.beginner6,binding.beginner7,binding.beginner8};


        Collections.shuffle(img);

        for(int i = 0; i < 8; i++){
            buttons[i].setBackgroundResource(R.drawable.chef);
        }

        return inflater.inflate(R.layout.fragment_beginner, container, false);


    }
}