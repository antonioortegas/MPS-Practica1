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

    @Test
    void shouldGetTypeOFATriangleWhereAllSidesAre5ReturnEquilateral(){
        Triangle.TriangleType expected = Triangle.TriangleType.EQUILATERAL;
        Triangle.TriangleType result = triangle.getType(5,5,5);
        assertEquals(expected, result);
    }

    @Test
    void shouldGetTypeOFATriangleWhereTwoSidesAre10AndTheThirdIs5ReturnIsosceles(){
        Triangle.TriangleType expected = Triangle.TriangleType.ISOSCELES;
        Triangle.TriangleType result1 = triangle.getType(5,10,10);
        Triangle.TriangleType result2 = triangle.getType(10,5,10);
        Triangle.TriangleType result3 = triangle.getType(10,10,5);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
    }

    @Test
    void shouldGetTypeOFATriangleWithSidesFiveSixAndSevenReturnScalene(){
        Triangle.TriangleType expected = Triangle.TriangleType.SCALENE;
        Triangle.TriangleType result1 = triangle.getType(5,6,7);
        Triangle.TriangleType result2 = triangle.getType(5,7,6);
        Triangle.TriangleType result3 = triangle.getType(6,5,7);
        Triangle.TriangleType result4 = triangle.getType(6,7,5);
        Triangle.TriangleType result5 = triangle.getType(7,5,6);
        Triangle.TriangleType result6 = triangle.getType(7,6,5);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
    }
}