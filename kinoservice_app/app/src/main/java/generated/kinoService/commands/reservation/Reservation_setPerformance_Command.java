/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.reservation;
import generated.kinoService.*;
import commands.*;
public class Reservation_setPerformance_Command extends ObjectCommand<Reservation, Void>{
   private static final long serialVersionUID = 723656818L;
   private Performance arg;
   public Reservation_setPerformance_Command(Reservation receiver, Performance arg){
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
