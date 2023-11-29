/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.cinemahall;
import generated.kinoService.*;
import commands.*;
public class Cinemahall_removeFromSeatRow_Command extends ObjectCommand<Cinemahall, Boolean>{
   private static final long serialVersionUID = 408793175L;
   private SeatRow arg;
   public Cinemahall_removeFromSeatRow_Command(Cinemahall receiver, SeatRow arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.result = this.receiver.removeFromSeatRow(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public SeatRow arg(){return this.arg;}
}
