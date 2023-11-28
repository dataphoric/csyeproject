/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 80 "model.ump"
// line 224 "model.ump"
public class Payment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Payment Attributes
  private string paymentID;
  private int amount;
  private string currency;
  private string bookingID;

  //Payment Associations
  private Refund refund;
  private List<Booking> bookings;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Payment(string aPaymentID, int aAmount, string aCurrency, string aBookingID)
  {
    paymentID = aPaymentID;
    amount = aAmount;
    currency = aCurrency;
    bookingID = aBookingID;
    bookings = new ArrayList<Booking>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPaymentID(string aPaymentID)
  {
    boolean wasSet = false;
    paymentID = aPaymentID;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmount(int aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrency(string aCurrency)
  {
    boolean wasSet = false;
    currency = aCurrency;
    wasSet = true;
    return wasSet;
  }

  public boolean setBookingID(string aBookingID)
  {
    boolean wasSet = false;
    bookingID = aBookingID;
    wasSet = true;
    return wasSet;
  }

  public string getPaymentID()
  {
    return paymentID;
  }

  public int getAmount()
  {
    return amount;
  }

  public string getCurrency()
  {
    return currency;
  }

  public string getBookingID()
  {
    return bookingID;
  }
  /* Code from template association_GetOne */
  public Refund getRefund()
  {
    return refund;
  }

  public boolean hasRefund()
  {
    boolean has = refund != null;
    return has;
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
  /* Code from template association_SetOptionalOneToOne */
  public boolean setRefund(Refund aNewRefund)
  {
    boolean wasSet = false;
    if (refund != null && !refund.equals(aNewRefund) && equals(refund.getPayment()))
    {
      //Unable to setRefund, as existing refund would become an orphan
      return wasSet;
    }

    refund = aNewRefund;
    Payment anOldPayment = aNewRefund != null ? aNewRefund.getPayment() : null;

    if (!this.equals(anOldPayment))
    {
      if (anOldPayment != null)
      {
        anOldPayment.refund = null;
      }
      if (refund != null)
      {
        refund.setPayment(this);
      }
    }
    wasSet = true;
    return wasSet;
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
    if (aBooking.indexOfPayment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBooking.addPayment(this);
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
    if (aBooking.indexOfPayment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBooking.removePayment(this);
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
    Refund existingRefund = refund;
    refund = null;
    if (existingRefund != null)
    {
      existingRefund.delete();
    }
    ArrayList<Booking> copyOfBookings = new ArrayList<Booking>(bookings);
    bookings.clear();
    for(Booking aBooking : copyOfBookings)
    {
      aBooking.removePayment(this);
    }
  }

  // line 89 "model.ump"
   public void makeRefund(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "amount" + ":" + getAmount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "paymentID" + "=" + (getPaymentID() != null ? !getPaymentID().equals(this)  ? getPaymentID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currency" + "=" + (getCurrency() != null ? !getCurrency().equals(this)  ? getCurrency().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bookingID" + "=" + (getBookingID() != null ? !getBookingID().equals(this)  ? getBookingID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "refund = "+(getRefund()!=null?Integer.toHexString(System.identityHashCode(getRefund())):"null");
  }
}