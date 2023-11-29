/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands.cinemahall;
import generated.kinoService.*;
import commands.*;
public class Cinemahall_delete_Command extends ObjectCommand<Cinemahall, Void>{
   private static final long serialVersionUID = 1375407708L;
   public Cinemahall_delete_Command(Cinemahall receiver){
      super(receiver);
   }
   public void execute(){
      try{Cinemahall.delete(receiver.getId());
      }catch(Exception e){this.e = e;
      }finally{this.receiver.notifyObservers(this);}
   }
}
