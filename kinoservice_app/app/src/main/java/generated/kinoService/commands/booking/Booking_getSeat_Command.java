/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.booking;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class Booking_getSeat_Command extends ObjectCommand<Booking, Collection<Seat>>{
   private static final long serialVersionUID = -759414860L;
   public Booking_getSeat_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeat();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
