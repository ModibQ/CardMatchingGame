package com.mobileapp.finalproject;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobileapp.finalproject.databinding.FragmentBeginnerBinding;

import java.util.Arrays;
import java.util.Random;


public class BeginnerFragment extends Fragment {
    int i;
    int clicked = 0;
    boolean turnOver = false;
    int lastClicked = -1;
    private FragmentBeginnerBinding binding;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBeginnerBinding.inflate(inflater,
                container, false);
        View view = binding.getRoot();


        int[] img = new int[]{R.drawable.chef, R.drawable.chef,
                R.drawable.cop,R.drawable.cop,
                R.drawable.hero,R.drawable.hero,
                R.drawable.king,R.drawable.king};

        Button[] buttons= new Button[]{binding.beginner1,binding.beginner2,binding.beginner3,binding.beginner4,
              binding.beginner5,binding.beginner6,binding.beginner7,binding.beginner8};





        Random rand = new Random();

        for (int i = 0; i < img.length; i++) {
            int randomIndexToSwap = rand.nextInt(img.length);
            int temp = img[randomIndexToSwap];
            img[randomIndexToSwap] = img[i];
            img[i] = temp;
        }
        System.out.println(Arrays.toString(img));

        for(i = 0; i < buttons.length-1; i++){
            buttons[i].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(R.drawable.code));
            System.out.println(buttons[i].getText());
            //buttons[i].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[i]));
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(buttons[i].getText() == "cardback" && !turnOver){
                        buttons[i].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[i]));
                        buttons[i].setText(img[i]);
                        System.out.println("CHECK");
                        if (clicked == 0) {
                            lastClicked = i;
                        }
                        clicked++;
                    } else if (buttons[i].getText() != "cardback") {
                        buttons[i].setBackgroundResource(R.drawable.code);
                        buttons[i].setText("cardback");
                        clicked--;
                    }
                    if (clicked == 2) {
                        turnOver = true;
                        if (buttons[i].getText() == buttons[lastClicked].getText()) {
                            buttons[i].setEnabled(false);
                            buttons[lastClicked].setEnabled(false);
                            turnOver = false;
                            clicked = 0;
                        }
                    } else if (clicked == 0) {
                        turnOver = false;
                    }
                }
            });
        }

        return view;


    }
}