package org.codility;

public class Solution {
    public int solution(String[] R) {

        Field field = Field.constructField(R);

        if (field.getCells().isEmpty()) {
            return 0;
        }

        Robot robot = new Robot(field, field.getCells().get(0).get(0));

        return robot.clean();



    }
}
