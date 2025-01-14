import org.BusinessLogic.ExecuteOperations;
import org.Model.SubmarineState;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ExecuteOperationsTest {
    SubmarineState sub;
    ArrayList<String[]> commandList;
    @BeforeEach
    void configure(){
        sub = new SubmarineState();
        commandList = new ArrayList<>();
    }
    @Test
    void testExecute_NoCommands(){
        ExecuteOperations.execute(sub, commandList);
        assertEquals(0, sub.getHorizontal());
        assertEquals(0, sub.getDepth());
        assertEquals(0, sub.getProduct());
    }

    @Test
    void testExecute_SingleCommand() {
        SubmarineState sub = new SubmarineState();
        commandList.add(new String[]{"forward", "10"});

        ExecuteOperations.execute(sub, commandList);

        assertEquals(10, sub.getHorizontal());
        assertEquals(0, sub.getDepth());
        assertEquals(0, sub.getProduct());
    }

    @Test
    void testExecute_UpDownCancelEachOther() {
        commandList.add(new String[]{"down", "5"});
        commandList.add(new String[]{"up", "5"});
        commandList.add(new String[]{"forward", "5"});

        ExecuteOperations.execute(sub, commandList);

        assertEquals(5, sub.getHorizontal());
        assertEquals(0, sub.getDepth());
        assertEquals(0, sub.getProduct());
    }

    @Test
    void testExecute_FloatingPointValues() {
        commandList.add(new String[]{"forward", "5.5"});
        commandList.add(new String[]{"down", "3.2"});
        commandList.add(new String[]{"up", "1.2"});

        ExecuteOperations.execute(sub, commandList);

        assertEquals(5.5, sub.getHorizontal());
        assertEquals(2.0, sub.getDepth());
        assertEquals(11.0, sub.getProduct());
    }
}
