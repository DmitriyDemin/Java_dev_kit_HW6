package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
* Класс для описания игрового пространства, исходного содержимого за дверями */
public class PlayingArea {

    private List<Door> doorList;

    public PlayingArea() {
        this.doorList = new ArrayList<>();
    }
/*
* метод для заполнения содержимого за дверью где true - содержимое в виде автомобиля, folse -  коза */

    public List<Door> fillGameBoard(boolean flag){
    List<Door> board = this.doorList;
    board.add(new Door(flag));
    if (flag){
        board.add(new Door(false));
        board.add(new Door(false));
    } else {
        Random rnd = new Random();
        boolean flag2 = rnd.nextBoolean();
        board.add(new Door(flag2));
        if (flag2) {
            board.add(new Door(false));
        } else {
            board.add(new Door(true));
        }
    }
    return board;
    }

    public List<Door> getDoorList() {
        return doorList;
    }


}
