package darkChess;

import java.awt.*;

public class Grid {

    public Grid() {}

    public Grid(Point anchor, int rows, int columns, int xDimension, int yDimension) {
        this.setAnchor(anchor);
        this.setRows(rows);
        this.setColumns(columns);
        this.setxDimension(xDimension);
        this.setyDimension(yDimension);
    }

    public void draw(Graphics2D g2) {
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                g2.drawRect(getAnchor().x + row * getxDimension(), getAnchor().y + col * getyDimension(), getxDimension(), getyDimension());
            }
        }
    }

    // fields
    private Point anchor;
    private int rows;
    private int columns;
    private int xDimension;
    private int yDimension;

    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getxDimension() {
        return xDimension;
    }

    public void setxDimension(int xDimension) {
        this.xDimension = xDimension;
    }

    public int getyDimension() {
        return yDimension;
    }

    public void setyDimension(int yDimension) {
        this.yDimension = yDimension;
    }

    public Point getSystemCoordinates(Point coordinate) {
        return new Point(getAnchor().x + coordinate.x * xDimension, getAnchor().y + coordinate.y * yDimension);
    }
}
