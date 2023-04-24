package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MainTest {

    @Test
    void isAllowedTestForbiddenPW() {
        assertEquals(false, Main.isAllowed("12345678"));
    }

    @Test
    void isAllowedTestNoSpecialCharAndNumAndToShort() {
        assertEquals(false, Main.isAllowed("Banane"));
    }

    @Test
    void isAllowedTestNoSpecialChar() {
        assertEquals(false, Main.isAllowed("IrgendwasOhneSonderzeichen213"));
    }

    @Test
    void isAllowedTestToShort() {
        assertEquals(false, Main.isAllowed("Al!35"));
    }

    @Test
    void isAllowedTestNoLowerCase() {
        assertEquals(false, Main.isAllowed("YAYPASSWORD123!!"));
    }

    @Test
    void isAllowedTestNoUpperCase() {
        assertFalse(Main.isAllowed("flüsterpasswort123!"));
    }

    @Test
    void isAllowedTestCorrect() {
        assertEquals(true, Main.isAllowed("VorblidlichesPasswort123!§%"));
    }

}