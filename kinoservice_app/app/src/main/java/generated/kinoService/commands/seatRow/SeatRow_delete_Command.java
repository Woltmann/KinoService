/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.seatRow;
import generated.kinoService.*;
import commands.*;
public class SeatRow_delete_Command extends ObjectCommand<SeatRow, Void>{
   private static final long serialVersionUID = 1309924265L;
   public SeatRow_delete_Command(SeatRow receiver){
      super(receiver);
   }
   public void execute(){
      try{SeatRow.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
