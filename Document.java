/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 156 "model.ump"
// line 240 "model.ump"
public class Document
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Document Attributes
  private string docID;
  private string docType;

  //Document Associations
  private List<Passenger> passengers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Document(string aDocID, string aDocType)
  {
    docID = aDocID;
    docType = aDocType;
    passengers = new ArrayList<Passenger>();
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
  /* Code from template association_GetMany */
  public Passenger getPassenger(int index)
  {
    Passenger aPassenger = passengers.get(index);
    return aPassenger;
  }

  public List<Passenger> getPassengers()
  {
    List<Passenger> newPassengers = Collections.unmodifiableList(passengers);
    return newPassengers;
  }

  public int numberOfPassengers()
  {
    int number = passengers.size();
    return number;
  }

  public boolean hasPassengers()
  {
    boolean has = passengers.size() > 0;
    return has;
  }

  public int indexOfPassenger(Passenger aPassenger)
  {
    int index = passengers.indexOf(aPassenger);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPassengers()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPassenger(Passenger aPassenger)
  {
    boolean wasAdded = false;
    if (passengers.contains(aPassenger)) { return false; }
    passengers.add(aPassenger);
    if (aPassenger.indexOfDocument(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPassenger.addDocument(this);
      if (!wasAdded)
      {
        passengers.remove(aPassenger);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePassenger(Passenger aPassenger)
  {
    boolean wasRemoved = false;
    if (!passengers.contains(aPassenger))
    {
      return wasRemoved;
    }

    int oldIndex = passengers.indexOf(aPassenger);
    passengers.remove(oldIndex);
    if (aPassenger.indexOfDocument(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPassenger.removeDocument(this);
      if (!wasRemoved)
      {
        passengers.add(oldIndex,aPassenger);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPassengerAt(Passenger aPassenger, int index)
  {  
    boolean wasAdded = false;
    if(addPassenger(aPassenger))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPassengers()) { index = numberOfPassengers() - 1; }
      passengers.remove(aPassenger);
      passengers.add(index, aPassenger);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePassengerAt(Passenger aPassenger, int index)
  {
    boolean wasAdded = false;
    if(passengers.contains(aPassenger))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPassengers()) { index = numberOfPassengers() - 1; }
      passengers.remove(aPassenger);
      passengers.add(index, aPassenger);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPassengerAt(aPassenger, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Passenger> copyOfPassengers = new ArrayList<Passenger>(passengers);
    passengers.clear();
    for(Passenger aPassenger : copyOfPassengers)
    {
      aPassenger.removeDocument(this);
    }
  }

  // line 162 "model.ump"
   public void validateDocument(){
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "docID" + "=" + (getDocID() != null ? !getDocID().equals(this)  ? getDocID().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "docType" + "=" + (getDocType() != null ? !getDocType().equals(this)  ? getDocType().toString().replaceAll("  ","    ") : "this" : "null");
  }
}