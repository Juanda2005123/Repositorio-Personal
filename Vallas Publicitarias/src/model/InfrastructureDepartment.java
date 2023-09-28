package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InfrastructureDepartment {
    
    private ArrayList<Billboard> billboards;
    private final String FILE_NAME = "\\BillboardDataExported.csv";

    public InfrastructureDepartment(){
        billboards = new ArrayList<>();
    }

    public void addBillBoard(String info){
        String[] input = info.split("\\++");
        double w = Double.parseDouble(input[0]);
        double h = Double.parseDouble(input[1]);
        boolean inUse = Boolean.parseBoolean(input[2]);
        billboards.add(new Billboard(w, h, inUse, input[3]));
        
    }

    public void importData() throws IOException{
        File file = new File("C:\\Users\\Compumax\\Desktop\\Vallas Publicitarias\\Vallas Publicitarias\\data"+FILE_NAME);

        
        BufferedReader lector = new BufferedReader(
            new FileReader(file));
            
        String linea;
        lector.readLine();

        while((linea = lector.readLine()) != null){
            String[] input = linea.split("\\|");
            double w = Double.parseDouble(input[0]);
            double h = Double.parseDouble(input[1]);
            boolean inUse = Boolean.parseBoolean(input[2]);
            billboards.add(new Billboard(w, h, inUse, input[3]));
        }   
        lector.close();
    }

    public String showBillboards() {
        String msg = "W       H      InUse  Brand";
        for(int i = 0; i < billboards.size() ; i++){
            msg += billboards.get(i).toString();
        }
        msg += "\n# "+billboards.size();
        return msg;
    }

    public void writeNEWCsv(String info) throws IOException{
        String[] input = info.split("\\++");

        File file = new File("C:\\Users\\Compumax\\Desktop\\Vallas Publicitarias\\Vallas Publicitarias\\data\\Nuevo.csv");

        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(
            new FileWriter(file));
        String sendInFile = input[0]+"|"+input[1]+"|"+input[2]+"|"+input[3];
        writer.write(sendInFile);
        writer.flush();
        writer.close();

    }

    public void writeCsv(String info) throws IOException{
        String[] input = info.split("\\++");

        File file = new File("C:\\Users\\Compumax\\Desktop\\Vallas Publicitarias\\Vallas Publicitarias\\data"+FILE_NAME);

        FileWriter writer = new FileWriter(file,true);

        String sendInFile = "\n"+input[0]+"|"+input[1]+"|"+input[2]+"|"+input[3];
        writer.write(sendInFile);
        writer.close();

    }

    public void serializable() throws IOException {
        File file = new File("C:\\Users\\Compumax\\Desktop\\Vallas Publicitarias\\Vallas Publicitarias\\data\\file.bd");
        ObjectOutputStream escritor = new ObjectOutputStream(
            new FileOutputStream(file));
        
        escritor.writeObject(billboards);
        escritor.close();
    }

    public void importDataSerializable() throws IOException, ClassNotFoundException{
        ObjectInputStream entrada =
            new ObjectInputStream(
                new FileInputStream(
                    new File("C:\\Users\\Compumax\\Desktop\\Vallas Publicitarias\\Vallas Publicitarias\\data\\file.bd")));

        billboards = (ArrayList<Billboard>)entrada.readObject();
    }

    

}
