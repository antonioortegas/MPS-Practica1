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
    void shouldGetTypeOfATriangleWithAtLeastOneNegativeSideLengthRiseAnException(){
        assertThrows(RuntimeException.class,()->triangle.getType(-1,-1,-1));
        assertThrows(RuntimeException.class,()->triangle.getType(-1,-1,1));
        assertThrows(RuntimeException.class,()->triangle.getType(-1,1,-1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,-1,-1));
        assertThrows(RuntimeException.class,()->triangle.getType(-1,1,1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,-1,1));
        assertThrows(RuntimeException.class,()->triangle.getType(1,1,-1));
    }

    @Test
    void shouldGetTypeOfATriangleWhereTheSumOfTwoSidesEqualsTheThirdRiseAnException(){
        assertThrows(RuntimeException.class, ()-> triangle.getType(1,2,3));
        assertThrows(RuntimeException.class, ()-> triangle.getType(1,3,2));
        assertThrows(RuntimeException.class, ()-> triangle.getType(2,1,3));
        assertThrows(RuntimeException.class, ()-> triangle.getType(2,3,1));
        assertThrows(RuntimeException.class, ()-> triangle.getType(3,1,2));
        assertThrows(RuntimeException.class, ()-> triangle.getType(3,2,1));
    }

    @Test
    void shouldGetTypeOfATriangleWhereTheSumOfTwoSidesIsLessThanTheThirdRiseAnException(){
        assertThrows(RuntimeException.class, ()-> triangle.getType(1,2,4));
        assertThrows(RuntimeException.class, ()-> triangle.getType(1,4,2));
        assertThrows(RuntimeException.class, ()-> triangle.getType(2,1,4));
        assertThrows(RuntimeException.class, ()-> triangle.getType(2,4,1));
        assertThrows(RuntimeException.class, ()-> triangle.getType(4,1,2));
        assertThrows(RuntimeException.class, ()-> triangle.getType(4,2,1));
    }


}