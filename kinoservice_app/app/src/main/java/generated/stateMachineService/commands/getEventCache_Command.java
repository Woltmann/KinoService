/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class getEventCache_Command extends ServiceCommand<java.util.Map<Integer, generated.stateMachineService.proxies.EventProxy>>{
   private static final long serialVersionUID = 574243495L;
   public getEventCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = StateMachineService.getInstance().getEventCache();
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
