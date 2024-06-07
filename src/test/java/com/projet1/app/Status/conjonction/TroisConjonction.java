package com.projet1.app.Status.conjonction;

import com.projet1.app.affirmation.Affirmation;
import com.projet1.app.affirmation.Mensonge;
import com.projet1.app.affirmation.Verite;
import com.projet1.app.affirmation.statuts.Status;
import com.projet1.app.conjonction.Donc;
import com.projet1.app.conjonction.Et;
import com.projet1.app.conjonction.Ou;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroisConjonction {
    @Test
    public void testTripleConjonction() {
        Status status = new Status();
        Affirmation louEstBeauOuLouEstGenereux = new Ou(new Verite("Lou est beau."), new Verite("Lou est généreux."));
        Affirmation premierement = new Donc(louEstBeauOuLouEstGenereux, new Mensonge("Lou est pauvre."));
        Affirmation deuxiemement = new Ou(new Mensonge("Lou est pauvre."), new Verite("Lou est généreux."));
        Affirmation complexe = new Et(premierement, deuxiemement);
        String resultat = status.CalculusRatiocinator(complexe);
        assertEquals("faux", resultat); }

}
