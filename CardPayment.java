/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 181 "model.ump"
// line 260 "model.ump"
public class CardPayment extends Payment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CardPayment Attributes
  private string cardType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CardPayment(string aPaymentID, int aAmount, string aCurrency, string aBookingID, string aCardType)
  {
    super(aPaymentID, aAmount, aCurrency, aBookingID);
    cardType = aCardType;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCardType(string aCardType)
  {
    boolean wasSet = false;
    cardType = aCardType;
    wasSet = true;
    return wasSet;
  }

  public string getCardType()
  {
    return cardType;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cardType" + "=" + (getCardType() != null ? !getCardType().equals(this)  ? getCardType().toString().replaceAll("  ","    ") : "this" : "null");
  }
}