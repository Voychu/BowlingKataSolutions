package org.example;

import java.util.ArrayList;

public class SpareStrikeFrame implements Frame{

    private int framesScore;


    public SpareStrikeFrame(int currentThrow, ArrayList<Integer> listOfThrows){
        this.framesScore = calculateFrameScore(currentThrow, listOfThrows);
    }

    @Override
    public int getFramesScore() {
        return this.framesScore;
    }

    @Override
    public int calculateFrameScore(int currentThrow, ArrayList<Integer> listOfThrows) {
        return listOfThrows.get(currentThrow) + listOfThrows.get(currentThrow+1) + listOfThrows.get(currentThrow+2);
    }

}
