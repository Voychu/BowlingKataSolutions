package org.example;

import java.util.ArrayList;

public class Game {

    private int totalScore;
    private Frame[] frames;

    private ArrayList<Integer> listOfThrows;

    public static final int REGULAR_NUMBER_OF_FRAMES = 10;

    public Game(String[] scores){
        this.listOfThrows = initializeListOfThrows(scores);
        this.frames = initializeFrames(scores, this.listOfThrows);
        this.totalScore = calculateTotalScore(this.frames);
    }

    private int calculateTotalScore(Frame[] frames){
        int totalScore = 0;
        for(Frame f : frames){
            totalScore += f.getFramesScore();
        }
        return totalScore;
    }

    private Frame[] initializeFrames(String[] scores, ArrayList<Integer> listOfThrows){
        Frame[] frames = new Frame[REGULAR_NUMBER_OF_FRAMES];
        int throwIndex = 0;
        for(int i=0; i < scores.length; i++){
            String s = scores[i];
            if (i == REGULAR_NUMBER_OF_FRAMES-1) {  //Ostatni legalny frame
                frames[i] = new TenthFrame(throwIndex, listOfThrows);
                break;
            }
            else if(s.contains("X")) {              //SpareFrame i StrikeFrame mają taki sam kod - redukcja do jednej klasy
                frames[i] = new SpareStrikeFrame(throwIndex, listOfThrows);
                throwIndex+=1;
            }
            else if (s.contains("/")) {
                frames[i] = new SpareStrikeFrame(throwIndex, listOfThrows);
                throwIndex+=2;
            }
            else {
                frames[i] = new RegularFrame(throwIndex, listOfThrows);
                throwIndex+=2;
            }
        }
        return frames;
    }

    private ArrayList<Integer> initializeListOfThrows(String[] scores){
        ArrayList<Integer> listOfThrows = new ArrayList<>();

        for(String score: scores){
            for(int i=0; i<score.length(); i++){
                char currentThrow = score.charAt(i);
                switch(currentThrow){
                    case 'X':
                        listOfThrows.add(10);
                        break;
                    case '-':
                        listOfThrows.add(0);
                        break;
                    case '/':
                        int previousThrow = listOfThrows.get(listOfThrows.size()-1);
                        listOfThrows.add(10 - previousThrow);
                        break;
                    default:
                        listOfThrows.add(Character.getNumericValue(currentThrow));
                        break;
                }
            }
        }

        return listOfThrows;
    }

    public int getTotalScore(){
        return this.totalScore;
    }

    public String getStringScoresForIndividualFrames(){
        String scoreTable = "";
        for(Frame f : this.frames){
            scoreTable += (f.getFramesScore() + " ");
        }
        return scoreTable;
    }
}
