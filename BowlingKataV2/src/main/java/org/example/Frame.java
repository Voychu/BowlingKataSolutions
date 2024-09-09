package org.example;

import java.util.ArrayList;

public interface Frame {

    int getFramesScore();
    int calculateFrameScore(int currentThrow, ArrayList<Integer> listOfThrows);
}
