/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 42 "model.ump"
// line 208 "model.ump"
public class Aircraft
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Aircraft Attributes
  private string aircraftID;
  private string model;
  private int capacity;

  //Aircraft Associations
  private Flight flight;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Aircraft(string aAircraftID, string aModel, int aCapacity, Flight aFlight)
  {
    aircraftID = aAircraftID;
    model = aModel;
    capacity = aCapacity;
    if (aFlight == null || aFlight.getAircraft() != null)
    {
      throw new RuntimeException("Unable to create Aircraft due to aFlight. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    flight = aFlight;
  }

  public Aircraft(string aAircraftID, string aModel, int aCapacity, string aFlightNumberForFlight, string aAircraftNoForFlight, string aDepartureAirportForFlight, string aArrivalAirportForFlight, datetime aDepartureTimeForFlight, datetime aArrivalTimeForFlight, string aStopsForFlight)
  {
    aircraftID = aAircraftID;
    model = aModel;
    capacity = aCapacity;
    flight = new Flight(aFlightNumberForFlight, aAircraftNoForFlight, aDepartureAirportForFlight, aArrivalAirportForFlight, aDepartureTimeForFlight, aArrivalTimeForFlight, aStopsForFlight, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAircraftID(string aAircraftID)
  {
    boolean wasSet = false;
    aircraftID = aAircraftID;
    wasSet = true;
    return wasSet;
  }

  public boolean setModel(string aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacity(int aCapacity)
  {
    boolean wasSet = false;
    capacity = aCapacity;
    wasSet = true;
    return wasSet;
  }

  public string getAircraftID()
  {
    return aircraftID;
  }

  public string getModel()
  {
    return model;
  }

  public int getCapacity()
  {
    return capacity;
  }
  /* Code from template association_GetOne */
  public Flight getFlight()
  {
    return flight;
  }

  public void delete()
  {
    Flight existingFlight = flight;
    flight = null;
    if (existingFlight != null)
    {
      existingFlight.delete();
    }
  }

  // line 49 "model.ump"
   public void loadCargo(){
    
  }

  // line 52 "model.ump"
   public void boardingPassenger(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "capacity" + ":" + getCapacity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "aircraftID" + "=" + (getAircraftID() != null ? !getAircraftID().equals(this)  ? getAircraftID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "flight = "+(getFlight()!=null?Integer.toHexString(System.identityHashCode(getFlight())):"null");
  }
}