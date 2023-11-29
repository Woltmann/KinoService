/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.booking;
import generated.kinoService.*;
import commands.*;
public class Booking_setPerformance_Command extends ObjectCommand<Booking, Void>{
   private static final long serialVersionUID = 54651085L;
   private Performance arg;
   public Booking_setPerformance_Command(Booking receiver, Performance arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setPerformance(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Performance arg(){return this.arg;}
}
