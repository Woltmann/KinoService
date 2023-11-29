/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.booking;
import generated.kinoService.*;
import commands.*;
public class Booking_getClient_Command extends ObjectCommand<Booking, Client>{
   private static final long serialVersionUID = -1969151617L;
   public Booking_getClient_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getClient();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
