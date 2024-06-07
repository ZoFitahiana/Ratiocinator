package com.projet1.app.affirmation.statuts;

import com.projet1.app.affirmation.Affirmation;
import com.projet1.app.affirmation.Mensonge;
import com.projet1.app.affirmation.Verite;
import com.projet1.app.conjonction.Et;
import com.projet1.app.conjonction.Ou;
import com.projet1.app.conjonction.Donc;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Status {
     private Mensonge mensonge;
     private Verite verite;

     public String CalculusRatiocinator(Affirmation affirmation) {
          if (affirmation instanceof Verite) {
               return "vrai";
          } else if (affirmation instanceof Mensonge) {
               return "faux";
          } else if (affirmation instanceof Et) {
               Et et = (Et) affirmation;
               String status1 = CalculusRatiocinator(et.getAffirmation1());
               String status2 = CalculusRatiocinator(et.getAffirmation2());
               if (status1.equals("vrai") && status2.equals("vrai")) {
                    return "vrai";
               } else if (status1.equals("faux") || status2.equals("faux")) {
                    return "faux";
               } else {
                    return "jenesaispas";
               }
          } else if (affirmation instanceof Ou) {
               Ou ou = (Ou) affirmation;
               String status1 = CalculusRatiocinator(ou.getAffirmation1());
               String status2 = CalculusRatiocinator(ou.getAffirmation2());
               if (status1.equals("vrai") || status2.equals("vrai")) {
                    return "vrai";
               } else if (status1.equals("faux") && status2.equals("faux")) {
                    return "faux";
               } else {
                    return "jenesaispas";
               }
          } else if (affirmation instanceof Donc) {
               Donc donc = (Donc) affirmation;
               String status1 = CalculusRatiocinator(donc.getAffirmation1());
               String status2 = CalculusRatiocinator(donc.getAffirmation2());
               if (status1.equals("vrai") && status2.equals("faux")) {
                    return "faux";
               } else if (status1.equals("faux") || status2.equals("vrai")) {
                    return "vrai";
               } else {
                    return "jenesaispas";
               }
          }
          return "jenesaispas";
     }
}
