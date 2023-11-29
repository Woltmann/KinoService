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
import generated.kinoService.proxies.IReservation;
import generated.kinoService.relationControl.reservationClientSupervisor;
import generated.kinoService.relationControl.bookingClientSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.ClientProxy;
import observation.Observable;
import generated.kinoService.proxies.IClient;
import generated.kinoService.relationControl.*;
import generated.kinoService.proxies.*;
import src.db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import generated.kinoService.proxies.IBooking;
import java.util.List;
//20 ===== Editable : Your Import Section =========
import java.util.List;
//25 ===== GENERATED:      Header Section =========
public class Client extends Observable implements java.io.Serializable, IClient
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   private String name;
   private String email;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Client(Integer id, String name, String email, boolean objectOnly)
   {
      super();
      this.setId(id);
      this.name = name;
      this.email = email;
      if(objectOnly) return;
   }
   public static Client createFresh(String name, String email)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Client", "id, typeKey, name, email", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Client").toString() + ", " + "'" + name + "'" + ", " + "'" + email + "'");
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Client me = new Client(id, name, email, false);
      KinoService.getInstance().addClientProxy(new ClientProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getClientCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Client toBeDeleted = KinoService.getInstance().getClient(id);
      List<IReservation> ownersInreservationClient = reservationClientSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInreservationClient.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association reservationClient");
      reservationClientSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      List<IBooking> ownersInbookingClient = bookingClientSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInbookingClient.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association bookingClient");
      bookingClientSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      KinoService.getInstance().getClientCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("Client", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Client instantiateRuntimeCopy(ClientProxy proxy, String name, String email){
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Client(proxy.getId(), name, email, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Client getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IClient)) return false;
      return ((IClient)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public String getName() {
      return this.name;
   }
   public void setName(String newName) throws PersistenceException{
      this.name = newName;
      try{KinoService.getInstance().getDmlExecuter().update("Client", "name", "'" + newName + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public String getEmail() {
      return this.email;
   }
   public void setEmail(String newEmail) throws PersistenceException{
      this.email = newEmail;
      try{KinoService.getInstance().getDmlExecuter().update("Client", "email", "'" + newEmail + "'", this.getId());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
   }
   public Set<Reservation> getReservation() throws PersistenceException{
      Set<Reservation> result = new HashSet<>();
      for (IReservation i : reservationClientSupervisor.getInstance().getReservation(this)) result.add(i.getTheObject());
      return result;
   }
   public Set<Booking> getBooking() throws PersistenceException{
      Set<Booking> result = new HashSet<>();
      for (IBooking i : bookingClientSupervisor.getInstance().getBooking(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
/**
 * Bucht die ausgewählten Plätze für einen Kunden in der ausgewählten Aufführung
 */
   public void booking(Collection<Seat> seat, Performance performance){
	  Booking newBooking = Booking.createFresh(this, performance);
	  for (Seat seatBooking : seat) {
		  newBooking.addToSeat(seatBooking);
		  }
	  System.out.println("Ihre Buchung mit ID " + newBooking.getId() + " wurde erstellt.");
   }
/**
 * Reserviert die ausgewählten Plätze für den Kunden in der ausgewählten Aufführung
 */
   public void reserve(Collection<Seat> seat, Performance performance){
	   Reservation newReservation = Reservation.createFresh(performance, this, "Die Reservierung ist 3 Tage gültig");
	   for (Seat seatReservation : seat) {
		  newReservation.addToSeat(seatReservation);
	   }
	   System.out.println("Ihre Reservierung mit ID " + newReservation.getId() + " wurde erstellt.");      
   }
/**
 * Gibt die Reservierung des Kunden wieder frei
 */
   public void cancelReservation(Reservation reservation){
	   try {
		    Set<Seat> seats = reservation.getSeat();
		    for (Seat seat : seats) {
		    	reservation.removeFromSeat(seat);
		    }
		    int reservationID = reservation.getId();
			Reservation.delete(reservationID);
			System.out.println("Die Reservierung mit der ID " + reservationID + " wurde erfolgreich storniert.");
		    } catch (ConstraintViolation e) {
		        System.out.println("Stornierung nicht möglich: " + e.getMessage());
		    } catch (SQLException e) {
		        System.out.println("Ein Datenbankfehler ist aufgetreten: " + e.getMessage());
		    } catch (NoConnectionException e) {
		        System.out.println("Keine Verbindung zur Datenbank: " + e.getMessage());
		}
   }
//90 ===== GENERATED: End of Your Operations ======
}
