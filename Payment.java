/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 79 "model.ump"
// line 223 "model.ump"
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
  private Booking booking;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Payment(string aPaymentID, int aAmount, string aCurrency, string aBookingID, Booking aBooking)
  {
    paymentID = aPaymentID;
    amount = aAmount;
    currency = aCurrency;
    bookingID = aBookingID;
    if (aBooking == null || aBooking.getPayment() != null)
    {
      throw new RuntimeException("Unable to create Payment due to aBooking. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    booking = aBooking;
  }

  public Payment(string aPaymentID, int aAmount, string aCurrency, string aBookingID, string aBookingIDForBooking, date aBookingDateForBooking, string aPaymentInfoForBooking, Passenger aPassengerForBooking, Seat aSeatForBooking)
  {
    paymentID = aPaymentID;
    amount = aAmount;
    currency = aCurrency;
    bookingID = aBookingID;
    booking = new Booking(aBookingIDForBooking, aBookingDateForBooking, aPaymentInfoForBooking, aPassengerForBooking, aSeatForBooking, this);
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
  /* Code from template association_GetOne */
  public Booking getBooking()
  {
    return booking;
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

  public void delete()
  {
    Refund existingRefund = refund;
    refund = null;
    if (existingRefund != null)
    {
      existingRefund.delete();
    }
    Booking existingBooking = booking;
    booking = null;
    if (existingBooking != null)
    {
      existingBooking.delete();
    }
  }

  // line 88 "model.ump"
   public void makeRefund(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "amount" + ":" + getAmount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "paymentID" + "=" + (getPaymentID() != null ? !getPaymentID().equals(this)  ? getPaymentID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currency" + "=" + (getCurrency() != null ? !getCurrency().equals(this)  ? getCurrency().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bookingID" + "=" + (getBookingID() != null ? !getBookingID().equals(this)  ? getBookingID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "refund = "+(getRefund()!=null?Integer.toHexString(System.identityHashCode(getRefund())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "booking = "+(getBooking()!=null?Integer.toHexString(System.identityHashCode(getBooking())):"null");
  }
}