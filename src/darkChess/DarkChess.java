package darkChess;

import environment.ApplicationStarter;

import javax.swing.JFrame;

public class DarkChess {
    public static void main(String[] args){
        ApplicationStarter.run("DarkChess", new Game());
    }
}