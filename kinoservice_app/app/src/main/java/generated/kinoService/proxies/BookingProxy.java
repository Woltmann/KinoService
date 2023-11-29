/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.Booking;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.Client;
import generated.kinoService.relationControl.bookingClientSupervisor;
import generated.kinoService.Seat;
import java.util.Set;
import generated.kinoService.Performance;
import generated.kinoService.relationControl.bookingPerformanceSupervisor;
public class BookingProxy implements IBooking{
   private Integer id;
   private Optional<Booking> theObject;
   public BookingProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public BookingProxy(Booking theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Booking getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Booking";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBooking)) return false;
      return ((IBooking)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Booking load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Booking", this.id);
         Client client = bookingClientSupervisor.getInstance().getClient(this).getTheObject();
         Performance performance = bookingPerformanceSupervisor.getInstance().getPerformance(this).getTheObject();
         return Booking.instantiateRuntimeCopy(this, client, performance);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Client getClient() throws PersistenceException{
      return this.getTheObject().getClient();
   }
   public void setClient(Client newClient)throws PersistenceException{
      this.getTheObject().setClient(newClient);
   }
   public Set<Seat> getSeat() throws PersistenceException{
      return this.getTheObject().getSeat();
   }
   public void addToSeat(Seat arg) throws PersistenceException{
      this.getTheObject().addToSeat(arg);
   }
   public boolean removeFromSeat(Seat arg) throws PersistenceException{
      return this.getTheObject().removeFromSeat(arg);
   }
   public Performance getPerformance() throws PersistenceException{
      return this.getTheObject().getPerformance();
   }
   public void setPerformance(Performance newPerformance)throws PersistenceException{
      this.getTheObject().setPerformance(newPerformance);
   }
}
