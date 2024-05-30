import java.util.*;
class PrintAllSubsetsOfAString {
    public static void main(String[] args) {
        printAllSubsets("cba", "");
    }
    
    private static void printAllSubsets(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }
        String output1 = output;
        String output2 = new StringBuilder().append(input.charAt(0)).toString() + output;
        printAllSubsets(input.substring(1), output1);
        printAllSubsets(input.substring(1), output2);
        return;
    }
}
