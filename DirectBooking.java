/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 150 "model.ump"
// line 235 "model.ump"
public class DirectBooking extends Booking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DirectBooking Attributes
  private string status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DirectBooking(string aBookingID, date aBookingDate, string aPaymentInfo, Passenger aPassenger, string aStatus)
  {
    super(aBookingID, aBookingDate, aPaymentInfo, aPassenger);
    status = aStatus;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStatus(string aStatus)
  {
    boolean wasSet = false;
    status = aStatus;
    wasSet = true;
    return wasSet;
  }

  public string getStatus()
  {
    return status;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "status" + "=" + (getStatus() != null ? !getStatus().equals(this)  ? getStatus().toString().replaceAll("  ","    ") : "this" : "null");
  }
}