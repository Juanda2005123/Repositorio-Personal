package ui;

import java.util.Scanner;

public class Executable {

    private Scanner lector;

    public Executable() {
        lector = new Scanner(System.in);
    }

    public static void main(String[] a){
        Executable ex = new Executable();
        ex.method();
    }

    public void method(){
        
    }
}