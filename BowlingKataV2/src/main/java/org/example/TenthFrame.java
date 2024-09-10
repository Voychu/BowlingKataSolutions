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
        //currentThrow jest 1. rzutem ostatniego Frame'a - jeśli regularny, to dodajemy oba
        int tenthFrameScore = listOfThrows.get(currentThrow) + listOfThrows.get(currentThrow + 1);

        //jeśli był to spare, to suma obu to 10 i dodajemy jeden ekstra. Jeśli był to strike,
        //to currentThrow=10 i w linijce wyżej już dodajemy ten pierwszy ekstra rzut, a tu drugi
        if (listOfThrows.get(currentThrow) == 10 || tenthFrameScore == 10) {
            tenthFrameScore += listOfThrows.get(currentThrow + 2);
        }
        return tenthFrameScore;
    }

}
