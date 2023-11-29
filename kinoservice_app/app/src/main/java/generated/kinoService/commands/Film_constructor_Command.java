/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class Film_constructor_Command extends ServiceCommand<Film>{
   private static final long serialVersionUID = 937366336L;
   private String  titel;
   private String  descritpion;
   public Film_constructor_Command(String  titel, String  descritpion){
      super();
      this.titel = titel;
      this.descritpion = descritpion;
   }
   public void execute(){
      try{this.result = Film.createFresh(titel, descritpion);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public String  titel(){return titel;}
   public String  descritpion(){return descritpion;}
}
