/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.seat;
import generated.kinoService.*;
import commands.*;
public class Seat_setSeatRow_Command extends ObjectCommand<Seat, Void>{
   private static final long serialVersionUID = 580382097L;
   private SeatRow arg;
   public Seat_setSeatRow_Command(Seat receiver, SeatRow arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setSeatRow(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public SeatRow arg(){return this.arg;}
}
