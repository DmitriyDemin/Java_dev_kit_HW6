package org.example;


import lombok.Lombok;

import java.util.HashMap;
import java.util.Random;

public class MonyHallGame {
    private static final int TOTAL_GAMES = 1000;
    //    HashMap<шаг теста, результат>
    private HashMap<Integer, Boolean> statisticsWithSubstitution = new HashMap<>();
    private HashMap<Integer, Boolean> statisticsWithoutSubstitution = new HashMap<>();
    private Integer curentWithSubstitution = 0;
    private Integer curentWithoutSubstitution = 0;

    Random rnd = new Random();

    public void StartGame() {
        for (int i = 0; i < TOTAL_GAMES; i++) {

            boolean flag = rnd.nextBoolean();
            boolean wishChange = rnd.nextBoolean();
            PlayingArea board = new PlayingArea();
            board.fillGameBoard(flag);
            Player pl1 = new Player(board);
            pl1.getGameOutcome(wishChange);
            if (wishChange) {
                curentWithSubstitution++;
                if (pl1.isGameOutcome()) statisticsWithSubstitution.put(i, true);
            } else if (!wishChange) {
                curentWithoutSubstitution++;
                if (pl1.isGameOutcome()) statisticsWithoutSubstitution.put(i, true);
            }
        }
    }

    public void StatOutput() {
        System.out.printf("при желании изменить свой выбор, количество игр %s выигрышный исход игры %s или (%.2f %%). %n", curentWithSubstitution, statisticsWithSubstitution.size(),
                (float)(statisticsWithSubstitution.size()*100/curentWithSubstitution));
        System.out.printf("при желании оставить первоначальный выбор, количество игр %s выигрышный исход игры %s или (%.2f %%). %n", curentWithoutSubstitution, statisticsWithoutSubstitution.size(),
                (float)(statisticsWithoutSubstitution.size()*100/curentWithoutSubstitution));
    }


}

