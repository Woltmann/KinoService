/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.reservation;
import generated.kinoService.*;
import commands.*;
public class Reservation_getClient_Command extends ObjectCommand<Reservation, Client>{
   private static final long serialVersionUID = -1561808701L;
   public Reservation_getClient_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getClient();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
