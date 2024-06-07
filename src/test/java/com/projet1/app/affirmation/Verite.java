package com.projet1.app.affirmation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Verite extends Affirmation {
    public Verite(String phrase) {
        super(phrase);
    }

    @Override
    public Boolean getStatusAffirmation() {
        return true;
    }
}
