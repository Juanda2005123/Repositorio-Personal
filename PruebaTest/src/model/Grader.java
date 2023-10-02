package model;

public class Grader {
    
    public Grader(){

    }

    public char determineLetterGrade(int numberGrade) throws IllegalArgumentException{
        if(numberGrade < 0){
            throw new IllegalArgumentException("Not valid number");
        } else if(numberGrade < 60){
            return 'F';
        } else if(numberGrade < 70){
            return 'D';
        } else if(numberGrade < 80){
            return 'C';
        } else if(numberGrade < 90){
            return 'B';
        } else if(numberGrade > 100){
            throw new IllegalArgumentException("Not valid");
        }else {
            return 'A';
        } 
    }
}
