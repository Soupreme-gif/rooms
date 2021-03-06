package edu.wctc;

import java.io.Serializable;

public class Wall implements Serializable {

    private double width;
    private double height;
    private static final long serialVersionUID = 1L;


    public Wall(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea()
    {
        double widthHolder = width;
        double heightHolder = height;

        return widthHolder * heightHolder;

    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

}
