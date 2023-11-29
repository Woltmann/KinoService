/**--- Generated at Fri Nov 24 20:30:03 CET 2023 
 * --- No Change Allowed!  
 */
package generated.kinoService.commands;
import generated.kinoService.*;
import commands.*;
public class Performance_constructor_Command extends ServiceCommand<Performance>{
   private static final long serialVersionUID = -1304264728L;
   private Film film;
   private Cinemahall assigendHall;
   public Performance_constructor_Command(Film film, Cinemahall assigendHall){
      super();
      this.film = film;
      this.assigendHall = assigendHall;
   }
   public void execute(){
      try{this.result = Performance.createFresh(film, assigendHall);
      }catch(Exception e){this.e = e;
      }finally{KinoService.getInstance().notifyObservers(this);}
   }
   public Film film(){return film;}
   public Cinemahall assigendHall(){return assigendHall;}
}
