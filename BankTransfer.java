/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 175 "model.ump"
// line 255 "model.ump"
public class BankTransfer extends Payment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BankTransfer Attributes
  private string bankCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BankTransfer(string aPaymentID, int aAmount, string aCurrency, string aBookingID, string aBankCode)
  {
    super(aPaymentID, aAmount, aCurrency, aBookingID);
    bankCode = aBankCode;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBankCode(string aBankCode)
  {
    boolean wasSet = false;
    bankCode = aBankCode;
    wasSet = true;
    return wasSet;
  }

  public string getBankCode()
  {
    return bankCode;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bankCode" + "=" + (getBankCode() != null ? !getBankCode().equals(this)  ? getBankCode().toString().replaceAll("  ","    ") : "this" : "null");
  }
}