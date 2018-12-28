package se.lexicon.emil.calculator;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.LinkedList;

class ManagerTest {

    private static Manager manager = new Manager();
    private static final LinkedList<Character> arithmeticList = new LinkedList<>(Arrays.asList('1', '+', '2', '*', '2', '/', '2', '-', '1'));
    private static final double CORRECT_ANSWER = 2;

    @BeforeEach
    void setupOperations() {
        manager.addOperations(new LinkedList<>(arithmeticList));
    }
    @AfterEach()
    void clearOperations() {
        manager.clearOperations();
    }
    @Test
    void compute() {
        Assertions.assertEquals(manager.compute(), CORRECT_ANSWER);
    }
    @Test
    void divisionByZero() {
        manager.addOperations(new LinkedList<>(Arrays.asList('/', '0')));
        Assertions.assertThrows(IllegalArgumentException.class, () -> manager.compute());
    }
}