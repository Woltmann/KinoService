/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.seat;
import generated.kinoService.*;
import commands.*;
public class Seat_getSeatRow_Command extends ObjectCommand<Seat, SeatRow>{
   private static final long serialVersionUID = -714860063L;
   public Seat_getSeatRow_Command(Seat receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeatRow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
