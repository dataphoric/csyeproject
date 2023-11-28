/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 3 "model.ump"
// line 192 "model.ump"
public class Passenger
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Passenger Attributes
  private string passID;
  private string name;
  private string email;
  private string phone;
  private string address;

  //Passenger Associations
  private List<Refund> refunds;
  private List<Booking> bookings;
  private List<BoardingPass> boardingPasses;
  private List<Document> documents;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Passenger(string aPassID, string aName, string aEmail, string aPhone, string aAddress)
  {
    passID = aPassID;
    name = aName;
    email = aEmail;
    phone = aPhone;
    address = aAddress;
    refunds = new ArrayList<Refund>();
    bookings = new ArrayList<Booking>();
    boardingPasses = new ArrayList<BoardingPass>();
    documents = new ArrayList<Document>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPassID(string aPassID)
  {
    boolean wasSet = false;
    passID = aPassID;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(string aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(string aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(string aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(string aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public string getPassID()
  {
    return passID;
  }

  public string getName()
  {
    return name;
  }

  public string getEmail()
  {
    return email;
  }

  public string getPhone()
  {
    return phone;
  }

  public string getAddress()
  {
    return address;
  }
  /* Code from template association_GetMany */
  public Refund getRefund(int index)
  {
    Refund aRefund = refunds.get(index);
    return aRefund;
  }

  public List<Refund> getRefunds()
  {
    List<Refund> newRefunds = Collections.unmodifiableList(refunds);
    return newRefunds;
  }

  public int numberOfRefunds()
  {
    int number = refunds.size();
    return number;
  }

  public boolean hasRefunds()
  {
    boolean has = refunds.size() > 0;
    return has;
  }

  public int indexOfRefund(Refund aRefund)
  {
    int index = refunds.indexOf(aRefund);
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
  /* Code from template association_GetMany */
  public BoardingPass getBoardingPass(int index)
  {
    BoardingPass aBoardingPass = boardingPasses.get(index);
    return aBoardingPass;
  }

  public List<BoardingPass> getBoardingPasses()
  {
    List<BoardingPass> newBoardingPasses = Collections.unmodifiableList(boardingPasses);
    return newBoardingPasses;
  }

  public int numberOfBoardingPasses()
  {
    int number = boardingPasses.size();
    return number;
  }

  public boolean hasBoardingPasses()
  {
    boolean has = boardingPasses.size() > 0;
    return has;
  }

  public int indexOfBoardingPass(BoardingPass aBoardingPass)
  {
    int index = boardingPasses.indexOf(aBoardingPass);
    return index;
  }
  /* Code from template association_GetMany */
  public Document getDocument(int index)
  {
    Document aDocument = documents.get(index);
    return aDocument;
  }

  public List<Document> getDocuments()
  {
    List<Document> newDocuments = Collections.unmodifiableList(documents);
    return newDocuments;
  }

  public int numberOfDocuments()
  {
    int number = documents.size();
    return number;
  }

  public boolean hasDocuments()
  {
    boolean has = documents.size() > 0;
    return has;
  }

  public int indexOfDocument(Document aDocument)
  {
    int index = documents.indexOf(aDocument);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRefunds()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Refund addRefund(string aRefundID, int aRefundAmt, date aDate, Payment aPayment)
  {
    return new Refund(aRefundID, aRefundAmt, aDate, this, aPayment);
  }

  public boolean addRefund(Refund aRefund)
  {
    boolean wasAdded = false;
    if (refunds.contains(aRefund)) { return false; }
    Passenger existingPassenger = aRefund.getPassenger();
    boolean isNewPassenger = existingPassenger != null && !this.equals(existingPassenger);
    if (isNewPassenger)
    {
      aRefund.setPassenger(this);
    }
    else
    {
      refunds.add(aRefund);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRefund(Refund aRefund)
  {
    boolean wasRemoved = false;
    //Unable to remove aRefund, as it must always have a passenger
    if (!this.equals(aRefund.getPassenger()))
    {
      refunds.remove(aRefund);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRefundAt(Refund aRefund, int index)
  {  
    boolean wasAdded = false;
    if(addRefund(aRefund))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRefunds()) { index = numberOfRefunds() - 1; }
      refunds.remove(aRefund);
      refunds.add(index, aRefund);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRefundAt(Refund aRefund, int index)
  {
    boolean wasAdded = false;
    if(refunds.contains(aRefund))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRefunds()) { index = numberOfRefunds() - 1; }
      refunds.remove(aRefund);
      refunds.add(index, aRefund);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRefundAt(aRefund, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBookings()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Booking addBooking(string aBookingID, date aBookingDate, string aPaymentInfo)
  {
    return new Booking(aBookingID, aBookingDate, aPaymentInfo, this);
  }

  public boolean addBooking(Booking aBooking)
  {
    boolean wasAdded = false;
    if (bookings.contains(aBooking)) { return false; }
    Passenger existingPassenger = aBooking.getPassenger();
    boolean isNewPassenger = existingPassenger != null && !this.equals(existingPassenger);
    if (isNewPassenger)
    {
      aBooking.setPassenger(this);
    }
    else
    {
      bookings.add(aBooking);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBooking(Booking aBooking)
  {
    boolean wasRemoved = false;
    //Unable to remove aBooking, as it must always have a passenger
    if (!this.equals(aBooking.getPassenger()))
    {
      bookings.remove(aBooking);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBoardingPasses()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addBoardingPass(BoardingPass aBoardingPass)
  {
    boolean wasAdded = false;
    if (boardingPasses.contains(aBoardingPass)) { return false; }
    boardingPasses.add(aBoardingPass);
    if (aBoardingPass.indexOfPassenger(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBoardingPass.addPassenger(this);
      if (!wasAdded)
      {
        boardingPasses.remove(aBoardingPass);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeBoardingPass(BoardingPass aBoardingPass)
  {
    boolean wasRemoved = false;
    if (!boardingPasses.contains(aBoardingPass))
    {
      return wasRemoved;
    }

    int oldIndex = boardingPasses.indexOf(aBoardingPass);
    boardingPasses.remove(oldIndex);
    if (aBoardingPass.indexOfPassenger(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBoardingPass.removePassenger(this);
      if (!wasRemoved)
      {
        boardingPasses.add(oldIndex,aBoardingPass);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBoardingPassAt(BoardingPass aBoardingPass, int index)
  {  
    boolean wasAdded = false;
    if(addBoardingPass(aBoardingPass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoardingPasses()) { index = numberOfBoardingPasses() - 1; }
      boardingPasses.remove(aBoardingPass);
      boardingPasses.add(index, aBoardingPass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBoardingPassAt(BoardingPass aBoardingPass, int index)
  {
    boolean wasAdded = false;
    if(boardingPasses.contains(aBoardingPass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoardingPasses()) { index = numberOfBoardingPasses() - 1; }
      boardingPasses.remove(aBoardingPass);
      boardingPasses.add(index, aBoardingPass);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBoardingPassAt(aBoardingPass, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDocuments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDocument(Document aDocument)
  {
    boolean wasAdded = false;
    if (documents.contains(aDocument)) { return false; }
    documents.add(aDocument);
    if (aDocument.indexOfPassenger(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDocument.addPassenger(this);
      if (!wasAdded)
      {
        documents.remove(aDocument);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDocument(Document aDocument)
  {
    boolean wasRemoved = false;
    if (!documents.contains(aDocument))
    {
      return wasRemoved;
    }

    int oldIndex = documents.indexOf(aDocument);
    documents.remove(oldIndex);
    if (aDocument.indexOfPassenger(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDocument.removePassenger(this);
      if (!wasRemoved)
      {
        documents.add(oldIndex,aDocument);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDocumentAt(Document aDocument, int index)
  {  
    boolean wasAdded = false;
    if(addDocument(aDocument))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDocuments()) { index = numberOfDocuments() - 1; }
      documents.remove(aDocument);
      documents.add(index, aDocument);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDocumentAt(Document aDocument, int index)
  {
    boolean wasAdded = false;
    if(documents.contains(aDocument))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDocuments()) { index = numberOfDocuments() - 1; }
      documents.remove(aDocument);
      documents.add(index, aDocument);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDocumentAt(aDocument, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=refunds.size(); i > 0; i--)
    {
      Refund aRefund = refunds.get(i - 1);
      aRefund.delete();
    }
    for(int i=bookings.size(); i > 0; i--)
    {
      Booking aBooking = bookings.get(i - 1);
      aBooking.delete();
    }
    ArrayList<BoardingPass> copyOfBoardingPasses = new ArrayList<BoardingPass>(boardingPasses);
    boardingPasses.clear();
    for(BoardingPass aBoardingPass : copyOfBoardingPasses)
    {
      aBoardingPass.removePassenger(this);
    }
    ArrayList<Document> copyOfDocuments = new ArrayList<Document>(documents);
    documents.clear();
    for(Document aDocument : copyOfDocuments)
    {
      aDocument.removePassenger(this);
    }
  }

  // line 13 "model.ump"
   public void createAccount(){
    
  }

  // line 16 "model.ump"
   public void createBooking(){
    
  }

  // line 19 "model.ump"
   public void viewBooking(){
    
  }

  // line 21 "model.ump"
   public void printBoardingPass(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "passID" + "=" + (getPassID() != null ? !getPassID().equals(this)  ? getPassID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "name" + "=" + (getName() != null ? !getName().equals(this)  ? getName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "email" + "=" + (getEmail() != null ? !getEmail().equals(this)  ? getEmail().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "phone" + "=" + (getPhone() != null ? !getPhone().equals(this)  ? getPhone().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "address" + "=" + (getAddress() != null ? !getAddress().equals(this)  ? getAddress().toString().replaceAll("  ","    ") : "this" : "null");
  }
}