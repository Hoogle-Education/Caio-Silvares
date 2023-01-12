import Prog1Tools.IOTools;

public class Zeitumrechnung {
    public static void main (String[] args){
        //Input
        long input = IOTools.readLong("Please enter the number of seconds you want to convert: ");
        //Calculation

        //Years
        long years = input / (365 * 24 * 60 * 60);
        long years_rest = input % (365 * 24 * 60 * 60);
        //Days
        long days = years_rest / (24 * 60 * 60);
        long days_rest = years_rest % (24 * 60 * 60);
        //Hours
        long hours = days_rest / (60 * 60);
        long hours_rest = days_rest % (60 * 60);
        //Minutes
        long minutes = hours_rest / 60;
        long minute_rest = hours_rest % 60;

        System.out.println("These are " + years + " Years " + days + " Days " + hours + " hours " + minutes + " Minutes " + minute_rest + " Seconds");
    }
}
