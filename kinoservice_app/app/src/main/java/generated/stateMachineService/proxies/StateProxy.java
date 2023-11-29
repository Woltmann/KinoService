/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.stateMachineService.StateMachineService;
import src.db.executer.*;
import generated.stateMachineService.State;
import java.sql.ResultSet;
import java.util.Optional;
public class StateProxy implements IState{
   private Integer id;
   private Optional<State> theObject;
   public StateProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public StateProxy(State theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public State getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "State";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IState)) return false;
      return ((IState)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private State load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = StateMachineService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("State", this.id);
         String name = rs.get().getString("name");
         Boolean isFinal = rs.get().getBoolean("isFinal");
         return State.instantiateRuntimeCopy(this, name, isFinal);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getName() {
      return this.getTheObject().getName();
   }
   public void setName(String newName) throws PersistenceException{
      this.getTheObject().setName(newName);
   }
   public Boolean getIsFinal() {
      return this.getTheObject().getIsFinal();
   }
   public void setIsFinal(Boolean newIsFinal) throws PersistenceException{
      this.getTheObject().setIsFinal(newIsFinal);
   }
}
