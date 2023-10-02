package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import model.Grader;

public class GraderTest {
    
    @Test
    public void MoreThan100ReturnException(){

        var grader = new Grader();
        assertThrows(IllegalArgumentException.class, 
        () -> {
            grader.determineLetterGrade(101);
        });
    }

    @Test
    public void eightyTworeturnB(){
        var grader = new Grader();
        assertEquals('B',grader.determineLetterGrade(82));
    }
}
