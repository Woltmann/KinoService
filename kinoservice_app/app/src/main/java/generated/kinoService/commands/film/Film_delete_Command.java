/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.film;
import generated.kinoService.*;
import commands.*;
public class Film_delete_Command extends ObjectCommand<Film, Void>{
   private static final long serialVersionUID = 280376314L;
   public Film_delete_Command(Film receiver){
      super(receiver);
   }
   public void execute(){
      try{Film.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
