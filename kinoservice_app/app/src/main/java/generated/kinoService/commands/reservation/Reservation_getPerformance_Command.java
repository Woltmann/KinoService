/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.reservation;
import generated.kinoService.*;
import commands.*;
public class Reservation_getPerformance_Command extends ObjectCommand<Reservation, Performance>{
   private static final long serialVersionUID = -1761045628L;
   public Reservation_getPerformance_Command(Reservation receiver){
      super(receiver);
   }
   public void execute(){
      try{this.result = this.receiver.getPerformance();
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
