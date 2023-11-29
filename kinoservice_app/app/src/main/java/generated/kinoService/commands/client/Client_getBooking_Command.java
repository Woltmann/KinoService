/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.client;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class Client_getBooking_Command extends ObjectCommand<Client, Collection<Booking>>{
   private static final long serialVersionUID = 967311819L;
   public Client_getBooking_Command(Client receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getBooking();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
