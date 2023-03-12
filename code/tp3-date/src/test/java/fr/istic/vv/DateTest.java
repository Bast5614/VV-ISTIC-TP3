package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    public void testDate() {
        // Test valid dates
        Date date1 = new Date(1, 1, 1);
        assertEquals(1, date1.getDay());
        assertEquals(1, date1.getMonth());
        assertEquals(1, date1.getYear());

        Date date2 = new Date(1, 1, 1582);
        assertEquals(1, date2.getDay());
        assertEquals(1, date2.getMonth());
        assertEquals(1582, date2.getYear());

        Date date3 = new Date(31, 12, 9999);
        assertEquals(31, date3.getDay());
        assertEquals(12, date3.getMonth());
        assertEquals(9999, date3.getYear());

        // Test leap year
        Date date4 = new Date(29, 2, 2020);
        assertEquals(29, date4.getDay());
        assertEquals(2, date4.getMonth());
        assertEquals(2020, date4.getYear());

        // Test invalid dates
        try {
            new Date(29, 2, 2021);
            // Expect an IllegalArgumentException to be thrown
            assertFalse(true);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            new Date(30, 2, 2020);
            // Expect an IllegalArgumentException to be thrown
            assertFalse(true);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            new Date(31, 4, 2020);
            // Expect an IllegalArgumentException to be thrown
            assertFalse(true);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            new Date(-1, 1, 2022);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date", e.getMessage());
        }

        try {
            new Date(32, 1, 2022);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date", e.getMessage());
        }

        try {
            new Date(1, -1, 2022);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date", e.getMessage());
        }

        try {
            new Date(1, 13, 2022);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date", e.getMessage());
        }

        try {
            new Date(1, 1, -1);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date", e.getMessage());
        }

        try {
            new Date(1, 1, 10000);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date", e.getMessage());
        }
    }

    @Test
    public void testIsValidDate() {
        assertTrue(Date.isValidDate(1, 1, 1));
        assertTrue(Date.isValidDate(1, 1, 1582));
        assertTrue(Date.isValidDate(31, 12, 9999));
        assertTrue(Date.isValidDate(29, 2, 2020));
        assertFalse(Date.isValidDate(29, 2, 2021));
        assertFalse(Date.isValidDate(30, 2, 2020));
        assertFalse(Date.isValidDate(31, 4, 2020));
    }

    @Test
    public void testIsLeapYear() {
        assertFalse(Date.isLeapYear(1));
        assertTrue(Date.isLeapYear(4));
        assertFalse(Date.isLeapYear(100));
        assertTrue(Date.isLeapYear(400));
    }

    @Test
    public void testCompareTo() {
        // Création des dates à comparer
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(31, 12, 2021);
        Date date3 = new Date(1, 1, 2023);

        // Test de la méthode compareTo
        assertTrue(date1.compareTo(date2) > 0); // date1 est postérieure à date2
        assertTrue(date2.compareTo(date1) < 0); // date2 est antérieure à date1
        assertTrue(date1.compareTo(date3) < 0); // date1 est antérieure à date3
        assertTrue(date3.compareTo(date1) > 0); // date3 est postérieure à date1
        assertEquals(0, date1.compareTo(date1)); // date1 est égale à elle-même

        Date d1 = new Date(1, 1, 2022);
        Date d2 = new Date(1, 1, 2023);

        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);

        Date d12 = new Date(1, 1, 2022);
        Date d22 = new Date(1, 2, 2022);

        assertTrue(d12.compareTo(d22) < 0);
        assertTrue(d22.compareTo(d12) > 0);

        Date d13 = new Date(1, 1, 2022);
        Date d23 = new Date(2, 1, 2022);

        assertTrue(d13.compareTo(d23) < 0);
        assertTrue(d23.compareTo(d13) > 0);

    }


}