/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.film;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class Film_getPerformance_Command extends ObjectCommand<Film, Collection<Performance>>{
   private static final long serialVersionUID = -1113783797L;
   public Film_getPerformance_Command(Film receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPerformance();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
