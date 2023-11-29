/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoService;
//10 ===== GENERATED:      Import Section =========
import java.sql.SQLException;
import src.db.connection.NoConnectionException;
import src.db.executer.PersistenceExecuterFactory;
import exceptions.ConstraintViolation;
import java.util.List;
import generated.kinoService.proxies.IClient;
import generated.kinoService.relationControl.bookingClientSupervisor;
import generated.kinoService.relationControl.book_SeatSupervisor;
import generated.kinoService.relationControl.book_PerfSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.BookingProxy;
import observation.Observable;
import generated.kinoService.proxies.IBooking;
import generated.kinoService.relationControl.*;
import generated.kinoService.proxies.*;
import src.db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import generated.kinoService.relationControl.bookingPerformanceSupervisor;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Booking extends Observable implements java.io.Serializable, IBooking
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Booking(Integer id, Client client, Performance performance, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      bookingClientSupervisor.getInstance().set(this, client);
      bookingPerformanceSupervisor.getInstance().set(this, performance);
      if(objectOnly) return;
   }
   public static Booking createFresh(Client client, Performance performance)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Booking", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Booking").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Booking me = new Booking(id, client, performance, false);
      KinoService.getInstance().addBookingProxy(new BookingProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getBookingCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Booking toBeDeleted = KinoService.getInstance().getBooking(id);
      bookingClientSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      book_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      bookingPerformanceSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoService.getInstance().getBookingCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("Booking", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Booking instantiateRuntimeCopy(BookingProxy proxy, Client client, Performance performance)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Booking(proxy.getId(), client, performance, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Booking getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IBooking)) return false;
      return ((IBooking)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Client getClient() throws PersistenceException{
      return bookingClientSupervisor.getInstance().getClient(this).getTheObject();
   }
   public void setClient(Client newClient)throws PersistenceException{
      bookingClientSupervisor.getInstance().change(this, this.getClient(), newClient);
   }
   public Set<Seat> getSeat() throws PersistenceException{
      Set<Seat> result = new HashSet<>();
      for (ISeat i : book_SeatSupervisor.getInstance().getSeat(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSeat(Seat arg) throws PersistenceException{
      book_SeatSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSeat(Seat arg) throws PersistenceException{
      return book_SeatSupervisor.getInstance().remove(this, arg);
   }
   public Performance getPerformance() throws PersistenceException{
      return bookingPerformanceSupervisor.getInstance().getPerformance(this).getTheObject();
   }
   public void setPerformance(Performance newPerformance)throws PersistenceException{
      bookingPerformanceSupervisor.getInstance().change(this, this.getPerformance(), newPerformance);
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
