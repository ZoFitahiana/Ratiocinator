package com.projet1.app.Status.conjonction;
import com.projet1.app.affirmation.Affirmation;
import com.projet1.app.affirmation.Mensonge;
import com.projet1.app.affirmation.Verite;
import com.projet1.app.affirmation.statuts.Status;
import com.projet1.app.conjonction.Et;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtTeste {
    @Test
    public void testLouEstPauvreEtLouEstGenereux() {
        Status status = new Status();
        Affirmation affirmation = new Et(new Mensonge("Lou est pauvre."), new Verite("Lou est généreux."));
        String resultat = status.CalculusRatiocinator(affirmation);
        assertEquals("faux", resultat);
    }

}
