package ui;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.InfrastructureDepartment;

public class Executable{

    private Scanner lector;
    private InfrastructureDepartment controller;

    public Executable(){
        lector = new Scanner(System.in);
        controller = new InfrastructureDepartment();
    }

    public static void main(String[] args) {
        
        Executable executable = new Executable();
        boolean menu = true;
        boolean exception = false;
        while(menu){
            try{
                menu = executable.menu(exception);
            } catch(InputMismatchException e){
                System.out.println("Wrong input");
                exception = true;
            }
        }
        

    }

    /**
     * This method is the menu.
     * @return boolean false if user wants to exit the program.
     */
    private boolean menu(boolean exception) throws InputMismatchException{
        if(exception){
            lector.nextLine();
        }
        System.out.println(showMenu());
        int menu = lector.nextInt();
        boolean flag = true;
        switch(menu){
            case 0:
                System.out.println("Exiting the program...");
                flag = false;
                serializable();
                break;
            case 1:
                addBillBoard();
                break;
            case 2:
                importData();
                break;
            case 3:
                showBillboards();
                break;
            case 4:
                writeNEWCsv();
                break;
            case 5:
                importDataSerializable();
                break;
            default:
                System.out.println("Type a valid option");
                break;
        }
        return flag;

    }

    private String showMenu(){
        String msg = "(1) Add NEW BillBoard, in the csv and serializable";
        msg += "\n(2) import data from csv";
        msg += "\n(3) Show billboards";
        msg += "\n(4) Write new Billboard in a NEW csv File";
        msg += "\n(5) import data from serializable";
        msg += "\n(0) Exit";
        return msg;
    }
    private void addBillBoard(){
        lector.nextLine();

        System.out.println("Type the billboard information like this: \n");
        System.out.println("(width++height++inUse++Brand)");
        System.out.println("(200++300++true++Caracol)");
        String info = lector.nextLine();
        controller.addBillBoard(info);
        writeCsv(info);
    }

    private void importData(){
        try{
            controller.importData();
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void showBillboards(){
        System.out.println(controller.showBillboards());
    }

    private void writeNEWCsv(){
        lector.nextLine();
        System.out.println("Type the billboard information like this: \n");
        System.out.println("(width++height++inUse++Brand)");
        System.out.println("(200++300++true++Caracol)");
        String info = lector.nextLine();
        try{
            controller.writeNEWCsv(info);

        } catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void writeCsv(String info){
        try{
            controller.writeCsv(info);

        } catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void serializable(){
        try{
            controller.serializable();
        } catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void importDataSerializable(){
        try{
            controller.importDataSerializable();
        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }


}