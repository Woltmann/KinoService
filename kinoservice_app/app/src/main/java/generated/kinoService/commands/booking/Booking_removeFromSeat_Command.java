/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.booking;
import generated.kinoService.*;
import commands.*;
public class Booking_removeFromSeat_Command extends ObjectCommand<Booking, Boolean>{
   private static final long serialVersionUID = -1570758824L;
   private Seat arg;
   public Booking_removeFromSeat_Command(Booking receiver, Seat arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromSeat(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Seat arg(){return this.arg;}
}
