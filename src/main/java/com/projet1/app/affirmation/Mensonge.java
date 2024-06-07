package com.projet1.app.affirmation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Mensonge extends Affirmation {
    public Mensonge(String phrase) {
        super(phrase);
    }

    @Override
    public Boolean getStatusAffirmation() {
        return false;
    }

}

