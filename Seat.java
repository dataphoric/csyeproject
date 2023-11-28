/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 55 "model.ump"
// line 213 "model.ump"
public class Seat
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Seat Attributes
  private string seatNumber;
  private string seatClass;
  private boolean isOccuped;

  //Seat Associations
  private Flight flight;
  private Booking booking;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Seat(string aSeatNumber, string aSeatClass, boolean aIsOccuped, Flight aFlight, Booking aBooking)
  {
    seatNumber = aSeatNumber;
    seatClass = aSeatClass;
    isOccuped = aIsOccuped;
    boolean didAddFlight = setFlight(aFlight);
    if (!didAddFlight)
    {
      throw new RuntimeException("Unable to create seat due to flight. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aBooking == null || aBooking.getSeat() != null)
    {
      throw new RuntimeException("Unable to create Seat due to aBooking. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    booking = aBooking;
  }

  public Seat(string aSeatNumber, string aSeatClass, boolean aIsOccuped, Flight aFlight, string aBookingIDForBooking, date aBookingDateForBooking, string aPaymentInfoForBooking, Passenger aPassengerForBooking, Payment aPaymentForBooking)
  {
    seatNumber = aSeatNumber;
    seatClass = aSeatClass;
    isOccuped = aIsOccuped;
    boolean didAddFlight = setFlight(aFlight);
    if (!didAddFlight)
    {
      throw new RuntimeException("Unable to create seat due to flight. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    booking = new Booking(aBookingIDForBooking, aBookingDateForBooking, aPaymentInfoForBooking, aPassengerForBooking, this, aPaymentForBooking);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSeatNumber(string aSeatNumber)
  {
    boolean wasSet = false;
    seatNumber = aSeatNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setSeatClass(string aSeatClass)
  {
    boolean wasSet = false;
    seatClass = aSeatClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsOccuped(boolean aIsOccuped)
  {
    boolean wasSet = false;
    isOccuped = aIsOccuped;
    wasSet = true;
    return wasSet;
  }

  public string getSeatNumber()
  {
    return seatNumber;
  }

  public string getSeatClass()
  {
    return seatClass;
  }

  public boolean getIsOccuped()
  {
    return isOccuped;
  }
  /* Code from template association_GetOne */
  public Flight getFlight()
  {
    return flight;
  }
  /* Code from template association_GetOne */
  public Booking getBooking()
  {
    return booking;
  }
  /* Code from template association_SetOneToMany */
  public boolean setFlight(Flight aFlight)
  {
    boolean wasSet = false;
    if (aFlight == null)
    {
      return wasSet;
    }

    Flight existingFlight = flight;
    flight = aFlight;
    if (existingFlight != null && !existingFlight.equals(aFlight))
    {
      existingFlight.removeSeat(this);
    }
    flight.addSeat(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Flight placeholderFlight = flight;
    this.flight = null;
    if(placeholderFlight != null)
    {
      placeholderFlight.removeSeat(this);
    }
    Booking existingBooking = booking;
    booking = null;
    if (existingBooking != null)
    {
      existingBooking.delete();
    }
  }

  // line 62 "model.ump"
   public void assignSeat(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "isOccuped" + ":" + getIsOccuped()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "seatNumber" + "=" + (getSeatNumber() != null ? !getSeatNumber().equals(this)  ? getSeatNumber().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "seatClass" + "=" + (getSeatClass() != null ? !getSeatClass().equals(this)  ? getSeatClass().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "flight = "+(getFlight()!=null?Integer.toHexString(System.identityHashCode(getFlight())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "booking = "+(getBooking()!=null?Integer.toHexString(System.identityHashCode(getBooking())):"null");
  }
}