/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 155 "model.ump"
// line 239 "model.ump"
public class Document
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Document Attributes
  private string docID;
  private string docType;

  //Document Associations
  private Passenger passenger;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Document(string aDocID, string aDocType, Passenger aPassenger)
  {
    docID = aDocID;
    docType = aDocType;
    if (aPassenger == null || aPassenger.getDocument() != null)
    {
      throw new RuntimeException("Unable to create Document due to aPassenger. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    passenger = aPassenger;
  }

  public Document(string aDocID, string aDocType, string aPassIDForPassenger, string aNameForPassenger, string aEmailForPassenger, string aPhoneForPassenger, string aAddressForPassenger)
  {
    docID = aDocID;
    docType = aDocType;
    passenger = new Passenger(aPassIDForPassenger, aNameForPassenger, aEmailForPassenger, aPhoneForPassenger, aAddressForPassenger, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDocID(string aDocID)
  {
    boolean wasSet = false;
    docID = aDocID;
    wasSet = true;
    return wasSet;
  }

  public boolean setDocType(string aDocType)
  {
    boolean wasSet = false;
    docType = aDocType;
    wasSet = true;
    return wasSet;
  }

  public string getDocID()
  {
    return docID;
  }

  public string getDocType()
  {
    return docType;
  }
  /* Code from template association_GetOne */
  public Passenger getPassenger()
  {
    return passenger;
  }

  public void delete()
  {
    Passenger existingPassenger = passenger;
    passenger = null;
    if (existingPassenger != null)
    {
      existingPassenger.delete();
    }
  }

  // line 161 "model.ump"
   public void validateDocument(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "docID" + "=" + (getDocID() != null ? !getDocID().equals(this)  ? getDocID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "docType" + "=" + (getDocType() != null ? !getDocType().equals(this)  ? getDocType().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "passenger = "+(getPassenger()!=null?Integer.toHexString(System.identityHashCode(getPassenger())):"null");
  }
}