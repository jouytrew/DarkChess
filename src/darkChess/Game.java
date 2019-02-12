package darkChess;

import environment.Environment;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Game extends Environment implements GridIntf, GameIntf {

    private ChessBoard chessBoard;
    private boolean mouseInBoard = false;
    private ArrayList<Piece> chessPieces;
    private Point selectedCell;

    public Game() { }

    @Override
    public void initializeEnvironment() {
        System.out.println("Hello World!");
        // create board
        chessBoard = new ChessBoard(new Point(50, 50), 8, 8, 50, 50, this);

        // create pieces
        chessPieces = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            chessPieces.add(new Piece(Team.WHITE, PieceType.PAWN, new Point(x, 6), this));
        }
        chessPieces.add(new Piece(Team.WHITE, PieceType.ROOK, new Point(0, 7), this));
        chessPieces.add(new Piece(Team.WHITE, PieceType.KNIGHT, new Point(1, 7), this));
        chessPieces.add(new Piece(Team.WHITE, PieceType.BISHOP, new Point(2, 7), this));
        chessPieces.add(new Piece(Team.WHITE, PieceType.QUEEN, new Point(3, 7), this));
        chessPieces.add(new Piece(Team.WHITE, PieceType.KING, new Point(4, 7), this));
        chessPieces.add(new Piece(Team.WHITE, PieceType.BISHOP, new Point(5, 7), this));
        chessPieces.add(new Piece(Team.WHITE, PieceType.KNIGHT, new Point(6, 7), this));
        chessPieces.add(new Piece(Team.WHITE, PieceType.ROOK, new Point(7, 7), this));

        for (int x = 0; x < 8; x++) {
            chessPieces.add(new Piece(Team.BLACK, PieceType.PAWN, new Point(x, 1), this));
        }
        chessPieces.add(new Piece(Team.BLACK, PieceType.ROOK, new Point(0, 0), this));
        chessPieces.add(new Piece(Team.BLACK, PieceType.KNIGHT, new Point(1, 0), this));
        chessPieces.add(new Piece(Team.BLACK, PieceType.BISHOP, new Point(2, 0), this));
        chessPieces.add(new Piece(Team.BLACK, PieceType.QUEEN, new Point(3, 0), this));
        chessPieces.add(new Piece(Team.BLACK, PieceType.KING, new Point(4, 0), this));
        chessPieces.add(new Piece(Team.BLACK, PieceType.BISHOP, new Point(5, 0), this));
        chessPieces.add(new Piece(Team.BLACK, PieceType.KNIGHT, new Point(6, 0), this));
        chessPieces.add(new Piece(Team.BLACK, PieceType.ROOK, new Point(7, 0), this));

    }

    //<editor-fold desc="Timer Handler">
    @Override
    public void timerTaskHandler() {

    }
    //</editor-fold>

    //<editor-fold desc="Key Handlers">
    @Override
    public void keyPressedHandler(KeyEvent e) {

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }
    //</editor-fold>

    //<editor-fold desc="Mouse Handlers">
    @Override
    protected void environmentMouseExited(MouseEvent e) {

    }

    @Override
    protected void environmentMouseEntered(MouseEvent e) {

    }

    @Override
    protected void environmentMouseReleased(MouseEvent e) {
        if (chessBoard != null) {
            if (chessBoard.mouseOverBoard()) {
                selectedCell = chessBoard.getCellCoordinates(getMouseLocation());
            }
        }
    }

    @Override
    protected void environmentMousePressed(MouseEvent e) {

    }

    @Override
    public void environmentMouseDragged(MouseEvent e) {

    }

    @Override
    public void environmentMouseMoved(MouseEvent e) {
        mouseInBoard = chessBoard.mouseOverBoard();
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }
    //</editor-fold>

    @Override
    public void paintEnvironment(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //<editor-fold defaultstate="collapsed" desc="Antialias">
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//</editor-fold>

        if (chessBoard != null) {
            chessBoard.draw(g2);
            if (mouseInBoard) {
                chessBoard.frameCell(g2);
            }
            if (selectedCell != null) {
                // TODO: check if the cell contains a piece and highlight the cells that it can move to
                chessBoard.highlightCell(g2, selectedCell);
            }
        }
        if (chessPieces != null) {
            for (Piece piece : chessPieces) {
                piece.draw(g2);
            }
        }
    }

    //<editor-fold desc="Interfaces">
    @Override
    public Point getDrawingCoordinates(Point coordinate) {
        return chessBoard.getSystemCoordinates(coordinate);
    }

    @Override
    public Point getMouseLocation() {
        return getMousePosition();
    }
    //</editor-fold>

}
