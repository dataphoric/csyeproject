/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 95 "model.ump"
// line 229 "model.ump"
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
  private Flight flight;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Crew(string aCrewID, string aName, string aPosition, string aContactInfo, Flight aFlight)
  {
    crewID = aCrewID;
    name = aName;
    position = aPosition;
    contactInfo = aContactInfo;
    boolean didAddFlight = setFlight(aFlight);
    if (!didAddFlight)
    {
      throw new RuntimeException("Unable to create crew due to flight. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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
  /* Code from template association_GetOne */
  public Flight getFlight()
  {
    return flight;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setFlight(Flight aFlight)
  {
    boolean wasSet = false;
    //Must provide flight to crew
    if (aFlight == null)
    {
      return wasSet;
    }

    if (flight != null && flight.numberOfCrews() <= Flight.minimumNumberOfCrews())
    {
      return wasSet;
    }

    Flight existingFlight = flight;
    flight = aFlight;
    if (existingFlight != null && !existingFlight.equals(aFlight))
    {
      boolean didRemove = existingFlight.removeCrew(this);
      if (!didRemove)
      {
        flight = existingFlight;
        return wasSet;
      }
    }
    flight.addCrew(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Flight placeholderFlight = flight;
    this.flight = null;
    if(placeholderFlight != null)
    {
      placeholderFlight.removeCrew(this);
    }
  }

  // line 103 "model.ump"
   public void viewFlight(){
    
  }

  // line 106 "model.ump"
   public void performSafetCheck(){
    
  }

  // line 109 "model.ump"
   public void assistPassengers(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "crewID" + "=" + (getCrewID() != null ? !getCrewID().equals(this)  ? getCrewID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "name" + "=" + (getName() != null ? !getName().equals(this)  ? getName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "contactInfo" + "=" + (getContactInfo() != null ? !getContactInfo().equals(this)  ? getContactInfo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "flight = "+(getFlight()!=null?Integer.toHexString(System.identityHashCode(getFlight())):"null");
  }
}