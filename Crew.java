/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 96 "model.ump"
// line 230 "model.ump"
public class Crew
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Crew Attributes
  private string crewID;
  private string name;
  private string position;
  private string contactInfo;

  //Crew Associations
  private List<Flight> flights;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Crew(string aCrewID, string aName, string aPosition, string aContactInfo)
  {
    crewID = aCrewID;
    name = aName;
    position = aPosition;
    contactInfo = aContactInfo;
    flights = new ArrayList<Flight>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCrewID(string aCrewID)
  {
    boolean wasSet = false;
    crewID = aCrewID;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(string aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(string aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setContactInfo(string aContactInfo)
  {
    boolean wasSet = false;
    contactInfo = aContactInfo;
    wasSet = true;
    return wasSet;
  }

  public string getCrewID()
  {
    return crewID;
  }

  public string getName()
  {
    return name;
  }

  public string getPosition()
  {
    return position;
  }

  public string getContactInfo()
  {
    return contactInfo;
  }
  /* Code from template association_GetMany */
  public Flight getFlight(int index)
  {
    Flight aFlight = flights.get(index);
    return aFlight;
  }

  public List<Flight> getFlights()
  {
    List<Flight> newFlights = Collections.unmodifiableList(flights);
    return newFlights;
  }

  public int numberOfFlights()
  {
    int number = flights.size();
    return number;
  }

  public boolean hasFlights()
  {
    boolean has = flights.size() > 0;
    return has;
  }

  public int indexOfFlight(Flight aFlight)
  {
    int index = flights.indexOf(aFlight);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfFlights()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addFlight(Flight aFlight)
  {
    boolean wasAdded = false;
    if (flights.contains(aFlight)) { return false; }
    flights.add(aFlight);
    if (aFlight.indexOfCrew(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFlight.addCrew(this);
      if (!wasAdded)
      {
        flights.remove(aFlight);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeFlight(Flight aFlight)
  {
    boolean wasRemoved = false;
    if (!flights.contains(aFlight))
    {
      return wasRemoved;
    }

    int oldIndex = flights.indexOf(aFlight);
    flights.remove(oldIndex);
    if (aFlight.indexOfCrew(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFlight.removeCrew(this);
      if (!wasRemoved)
      {
        flights.add(oldIndex,aFlight);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addFlightAt(Flight aFlight, int index)
  {  
    boolean wasAdded = false;
    if(addFlight(aFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFlights()) { index = numberOfFlights() - 1; }
      flights.remove(aFlight);
      flights.add(index, aFlight);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFlightAt(Flight aFlight, int index)
  {
    boolean wasAdded = false;
    if(flights.contains(aFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFlights()) { index = numberOfFlights() - 1; }
      flights.remove(aFlight);
      flights.add(index, aFlight);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFlightAt(aFlight, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Flight> copyOfFlights = new ArrayList<Flight>(flights);
    flights.clear();
    for(Flight aFlight : copyOfFlights)
    {
      if (aFlight.numberOfCrews() <= Flight.minimumNumberOfCrews())
      {
        aFlight.delete();
      }
      else
      {
        aFlight.removeCrew(this);
      }
    }
  }

  // line 104 "model.ump"
   public void viewFlight(){
    
  }

  // line 107 "model.ump"
   public void performSafetCheck(){
    
  }

  // line 110 "model.ump"
   public void assistPassengers(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "crewID" + "=" + (getCrewID() != null ? !getCrewID().equals(this)  ? getCrewID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "name" + "=" + (getName() != null ? !getName().equals(this)  ? getName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "contactInfo" + "=" + (getContactInfo() != null ? !getContactInfo().equals(this)  ? getContactInfo().toString().replaceAll("  ","    ") : "this" : "null");
  }
}