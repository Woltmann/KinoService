/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.commands;
import generated.stateMachineService.*;
import commands.*;
public class State_constructor_Command extends ServiceCommand<State>{
   private static final long serialVersionUID = -931105602L;
   private String  name;
   private Boolean  isFinal;
   public State_constructor_Command(String  name, Boolean  isFinal){
      super();
      this.name = name;
      this.isFinal = isFinal;
   }
   public void execute(){
      try{this.result = State.createFresh(name, isFinal);
      }catch(Exception e){this.e = e;
      }finally{StateMachineService.getInstance().notifyObservers(this);}
   }
   public String  name(){return name;}
   public Boolean  isFinal(){return isFinal;}
}
