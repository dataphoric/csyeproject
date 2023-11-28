/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 66 "model.ump"
// line 219 "model.ump"
public class Flight
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Flight Attributes
  private string flightNumber;
  private string aircraftNo;
  private string departureAirport;
  private string arrivalAirport;
  private datetime departureTime;
  private datetime arrivalTime;
  private string stops;

  //Flight Associations
  private List<Seat> seats;
  private Aircraft aircraft;
  private List<Crew> crews;
  private List<BoardingPass> boardingPasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Flight(string aFlightNumber, string aAircraftNo, string aDepartureAirport, string aArrivalAirport, datetime aDepartureTime, datetime aArrivalTime, string aStops, Aircraft aAircraft, Seat[] allSeats, Crew[] allCrews)
  {
    flightNumber = aFlightNumber;
    aircraftNo = aAircraftNo;
    departureAirport = aDepartureAirport;
    arrivalAirport = aArrivalAirport;
    departureTime = aDepartureTime;
    arrivalTime = aArrivalTime;
    stops = aStops;
    seats = new ArrayList<Seat>();
    boolean didAddSeats = setSeats(allSeats);
    if (!didAddSeats)
    {
      throw new RuntimeException("Unable to create Flight, must have at least 1 seats. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aAircraft == null || aAircraft.getFlight() != null)
    {
      throw new RuntimeException("Unable to create Flight due to aAircraft. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    aircraft = aAircraft;
    crews = new ArrayList<Crew>();
    boolean didAddCrews = setCrews(allCrews);
    if (!didAddCrews)
    {
      throw new RuntimeException("Unable to create Flight, must have at least 1 crews. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boardingPasses = new ArrayList<BoardingPass>();
  }

  public Flight(string aFlightNumber, string aAircraftNo, string aDepartureAirport, string aArrivalAirport, datetime aDepartureTime, datetime aArrivalTime, string aStops, string aAircraftIDForAircraft, string aModelForAircraft, int aCapacityForAircraft, Seat[] allSeats, Crew[] allCrews)
  {
    flightNumber = aFlightNumber;
    aircraftNo = aAircraftNo;
    departureAirport = aDepartureAirport;
    arrivalAirport = aArrivalAirport;
    departureTime = aDepartureTime;
    arrivalTime = aArrivalTime;
    stops = aStops;
    seats = new ArrayList<Seat>();
    boolean didAddSeats = setSeats(allSeats);
    if (!didAddSeats)
    {
      throw new RuntimeException("Unable to create Flight, must have at least 1 seats. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    aircraft = new Aircraft(aAircraftIDForAircraft, aModelForAircraft, aCapacityForAircraft, this);
    crews = new ArrayList<Crew>();
    boolean didAddCrews = setCrews(allCrews);
    if (!didAddCrews)
    {
      throw new RuntimeException("Unable to create Flight, must have at least 1 crews. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boardingPasses = new ArrayList<BoardingPass>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFlightNumber(string aFlightNumber)
  {
    boolean wasSet = false;
    flightNumber = aFlightNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setAircraftNo(string aAircraftNo)
  {
    boolean wasSet = false;
    aircraftNo = aAircraftNo;
    wasSet = true;
    return wasSet;
  }

  public boolean setDepartureAirport(string aDepartureAirport)
  {
    boolean wasSet = false;
    departureAirport = aDepartureAirport;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrivalAirport(string aArrivalAirport)
  {
    boolean wasSet = false;
    arrivalAirport = aArrivalAirport;
    wasSet = true;
    return wasSet;
  }

  public boolean setDepartureTime(datetime aDepartureTime)
  {
    boolean wasSet = false;
    departureTime = aDepartureTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrivalTime(datetime aArrivalTime)
  {
    boolean wasSet = false;
    arrivalTime = aArrivalTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setStops(string aStops)
  {
    boolean wasSet = false;
    stops = aStops;
    wasSet = true;
    return wasSet;
  }

  public string getFlightNumber()
  {
    return flightNumber;
  }

  public string getAircraftNo()
  {
    return aircraftNo;
  }

  public string getDepartureAirport()
  {
    return departureAirport;
  }

  public string getArrivalAirport()
  {
    return arrivalAirport;
  }

  public datetime getDepartureTime()
  {
    return departureTime;
  }

  public datetime getArrivalTime()
  {
    return arrivalTime;
  }

  public string getStops()
  {
    return stops;
  }
  /* Code from template association_GetMany */
  public Seat getSeat(int index)
  {
    Seat aSeat = seats.get(index);
    return aSeat;
  }

  public List<Seat> getSeats()
  {
    List<Seat> newSeats = Collections.unmodifiableList(seats);
    return newSeats;
  }

  public int numberOfSeats()
  {
    int number = seats.size();
    return number;
  }

  public boolean hasSeats()
  {
    boolean has = seats.size() > 0;
    return has;
  }

  public int indexOfSeat(Seat aSeat)
  {
    int index = seats.indexOf(aSeat);
    return index;
  }
  /* Code from template association_GetOne */
  public Aircraft getAircraft()
  {
    return aircraft;
  }
  /* Code from template association_GetMany */
  public Crew getCrew(int index)
  {
    Crew aCrew = crews.get(index);
    return aCrew;
  }

  public List<Crew> getCrews()
  {
    List<Crew> newCrews = Collections.unmodifiableList(crews);
    return newCrews;
  }

  public int numberOfCrews()
  {
    int number = crews.size();
    return number;
  }

  public boolean hasCrews()
  {
    boolean has = crews.size() > 0;
    return has;
  }

  public int indexOfCrew(Crew aCrew)
  {
    int index = crews.indexOf(aCrew);
    return index;
  }
  /* Code from template association_GetMany */
  public BoardingPass getBoardingPass(int index)
  {
    BoardingPass aBoardingPass = boardingPasses.get(index);
    return aBoardingPass;
  }

  public List<BoardingPass> getBoardingPasses()
  {
    List<BoardingPass> newBoardingPasses = Collections.unmodifiableList(boardingPasses);
    return newBoardingPasses;
  }

  public int numberOfBoardingPasses()
  {
    int number = boardingPasses.size();
    return number;
  }

  public boolean hasBoardingPasses()
  {
    boolean has = boardingPasses.size() > 0;
    return has;
  }

  public int indexOfBoardingPass(BoardingPass aBoardingPass)
  {
    int index = boardingPasses.indexOf(aBoardingPass);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfSeatsValid()
  {
    boolean isValid = numberOfSeats() >= minimumNumberOfSeats();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSeats()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addSeat(Seat aSeat)
  {
    boolean wasAdded = false;
    if (seats.contains(aSeat)) { return false; }
    seats.add(aSeat);
    if (aSeat.indexOfFlight(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSeat.addFlight(this);
      if (!wasAdded)
      {
        seats.remove(aSeat);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeSeat(Seat aSeat)
  {
    boolean wasRemoved = false;
    if (!seats.contains(aSeat))
    {
      return wasRemoved;
    }

    if (numberOfSeats() <= minimumNumberOfSeats())
    {
      return wasRemoved;
    }

    int oldIndex = seats.indexOf(aSeat);
    seats.remove(oldIndex);
    if (aSeat.indexOfFlight(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSeat.removeFlight(this);
      if (!wasRemoved)
      {
        seats.add(oldIndex,aSeat);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setSeats(Seat... newSeats)
  {
    boolean wasSet = false;
    ArrayList<Seat> verifiedSeats = new ArrayList<Seat>();
    for (Seat aSeat : newSeats)
    {
      if (verifiedSeats.contains(aSeat))
      {
        continue;
      }
      verifiedSeats.add(aSeat);
    }

    if (verifiedSeats.size() != newSeats.length || verifiedSeats.size() < minimumNumberOfSeats())
    {
      return wasSet;
    }

    ArrayList<Seat> oldSeats = new ArrayList<Seat>(seats);
    seats.clear();
    for (Seat aNewSeat : verifiedSeats)
    {
      seats.add(aNewSeat);
      if (oldSeats.contains(aNewSeat))
      {
        oldSeats.remove(aNewSeat);
      }
      else
      {
        aNewSeat.addFlight(this);
      }
    }

    for (Seat anOldSeat : oldSeats)
    {
      anOldSeat.removeFlight(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSeatAt(Seat aSeat, int index)
  {  
    boolean wasAdded = false;
    if(addSeat(aSeat))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSeats()) { index = numberOfSeats() - 1; }
      seats.remove(aSeat);
      seats.add(index, aSeat);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSeatAt(Seat aSeat, int index)
  {
    boolean wasAdded = false;
    if(seats.contains(aSeat))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSeats()) { index = numberOfSeats() - 1; }
      seats.remove(aSeat);
      seats.add(index, aSeat);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSeatAt(aSeat, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfCrewsValid()
  {
    boolean isValid = numberOfCrews() >= minimumNumberOfCrews();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCrews()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCrew(Crew aCrew)
  {
    boolean wasAdded = false;
    if (crews.contains(aCrew)) { return false; }
    crews.add(aCrew);
    if (aCrew.indexOfFlight(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCrew.addFlight(this);
      if (!wasAdded)
      {
        crews.remove(aCrew);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeCrew(Crew aCrew)
  {
    boolean wasRemoved = false;
    if (!crews.contains(aCrew))
    {
      return wasRemoved;
    }

    if (numberOfCrews() <= minimumNumberOfCrews())
    {
      return wasRemoved;
    }

    int oldIndex = crews.indexOf(aCrew);
    crews.remove(oldIndex);
    if (aCrew.indexOfFlight(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCrew.removeFlight(this);
      if (!wasRemoved)
      {
        crews.add(oldIndex,aCrew);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setCrews(Crew... newCrews)
  {
    boolean wasSet = false;
    ArrayList<Crew> verifiedCrews = new ArrayList<Crew>();
    for (Crew aCrew : newCrews)
    {
      if (verifiedCrews.contains(aCrew))
      {
        continue;
      }
      verifiedCrews.add(aCrew);
    }

    if (verifiedCrews.size() != newCrews.length || verifiedCrews.size() < minimumNumberOfCrews())
    {
      return wasSet;
    }

    ArrayList<Crew> oldCrews = new ArrayList<Crew>(crews);
    crews.clear();
    for (Crew aNewCrew : verifiedCrews)
    {
      crews.add(aNewCrew);
      if (oldCrews.contains(aNewCrew))
      {
        oldCrews.remove(aNewCrew);
      }
      else
      {
        aNewCrew.addFlight(this);
      }
    }

    for (Crew anOldCrew : oldCrews)
    {
      anOldCrew.removeFlight(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCrewAt(Crew aCrew, int index)
  {  
    boolean wasAdded = false;
    if(addCrew(aCrew))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCrews()) { index = numberOfCrews() - 1; }
      crews.remove(aCrew);
      crews.add(index, aCrew);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCrewAt(Crew aCrew, int index)
  {
    boolean wasAdded = false;
    if(crews.contains(aCrew))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCrews()) { index = numberOfCrews() - 1; }
      crews.remove(aCrew);
      crews.add(index, aCrew);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCrewAt(aCrew, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBoardingPasses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public BoardingPass addBoardingPass(string aPassNo, datetime aBoardingTime, string aGate, string aPassengerInfo)
  {
    return new BoardingPass(aPassNo, aBoardingTime, aGate, aPassengerInfo, this);
  }

  public boolean addBoardingPass(BoardingPass aBoardingPass)
  {
    boolean wasAdded = false;
    if (boardingPasses.contains(aBoardingPass)) { return false; }
    Flight existingFlight = aBoardingPass.getFlight();
    boolean isNewFlight = existingFlight != null && !this.equals(existingFlight);
    if (isNewFlight)
    {
      aBoardingPass.setFlight(this);
    }
    else
    {
      boardingPasses.add(aBoardingPass);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBoardingPass(BoardingPass aBoardingPass)
  {
    boolean wasRemoved = false;
    //Unable to remove aBoardingPass, as it must always have a flight
    if (!this.equals(aBoardingPass.getFlight()))
    {
      boardingPasses.remove(aBoardingPass);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBoardingPassAt(BoardingPass aBoardingPass, int index)
  {  
    boolean wasAdded = false;
    if(addBoardingPass(aBoardingPass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoardingPasses()) { index = numberOfBoardingPasses() - 1; }
      boardingPasses.remove(aBoardingPass);
      boardingPasses.add(index, aBoardingPass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBoardingPassAt(BoardingPass aBoardingPass, int index)
  {
    boolean wasAdded = false;
    if(boardingPasses.contains(aBoardingPass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoardingPasses()) { index = numberOfBoardingPasses() - 1; }
      boardingPasses.remove(aBoardingPass);
      boardingPasses.add(index, aBoardingPass);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBoardingPassAt(aBoardingPass, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (seats.size() > 0)
    {
      Seat aSeat = seats.get(seats.size() - 1);
      aSeat.delete();
      seats.remove(aSeat);
    }
    
    Aircraft existingAircraft = aircraft;
    aircraft = null;
    if (existingAircraft != null)
    {
      existingAircraft.delete();
    }
    ArrayList<Crew> copyOfCrews = new ArrayList<Crew>(crews);
    crews.clear();
    for(Crew aCrew : copyOfCrews)
    {
      aCrew.removeFlight(this);
    }
    for(int i=boardingPasses.size(); i > 0; i--)
    {
      BoardingPass aBoardingPass = boardingPasses.get(i - 1);
      aBoardingPass.delete();
    }
  }

  // line 77 "model.ump"
   public void checkAvailability(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "flightNumber" + "=" + (getFlightNumber() != null ? !getFlightNumber().equals(this)  ? getFlightNumber().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "aircraftNo" + "=" + (getAircraftNo() != null ? !getAircraftNo().equals(this)  ? getAircraftNo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "departureAirport" + "=" + (getDepartureAirport() != null ? !getDepartureAirport().equals(this)  ? getDepartureAirport().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "arrivalAirport" + "=" + (getArrivalAirport() != null ? !getArrivalAirport().equals(this)  ? getArrivalAirport().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "departureTime" + "=" + (getDepartureTime() != null ? !getDepartureTime().equals(this)  ? getDepartureTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "arrivalTime" + "=" + (getArrivalTime() != null ? !getArrivalTime().equals(this)  ? getArrivalTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "stops" + "=" + (getStops() != null ? !getStops().equals(this)  ? getStops().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "aircraft = "+(getAircraft()!=null?Integer.toHexString(System.identityHashCode(getAircraft())):"null");
  }
}