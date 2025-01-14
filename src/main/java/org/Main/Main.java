package org.Main;

import org.BusinessLogic.ExecuteOperations;
import org.Helpers.FetchInputHelper;
import org.Model.SubmarineState;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Dividing the task into abstractions for easy enhancements
        // Fetch input from a file
        FetchInputHelper helper = new FetchInputHelper();
        SubmarineState sub = new SubmarineState();
        try{
            File input = helper.selectInputFile();
            ArrayList<String[]> courseList = helper.getPlannedCourse(input);
            ExecuteOperations.execute(sub, courseList);
        }
        catch (FileNotFoundException fnf){
            System.out.println("Error reading selected course for the submarine");
        }
        catch (Exception e){
            System.out.println("Error reading the input files");
        }
        System.out.println("Final position of the Submarine:");
        System.out.println("Horizontal: "+ sub.getHorizontal());
        System.out.println("Depth: "+ sub.getDepth());
        System.out.println("Product: "+sub.getProduct());
    }
}