package org.example;

public class Door {
    private boolean state;

    public Door(boolean state){
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return "за дверью-"+ state;
    }

}
