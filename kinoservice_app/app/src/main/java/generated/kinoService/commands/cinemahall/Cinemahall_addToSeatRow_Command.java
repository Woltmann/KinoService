/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.cinemahall;
import generated.kinoService.*;
import commands.*;
public class Cinemahall_addToSeatRow_Command extends ObjectCommand<Cinemahall, Void>{
   private static final long serialVersionUID = 1137281609L;
   private SeatRow arg;
   public Cinemahall_addToSeatRow_Command(Cinemahall receiver, SeatRow arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.addToSeatRow(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public SeatRow arg(){return this.arg;}
}
