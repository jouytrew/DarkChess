package darkChess;

import java.awt.*;

public class ChessBoard extends Grid {

    public ChessBoard() {
        super();
    }

    public ChessBoard(Point anchor, int rows, int columns, int xDimension, int yDimension, GameIntf gameIntf) {
        super(anchor, rows, columns, xDimension, yDimension);
        this.gameIntf = gameIntf;
    }

    GameIntf gameIntf;

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.ORANGE);
        // draw background
        g2.fillRect(getAnchor().x - getxDimension(), getAnchor().y - getyDimension(),
                getxDimension() * (getColumns() + 2), getyDimension() * (getRows() + 2));
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                if ((row + col) % 2 == 0)
                    g2.setColor(Color.LIGHT_GRAY);
                else
                    g2.setColor(Color.DARK_GRAY);


                g2.fillRect(getAnchor().x + row * getxDimension(), getAnchor().y + col * getyDimension(), getxDimension(), getyDimension());
            }
        }
    }

    public void frame(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        g2.drawRect(getAnchor().x, getAnchor().y, getColumns() * getxDimension(), getRows() * getyDimension());
    }

    public void frameCell(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        if (gameIntf.getMouseLocation() != null) {
            Point mouseCell = getCellCoordinates(gameIntf.getMouseLocation());
            g2.drawRect(getAnchor().x + mouseCell.x * getxDimension(), getAnchor().y + mouseCell.y * getyDimension(),
                    getxDimension(), getyDimension());
        }
    }

    public void highlightCell(Graphics2D g2, Point cellCoordinate) {
        g2.setColor(new Color(0, 255, 255, 80));
        Point cellAnchor = getSystemCoordinates(cellCoordinate);
        g2.fillRect(cellAnchor.x, cellAnchor.y, getxDimension(), getyDimension());
    }

    @Override
    public Point getSystemCoordinates(Point coordinate) {
        return super.getSystemCoordinates(coordinate);
    }

    public Point getCellCoordinates(Point coordinate) {
        return new Point((coordinate.x - getAnchor().x) / getxDimension(), (coordinate.y - getAnchor().y) / getyDimension());
    }

    /**
     * Is the cursor within the confines of the board?
     * @return whether or not the cursor is in the area with the board
     */
    public boolean mouseOverBoard() {
        if (gameIntf.getMouseLocation() != null) {
            Point mouseLocation = gameIntf.getMouseLocation();
            if (mouseLocation.x >= getAnchor().x && mouseLocation.x <= getAnchor().x + getColumns() * getxDimension()) {
                if (mouseLocation.y >= getAnchor().y && mouseLocation.y <= getAnchor().y + getRows() * getyDimension()) {

                    return true;
                }
            }
        }
        return false;
    }
}
