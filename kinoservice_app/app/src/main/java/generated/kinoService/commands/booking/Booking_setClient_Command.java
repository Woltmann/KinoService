/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.booking;
import generated.kinoService.*;
import commands.*;
public class Booking_setClient_Command extends ObjectCommand<Booking, Void>{
   private static final long serialVersionUID = -2059045216L;
   private Client arg;
   public Booking_setClient_Command(Booking receiver, Client arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setClient(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Client arg(){return this.arg;}
}
