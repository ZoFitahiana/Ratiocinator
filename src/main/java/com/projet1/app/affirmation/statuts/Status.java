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
               String[] affirmations = et.splitAffirmation();
               String status1 = CalculusRatiocinator(creationAffirmation(affirmations[0]));
               String status2 = CalculusRatiocinator(creationAffirmation(affirmations[1]));
               if (status1.equals("vrai") && status2.equals("vrai")) {
                    return "vrai";
               } else if (status1.equals("faux") || status2.equals("faux")) {
                    return "faux";
               } else {
                    return "jenesaispas";
               }
          } else if (affirmation instanceof Ou) {
               Ou ou = (Ou) affirmation;
               String[] affirmations = ou.splitAffirmation();
               String status1 = CalculusRatiocinator(creationAffirmation(affirmations[0]));
               String status2 = CalculusRatiocinator(creationAffirmation(affirmations[1]));
               if (status1.equals("vrai") || status2.equals("vrai")) {
                    return "vrai";
               } else if (status1.equals("faux") && status2.equals("faux")) {
                    return "faux";
               } else {
                    return "jenesaispas";
               }
          } else if (affirmation instanceof Donc) {
               Donc donc = (Donc) affirmation;
               String[] affirmations = donc.splitAffirmation();
               String status1 = CalculusRatiocinator(creationAffirmation(affirmations[0]));
               String status2 = CalculusRatiocinator(creationAffirmation(affirmations[1]));
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

     private Affirmation creationAffirmation(String phrase) {
          String phraseLowerCase = phrase.toLowerCase();
          if (phraseLowerCase.contains("donc")) {
               int doncIndex = phraseLowerCase.indexOf("donc");
               String phraseAvantDonc = phrase.substring(0, doncIndex).trim();
               String phraseApresDonc = phrase.substring(doncIndex + "donc".length()).trim();
               return new Donc(creationAffirmation(phraseAvantDonc), creationAffirmation(phraseApresDonc));
          } else if (phraseLowerCase.contains("ou")) {
               int ouIndex = phraseLowerCase.indexOf("ou");
               String phraseAvantOu = phrase.substring(0, ouIndex).trim();
               String phraseApresOu = phrase.substring(ouIndex + "ou".length()).trim();
               return new Ou(creationAffirmation(phraseAvantOu), creationAffirmation(phraseApresOu));
          } else if (phraseLowerCase.contains("et")) {
               int etIndex = phraseLowerCase.indexOf("et");
               String phraseAvantEt = phrase.substring(0, etIndex).trim();
               String phraseApresEt = phrase.substring(etIndex + "et".length()).trim();
               return new Et(creationAffirmation(phraseAvantEt), creationAffirmation(phraseApresEt));
          } else {
               return new Verite(phrase);}
     }


}

