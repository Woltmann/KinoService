/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.reservation;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class Reservation_getSeat_Command extends ObjectCommand<Reservation, Collection<Seat>>{
   private static final long serialVersionUID = 691363736L;
   public Reservation_getSeat_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeat();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
