package darkChess;

import java.awt.*;

public class Piece {

    public Piece() {}

    public Piece(Team team, PieceType pieceType, Point coordinate, GridIntf gridIntf) {
        this.team = team;
        this.pieceType = pieceType;
        this.coordinate = coordinate;
        this.gridIntf = gridIntf;
    }

    private Team team;
    private PieceType pieceType;
    private Point coordinate;
    private GridIntf gridIntf;

    public void draw(Graphics2D g2) {
        if (team == Team.WHITE)
            g2.setColor(Color.WHITE);
        else
            g2.setColor(Color.BLACK);

        Point topLeft = gridIntf.getDrawingCoordinates(coordinate);
        switch (pieceType) {
            case PAWN:
                g2.fillOval(topLeft.x, topLeft.y, 50, 50);
                break;
            case ROOK:
                g2.drawString("R", topLeft.x, topLeft.y + 10);
                break;
            case KNIGHT:
                g2.drawString("N", topLeft.x, topLeft.y + 10);
                break;
            case BISHOP:
                g2.drawString("B", topLeft.x, topLeft.y + 10);
                break;
            case QUEEN:
                g2.drawString("Q", topLeft.x, topLeft.y + 10);
                break;
            case KING:
                g2.drawString("K", topLeft.x, topLeft.y + 10);
                break;
            default:
                g2.drawString("WHAT", topLeft.x, topLeft.y + 10);
                break;
        }
    }
}
