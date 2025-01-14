package org.BusinessLogic;

import org.Model.SubmarineState;

import java.util.ArrayList;

public class ExecuteOperations {

    public static void execute(SubmarineState sub, ArrayList<String[]> courseList ){
        for(int i=0;i<courseList.size();i++){
            String[] op = courseList.get(i);
            switch (op[0]){
                case "down":
                    sub.setDepth(sub.getDepth() + Double.parseDouble(op[1]));
                    break;
                case "up":
                    sub.setDepth(sub.getDepth() - Double.parseDouble(op[1]));
                    break;
                case "forward":
                    sub.setHorizontal(sub.getHorizontal() +  Double.parseDouble(op[1]));
            }

        }
        sub.setProduct(sub.getDepth()* sub.getHorizontal());
    }
}
