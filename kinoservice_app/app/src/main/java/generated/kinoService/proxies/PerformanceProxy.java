/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.proxies;
import src.db.executer.PersistenceException;
import java.util.Optional;
import generated.kinoService.KinoService;
import src.db.executer.*;
import generated.kinoService.Performance;
import java.sql.ResultSet;
import java.util.Optional;
import generated.kinoService.Film;
import generated.kinoService.relationControl.filmPerformanceSupervisor;
import generated.kinoService.Cinemahall;
import generated.kinoService.relationControl.perf_CiHaSupervisor;
import generated.kinoService.Reservation;
import java.util.Set;
import generated.kinoService.Booking;
public class PerformanceProxy implements IPerformance{
   private Integer id;
   private Optional<Performance> theObject;
   public PerformanceProxy(Integer id){
      this.id = id;
      this.theObject = Optional.empty();
   }
   public PerformanceProxy(Performance theObject) throws PersistenceException{
      this(theObject.getId());
      this.theObject = Optional.of(theObject);
   }
   public boolean isObjectPresent() {
      return this.theObject.isPresent();
   }
   public Performance getTheObject()
   {
      try{if(!this.isObjectPresent()) this.theObject = Optional.of(this.load());}catch(PersistenceException pe){assert false : "Fatal Error Occured when loading an existing object from DB: " + "Performance";}
      return this.theObject.get();
   }
   public Integer getId(){
      return this.id;
   }
   public boolean equals(Object o) {
      if(!(o instanceof IPerformance)) return false;
      return ((IPerformance)o).getId().equals(this.getId());
   }
   public int hashCode() {return this.getId().hashCode();}
   private Performance load() throws PersistenceException {
      Optional<ResultSet> rs = Optional.empty();
      try {
         rs = KinoService.getInstance().getDmlExecuter().selectIdSpecifiedCursorAleadyAtFirstRow("Performance", this.id);
         Film film = filmPerformanceSupervisor.getInstance().getFilm(this).getTheObject();
         Cinemahall assigendHall = perf_CiHaSupervisor.getInstance().getAssigendHall(this).getTheObject();
         return Performance.instantiateRuntimeCopy(this, film, assigendHall);
      } catch (Exception e) {throw new PersistenceException(e.getMessage());}
   }
   public Film getFilm() throws PersistenceException{
      return this.getTheObject().getFilm();
   }
   public void setFilm(Film newFilm)throws PersistenceException{
      this.getTheObject().setFilm(newFilm);
   }
   public Cinemahall getAssigendHall() throws PersistenceException{
      return this.getTheObject().getAssigendHall();
   }
   public void setAssigendHall(Cinemahall newAssigendHall)throws PersistenceException{
      this.getTheObject().setAssigendHall(newAssigendHall);
   }
   public Set<Reservation> getReservation() throws PersistenceException{
      return this.getTheObject().getReservation();
   }
   public Set<Booking> getBooking() throws PersistenceException{
      return this.getTheObject().getBooking();
   }
}
