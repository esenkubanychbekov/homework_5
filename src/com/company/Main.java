package com.company;

import java.util.Random;

public class Main {

    static int health[] = {700,250,250,250,250}; //Уровень здоровья

    static String hitTypes[] ={"Physycal",
                               "Physycal", //Массив для атаки и уязвимости персонажей
                               "Magical",
                               "Psyho",
                               "Doctor"};

    static  int hits[] = {50, 20, 20, 20,20}; //Массив для силы атаки персонажей

    public static void main(String[] args) {
    fighting();
    }

    public static void fighting() {
        while (!isFinish()) {
            round();
            printStatistics();
            changeBossDefence();
        }
    }

        public static boolean isFinish(){
            if(health[0] <=0){
                System.out.println("Players WIN!!!");
                return true;
            }
            if (health[1] <= 0 && health[2] <= 0 && health[3] <= 0 && health[4] <= 0){
                System.out.println("Boss WIN!!!");

                return true;
            }
            return false;
        }

    public static void round() {

        for(int i = 1; i< health.length; i++){
            health[0] = playerHit(i);
        }

        if(health[0] <= 0){
            return;
        }

        for (int i =1; i < health.length; i++){

            health[i] = health[i] - hits[0];
        }
    }

    public static int playerHit(int playerNumber){
        Random random = new Random();
        int randomInt = random.nextInt(7)+2;
        int resultHit = 0;
        if (hitTypes[0].equals(hitTypes[playerNumber])){
            resultHit = hits[playerNumber]*randomInt;
        } else {

            resultHit = hits[playerNumber];
        }

        return health[0]-resultHit;
    }

    public static void changeBossDefence() {
        Random random = new Random();
        int randomInt = random.nextInt(4)+1;
        switch (randomInt){
            case 1:
                hitTypes[0] = hitTypes[1];
                break;
            case 2:
                hitTypes[0] = hitTypes[2];
                break;
            case 3:
                hitTypes[0] = hitTypes[3];
                break;
            case 4:
                hitTypes[0] = hitTypes[4];
                break;
        }

    }

    public  static void printStatistics(){
        System.out.println("Boss health - " +health[0]);
        System.out.println("Player Warrior - " + health[1]);
        System.out.println("Player Magical - " + health[2]);
        System.out.println("Player Kinetic - " + health[3]);
        System.out.println("Player Doctor - " + health[4]);
        System.out.println("_______________________________");
    }

    }

