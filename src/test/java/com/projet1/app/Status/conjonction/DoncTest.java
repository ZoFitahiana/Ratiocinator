package com.projet1.app.Status.conjonction;

import com.projet1.app.affirmation.Affirmation;
import com.projet1.app.affirmation.Mensonge;
import com.projet1.app.affirmation.Verite;
import com.projet1.app.affirmation.statuts.Status;
import com.projet1.app.conjonction.Donc;
import com.projet1.app.conjonction.Ou;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoncTest {
    @Test
    public void testLouEstBeauDoncLouEstPauvre() {
        Status status = new Status();
        Affirmation affirmation = new Donc(new Verite("Lou est beau."), new Mensonge("Lou est pauvre."));
        String resultat = status.CalculusRatiocinator(affirmation);
        assertEquals("faux", resultat);
    }

    @Test
    public void testLouEstPauvreDoncLouEstGenereux() {
        Status status = new Status();
        Affirmation affirmation = new Donc(new Mensonge("Lou est pauvre."), new Verite("Lou est généreux."));
        String resultat = status.CalculusRatiocinator(affirmation);
        assertEquals("vrai", resultat);
    }

}
