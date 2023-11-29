/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.seatRow;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class SeatRow_getSeat_Command extends ObjectCommand<SeatRow, Collection<Seat>>{
   private static final long serialVersionUID = -1459373944L;
   public SeatRow_getSeat_Command(SeatRow receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeat();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
