package com.company;
import java.util.Scanner;

public class check{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Hotel[] hotel=new Hotel[4];
        for(int i=0;i<hotel.length;i++)
        {
            int hotelId=sc.nextInt();
            sc.nextLine();
            String hotelName=sc.nextLine();
            String dateOfBooking=sc.nextLine();
            int noOfRoomsBooked=sc.nextInt();
            sc.nextLine();
            String wifiFacility=sc.nextLine();
            double totalBill=sc.nextDouble();
            sc.nextLine();
            hotel[i]=new Hotel(hotelId,hotelName,dateOfBooking,noOfRoomsBooked,wifiFacility,totalBill);
        }

        String month=sc.nextLine();
        String wifi=sc.nextLine();
        sc.close();

        int count=noOfRoomsBookedInGivenMonth(hotel,month);
        if(count==0)
        {
            System.out.println("No rooms booked in the given month");
        }
        else
        {
            System.out.println(count);
        }
        Hotel h=searchHotelByWifiOption(hotel,wifi);
        if(h==null)
        {
            System.out.println("No such option available");
        }
        else
        {
            System.out.println(h.getHotelId());
        }

    }

    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotel,String month){
        int count=0;
        for(int i=0;i<hotel.length;i++)
        {
            if(hotel[i].getDateOfBooking().contains(month))
            {
                count =count + hotel[i].getNoOfRoomsBooked();
            }
        }
        return count;
    }

    public static Hotel searchHotelByWifiOption(Hotel[] hotel,String wifi){


        int max=0;
        int max2=0;
        int index=0;
        int index2=0;
        for(int i=0;i<hotel.length;i++)
        {
            if(hotel[i].getWifiFacility().equals(wifi))
            {
                if(hotel[i].getTotalBill()>max)
                {
                    max2=max;
                    index2=index;
                    max= (int) hotel[i].getTotalBill();
                    index=i;
                }
                else if(hotel[i].getTotalBill()>max2)
                {
                    max2= (int) hotel[i].getTotalBill();
                    index2=i;
                }
            }
        }
        if(max2==0)
        {
            return null;
        }
        else
        {
            return hotel[index2];
        }
    }
}



class Hotel{
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill){
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId()
    {
        return hotelId;
    }

    public void setHotelId(int hotelId)
    {
        this.hotelId = hotelId;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getDateOfBooking()
    {
        return dateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking)
    {
        this.dateOfBooking = dateOfBooking;
    }

    public int getNoOfRoomsBooked()
    {
        return noOfRoomsBooked;
    }

    public void setNoOfRoomsBooked(int noOfRoomsBooked)
    {
        this.noOfRoomsBooked = noOfRoomsBooked;
    }

    public String getWifiFacility()
    {
        return wifiFacility;
    }

    public void setWifiFacility(String wifiFacility)
    {
        this.wifiFacility = wifiFacility;
    }

    public double getTotalBill()
    {
        return totalBill;
    }

    public void setTotalBill(double totalBill)
    {
        this.totalBill = totalBill;
    }

}



