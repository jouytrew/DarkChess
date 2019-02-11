package darkChess;

import java.awt.*;
import java.util.ArrayList;

public class Player {

    public Player() {

    }

    public Player(Team team, GridIntf gridIntf) {
        this.team = team;
        this.gridIntf = gridIntf;
        pieces = new ArrayList<>();
        generatePieces();
    }

    private void generatePieces() {
        switch (team) {
            case BLACK:

                break;
            default:
                break;
        }
    }

    public void drawPieces(Graphics2D g2) {
        if (team == Team.WHITE)
            g2.setColor(Color.WHITE);
        else
            g2.setColor(Color.BLACK);

        for (Piece piece : pieces) {
            piece.draw(g2);
        }
    }

    private ArrayList<Piece> pieces;
    private Team team;

    private GridIntf gridIntf;

}
