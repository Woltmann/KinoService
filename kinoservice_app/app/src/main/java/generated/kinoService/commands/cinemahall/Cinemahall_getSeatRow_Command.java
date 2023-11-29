/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.cinemahall;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class Cinemahall_getSeatRow_Command extends ObjectCommand<Cinemahall, Collection<SeatRow>>{
   private static final long serialVersionUID = 1521258349L;
   public Cinemahall_getSeatRow_Command(Cinemahall receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getSeatRow();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
