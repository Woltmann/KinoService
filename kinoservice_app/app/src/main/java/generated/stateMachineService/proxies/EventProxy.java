/**--- Generated at Tue Oct 10 19:50:13 CEST 2023 
 * --- No Change Allowed!  
 */
package generated.stateMachineService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.stateMachineService.StateMachineService;
import src.db.executer.*;
import generated.stateMachineService.Event;
import java.sql.ResultSet;
import java.util.Optional;
public class EventProxy implements IEvent{
   private Integer id;
   private Optional<Event> theObject;
   public EventProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public EventProxy(Event theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Event getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Event";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IEvent)) return false;
      return ((IEvent)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Event load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = StateMachineService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Event", this.id);
         String label = rs.get().getString("label");
         return Event.instantiateRuntimeCopy(this, label);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public String getLabel() {
      return this.getTheObject().getLabel();
   }
   public void setLabel(String newLabel) throws PersistenceException{
      this.getTheObject().setLabel(newLabel);
   }
}
