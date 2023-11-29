/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.seat;
import generated.kinoService.*;
import commands.*;
public class Seat_delete_Command extends ObjectCommand<Seat, Void>{
   private static final long serialVersionUID = 1472612074L;
   public Seat_delete_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{Seat.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
