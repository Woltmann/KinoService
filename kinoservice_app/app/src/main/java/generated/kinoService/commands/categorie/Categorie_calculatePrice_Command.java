/**--- Generated at Sat Nov 18 18:54:54 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.categorie;
import generated.kinoService.*;
import commands.*;
public class Categorie_calculatePrice_Command extends ObjectCommand<Categorie, Integer>{
   private static final long serialVersionUID = -84642608L;
   public Categorie_calculatePrice_Command(Categorie receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.calculatePrice();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
