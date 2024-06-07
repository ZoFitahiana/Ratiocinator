package com.projet1.app.affirmation.statuts;

import com.projet1.app.affirmation.Affirmation;
import com.projet1.app.affirmation.Mensonge;
import com.projet1.app.affirmation.Verite;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Status {
     private Mensonge mensonge;
     private Verite verite;


}
