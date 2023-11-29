/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- Mode = Integrated Database 
 * --- Change only in Editable Sections!  
 * --- Do NOT touch section numbering!   
 * --- Do NOT use automatic Eclipse Comment Formatting!   
 */
package generated.kinoService;
//10 ===== GENERATED: Import Section ==============
import src.db.executer.PersistenceException;
import generated.kinoService.relationControl.*;
import utilities.InitialProxyLoader;
import utilities.InitialRelationLoader;
import utilities.InitialRelationLoader.IntegerPair;
import exceptions.ConstraintViolation;
import generated.kinoService.proxies.*;
import observation.Observable;
import src.db.executer.PersistenceExecuterFactory;
import src.db.executer.PersistenceDMLExecuter;
import src.db.connection.DBConnectionData;
import java.util.Map;
//20 ===== Editable : Your import section =========
//30 ===== GENERATED: Main Section ================
public class KinoService extends Observable{
   private PersistenceDMLExecuter dmlExecuter;
   private Map<Integer,FilmProxy> filmCache;
   private Map<Integer,PerformanceProxy> performanceCache;
   private Map<Integer,CinemahallProxy> cinemahallCache;
   private Map<Integer,SeatRowProxy> seatRowCache;
   private Map<Integer,SeatProxy> seatCache;
   private Map<Integer,ReservationProxy> reservationCache;
   private Map<Integer,ClientProxy> clientCache;
   private Map<Integer,BookingProxy> bookingCache;
   private static KinoService theInstance = new KinoService();
   private KinoService(){
      PersistenceExecuterFactory.setUseDataBase();
      this.dmlExecuter = PersistenceExecuterFactory.getConfiguredFactory().getDBDMLExecuter("KinoService");
      try{PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().openDBConnection(new DBConnectionData("jdbc:mysql://db:3306", "KinoService", "root" , "root"));
         PersistenceExecuterFactory.getConfiguredFactory().getTypeKeyManager().initializeFor("KinoService");
         this.loadProxies();
         this.loadRelations();
      }catch(Exception e){assert false : "Failed to establish initial database connection. Program aborted: " + e.getMessage();}
   }
   public static KinoService getInstance(){return theInstance;}
   
// The methods loadProxies/Relations will be replaced by more intelligent lazy-load-strategies!
   private void loadProxies() throws PersistenceException{
      this.filmCache = new InitialProxyLoader<FilmProxy>("generated", "KinoService", "kinoService", "Film", "Film").perform();
      this.performanceCache = new InitialProxyLoader<PerformanceProxy>("generated", "KinoService", "kinoService", "Performance", "Performance").perform();
      this.cinemahallCache = new InitialProxyLoader<CinemahallProxy>("generated", "KinoService", "kinoService", "Cinemahall", "Cinemahall").perform();
      this.seatRowCache = new InitialProxyLoader<SeatRowProxy>("generated", "KinoService", "kinoService", "SeatRow", "SeatRow").perform();
      this.seatCache = new InitialProxyLoader<SeatProxy>("generated", "KinoService", "kinoService", "Seat", "Seat").perform();
      this.reservationCache = new InitialProxyLoader<ReservationProxy>("generated", "KinoService", "kinoService", "Reservation", "Reservation").perform();
      this.clientCache = new InitialProxyLoader<ClientProxy>("generated", "KinoService", "kinoService", "Client", "Client").perform();
      this.bookingCache = new InitialProxyLoader<BookingProxy>("generated", "KinoService", "kinoService", "Booking", "Booking").perform();
   }
   private void loadRelations() throws PersistenceException{
      for(IntegerPair pair : new InitialRelationLoader("filmPerformance").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Performance");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Film");
         try{this.addfilmPerformanceElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("perf_CiHa").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Performance");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Cinemahall");
         try{this.addperf_CiHaElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("CiHa_SeRo").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Cinemahall");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "SeatRow");
         try{this.addCiHa_SeRoElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("seRo_Ca").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "SeatRow");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Categorie");
         try{this.addseRo_CaElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("seatRowSeat").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Seat");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "SeatRow");
         try{this.addseatRowSeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("rese_Seat").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat");
         try{this.addrese_SeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("reservationPerformance").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Performance");
         try{this.addreservationPerformanceElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("reservationClient").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Reservation");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Client");
         try{this.addreservationClientElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("bookingClient").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Booking");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Client");
         try{this.addbookingClientElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("book_Seat").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Booking");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Seat");
         try{this.addbook_SeatElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
      for(IntegerPair pair : new InitialRelationLoader("bookingPerformance").perform(this.dmlExecuter).values()){
         String className1 = this.dmlExecuter.getNameOfConcreteType(pair.getP1(), "Booking");
         String className2 = this.dmlExecuter.getNameOfConcreteType(pair.getP2(), "Performance");
         try{this.addbookingPerformanceElement(pair.getP1(), className1, pair.getP2(), className2);}catch(ConstraintViolation cv){throw new PersistenceException(cv.getMessage());}
      }
   }
   private void addfilmPerformanceElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IPerformance proxy1 = null; IFilm proxy2 = null; 
      if(className2.equals("Film"))  proxy2 = this.filmCache.get(id2);
      if(className1.equals("Performance"))  proxy1 = this.performanceCache.get(id1);
      filmPerformanceSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addperf_CiHaElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IPerformance proxy1 = null; ICinemahall proxy2 = null; 
      if(className1.equals("Performance"))  proxy1 = this.performanceCache.get(id1);
      if(className2.equals("Cinemahall"))  proxy2 = this.cinemahallCache.get(id2);
      perf_CiHaSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addCiHa_SeRoElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ICinemahall proxy1 = null; ISeatRow proxy2 = null; 
      if(className1.equals("Cinemahall"))  proxy1 = this.cinemahallCache.get(id1);
      if(className2.equals("SeatRow"))  proxy2 = this.seatRowCache.get(id2);
      CiHa_SeRoSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addseRo_CaElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ISeatRow proxy1 = null; ICategorie proxy2 = null; 
      if(className1.equals("SeatRow"))  proxy1 = this.seatRowCache.get(id1);
      if(className2.equals("Parquet"))  proxy2 = Parquet.getInstance();
      if(className2.equals("Loge"))  proxy2 = Loge.getInstance();
      if(className2.equals("LogeService"))  proxy2 = LogeService.getInstance();
      seRo_CaSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addseatRowSeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      ISeat proxy1 = null; ISeatRow proxy2 = null; 
      if(className2.equals("SeatRow"))  proxy2 = this.seatRowCache.get(id2);
      if(className1.equals("Seat"))  proxy1 = this.seatCache.get(id1);
      seatRowSeatSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addrese_SeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; ISeat proxy2 = null; 
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      rese_SeatSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addreservationPerformanceElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; IPerformance proxy2 = null; 
      if(className2.equals("Performance"))  proxy2 = this.performanceCache.get(id2);
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      reservationPerformanceSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addreservationClientElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IReservation proxy1 = null; IClient proxy2 = null; 
      if(className1.equals("Reservation"))  proxy1 = this.reservationCache.get(id1);
      if(className2.equals("Client"))  proxy2 = this.clientCache.get(id2);
      reservationClientSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addbookingClientElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBooking proxy1 = null; IClient proxy2 = null; 
      if(className2.equals("Client"))  proxy2 = this.clientCache.get(id2);
      if(className1.equals("Booking"))  proxy1 = this.bookingCache.get(id1);
      bookingClientSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   private void addbook_SeatElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBooking proxy1 = null; ISeat proxy2 = null; 
      if(className2.equals("Seat"))  proxy2 = this.seatCache.get(id2);
      if(className1.equals("Booking"))  proxy1 = this.bookingCache.get(id1);
      book_SeatSupervisor.getInstance().addAlreadyPersistent(proxy1, proxy2);
   }
   private void addbookingPerformanceElement(Integer id1, String className1, Integer id2, String className2) throws ConstraintViolation, PersistenceException{
      IBooking proxy1 = null; IPerformance proxy2 = null; 
      if(className2.equals("Performance"))  proxy2 = this.performanceCache.get(id2);
      if(className1.equals("Booking"))  proxy1 = this.bookingCache.get(id1);
      bookingPerformanceSupervisor.getInstance().setAlreadyPersistent(proxy1, proxy2);
   }
   public Film getFilm(Integer id){
      return this.filmCache.get(id).getTheObject();
   }
   public void addFilmProxy(FilmProxy p) throws PersistenceException{
      this.filmCache.put(p.getId(), p);
   }
   public Map<Integer,FilmProxy> getFilmCache(){
      return this.filmCache;
   }
   public Performance getPerformance(Integer id){
      return this.performanceCache.get(id).getTheObject();
   }
   public void addPerformanceProxy(PerformanceProxy p) throws PersistenceException{
      this.performanceCache.put(p.getId(), p);
   }
   public Map<Integer,PerformanceProxy> getPerformanceCache(){
      return this.performanceCache;
   }
   public Cinemahall getCinemahall(Integer id){
      return this.cinemahallCache.get(id).getTheObject();
   }
   public void addCinemahallProxy(CinemahallProxy p) throws PersistenceException{
      this.cinemahallCache.put(p.getId(), p);
   }
   public Map<Integer,CinemahallProxy> getCinemahallCache(){
      return this.cinemahallCache;
   }
   public SeatRow getSeatRow(Integer id){
      return this.seatRowCache.get(id).getTheObject();
   }
   public void addSeatRowProxy(SeatRowProxy p) throws PersistenceException{
      this.seatRowCache.put(p.getId(), p);
   }
   public Map<Integer,SeatRowProxy> getSeatRowCache(){
      return this.seatRowCache;
   }
   public Seat getSeat(Integer id){
      return this.seatCache.get(id).getTheObject();
   }
   public void addSeatProxy(SeatProxy p) throws PersistenceException{
      this.seatCache.put(p.getId(), p);
   }
   public Map<Integer,SeatProxy> getSeatCache(){
      return this.seatCache;
   }
   public Reservation getReservation(Integer id){
      return this.reservationCache.get(id).getTheObject();
   }
   public void addReservationProxy(ReservationProxy p) throws PersistenceException{
      this.reservationCache.put(p.getId(), p);
   }
   public Map<Integer,ReservationProxy> getReservationCache(){
      return this.reservationCache;
   }
   public Client getClient(Integer id){
      return this.clientCache.get(id).getTheObject();
   }
   public void addClientProxy(ClientProxy p) throws PersistenceException{
      this.clientCache.put(p.getId(), p);
   }
   public Map<Integer,ClientProxy> getClientCache(){
      return this.clientCache;
   }
   public Booking getBooking(Integer id){
      return this.bookingCache.get(id).getTheObject();
   }
   public void addBookingProxy(BookingProxy p) throws PersistenceException{
      this.bookingCache.put(p.getId(), p);
   }
   public Map<Integer,BookingProxy> getBookingCache(){
      return this.bookingCache;
   }
   public PersistenceDMLExecuter getDmlExecuter() {
      return this.dmlExecuter;
   }
   public void closeDBConnection() throws java.sql.SQLException{
      PersistenceExecuterFactory.getConfiguredFactory().getDBDDLExecuter().closeConnection("KinoService");
   }
   //80 ===== Editable : Your Operations =============
//90 ===== GENERATED: End of Your Operations ======
}
