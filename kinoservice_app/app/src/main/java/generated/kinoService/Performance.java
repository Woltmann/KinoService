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
import generated.kinoService.proxies.IReservation;
import generated.kinoService.relationControl.reservationPerformanceSupervisor;
import generated.kinoService.proxies.IBooking;
import generated.kinoService.relationControl.bookingPerformanceSupervisor;
import generated.kinoService.relationControl.filmPerformanceSupervisor;
import generated.kinoService.relationControl.perf_CiHaSupervisor;
import src.db.executer.PersistenceExecuterFactory;
import generated.kinoService.proxies.PerformanceProxy;
import observation.Observable;
import generated.kinoService.proxies.IPerformance;
import generated.kinoService.relationControl.*;
import generated.kinoService.proxies.*;
import src.db.executer.PersistenceException;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
//20 ===== Editable : Your Import Section =========

//25 ===== GENERATED:      Header Section =========
public class Performance extends Observable implements java.io.Serializable, IPerformance
{
   //30 ===== GENERATED:      Attribute Section ======
   private Integer id;
   //40 ===== Editable : Your Attribute Section ======
   
   //50 ===== GENERATED:      Constructor ============
   private Performance(Integer id, Film film, Cinemahall assigendHall, boolean objectOnly)
   throws PersistenceException{
      super();
      this.setId(id);
      filmPerformanceSupervisor.getInstance().set(this, film);
      perf_CiHaSupervisor.getInstance().set(this, assigendHall);
      if(objectOnly) return;
   }
   public static Performance createFresh(Film film, Cinemahall assigendHall)throws PersistenceException{
      src.db.executer.PersistenceDMLExecuter dmlExecuter = KinoService.getInstance().getDmlExecuter();
      Integer id = dmlExecuter.getNextId();
      try{
         dmlExecuter.insertInto("Performance", "id, typeKey", 
         id.toString() + ", " + PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().getTypeKey("KinoService", "Performance").toString());
      }catch(SQLException|NoConnectionException e){throw new PersistenceException(e.getMessage());}
      Performance me = new Performance(id, film, assigendHall, false);
      KinoService.getInstance().addPerformanceProxy(new PerformanceProxy(me));
      return me;
   }
   public static void delete(Integer id) throws ConstraintViolation, SQLException, NoConnectionException {
      if(!KinoService.getInstance().getPerformanceCache().containsKey(id))throw new ConstraintViolation("Deletion not possible: " + "id " + id + " does not exist!");
      Performance toBeDeleted = KinoService.getInstance().getPerformance(id);
      List<IReservation> ownersInreservationPerformance = reservationPerformanceSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInreservationPerformance.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association reservationPerformance");
      reservationPerformanceSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      List<IBooking> ownersInbookingPerformance = bookingPerformanceSupervisor.getInstance().getRelationData().getRelatedSources(toBeDeleted);
      if(ownersInbookingPerformance.size()>0) throw new ConstraintViolation(" Deletion not possible: Object is still referenced within TotalMap-Association bookingPerformance");
      bookingPerformanceSupervisor.getInstance().getRelationData().removeAllPairsWithTarget(toBeDeleted);
      filmPerformanceSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      perf_CiHaSupervisor.getInstance().getRelationData().removeAllPairsWithSource(toBeDeleted);
      KinoService.getInstance().getPerformanceCache().remove(id);
      KinoService.getInstance().getDmlExecuter().delete("Performance", id);
   }
   /** Caution: A Call to this Method Requires to add any newly instantiated Object to its Cache! */
   public static Performance instantiateRuntimeCopy(PerformanceProxy proxy, Film film, Cinemahall assigendHall)throws PersistenceException{
      if(proxy.isObjectPresent()) return proxy.getTheObject();
      return new Performance(proxy.getId(), film, assigendHall, true);
   }
   //60 ===== Editable : Your Constructors ===========
   
   //70 ===== GENERATED:      Feature Access =========
   public Performance getTheObject(){
      return this;
   }
   public Integer getId(){
      return this.id;
   }
   protected void setId(Integer id){
      this.id = id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IPerformance)) return false;
      return ((IPerformance)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   public Film getFilm() throws PersistenceException{
      return filmPerformanceSupervisor.getInstance().getFilm(this).getTheObject();
   }
   public void setFilm(Film newFilm)throws PersistenceException{
      filmPerformanceSupervisor.getInstance().change(this, this.getFilm(), newFilm);
   }
   public Cinemahall getAssigendHall() throws PersistenceException{
      return perf_CiHaSupervisor.getInstance().getAssigendHall(this).getTheObject();
   }
   public void setAssigendHall(Cinemahall newAssigendHall)throws PersistenceException{
      perf_CiHaSupervisor.getInstance().change(this, this.getAssigendHall(), newAssigendHall);
   }
   public Set<Reservation> getReservation() throws PersistenceException{
      Set<Reservation> result = new HashSet<>();
      for (IReservation i : reservationPerformanceSupervisor.getInstance().getReservation(this)) result.add(i.getTheObject());
      return result;
   }
   public Set<Booking> getBooking() throws PersistenceException{
      Set<Booking> result = new HashSet<>();
      for (IBooking i : bookingPerformanceSupervisor.getInstance().getBooking(this)) result.add(i.getTheObject());
      return result;
   }
   //80 ===== Editable : Your Operations =============
   /**
    * Liefert die aktuellen Einnahmen für eine Aufführung
    */
      public Integer calculateRevenuePerformance(){
   	   int revenuePerformance = 0;
   	   Set<Booking> bookings = this.getBooking();
   	   for (Booking booking :bookings) {
   		   Set<Seat> seats = booking.getSeat();
   		   for (Seat seat :seats) {
   			   revenuePerformance += seat.getSeatRow().getCategorie().calculatePrice();
   		   }
   	   }
   	   return revenuePerformance;
      }
   /**
    * Setzt den Status des KinoSaals auf besetzt
    */
      public void assignCinemaHall(){
         this.getAssigendHall().setIsFree(false);
         return;
      }
   /**
    * Setzt den Status des KinoSaal auf frei
    */
      public void releaseCinemaHall(){
         this.getAssigendHall().setIsFree(true);
         return;
      }   
	/**
	 * Liefert die Anzahl der nicht gebuchten oder reservierten Sitze
	 */
	   public Collection<Seat> getFreeSeats(){
		   Set<SeatRow> performanceSeatRows = this.getAssigendHall().getSeatRow();
		   	Set<Booking> bookings = this.getBooking();
		   	Set<Reservation> reservations = this.getReservation();
	    	Set<Seat> bookedSeats = new HashSet<>();
	    	Set<Seat> freeSeats = new HashSet<>();
		   	for (SeatRow seatRows : performanceSeatRows) {
			   	freeSeats.addAll(seatRows.getSeat());		   	
		   	}
		   	for (Booking booking :bookings) {
		   		bookedSeats.addAll(booking.getSeat());
		   	}
		   	for (Reservation reservation :reservations) {
		   		bookedSeats.addAll(reservation.getSeat());
		   	}
	    	freeSeats.removeAll(bookedSeats);
	      return freeSeats;
	   }
//90 ===== GENERATED: End of Your Operations ======
}
