package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @AfterEach
    void tearDown() {
        triangle = null;
    }

    @Test
    void shouldGetTypeOfATriangleWithAtLeastOneNullSideRiseAnException(){
        assertThrows(RuntimeException.class,()->triangle.getType(0,0,0));
        assertThrows(RuntimeException.class,()->triangle.getType(0,0,1));
        assertThrows(RuntimeException.class,()->triangle.getType(0,1,0));
        assertThrows(RuntimeException.class,()->triangle.getType(1,0,0));
        assertThrows(RuntimeException.class,()->triangle.getType(0,1,1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,0,1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,1,0));
    }

    @Test
    void shouldGetTypeOfATriangleWithAtLeastOneNegativeSideLenghtRiseAnException(){
        assertThrows(RuntimeException.class,()->triangle.getType(-1,-1,-1));
        assertThrows(RuntimeException.class,()->triangle.getType(-1,-1,1));
        assertThrows(RuntimeException.class,()->triangle.getType(-1,1,-1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,-1,-1));
        assertThrows(RuntimeException.class,()->triangle.getType(-1,1,1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,-1,1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,1,-1));
    }
}