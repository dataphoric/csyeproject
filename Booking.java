/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 33 "model.ump"
// line 204 "model.ump"
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
  private List<Seat> seats;
  private List<Payment> payments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Booking(string aBookingID, date aBookingDate, string aPaymentInfo, Passenger aPassenger)
  {
    bookingID = aBookingID;
    bookingDate = aBookingDate;
    paymentInfo = aPaymentInfo;
    boolean didAddPassenger = setPassenger(aPassenger);
    if (!didAddPassenger)
    {
      throw new RuntimeException("Unable to create booking due to passenger. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    seats = new ArrayList<Seat>();
    payments = new ArrayList<Payment>();
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
  /* Code from template association_GetMany */
  public Payment getPayment(int index)
  {
    Payment aPayment = payments.get(index);
    return aPayment;
  }

  public List<Payment> getPayments()
  {
    List<Payment> newPayments = Collections.unmodifiableList(payments);
    return newPayments;
  }

  public int numberOfPayments()
  {
    int number = payments.size();
    return number;
  }

  public boolean hasPayments()
  {
    boolean has = payments.size() > 0;
    return has;
  }

  public int indexOfPayment(Payment aPayment)
  {
    int index = payments.indexOf(aPayment);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSeats()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addSeat(Seat aSeat)
  {
    boolean wasAdded = false;
    if (seats.contains(aSeat)) { return false; }
    seats.add(aSeat);
    if (aSeat.indexOfBooking(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSeat.addBooking(this);
      if (!wasAdded)
      {
        seats.remove(aSeat);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeSeat(Seat aSeat)
  {
    boolean wasRemoved = false;
    if (!seats.contains(aSeat))
    {
      return wasRemoved;
    }

    int oldIndex = seats.indexOf(aSeat);
    seats.remove(oldIndex);
    if (aSeat.indexOfBooking(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSeat.removeBooking(this);
      if (!wasRemoved)
      {
        seats.add(oldIndex,aSeat);
      }
    }
    return wasRemoved;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPayments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPayment(Payment aPayment)
  {
    boolean wasAdded = false;
    if (payments.contains(aPayment)) { return false; }
    payments.add(aPayment);
    if (aPayment.indexOfBooking(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPayment.addBooking(this);
      if (!wasAdded)
      {
        payments.remove(aPayment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePayment(Payment aPayment)
  {
    boolean wasRemoved = false;
    if (!payments.contains(aPayment))
    {
      return wasRemoved;
    }

    int oldIndex = payments.indexOf(aPayment);
    payments.remove(oldIndex);
    if (aPayment.indexOfBooking(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPayment.removeBooking(this);
      if (!wasRemoved)
      {
        payments.add(oldIndex,aPayment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPaymentAt(Payment aPayment, int index)
  {  
    boolean wasAdded = false;
    if(addPayment(aPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPayments()) { index = numberOfPayments() - 1; }
      payments.remove(aPayment);
      payments.add(index, aPayment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePaymentAt(Payment aPayment, int index)
  {
    boolean wasAdded = false;
    if(payments.contains(aPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPayments()) { index = numberOfPayments() - 1; }
      payments.remove(aPayment);
      payments.add(index, aPayment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPaymentAt(aPayment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Passenger placeholderPassenger = passenger;
    this.passenger = null;
    if(placeholderPassenger != null)
    {
      placeholderPassenger.removeBooking(this);
    }
    ArrayList<Seat> copyOfSeats = new ArrayList<Seat>(seats);
    seats.clear();
    for(Seat aSeat : copyOfSeats)
    {
      aSeat.removeBooking(this);
    }
    ArrayList<Payment> copyOfPayments = new ArrayList<Payment>(payments);
    payments.clear();
    for(Payment aPayment : copyOfPayments)
    {
      aPayment.removeBooking(this);
    }
  }

  // line 40 "model.ump"
   public void makePayment(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bookingID" + "=" + (getBookingID() != null ? !getBookingID().equals(this)  ? getBookingID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bookingDate" + "=" + (getBookingDate() != null ? !getBookingDate().equals(this)  ? getBookingDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "paymentInfo" + "=" + (getPaymentInfo() != null ? !getPaymentInfo().equals(this)  ? getPaymentInfo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "passenger = "+(getPassenger()!=null?Integer.toHexString(System.identityHashCode(getPassenger())):"null");
  }
}