/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.client;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class Client_getReservation_Command extends ObjectCommand<Client, Collection<Reservation>>{
   private static final long serialVersionUID = -1042632015L;
   public Client_getReservation_Command(Client receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getReservation();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
