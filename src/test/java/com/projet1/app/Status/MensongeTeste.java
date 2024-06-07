package com.projet1.app.Status;

import com.projet1.app.affirmation.Affirmation;
import com.projet1.app.affirmation.Mensonge;
import com.projet1.app.affirmation.statuts.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MensongeTeste {
    @Test
    public void testMensonge() {
        Status status = new Status();
        Affirmation affirmation = new Mensonge("Lou est pauvre.");
        String resultat = status.CalculusRatiocinator(affirmation);
        assertEquals("faux", resultat);
    }
}
