package com.projet1.app.affirmation;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Verite extends Affirmation {
    public Verite(String phrase) {
        super(phrase);
    }

    @Override
    public Boolean getStatusAffirmation() {
        return true;
    }
}

