/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 56 "model.ump"
// line 214 "model.ump"
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
  private List<Flight> flights;
  private List<Booking> bookings;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Seat(string aSeatNumber, string aSeatClass, boolean aIsOccuped)
  {
    seatNumber = aSeatNumber;
    seatClass = aSeatClass;
    isOccuped = aIsOccuped;
    flights = new ArrayList<Flight>();
    bookings = new ArrayList<Booking>();
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
  /* Code from template association_GetMany */
  public Booking getBooking(int index)
  {
    Booking aBooking = bookings.get(index);
    return aBooking;
  }

  public List<Booking> getBookings()
  {
    List<Booking> newBookings = Collections.unmodifiableList(bookings);
    return newBookings;
  }

  public int numberOfBookings()
  {
    int number = bookings.size();
    return number;
  }

  public boolean hasBookings()
  {
    boolean has = bookings.size() > 0;
    return has;
  }

  public int indexOfBooking(Booking aBooking)
  {
    int index = bookings.indexOf(aBooking);
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
    if (aFlight.indexOfSeat(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFlight.addSeat(this);
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
    if (aFlight.indexOfSeat(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFlight.removeSeat(this);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBookings()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addBooking(Booking aBooking)
  {
    boolean wasAdded = false;
    if (bookings.contains(aBooking)) { return false; }
    bookings.add(aBooking);
    if (aBooking.indexOfSeat(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBooking.addSeat(this);
      if (!wasAdded)
      {
        bookings.remove(aBooking);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeBooking(Booking aBooking)
  {
    boolean wasRemoved = false;
    if (!bookings.contains(aBooking))
    {
      return wasRemoved;
    }

    int oldIndex = bookings.indexOf(aBooking);
    bookings.remove(oldIndex);
    if (aBooking.indexOfSeat(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBooking.removeSeat(this);
      if (!wasRemoved)
      {
        bookings.add(oldIndex,aBooking);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBookingAt(Booking aBooking, int index)
  {  
    boolean wasAdded = false;
    if(addBooking(aBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBookings()) { index = numberOfBookings() - 1; }
      bookings.remove(aBooking);
      bookings.add(index, aBooking);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBookingAt(Booking aBooking, int index)
  {
    boolean wasAdded = false;
    if(bookings.contains(aBooking))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBookings()) { index = numberOfBookings() - 1; }
      bookings.remove(aBooking);
      bookings.add(index, aBooking);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBookingAt(aBooking, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Flight> copyOfFlights = new ArrayList<Flight>(flights);
    flights.clear();
    for(Flight aFlight : copyOfFlights)
    {
      if (aFlight.numberOfSeats() <= Flight.minimumNumberOfSeats())
      {
        aFlight.delete();
      }
      else
      {
        aFlight.removeSeat(this);
      }
    }
    ArrayList<Booking> copyOfBookings = new ArrayList<Booking>(bookings);
    bookings.clear();
    for(Booking aBooking : copyOfBookings)
    {
      aBooking.removeSeat(this);
    }
  }

  // line 63 "model.ump"
   public void assignSeat(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "isOccuped" + ":" + getIsOccuped()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "seatNumber" + "=" + (getSeatNumber() != null ? !getSeatNumber().equals(this)  ? getSeatNumber().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "seatClass" + "=" + (getSeatClass() != null ? !getSeatClass().equals(this)  ? getSeatClass().toString().replaceAll("  ","    ") : "this" : "null");
  }
}