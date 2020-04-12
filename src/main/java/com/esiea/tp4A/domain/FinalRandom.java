package com.esiea.tp4A.domain;
import java.util.Random;

public class FinalRandom {
        public int getRandomInt(int max,int min){
            Random rand = new Random();
            return rand.nextInt(max - min + 1) + min;
        }
    }
