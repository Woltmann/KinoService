/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class getStateMachineCache_Command extends ServiceCommand<java.util.Map<Integer, generated.stateMachineService.proxies.StateMachineProxy>>{
   private static final long serialVersionUID = 862930788L;
   public getStateMachineCache_Command(){
      super();
   }
   public void execute(){
      try{this.result = StateMachineService.getInstance().getStateMachineCache();
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
}
