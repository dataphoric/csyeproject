/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 142 "model.ump"
// line 249 "model.ump"
public class AgentBooking extends Booking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AgentBooking Attributes
  private string agentID;
  private string agentName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AgentBooking(string aBookingID, date aBookingDate, string aPaymentInfo, Passenger aPassenger, Seat aSeat, Payment aPayment, string aAgentID, string aAgentName)
  {
    super(aBookingID, aBookingDate, aPaymentInfo, aPassenger, aSeat, aPayment);
    agentID = aAgentID;
    agentName = aAgentName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAgentID(string aAgentID)
  {
    boolean wasSet = false;
    agentID = aAgentID;
    wasSet = true;
    return wasSet;
  }

  public boolean setAgentName(string aAgentName)
  {
    boolean wasSet = false;
    agentName = aAgentName;
    wasSet = true;
    return wasSet;
  }

  public string getAgentID()
  {
    return agentID;
  }

  public string getAgentName()
  {
    return agentName;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "agentID" + "=" + (getAgentID() != null ? !getAgentID().equals(this)  ? getAgentID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "agentName" + "=" + (getAgentName() != null ? !getAgentName().equals(this)  ? getAgentName().toString().replaceAll("  ","    ") : "this" : "null");
  }
}