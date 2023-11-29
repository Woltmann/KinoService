/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.reservation;
import generated.kinoService.*;
import commands.*;
public class Reservation_setClient_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = 830974698L;
   private Client arg;
   public Reservation_setClient_Command(Reservation receiver, Client arg){
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
