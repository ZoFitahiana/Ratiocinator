package com.projet1.app.conjonction;

import com.projet1.app.affirmation.Affirmation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Ou extends Affirmation {
    private Affirmation affirmation1;
    private Affirmation affirmation2;
    @Override
    public Boolean getStatusAffirmation() {
        return affirmation1.getStatusAffirmation() || affirmation2.getStatusAffirmation();
    }
}


