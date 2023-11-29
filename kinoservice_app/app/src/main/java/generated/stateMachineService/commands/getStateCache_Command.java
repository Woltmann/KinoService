/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class getStateCache_Command extends ServiceCommand<java.util.Map<Integer, generated.stateMachineService.proxies.StateProxy>>{
   private static final long serialVersionUID = -1821501353L;
   public getStateCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = StateMachineService.getInstance().getStateCache();
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
