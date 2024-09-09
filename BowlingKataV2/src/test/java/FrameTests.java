import org.example.Frame;
import org.example.RegularFrame;
import org.example.SpareStrikeFrame;
import org.example.TenthFrame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FrameTests {


    @Test
    public void frameCorrectlyCountsScoresForAllLegalPossibilites(){
        ArrayList<Integer> listOfThrowsStrikeAt10 = new ArrayList<>(Arrays.asList(10,5,3,3,7,4,6,10,10,0,4,0,0,8,2,10,5,5));
        Frame strike = new SpareStrikeFrame(0,listOfThrowsStrikeAt10);
        Frame reg = new RegularFrame(1,listOfThrowsStrikeAt10);
        Frame spare = new SpareStrikeFrame(3,listOfThrowsStrikeAt10);
        Frame strikeOnLast = new TenthFrame(15,listOfThrowsStrikeAt10);

        assertEquals(strike.getFramesScore(),18);
        assertEquals(reg.getFramesScore(),8);
        assertEquals(spare.getFramesScore(),14);
        assertEquals(strikeOnLast.getFramesScore(),20);

        ArrayList<Integer> listOfThrowsSpareAt10 = new ArrayList<>(Arrays.asList(10,5,3,3,7,4,6,10,10,0,4,0,0,8,2,8,2,5));
        Frame spareOnLast = new TenthFrame(15,listOfThrowsSpareAt10);
        assertEquals(spareOnLast.getFramesScore(),15);

        ArrayList<Integer> listOfThrowsRegularAt10 = new ArrayList<>(Arrays.asList(10,5,3,3,7,4,6,10,10,0,4,0,0,8,2,4,2));
        Frame regOnLast = new TenthFrame(15,listOfThrowsRegularAt10);
        assertEquals(regOnLast.getFramesScore(),6);


    }
}
