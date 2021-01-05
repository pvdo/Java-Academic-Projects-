//REFLECT - Workshop 10
//Course:JAC444 - 4 Semester
//Last Name: Do Carmo Saraiva Teixeira
//First Name: Pedro Vitor
//ID: 100036193
//Section: NDD
//This assignment represents my own work in accordance with Seneca Academic Policy.
//Date: December 08, 2020

import java.util.Calendar;
import java.util.Scanner;


public class Time implements Comparable<Time>, Cloneable{
	
//	A data field of the long time that stores the elapsed time since midnight, Jan 1, 1970.
	long elapsedTime;
	int hour;
	int minute;
	int second;
	
	
//	2. A no-arg constructor that constructs a Time for the current time.
	public Time() {
		
		Calendar cal = Calendar.getInstance(); //abstract class
		this.hour = cal.get(Calendar.HOUR);
		this.minute = cal.get(Calendar.MINUTE);
		this.second = cal.get(Calendar.SECOND);
	}
//	3. A constructor with the specified hour, minute, and second to create a Time.
	public Time(int m_hour, int m_minute, int m_second) {
		
		elapsedTime = (m_hour * 3600) + (m_minute * 60) + m_second; //1194314
		getHour();
		getMinute();
		getSecond();
		
	}
//	4. A constructor with the specified elapsed time since midnight, Jan 1, 1970.
	public Time(long m_elapsedTime) {
		// difference, measured in milliseconds, between the current time and midnight, January 1, 1970 UTC
		this.elapsedTime = m_elapsedTime;
		getHour();
		getMinute();
		getSecond();
		
	
	}
//	5. The getHour() method that returns the current hour in the range 0-23.
	public int getHour() {
		this.hour = (int) (this.elapsedTime / 3600) % 24;
		
		return this.hour >= 0 && this.hour <= 23 ? this.hour : 0;
			
	}
//	6. The getMinute() method that returns the current minute in the range 0-59.
	public int getMinute() {
		this.minute = (int) (this.elapsedTime / 60) % 60;
		return this.minute >= 0 && this.minute <= 59 ? this.minute : 0;

	}
//	7. The getSecond() method that returns the current second in the range 0-59.
	public int getSecond() {
		this.second = (int) this.elapsedTime % 60;
		return this.second >= 0 && this.second <= 59 ? this.second : 0;

	}
//	8. The getSeconds() method that returns the elapsed total seconds.
	public long getSeconds() {
		return this.elapsedTime;
	}
//	9. The toString() method that returns a string such as "1 hour 2 minutes 1 second" and "14
//	hours 21 minutes 1 second".
	public String toString() {
		return this.hour + (this.hour == 0 || this.hour == 1? " hour " : " hours ") 
				+ this.minute + (this.minute == 0 || this.minute == 1? " minute " : " minutes ")
				+ this.second + (this.second == 0 || this.second == 1? " second " : " seconds ");
	}
//	10. Implement the Comparable<Time> interface to compare this Time with another one
//	based on their elapse seconds. The compareTo method returns the difference between
//	this object’s elapse seconds and the another’s.

	@Override
	public int compareTo(Time time1) {
		long difElapsedTime = this.elapsedTime - time1.elapsedTime;
		
		return (int) difElapsedTime;
	}
	
	

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int hour, minute, second;
    	long elapsedTime;
        
        System.out.println("Sample Run - 1");
        System.out.print("Enter time1 (hour minute second): ");
        hour = input.nextInt();
        minute = input.nextInt();
        second = input.nextInt();
        Time time1 = new Time(hour, minute, second);
        System.out.println(time1.toString());
        
        System.out.println("Elapsed seconds in time1: " + time1.getSeconds());
        
        System.out.print("Enter time2 (elapsed time in seconds): ");
        elapsedTime = input.nextInt();

        Time time2 = new Time(elapsedTime);
        System.out.println(time2.toString());
        System.out.println("Elapsed seconds in time2: " + time2.getSeconds());
        System.out.println("time1.compareTo(time2)? " + time1.compareTo(time2));
        
        System.out.println("time3 is created as a clone of time1");
        //clone
        try {
            Time time3 = (Time) time1.clone();
            System.out.println("time1.compareTo(time3)?" + time1.compareTo(time3));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("End Sample Run - 1 \n");
        
        
        System.out.println("Sample Run - 2");
        System.out.print("Enter time1 (hour minute second):");
        hour = input.nextInt();
        minute = input.nextInt();
        second = input.nextInt();
        Time s2_time1 = new Time(hour, minute, second);
        System.out.println(s2_time1.toString());
        
        System.out.println("Elapsed seconds in time1: " + s2_time1.getSeconds());
        
        System.out.print("Enter time2 (elapsed time in seconds):");
        elapsedTime = input.nextInt();

        Time s2_time2 = new Time(elapsedTime);
        System.out.println(s2_time2.toString());
        System.out.println("Elapsed seconds in time2: " + s2_time2.getSeconds());
        System.out.println("time1.compareTo(time2)? " + s2_time1.compareTo(s2_time2));
        
        System.out.println("time3 is created as a clone of time1");
        //clone
        try {
            Time s2_time3 = (Time) s2_time1.clone();
            System.out.println("time1.compareTo(time3)? " + s2_time1.compareTo(s2_time3));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("End Sample Run - 2");
        
        

    }

}
