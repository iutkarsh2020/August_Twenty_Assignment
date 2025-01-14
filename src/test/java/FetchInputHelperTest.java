import org.Helpers.FetchInputHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FetchInputHelperTest {
    FetchInputHelper helper = new FetchInputHelper();

    @Test
    void testCheckValid_InvalidInstruction_1(){
        String[] instruction1 = new String []{"up", "down"};
        assertFalse(helper.checkValid(instruction1));
        instruction1 = new String []{"up", "80", "Billy String"};
        assertFalse(helper.checkValid(instruction1));
        instruction1 = new String []{"Random Instruction", "80"};
        assertFalse(helper.checkValid(instruction1));
    }

    @Test
    void testCheckValid_ValidInstruction_1(){
        String[] instruction1 = new String []{"up", "80.8"};
        assertTrue(helper.checkValid(instruction1));
        instruction1 = new String []{"Up", "80.8"};
        assertTrue(helper.checkValid(instruction1));
        instruction1 = new String []{"dOwN", "80"};
        assertTrue(helper.checkValid(instruction1));
        instruction1 = new String []{"FoRwarD", "80"};
        assertTrue(helper.checkValid(instruction1));
    }


}
