/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 32 "model.ump"
// line 203 "model.ump"
public class Booking
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Booking Attributes
  private string bookingID;
  private date bookingDate;
  private string paymentInfo;

  //Booking Associations
  private Passenger passenger;
  private Seat seat;
  private Payment payment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Booking(string aBookingID, date aBookingDate, string aPaymentInfo, Passenger aPassenger, Seat aSeat, Payment aPayment)
  {
    bookingID = aBookingID;
    bookingDate = aBookingDate;
    paymentInfo = aPaymentInfo;
    boolean didAddPassenger = setPassenger(aPassenger);
    if (!didAddPassenger)
    {
      throw new RuntimeException("Unable to create booking due to passenger. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aSeat == null || aSeat.getBooking() != null)
    {
      throw new RuntimeException("Unable to create Booking due to aSeat. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    seat = aSeat;
    if (aPayment == null || aPayment.getBooking() != null)
    {
      throw new RuntimeException("Unable to create Booking due to aPayment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    payment = aPayment;
  }

  public Booking(string aBookingID, date aBookingDate, string aPaymentInfo, Passenger aPassenger, string aSeatNumberForSeat, string aSeatClassForSeat, boolean aIsOccupedForSeat, Flight aFlightForSeat, string aPaymentIDForPayment, int aAmountForPayment, string aCurrencyForPayment, string aBookingIDForPayment)
  {
    bookingID = aBookingID;
    bookingDate = aBookingDate;
    paymentInfo = aPaymentInfo;
    boolean didAddPassenger = setPassenger(aPassenger);
    if (!didAddPassenger)
    {
      throw new RuntimeException("Unable to create booking due to passenger. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    seat = new Seat(aSeatNumberForSeat, aSeatClassForSeat, aIsOccupedForSeat, aFlightForSeat, this);
    payment = new Payment(aPaymentIDForPayment, aAmountForPayment, aCurrencyForPayment, aBookingIDForPayment, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBookingID(string aBookingID)
  {
    boolean wasSet = false;
    bookingID = aBookingID;
    wasSet = true;
    return wasSet;
  }

  public boolean setBookingDate(date aBookingDate)
  {
    boolean wasSet = false;
    bookingDate = aBookingDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setPaymentInfo(string aPaymentInfo)
  {
    boolean wasSet = false;
    paymentInfo = aPaymentInfo;
    wasSet = true;
    return wasSet;
  }

  public string getBookingID()
  {
    return bookingID;
  }

  public date getBookingDate()
  {
    return bookingDate;
  }

  public string getPaymentInfo()
  {
    return paymentInfo;
  }
  /* Code from template association_GetOne */
  public Passenger getPassenger()
  {
    return passenger;
  }
  /* Code from template association_GetOne */
  public Seat getSeat()
  {
    return seat;
  }
  /* Code from template association_GetOne */
  public Payment getPayment()
  {
    return payment;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPassenger(Passenger aPassenger)
  {
    boolean wasSet = false;
    if (aPassenger == null)
    {
      return wasSet;
    }

    Passenger existingPassenger = passenger;
    passenger = aPassenger;
    if (existingPassenger != null && !existingPassenger.equals(aPassenger))
    {
      existingPassenger.removeBooking(this);
    }
    passenger.addBooking(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Passenger placeholderPassenger = passenger;
    this.passenger = null;
    if(placeholderPassenger != null)
    {
      placeholderPassenger.removeBooking(this);
    }
    Seat existingSeat = seat;
    seat = null;
    if (existingSeat != null)
    {
      existingSeat.delete();
    }
    Payment existingPayment = payment;
    payment = null;
    if (existingPayment != null)
    {
      existingPayment.delete();
    }
  }

  // line 39 "model.ump"
   public void makePayment(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bookingID" + "=" + (getBookingID() != null ? !getBookingID().equals(this)  ? getBookingID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bookingDate" + "=" + (getBookingDate() != null ? !getBookingDate().equals(this)  ? getBookingDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "paymentInfo" + "=" + (getPaymentInfo() != null ? !getPaymentInfo().equals(this)  ? getPaymentInfo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "passenger = "+(getPassenger()!=null?Integer.toHexString(System.identityHashCode(getPassenger())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "seat = "+(getSeat()!=null?Integer.toHexString(System.identityHashCode(getSeat())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "payment = "+(getPayment()!=null?Integer.toHexString(System.identityHashCode(getPayment())):"null");
  }
}