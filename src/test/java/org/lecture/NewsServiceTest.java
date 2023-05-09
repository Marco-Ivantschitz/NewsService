package org.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * The Java Unit Tests of the Program
 */

import static org.junit.jupiter.api.Assertions.*;

public class NewsServiceTest {
    private final ByteArrayOutputStream bo = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(bo, true));
    }

    @Test
    public void consoleInput1() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 1);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput2() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("2\nMarco\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        //assertTrue(guessCount == 2);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput3() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 3);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput4() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 4);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput5() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 5);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput6() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("6\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 6);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput7() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("7\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 7);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput8() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("8\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 8);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput9() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("9\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 9);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput10() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("10\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 10);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInputFail() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("9\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertFalse(guessCount == 1);
        System.setIn(sysIn);
    }


}

