/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.booking;
import generated.kinoService.*;
import commands.*;
public class Booking_getPerformance_Command extends ObjectCommand<Booking, Performance>{
   private static final long serialVersionUID = 42281402L;
   public Booking_getPerformance_Command(Booking receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPerformance();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
