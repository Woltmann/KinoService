package KinoApplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import exceptions.ConstraintViolation;
import generated.kinoService.*;
import generated.kinoService.proxies.CinemahallProxy;
import generated.kinoService.proxies.ClientProxy;
import generated.kinoService.proxies.FilmProxy;
import generated.kinoService.proxies.PerformanceProxy;
import src.db.connection.NoConnectionException;

public class KinoApplication {
	
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    KinoService newKinoService = KinoService.getInstance();
	    Parquet parquetInstance = Parquet.getInstance();
	    Loge logeInstance = Loge.getInstance();
	    LogeService logeServiceInstance = LogeService.getInstance();

	    System.out.println("Sind Sie ein Kunde oder ein Kinobetreiber? (Kunde/Betreiber)");
	    String userType = scanner.nextLine().trim().toLowerCase();

	    while (!userType.equals("beenden")) {
	        try {
	            if (userType.equals("betreiber")) {
	                handleOperator(scanner, newKinoService, parquetInstance, logeInstance, logeServiceInstance);
	            } else if (userType.equals("kunde")) {
	                handleClient(scanner, newKinoService);
	            } else {
	                System.out.println("Ungültige Eingabe. Bitte wählen Sie 'Kunde', 'Betreiber' oder 'Beenden' um das Programm zu verlassen.");
	            }

	            System.out.println("Möchten Sie das Programm beenden? (Ja/Nein)");
	            String exitInput = scanner.nextLine().trim().toLowerCase();
	            if (exitInput.equals("ja")) {
	                userType = "beenden";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    scanner.close();
	}

    private static void handleOperator(Scanner scanner, KinoService newKinoService, Parquet parquetInstance, Loge logeInstance, LogeService logeServiceInstance) throws ConstraintViolation, SQLException, NoConnectionException {
        // Betreiber-Logik
        System.out.println("Möchten Sie einen Kinosaal anlegen, Film hinterlegen, Preise ändern, die Einnahmen berechnen oder die Aufführung planen? (Saal/Film/Preise/Einnahmen/Aufführung)");
        String actionType = scanner.nextLine().trim().toLowerCase();

        switch (actionType) {
            case "saal":
                createCinemahall(scanner, newKinoService, parquetInstance, logeInstance, logeServiceInstance);
                break;
            case "film":
                depositMovie(scanner, newKinoService);
                break;
            case "preise":
                depositMovie(scanner, parquetInstance, logeInstance, logeServiceInstance);
                break;
            case "einnahmen":
                calculateRevenueOperator(scanner, newKinoService);
                break;
            case "aufführung":
                planPerformance(scanner, newKinoService);
                break;
            default:
                System.out.println("Ungültige Aktion.");
                break;
        }
    }

    private static void handleClient(Scanner scanner, KinoService newKinoService) {
        // Kunden-Logik
        System.out.println("Möchten Sie einen Kundenkonto anlegen, ins Kino gehen oder eine Reservierung stornieren? (Kundenkonto/Kino/Stornieren)");
        String actionType = scanner.nextLine().trim().toLowerCase();

        switch (actionType) {
            case "kundenkonto":
                createCustomerAccount(scanner, newKinoService);
                break;
            case "kino":
                visitCinema(scanner, newKinoService);
                break;
            case "stornieren":
                cancelReservation(scanner, newKinoService);
                break;
            default:
                System.out.println("Ungültige Aktion.");
                break;
        }
    }

    private static void createCinemahall(Scanner scanner, KinoService newKinoService, Parquet parquetInstance, Loge logeInstance, LogeService logeServiceInstance) {
        System.out.println("Geben Sie den Namen des neuen Kinosaals ein:");
        String hallName = scanner.nextLine();

        Cinemahall newCinemahall = Cinemahall.createFresh(hallName, true);
        System.out.println("Wie viele Sitzreihen soll der Kinosaal " + newCinemahall.getHallname() + " haben?");
        int numberOfSeatRows = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfSeatRows; i++) {
            System.out.println("Zu welcher Kategorie gehört die Sitzreihe " + (i + 1) + "? (Parkett/Loge/Loge Service)");
            String category = scanner.nextLine().trim().toLowerCase();
            System.out.println("Wie viele Sitze hat die Sitzreihe?");
            int seatCount = Integer.parseInt(scanner.nextLine());

            SeatRow newSeatRow = null;
            switch (category) {
                case "parkett":
                    newSeatRow = SeatRow.createFresh(parquetInstance, seatCount);
                    break;
                case "loge":
                    newSeatRow = SeatRow.createFresh(logeInstance, seatCount);
                    break;
                case "loge service":
                    newSeatRow = SeatRow.createFresh(logeServiceInstance, seatCount);
                    break;
                default:
                    System.out.println("Ungültige Kategorie.");
                    continue;
            }

            for (int a = 0; a < seatCount; a++) {
                Seat newSeat = Seat.createFresh(newSeatRow);
            }

            newCinemahall.addToSeatRow(newSeatRow);
        }

        System.out.println("Kinosaal wurde unter der ID " + newCinemahall.getId() + " angelegt.");
    }


    private static void depositMovie(Scanner scanner, KinoService newKinoService) {
        System.out.println("Geben Sie den Namen des Films ein:");
        String movieName = scanner.nextLine();
        System.out.println("Geben Sie die Beschreibung des Films ein:");
        String movieDescription = scanner.nextLine();

        Film newMovie = Film.createFresh(movieName, movieDescription);

        System.out.println("Der Film wurde hinterlegt mit der ID " + newMovie.getId() + ".");
    }


    private static void depositMovie(Scanner scanner, Parquet parquetInstance, Loge logeInstance, LogeService logeServiceInstance) {
        System.out.println("Geben Sie den neuen Basispreis ein:");
        Integer basePrice = Integer.parseInt(scanner.nextLine());

        System.out.println("Geben Sie den neuen Preiszuschlag für die Loge ein:");
        Integer logeSurcharge = Integer.parseInt(scanner.nextLine());

        System.out.println("Geben Sie den neuen Preiszuschlag für den Loge-Service ein:");
        Integer logeServiceSurcharge = Integer.parseInt(scanner.nextLine());

        // Setzen der Preise
        parquetInstance.setBasePrice(basePrice);
        logeInstance.setBasePrice(basePrice);
        logeInstance.setPriceSurchargeLoge(logeSurcharge);
        logeServiceInstance.setBasePrice(basePrice);
        logeServiceInstance.setPriceSurchargeLogeService(logeServiceSurcharge);

        System.out.println("Die Preise wurden erfolgreich aktualisiert.");
    }

    
    private static void calculateRevenueOperator(Scanner scanner, KinoService newKinoService) {
        System.out.println("Möchten Sie die Einnahmen für eine Aufführung oder einen ganzen Film berechnen? (Aufführung/Film)");
        String revenueType = scanner.nextLine().trim().toLowerCase();

        if (revenueType.equals("aufführung")) {
        	Map<Integer, PerformanceProxy> performanceCache = newKinoService.getPerformanceCache();
         	for (PerformanceProxy performanceProxy : performanceCache.values()) {
         	    System.out.println("Die Aufführung mit dem Film: " + performanceProxy.getFilm().getTitel() + " wurde im Kino: " + performanceProxy.getAssigendHall().getHallname() + " unter der ID: " + performanceProxy.getId() + " geplant.");
         	}
            System.out.println("Geben Sie die ID der Aufführung ein:");
            int performanceID = Integer.parseInt(scanner.nextLine());
            Performance performance = newKinoService.getPerformance(performanceID);
            int revenue = performance.calculateRevenuePerformance(); // Annahme: Diese Methode existiert
            System.out.println("Die Einnahmen der Aufführung betragen: " + revenue + " Euro.");
        } else if (revenueType.equals("film")) {
        	Map<Integer, FilmProxy> movieCache = newKinoService.getFilmCache();
        	for (FilmProxy filmProxy : movieCache.values()) {
        	    System.out.println("Für folgende Filme können die Einnahmen berechnet werden: " + filmProxy.getTitel() + ". Die ID lautet: " + filmProxy.getId());
        	}
            System.out.println("Geben Sie die ID des Films ein:");
            int movieID = Integer.parseInt(scanner.nextLine());
            Film movie = newKinoService.getFilm(movieID);
            int revenue = movie.calculateRevenue(); // Annahme: Diese Methode existiert
            System.out.println("Die gesamten Einnahmen des Films betragen: " + revenue + " Euro.");
        } else {
            System.out.println("Ungültige Eingabe.");
        }
    }

    
    private static void planPerformance(Scanner scanner, KinoService newKinoService) throws ConstraintViolation, SQLException, NoConnectionException {
    	System.out.println("Möchten Sie eine Aufführung anlegen oder löschen? (anlegen/loeschen)");
        String action = scanner.nextLine().trim().toLowerCase();

        if (action.equals("anlegen")) {
            // Logik zum Anlegen einer Aufführung
        	// Anzeigen verfügbarer Filme
            Map<Integer, FilmProxy> filmCache = newKinoService.getFilmCache();
            System.out.println("Verfügbare Filme:");
            for (FilmProxy filmProxy : filmCache.values()) {
                System.out.println("Film ID: " + filmProxy.getId() + " - Titel: " + filmProxy.getTitel());
            }
            System.out.println("Geben Sie die ID des Films ein, welcher in der Aufführung ausgestrahlt werden soll:");
            Integer movieID = Integer.parseInt(scanner.nextLine());
            Film movie = newKinoService.getFilm(movieID);

            // Anzeigen verfügbarer Kinosäle
            Map<Integer, CinemahallProxy> cinemahallCache = newKinoService.getCinemahallCache();
            System.out.println("Verfügbare Kinosäle:");
            for (CinemahallProxy cinemahallProxy : cinemahallCache.values()) {
                System.out.println("Kinosal ID: " + cinemahallProxy.getId() + " - Name: " + cinemahallProxy.getHallname());
            }
            System.out.println("Geben Sie die ID des Kino Saals an, in welchem die Aufführung stattfinden soll:");
            Integer cinemaHallID = Integer.parseInt(scanner.nextLine());
            Cinemahall cinemahall = newKinoService.getCinemahall(cinemaHallID);

            // Erstellen der Aufführung
            Performance newPerformance = Performance.createFresh(movie, cinemahall);
            newPerformance.assignCinemaHall();
            System.out.println("Die Aufführung mit der ID " + newPerformance.getId() + " wurde erfolgreich geplant.");
        } else if (action.equals("loeschen")) {
            // Logik zum Löschen einer Aufführung
            Map<Integer, PerformanceProxy> performanceCache = newKinoService.getPerformanceCache();
            System.out.println("Geplante Aufführungen:");
            for (PerformanceProxy performanceProxy : performanceCache.values()) {
                System.out.println("Aufführung ID: " + performanceProxy.getId() + " - Film: " + performanceProxy.getFilm().getTitel() + " im Kino: " + performanceProxy.getAssigendHall().getHallname());
            }

            System.out.println("Geben Sie die ID der zu löschenden Aufführung ein:");
            Integer performanceID = Integer.parseInt(scanner.nextLine());
            Performance deletingPerformance = newKinoService.getPerformance(performanceID);
            // Stellen Sie sicher, dass die Aufführung existiert, bevor Sie versuchen, sie zu löschen
            if (deletingPerformance != null) {
            	// Stornieren aller Buchungen und Reservierungen der Aufführung
                cancelAllBookingsAndReservations(deletingPerformance, newKinoService);
                //Freigeben des Kinos
                deletingPerformance.releaseCinemaHall(); 
                //Löschen der Aufführung
                Performance.delete(performanceID); 
                System.out.println("Die Aufführung mit der ID " + performanceID + " wurde gelöscht.");
            } else {
                System.out.println("Aufführung nicht gefunden.");
            }
        } else {
            System.out.println("Ungültige Aktion.");
        }
    }
    
    private static void cancelAllBookingsAndReservations(Performance performance, KinoService newKinoService) {
        Set<Booking> allBookings = new HashSet<>();
        Set<Reservation> allReservations= new HashSet<>(); 
        Map<Integer, ClientProxy> clientChache = newKinoService.getClientCache();
        for (ClientProxy clientProxy : clientChache.values()) {
        	Set<Reservation> clientReservations = clientProxy.getReservation();
        	Set<Booking> clientBookings = clientProxy.getBooking();
        	for (Reservation reservation : clientReservations ){
        		if(reservation.getPerformance().equals(performance)) {
        			allReservations.add(reservation);
        		}
        	}
        	for (Booking booking : clientBookings ){
        		if(booking.getPerformance().equals(performance)) {
        			allBookings.add(booking);
        		}
        	}
        }
        for (Booking booking : allBookings) {
            try {
				Booking.delete(booking.getId());
			} catch (ConstraintViolation | SQLException | NoConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        for (Reservation reservation : allReservations) {
        	Set<Seat> seats = reservation.getSeat();
            try {
				Reservation.delete(reservation.getId());
			} catch (ConstraintViolation e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    
    private static void createCustomerAccount(Scanner scanner, KinoService newKinoService) {
        System.out.println("Geben Sie Ihren Namen ein:");
        String clientName = scanner.nextLine();
        System.out.println("Geben Sie Ihre Email-Adresse ein:");
        String clientEmail = scanner.nextLine();
        Client newClient = Client.createFresh(clientName, clientEmail);

        System.out.println("Ihr Kundenkonto wurde unter folgender ID " + newClient.getId() + " angelegt.");
    }

    
    private static void visitCinema(Scanner scanner, KinoService newKinoService) {
        // Kunden-ID abfragen
        System.out.println("Geben Sie Ihre Kunden ID ein:");
        Integer clientId = Integer.parseInt(scanner.nextLine());
        Client currentClient = newKinoService.getClient(clientId);
        Map<Integer, PerformanceProxy> performanceCache = newKinoService.getPerformanceCache();
        System.out.println("Verfügbare Aufführungen:");
        for (PerformanceProxy performanceProxy : performanceCache.values()) {
            System.out.println("Aufführung ID: " + performanceProxy.getId() + " - Film: " + performanceProxy.getFilm().getTitel() + " im Kino: " + performanceProxy.getAssigendHall().getHallname());
        }

        // Aufführungs-ID abfragen
        System.out.println("Geben Sie die ID der Vorstellung ein, die Sie besuchen wollen:");
        Integer performanceID = Integer.parseInt(scanner.nextLine());
        Performance selectedPerformance = newKinoService.getPerformance(performanceID);
        Set<Reservation> clientReservations = currentClient.getReservation();
        for (Reservation clientReservation :clientReservations) {
        	if (clientReservation.getPerformance().equals(selectedPerformance)) {
        		System.out.println("Sie haben bereits eine Reservierung für die Aufführung, soll die gebucht werden? (Ja/Nein) ID: " + clientReservation.getId());
        		String bookReservation = scanner.nextLine().trim().toLowerCase();
        		if (bookReservation.equals("ja")) {
        			bookingSeat(currentClient, clientReservation.getPerformance(), clientReservation.getSeat());
        			try {
						Reservation.delete(clientReservation.getId());
					} catch (ConstraintViolation | SQLException | NoConnectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			return;
        		}
        	}
        }

        // Sitzplatz-Auswahl
        System.out.println("Möchten Sie einen oder mehrere Sitzplätze buchen? (Einen/Mehrere)");
        String seatSelection = scanner.nextLine().trim().toLowerCase();
        Set<Seat> seatIds = new HashSet<>();
        if (seatSelection.equals("einen")) {
            // Logik für die Auswahl eines einzelnen Sitzes
            seatIds.add(waehleEinenSitzplatz(scanner, selectedPerformance, newKinoService));
        } else if (seatSelection.equals("mehrere")) {
            // Logik für die Auswahl mehrerer Sitzplätze
            seatIds.addAll(chooseSeveralSeats(scanner, selectedPerformance, newKinoService));
        }

        // Buchung oder Reservierung
        System.out.println("Möchten Sie reservieren oder buchen? (reservieren/buchen)");
        String bookingTyp = scanner.nextLine().trim().toLowerCase();
        if (bookingTyp.equals("buchen")) {
            // Buchungslogik
            bookingSeat(currentClient, selectedPerformance, seatIds);
        } else if (bookingTyp.equals("reservieren")) {
            // Reservierungslogik
            reserveSeat(currentClient, selectedPerformance, seatIds);
        }
    }

    private static Seat waehleEinenSitzplatz(Scanner scanner, Performance performance, KinoService newKinoService) {
        System.out.println("Verfügbare freie Sitzplätze:");
    	getFreeSeats(performance);
    	System.out.println("Geben Sie die ID des Sitzplatzes ein, den Sie buchen möchten:");
        Integer seatId = Integer.parseInt(scanner.nextLine());
        return newKinoService.getSeat(seatId);
    }

    private static Set<Seat> chooseSeveralSeats(Scanner scanner, Performance performance, KinoService newKinoService) {
    	System.out.println("Verfügbare freie Sitzplätze:");
    	getFreeSeats(performance);
        System.out.println("Geben Sie die IDs der Sitzplätze ein, die Sie buchen möchten, getrennt durch Leerzeichen:");
        String[] seatIdsString = scanner.nextLine().split("\\s+");
        Set<Seat> seats = new HashSet<>();
        for (String id : seatIdsString) {
            seats.add(newKinoService.getSeat(Integer.parseInt(id)));
        }
        return seats;
    }
    
    private static void getFreeSeats(Performance performance) {
    	Collection<Seat> freeSeats = performance.getFreeSeats(); 
    	for (Seat seat : freeSeats) {
		   	System.out.println("Der Sitz mit der ID: " + seat.getId() + " ist frei.");
		}
    }

    private static void bookingSeat(Client client, Performance performance, Set<Seat> sitzplaetze) {
        client.booking(sitzplaetze, performance);
        System.out.println("Sitzplätze erfolgreich gebucht.");
    }

    private static void reserveSeat(Client client, Performance performance, Set<Seat> sitzIds) {
        client.reserve(sitzIds, performance);
        System.out.println("Sitzplätze erfolgreich reserviert.");
    }

    
    private static void cancelReservation(Scanner scanner, KinoService newKinoService) {
        System.out.println("Geben Sie Ihre Kunden ID ein:");
        Integer clientId = Integer.parseInt(scanner.nextLine());
        Client currentClient = newKinoService.getClient(clientId);

        // Anzeigen aller Reservierungen des Kunden
        Set<Reservation> bookedReservations = currentClient.getReservation();
        if (bookedReservations.isEmpty()) {
            System.out.println("Sie haben keine aktiven Reservierungen.");
            return;
        }

        System.out.println("Ihre Reservierungen:");
        for (Reservation reservation : bookedReservations) {
            System.out.println("Reservierungs-ID: " + reservation.getId() + " - Film: " + reservation.getPerformance().getFilm().getTitel() + " - Kino Saal: " + reservation.getPerformance().getAssigendHall().getHallname());
        }

        // Reservierungs-ID abfragen, die storniert werden soll
        System.out.println("Bitte geben Sie die ID der zu stornierenden Reservierung ein:");
        Integer reservationID = Integer.parseInt(scanner.nextLine());
        Reservation canceledReservation = newKinoService.getReservation(reservationID);

        // Stornierungslogik
        if (canceledReservation != null && bookedReservations.contains(canceledReservation)) {
            currentClient.cancelReservation(canceledReservation);
            System.out.println("Die Reservierung mit der ID " + reservationID + " wurde erfolgreich storniert.");
        } else {
            System.out.println("Reservierung nicht gefunden oder gehört nicht zu diesem Kunden.");
        }
    }


}
