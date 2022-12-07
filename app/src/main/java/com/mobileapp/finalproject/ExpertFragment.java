package com.mobileapp.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobileapp.finalproject.databinding.FragmentBeginnerBinding;
import com.mobileapp.finalproject.databinding.FragmentExpertBinding;

import java.util.Arrays;
import java.util.Random;


public class ExpertFragment extends Fragment {
    int i;
    int clicked = 0;
    boolean turnOver = false;
    int lastClicked = -1;
    int matches = 0;
    int turn = 0;
    private FragmentExpertBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExpertBinding.inflate(inflater,container, false);
        View view = binding.getRoot();
        int[] img = new int[]{R.drawable.chef, R.drawable.chef,
                R.drawable.cop,R.drawable.cop,
                R.drawable.hero,R.drawable.hero,
                R.drawable.king,R.drawable.king,
                R.drawable.queen,R.drawable.queen,
                R.drawable.nurse,R.drawable.nurse};

        int flippedImg = R.drawable.code;

        Button[] buttons= new Button[]{binding.expert1,binding.expert2,binding.expert3,binding.expert4,
                binding.expert5,binding.expert6,binding.expert7,binding.expert8,binding.expert9,
                binding.expert10,binding.expert11,binding.expert12};





        Random rand = new Random();

        for (int i = 0; i < img.length; i++) {
            int randomIndexToSwap = rand.nextInt(img.length);
            int temp = img[randomIndexToSwap];
            img[randomIndexToSwap] = img[i];
            img[i] = temp;
        }
        System.out.println(Arrays.toString(img));

