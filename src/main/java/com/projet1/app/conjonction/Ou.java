package com.projet1.app.conjonction;

import com.projet1.app.affirmation.Affirmation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ou extends Affirmation {
    private Affirmation affirmation1;
    private Affirmation affirmation2;

    public Ou(Affirmation affirmation1, Affirmation affirmation2) {
        super(affirmation1.getPhrase() + " ou " + affirmation2.getPhrase());
        this.affirmation1 = affirmation1;
        this.affirmation2 = affirmation2;
    }

    @Override
    public Boolean getStatusAffirmation() {
        return affirmation1.getStatusAffirmation() || affirmation2.getStatusAffirmation();
    }
}



