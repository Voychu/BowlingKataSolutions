package org.example;

import java.util.ArrayList;

public class TenthFrame implements Frame{

    private int framesScore;


    public TenthFrame(int currentThrow, ArrayList<Integer> listOfThrows){
        this.framesScore = calculateFrameScore(currentThrow, listOfThrows);
    }
    @Override
    public int getFramesScore() {
        return this.framesScore;
    }

    @Override
    public int calculateFrameScore(int currentThrow, ArrayList<Integer> listOfThrows) {

        int tenthFrameScore = listOfThrows.get(currentThrow) + listOfThrows.get(currentThrow + 1);

        if (listOfThrows.get(currentThrow) == 10 || tenthFrameScore == 10) {
            tenthFrameScore += listOfThrows.get(currentThrow + 2); // Add the first bonus throw
        }
        return tenthFrameScore;
    }

}
