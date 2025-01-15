package org.Helpers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class FetchInputHelper {

    /**
     * Selects one input file from the directory according to user's input
     * @return a user specified File object
     */
    public File selectInputFile(){
        File f = new File("kata-materials");
        File[] files = f.listFiles((dir, name) -> name.endsWith(".txt"));
        int option = Integer.MAX_VALUE;
        while(option<=0 || option > files.length){
            System.out.println("Please select the input file to run!");
            for(int i=0;i<files.length;i++){
                System.out.println(i+1 + "  -  " + files[i].getName());
            }
            System.out.println("Enter an integer from the given options");
            Scanner s = new Scanner(System.in);
            try{
                // for cases when user inputs a non integer
                option = s.nextInt();
            }
            catch(Exception e){
                System.out.println("Invalid input entered");
            }
        }
        return files[option-1];
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public Map<String, String[]> jsonToHashMap() throws IOException {
        String jsonFilePath = "scanner-data.json";
        Path jsonPath = Paths.get(jsonFilePath);
        String jsonData = new String(Files.readAllBytes(jsonPath));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String[]> dataMap = objectMapper.readValue(jsonData,
                new TypeReference<Map<String, String[]>>() {
                });
        return dataMap;
    }

    /**
     * Checks validity of one line of input from the input.txt
     * @param instruction
     * @return a boolean to conclude validity
     */
    public boolean checkValid(String[] instruction){
        if(instruction.length!=2)
            return false;
        boolean isValid = true;
        try{
            String operation = instruction[0];
            double X = Double.parseDouble(instruction[1]);
            if(!(operation.toLowerCase().equals("up") || operation.toLowerCase().equals("down") || operation.toLowerCase().equals("forward"))){
                isValid = false;
            }
        }
        catch(Exception e){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Get Validated Submarine CourseList from the input file
     * @param input the input File object chosen by the user
     * @throws FileNotFoundException if this object is not usable
     */
    public ArrayList<String[]> getPlannedCourse(File input) throws FileNotFoundException {
        Scanner s = new Scanner(input);
        ArrayList<String[]> courseList = new ArrayList<>();
        boolean isValid = true;
        try{
            while(s.hasNext()){
                String[] currentInstruction = s.nextLine().split(" ");
                isValid = checkValid(currentInstruction);
                if(!isValid)
                    throw new Exception();
                courseList.add(currentInstruction);
            }
        }
        catch(Exception e){
            System.out.println("Invalid Instructions in the submarine course file");
        }
        return courseList;
    }
}

