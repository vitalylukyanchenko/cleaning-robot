package org.codility;

public class Solution {
    public int solution(String[] R) {

        Field field = Field.constructField(R);

        Robot robot = new Robot(field.getStartCell(), field);

        return robot.clean();

    }
}
