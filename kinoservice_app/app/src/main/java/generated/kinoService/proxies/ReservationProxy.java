/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.Reservation;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.Seat;
import java.util.Set;
import generated.kinoService.Performance;
import generated.kinoService.relationControl.reservationPerformanceSupervisor;
import generated.kinoService.Client;
import generated.kinoService.relationControl.reservationClientSupervisor;
public class ReservationProxy implements IReservation{
   private Integer id;
   private Optional<Reservation> theObject;
   public ReservationProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public ReservationProxy(Reservation theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Reservation getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Reservation";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IReservation)) return false;
      return ((IReservation)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Reservation load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Reservation", this.id);
         Performance performance = reservationPerformanceSupervisor.getInstance().getPerformance(this).getTheObject();
         Client client = reservationClientSupervisor.getInstance().getClient(this).getTheObject();
         String valid = rs.get().getString("valid");
         return Reservation.instantiateRuntimeCopy(this, performance, client, valid);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
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
   public Client getClient() throws PersistenceException{
      return this.getTheObject().getClient();
   }
   public void setClient(Client newClient)throws PersistenceException{
      this.getTheObject().setClient(newClient);
   }
   public String getValid() {
      return this.getTheObject().getValid();
   }
   public void setValid(String newValid) throws PersistenceException{
      this.getTheObject().setValid(newValid);
   }
}
