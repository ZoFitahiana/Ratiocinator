package com.projet1.app.Status;

import com.projet1.app.affirmation.Affirmation;
import com.projet1.app.affirmation.Verite;
import com.projet1.app.affirmation.statuts.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeriteTeste {
    @Test
    public void testVerite() {
        Status status = new Status();
        Affirmation affirmation = new Verite("Lou est beau.");
        String resultat = status.CalculusRatiocinator(affirmation);
        assertEquals("vrai", resultat);
    }
}
