package darkChess;

import java.awt.*;

public class Piece {

    public Piece() {}

    public Piece(Team team, PieceType pieceType, Point coordinate, GridIntf gridIntf) {
        this.setTeam(team);
        this.setPieceType(pieceType);
        this.setCoordinate(coordinate);
        this.gridIntf = gridIntf;
    }

    private Team team;
    private PieceType pieceType;
    private Point coordinate;
    private GridIntf gridIntf;

    public void draw(Graphics2D g2) {
        if (getTeam() == Team.WHITE)
            g2.setColor(Color.WHITE);
        else
            g2.setColor(Color.BLACK);

        Point topLeft = gridIntf.getDrawingCoordinates(getCoordinate());
        switch (getPieceType()) {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }
}
