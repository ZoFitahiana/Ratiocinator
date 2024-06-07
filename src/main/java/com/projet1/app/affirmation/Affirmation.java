package com.projet1.app.affirmation;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Affirmation {
    private String phrase;
    public abstract Boolean getStatusAffirmation();

    public abstract String[] splitAffirmation();
}
