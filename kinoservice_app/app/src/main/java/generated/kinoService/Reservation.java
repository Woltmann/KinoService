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
import generated.kinoService.relationControl.rese_SeatSupervisor;
import generated.kinoService.relationControl.rese_PerfSupervisor;
import generated.kinoService.relationControl.reservationClientSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.ReservationProxy;
import observation.Observable;
import generated.kinoService.proxies.IReservation;
import generated.kinoService.relationControl.*;
import generated.kinoService.proxies.*;
import src.db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import generated.kinoService.relationControl.reservationPerformanceSupervisor;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Reservation extends Observable implements java.io.Serializable, IReservation
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String valid;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Reservation(Integer id, Performance performance, Client client, String valid, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      reservationPerformanceSupervisor.getInstance().set(this, performance);
      reservationClientSupervisor.getInstance().set(this, client);
      this.valid = valid;
      if(objectOnly) return;
   }
   public static Reservation createFresh(Performance performance, Client client, String valid)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Reservation", "id, typeKey, valid", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Reservation").toString() + ", " + "'" + valid + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Reservation me = new Reservation(id, performance, client, valid, false);
      KinoService.getInstance().addReservationProxy(new ReservationProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getReservationCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Reservation toBeDeleted = KinoService.getInstance().getReservation(id);
      rese_SeatSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      reservationPerformanceSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      reservationClientSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoService.getInstance().getReservationCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("Reservation", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Reservation instantiateRuntimeCopy(ReservationProxy proxy, Performance performance, Client client, String valid)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Reservation(proxy.getId(), performance, client, valid, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Reservation getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Set<Seat> getSeat() throws PersistenceException{
      Set<Seat> result = new HashSet<>();
      for (ISeat i : rese_SeatSupervisor.getInstance().getSeat(this)) result.add(i.getTheObject());
      return result;
   }
   public void addToSeat(Seat arg) throws PersistenceException{
      rese_SeatSupervisor.getInstance().add(this, arg);
   }
   public boolean removeFromSeat(Seat arg) throws PersistenceException{
      return rese_SeatSupervisor.getInstance().remove(this, arg);
   }
   public Performance getPerformance() throws PersistenceException{
      return reservationPerformanceSupervisor.getInstance().getPerformance(this).getTheObject();
   }
   public void setPerformance(Performance newPerformance)throws PersistenceException{
      reservationPerformanceSupervisor.getInstance().change(this, this.getPerformance(), newPerformance);
   }
   public Client getClient() throws PersistenceException{
      return reservationClientSupervisor.getInstance().getClient(this).getTheObject();
   }
   public void setClient(Client newClient)throws PersistenceException{
      reservationClientSupervisor.getInstance().change(this, this.getClient(), newClient);
   }
   public String getValid() {
      return this.valid;
   }
   public void setValid(String newValid) throws PersistenceException{
      this.valid = newValid;
      try{KinoService.getInstance().getDmlExecuter().update("Reservation", "valid", "'" + newValid + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
