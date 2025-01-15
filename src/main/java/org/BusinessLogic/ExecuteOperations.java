package org.BusinessLogic;

import org.Model.SubmarineState;

import java.util.ArrayList;

public class ExecuteOperations {

    public static void execute(SubmarineState sub, ArrayList<String[]> courseList ){
        for(int i=0;i<courseList.size();i++){
            String[] op = courseList.get(i);
            double movementAmount = Double.parseDouble(op[1]);
            switch (op[0]){
                case "down":
                    sub.setAim(sub.getAim() + movementAmount);
                    break;
                case "up":
                    sub.setAim(sub.getAim() - movementAmount);
                    break;
                case "forward":
                    sub.setHorizontal(sub.getHorizontal() +  movementAmount);
                    sub.setDepth(sub.getDepth() + sub.getAim() * movementAmount);
            }

        }
        sub.setProduct(sub.getDepth()* sub.getHorizontal());
    }
}
