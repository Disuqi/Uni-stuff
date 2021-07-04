import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * A class Diary that represents a "diary" of library item reservations.
 * 
 * The diary is structured as a Map of entries in which each entry corresponds 
 * to a specific day.  As the map is not accessed in a sequential fashion, it
 * doesn't matter whether the actual map class is a TreeMap or a HashMap.
 *
 * @author D E Newton
 * 
 */
public class Diary
{
   private Map<Date, DayInDiary> dayInDiaryMap;

   /**
    * Constructor for objects of class Diary
    */
   public Diary()
   {
      // create diary as a map
      dayInDiaryMap = new HashMap<Date, DayInDiary>();
   }
   
   /**
    * Method for adding a reservation to the diary. 
    * @parameter itemReservation, of type ItemReservation 
    */
   public void addReservation(ItemReservation itemReservation)
   {
      Date date = itemReservation.getStartDate();
      for(int day=1; day<=itemReservation.getNoOfDays(); day++)
      {
         if( !dayInDiaryMap.containsKey(date) )
         {
            // add new day to diary if no previous entries for this day
            dayInDiaryMap.put(date, new DayInDiary(date));
         }
         
         dayInDiaryMap.get(date).addEntry(itemReservation, day);
         date = DateUtil.nextDate(date);
      }
   }
  
   /**
    * Method for displaying the reservations between specified dates. 
    *
    * @parameter     startDate, of type Date
    * @parameter     endDate, of type Date
    */
   public void printEntries(Date startDate, Date endDate)
   {
      if( DateUtil.daysBetween(startDate, endDate)<0 )  
      {
         // startDate after endDate 
         System.out.println("*** Error in method displayEntries(): The specified end date is before the start date ***");
      }
      else
      {
         System.out.println("\n\nDiary: Reservations for period " + DateUtil.convertDateToShortString(startDate)
                            + " to " + DateUtil.convertDateToShortString(endDate) + " inclusive");
         System.out.println("=================================================================");
         for(Date date=startDate; date.compareTo(endDate)<=0; date = DateUtil.nextDate(date))
         {
            String longDate = DateUtil.convertDateToLongString(date); 
            System.out.print(longDate + ":");
            if( dayInDiaryMap.containsKey(date) )
            {
               DayInDiary dayInDiary = dayInDiaryMap.get(date);
               dayInDiary.printEntries();
            }
            else
               System.out.println(" No reservations\n");
         }
      }
   }

   /**
    * Method for deleting a reservation from the diary. 
    * @parameter itemReservation, of type ItemReservation 
    */   
   public void deleteReservation(ItemReservation itemReservation)
   {
      Date date = itemReservation.getStartDate();
      for(int day=1; day<=itemReservation.getNoOfDays(); day++)
      {
         DayInDiary dayInDiary = dayInDiaryMap.get(date);
         dayInDiary.deleteEntry(itemReservation);

         if( dayInDiary.getDaysEntries().size()==0 )
            dayInDiaryMap.remove(date);

         date = DateUtil.nextDate(date);
      }
   }   
      
   /**
    * Accessor method for returning all reservations that have entries 
    * in the diary for a particular date. 
    *
    * @parameter     date, of type Date 
    * @return        an array of reservations, or null if no entry for that date
    */   
   public ItemReservation[] getReservations(Date date)
   {
      DayInDiary dayinDiary = dayInDiaryMap.get(date);
      if( dayinDiary==null )
         return null;
      else
         return dayinDiary.getReservations();
   }
   
   // inner class, only needed in the Diary class
   private class DayInDiary
   {
      // reservations for the day
      private ArrayList<Entry> daysEntries;
      private Date date;
   
      /*
       * Constructor for objects of class DayInDiary
       */
      private DayInDiary(Date date)
      {
         this.date = date;
         daysEntries = new ArrayList<Entry>();
      }
 
      private ArrayList<Entry> getDaysEntries()
      {
         return daysEntries;   
      }
      
      private ItemReservation[] getReservations()
      {
         int noOfEntries = daysEntries.size();
         ItemReservation[] itemReservations = new ItemReservation[noOfEntries];
         for(int i=0; i<noOfEntries; i++)
            itemReservations[i] = daysEntries.get(i).getReservation();
         return itemReservations;
      }
    
      private void addEntry(ItemReservation itemReservation, int dayNo)
      {
         daysEntries.add(new Entry(itemReservation, dayNo));
      }
   
      private void deleteEntry(ItemReservation itemReservation)
      {
         // find the entry for this reservation and delete it
         Entry toBeDeletedEntry = null;
         for(Entry entry : daysEntries)
         {
            if( entry.getReservation()==itemReservation )  // in this situation, this is better than using "equals()"
            {
               toBeDeletedEntry = entry;
               break;
            }
         }
         daysEntries.remove(toBeDeletedEntry);
      }
   
      private void printEntries()
      {
         int size = daysEntries.size();
         if( size>0 )
         {
            System.out.println(" " + size + " reservation(s)");
            for( Entry entry: daysEntries )
            {
               ItemReservation itemReservation = entry.getReservation();
               int reservationDay = DateUtil.daysBetween(itemReservation.getStartDate(), date) + 1;;
               System.out.println("    " + itemReservation + ", day " + reservationDay + " of " + itemReservation.getNoOfDays());
            }
         }
         else
         {
            System.out.println("*** Unexpected error in displayEntries() ***");
            System.out.println("*** No entries for this date so it should not be in the diary  ***");
         }
         System.out.println();
      }
   
      // an inner class of the DaysDiary class
      private class Entry
      {
         private ItemReservation itemReservation;
         private int reservationDay;  // e.g. second day is day 2 of 4 for a reservation spanning 4 days
   
         private Entry(ItemReservation itemReservation,  int reservationDay)
         {
            this.itemReservation = itemReservation;
            this.reservationDay = reservationDay;
         }
   
         private ItemReservation getReservation()
         {
            return itemReservation;  
         }         
      }
   }   
}
