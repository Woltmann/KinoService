/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.performance;
import generated.kinoService.*;
import commands.*;
import java.util.Collection;
public class Performance_getBooking_Command extends ObjectCommand<Performance, Collection<Booking>>{
   private static final long serialVersionUID = -768005840L;
   public Performance_getBooking_Command(Performance receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getBooking();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
