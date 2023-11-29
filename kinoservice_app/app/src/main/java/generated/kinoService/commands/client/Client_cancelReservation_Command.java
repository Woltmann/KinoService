/**--- Generated at Sat Nov 18 19:53:13 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.client;
import generated.kinoService.*;
import commands.*;
public class Client_cancelReservation_Command extends ObjectCommand<Client, Void>{
   private static final long serialVersionUID = -2086096109L;
   private Reservation reservation;
   public Client_cancelReservation_Command(Client receiver, Reservation reservation){
      super(receiver);
      this.reservation = reservation;
   }
   public void execute(){
      try{this.receiver.cancelReservation(reservation);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Reservation reservation(){return this.reservation;}
}
