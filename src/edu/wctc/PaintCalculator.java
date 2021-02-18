package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {

   private List<Room> roomList = new ArrayList<>();
    private static final long serialVersionUID = 1L;


    public void addRoom(double width, double length, double height)
   {

        Room currentRoom = new Room(width, length, height);
        roomList.add(currentRoom);

   }

   public String toString()
   {

       String roomOutput = "The area of the room is: ";

       if(roomList.isEmpty())
       {

           return "No rooms have been created yet.";

       }
       else {

           for(Room currentRoom : roomList) {

                roomOutput += currentRoom.getArea();

           }
       }

       return roomOutput;

   }

}