        for(i = 0; i < buttons.length; i++){
            buttons[i].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(R.drawable.code));
            buttons[i].setText("cardback");
            //buttons[i].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[i]));
        }

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttons[0].getText() == "cardback" && !turnOver){
                    buttons[0].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[0]));
                    buttons[0].setText(img[0]);
                    if (clicked == 0) {
                        lastClicked = 0;
                    }
                    clicked++;
                } else if (buttons[0].getText() != "cardback") {
                    buttons[0].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[0].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[0].getText() == buttons[lastClicked].getText()) {
                        buttons[0].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        //Learned about handlers
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[0].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[0].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);



                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttons[1].getText() == "cardback" && !turnOver){
                    buttons[1].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[1]));
                    buttons[1].setText(img[1]);
                    if (clicked == 0) {
                        lastClicked = 1;
                    }
                    clicked++;
                } else if (buttons[1].getText() != "cardback") {
                    buttons[1].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[1].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[1].getText() == buttons[lastClicked].getText()) {
                        buttons[1].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[1].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[1].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                }else if (clicked == 0) {
                    turnOver = false;

                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttons[2].getText() == "cardback" && !turnOver){
                    buttons[2].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[2]));
                    buttons[2].setText(img[2]);
                    if (clicked == 0) {
                        lastClicked = 2;
                    }
                    clicked++;
                } else if (buttons[2].getText() != "cardback") {
                    buttons[2].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[2].setText("cardback");
                    clicked--;
                    lastClicked = -1;

                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[2].getText() == buttons[lastClicked].getText()) {
                        buttons[2].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[2].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[2].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttons[3].getText() == "cardback" && !turnOver){
                    buttons[3].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[3]));
                    buttons[3].setText(img[3]);
                    if (clicked == 0) {
                        lastClicked = 3;
                    }
                    clicked++;
                } else if (buttons[3].getText() != "cardback") {
                    buttons[3].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[3].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[3].getText() == buttons[lastClicked].getText()) {
                        buttons[3].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[3].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[3].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttons[4].getText() == "cardback" && !turnOver){
                    buttons[4].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[4]));
                    buttons[4].setText(img[4]);
                    System.out.println("CHECK");
                    if (clicked == 0) {
                        lastClicked = 4;
                    }
                    clicked++;
                } else if (buttons[4].getText() != "cardback") {
                    buttons[4].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[4].setText("cardback");
                    clicked--;
                    lastClicked = -1;

                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[4].getText() == buttons[lastClicked].getText()) {
                        buttons[4].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        matches++;
                        clicked = 0;
                    }else{
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[4].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[4].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttons[5].getText() == "cardback" && !turnOver){
                    buttons[5].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[5]));
                    buttons[5].setText(img[5]);
                    if (clicked == 0) {
                        lastClicked = 5;
                    }
                    clicked++;
                } else if (buttons[5].getText() != "cardback") {
                    buttons[5].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[5].setText("cardback");
                    clicked--;
                    lastClicked = -1;

                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[5].getText() == buttons[lastClicked].getText()) {
                        buttons[5].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[5].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[5].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);

                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttons[6].getText() == "cardback" && !turnOver){
                    buttons[6].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[6]));
                    buttons[6].setText(img[6]);
                    if (clicked == 0) {
                        lastClicked = 6;
                    }
                    clicked++;
                } else if (buttons[6].getText() != "cardback") {
                    buttons[6].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[6].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[6].getText() == buttons[lastClicked].getText()) {
                        buttons[6].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[6].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[6].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }

        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttons[7].getText() == "cardback" && !turnOver){
                    buttons[7].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[7]));
                    buttons[7].setText(img[7]);
                    if (clicked == 0) {
                        lastClicked = 7;
                    }
                    clicked++;
                } else if (buttons[7].getText() != "cardback") {
                    buttons[7].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[7].setText("cardback");
                    clicked--;
                    lastClicked = -1;

                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[7].getText() == buttons[lastClicked].getText()) {
                        buttons[7].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[7].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[7].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });

        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttons[8].getText() == "cardback" && !turnOver){
                    buttons[8].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[8]));
                    buttons[8].setText(img[8]);
                    if (clicked == 0) {
                        lastClicked = 8;
                    }
                    clicked++;
                } else if (buttons[8].getText() != "cardback") {
                    buttons[8].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[8].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[8].getText() == buttons[lastClicked].getText()) {
                        buttons[8].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        //Learned about handlers
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[8].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[8].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });

        buttons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttons[9].getText() == "cardback" && !turnOver){
                    buttons[9].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[9]));
                    buttons[9].setText(img[9]);
                    if (clicked == 0) {
                        lastClicked = 9;
                    }
                    clicked++;
                } else if (buttons[9].getText() != "cardback") {
                    buttons[9].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[9].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[9].getText() == buttons[lastClicked].getText()) {
                        buttons[9].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        //Learned about handlers
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[9].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[9].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);
                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });

        buttons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttons[10].getText() == "cardback" && !turnOver){
                    buttons[10].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[10]));
                    buttons[10].setText(img[10]);
                    if (clicked == 0) {
                        lastClicked = 10;
                    }
                    clicked++;
                } else if (buttons[10].getText() != "cardback") {
                    buttons[10].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[10].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[10].getText() == buttons[lastClicked].getText()) {
                        buttons[10].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        //Learned about handlers
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[10].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[10].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);



                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });

        buttons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttons[11].getText() == "cardback" && !turnOver){
                    buttons[11].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(img[11]));
                    buttons[11].setText(img[11]);
                    if (clicked == 0) {
                        lastClicked = 11;
                    }
                    clicked++;
                } else if (buttons[11].getText() != "cardback") {
                    buttons[11].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                    buttons[11].setText("cardback");
                    clicked--;
                    lastClicked = -1;
                }
                if (clicked == 2) {
                    turn++;
                    turnOver = true;
                    if (buttons[11].getText() == buttons[lastClicked].getText()) {
                        buttons[11].setEnabled(false);
                        buttons[lastClicked].setEnabled(false);
                        turnOver = false;
                        clicked = 0;
                        matches++;
                    }else{
                        //Learned about handlers
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                buttons[0].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[0].setText("cardback");
                                buttons[lastClicked].setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,getResources().getDrawable(flippedImg));;
                                buttons[lastClicked].setText("cardback");
                                lastClicked = -1;
                                clicked = 0;
                                turnOver = false;
                            }
                        },500);



                    }
                } else if (clicked == 0) {
                    turnOver = false;
                }
                if(matches == (buttons.length/2)){
                    ExpertFragmentDirections.ActionExpertFragmentToResultsFragment action = ExpertFragmentDirections.actionExpertFragmentToResultsFragment(turn);
                    Navigation.findNavController(view).navigate(action);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}