package Gym;

import java.io.Serializable;

public class Date implements Serializable {
    //initializing the instance variables
    private int year;
    private int month;
    private int day;

    //initializing the constructor according to date
    public Date(int day, int month, int year){
        if((year%4 != 0) && (month != 2) && (year > 1919) && (year < 2119) && (month > 0) && (month < 13) && (day > 0) && (day < 32)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else if((year%4 == 0) && (month == 2) && (year > 1919) && (year < 2119) && (day > 0) && (day < 30)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else if((year%4 != 0) && (month == 2) && (year > 1919) && (year < 2119) && (day > 0) && (day < 29)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }else {
            System.out.println("Not correct date");
        }
    }
    public void setYear(int year){
        if ((year > 1919) && (year<2119)){
            this.year = year;
        }
        else{
            System.out.println("Not correct range");
        }
    }

    public void setMonth(int month){
        if ((month > 0) && (month<13)){
            this.month = month;
        }else{
            System.out.println("Not correct range");
        }
    }

    public void setDay(int month, int year, int day){
        if ((year%4 != 0) && (month != 2) && (day > 0) && (day<32)){
            this.day = day;
        }
        else if((year%4 == 0) && (month == 2) && (day > 0) && (day<30)){
            this.day = day;
        }
        else if((year%4 != 0) && (month == 2) && (day > 0) && (day<29)){
            this.day = day;
        }
        else{
            System.out.println("Not correct range");
        }
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String getDate(){
        String dateStr = String.format("%02d/%02d/%04d", day, month, year);
        return dateStr;
    }

    public String toString(){
        String dateStr = String.format("%02d/%02d/%04d", day, month, year);
        return dateStr;
    }
}
