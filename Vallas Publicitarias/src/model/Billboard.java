package model;

import java.io.Serializable;

public class Billboard implements Serializable{

    private static final long serialVersionUID = 7;

    private double width;
    private double height;
    private boolean inUse;
    private String brand;

    private double area;

    public Billboard(double width, double height, boolean inUse, String brand){
        this.width = width;
        this.height = height;
        this.inUse = inUse;
        this.brand = brand;
        area = calculateArea();
    }

    public String toString() {
        String msg = (inUse) ? ("\n"+width+"   "+height+"  "+inUse+"   "+brand) : ("\n"+width+"   "+height+"  "+inUse+"  "+brand);
        return msg;
    }


    private double calculateArea() {
        return width*height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    
    public boolean isInUse() {
        return inUse;
    }

    public String getBrand() {
        return brand;
    }
    
    public double getArea() {
        return area;
    }
}
