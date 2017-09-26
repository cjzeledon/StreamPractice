package com.TheIronYard;

import com.TheIronYard.Day;
import com.TheIronYard.Entry;

import javax.xml.ws.EndpointReference;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        int duration;
        List<Entry> entries = Entry.populate();
        printEntries(entries);
        printTuesdays(entries);
        countTueWedThur(entries);
        weekendList(entries);
        weekdaySet(entries);
//        printDurationGreaterThan10(entries);
//        findMaxDuration(entries);
//        listGreaterThan50(entries);
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop to print all entries:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.stream().forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {

        // DONE - Print out Tuesday entries using enhanced loop method
        System.out.println("For Loop:");
        // write for loop
        for (Entry current : entries) {
            if (current.getDay().equals(Day.TUESDAY)) {
                System.out.println(current);
            }
        }

        // DONE - Print out Tuesday entries using stream method
        System.out.println("\nStream, filter, forEach:");
        // write stream
            entries
                .stream()
                .filter(entry -> entry.getDay().equals(Day.TUESDAY))
                .forEach(entry -> System.out.println(entry));
    }

    public static void countTueWedThur(List<Entry> entries) {
        // DONE - Count the number of Tuesday, Wednesday, and Thursday entries
        System.out.println("\nFor Loop with count:");
        int count = 0;
        // write for loop
        for (Entry entry : entries){
            if (entry.equals(Day.values())){
                if(entry.getDay().equals(Day.TUESDAY) ||
                   entry.getDay().equals(Day.WEDNESDAY) ||
                   entry.getDay().equals(Day.THURSDAY)){
                   count++;
                }
            }
        }
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
        System.out.println("Stream, filter, count: ");
        // DONE - Do the same count but in stream method
        long count1 = entries
            .stream()
            .filter(e -> e.getDay().equals(Day.TUESDAY) ||
                         e.getDay().equals(Day.WEDNESDAY) ||
                         e.getDay().equals(Day.THURSDAY))
            .count();
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println(count);
    }

    public static void weekendList(List<Entry> entries) {
        //Create a list of weekend (Saturday and Sunday) entries
        System.out.println("For Loop:");
        List<Entry> weekends = new ArrayList<>();
        // write for loop
//        for (Entry wknd : entries){
//            if (wknd.getDay().equals(Day.SATURDAY)){
//                System.out.println(wknd);
//            } else if (wknd.getDay().equals(Day.SUNDAY)){
//                System.out.println(wknd);
//            }
//        }
        for (Entry entry : entries){
                if(entry.getDay().equals(Day.SATURDAY) ||
                   entry.getDay().equals(Day.SUNDAY)) {
                    weekends.add(entry);
                }

        }
        System.out.println(weekends);
        System.out.println("Stream, filter, collect:");
        // write stream use collect as the terminal operation
        weekends.stream()
                .filter(wk -> wk.getDay().equals(Day.SATURDAY) || wk.getDay().equals(Day.SUNDAY))
                .collect(Collectors.toList());
        System.out.println(weekends);
        System.out.println();


    }

    public static void weekdaySet(List<Entry> entries) {
        //Create a SET of weekday entries
        System.out.println("For Loop:");
        Set<String> weekdays = new HashSet<>();
        // write for loop
        for (Entry entry : entries) {
            if (!(entry.getDay().equals(Day.SATURDAY) ||
                    entry.getDay().equals(Day.SUNDAY))) {
                weekdays.add(entry.getDay().toString());
            }
        }

        System.out.println(weekdays);
        System.out.println("Stream, filter, map, collect:");
        weekdays = entries
                .stream()
                .filter(e -> !(e.getDay().equals(Day.SATURDAY) ||
                               e.getDay().equals(Day.SUNDAY)))
                .map(e -> e.getDay().toString())
                .collect(Collectors.toSet());
        System.out.println(weekdays);
        System.out.println();
    }

//    public static void printDurationGreaterThan10(List<Entry> entries){
//        System.out.println("For Loop (printDurationGreaterThan10):");
//        // write for loop
//        for (Entry entry : entries){
//            if (Entry.populate().size() > 10){
//                System.out.println(entry);
//            }
//        }
//        System.out.println("Stream, filter, forEach (printDurationGreaterThan10):");
//        // write stream
//        entries
//            .stream()
//            .filter()
//        System.out.println();
//    }

//    public static void findMaxDuration(List<Entry> entries){
//        System.out.println("For Loop:");
//        int temp = 0;
//        // write for loop
//        System.out.println("The Max Duration is: " + temp);
//        System.out.println("Stream, mapToInt, max, getAsInt:");
//        temp = // write stream use mapToInt then max the getAsInt
//        System.out.println("The Max Duration is: " + temp);
//        System.out.println();
//    }
//
//    public static void listGreaterThan50(List<Entry> entries){
//        System.out.println("For Loop:");
//        List<Entry> greaterThan50 = new ArrayList<>();
//        // write for looop
//        System.out.println(greaterThan50);
//        System.out.println("Stream, filter, collect:");
//        // write stream
//        System.out.println(greaterThan50);
//        System.out.println();
//    }
}


