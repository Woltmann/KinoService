/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.performance;
import generated.kinoService.*;
import commands.*;
public class Performance_setAssigendHall_Command extends ObjectCommand<Performance, Void>{
   private static final long serialVersionUID = -413468684L;
   private Cinemahall arg;
   public Performance_setAssigendHall_Command(Performance receiver, Cinemahall arg){
      super(receiver);
      this.arg = arg;
   }
   public void execute(){
      try{this.receiver.setAssigendHall(arg);
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
   public Cinemahall arg(){return this.arg;}
}
