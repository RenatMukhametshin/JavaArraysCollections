package prj01Arrays;

public class ArrayArrays {
    public static void main(String[] args) {
        int[][] studentsMarks = {
                {4, 3, 1, 2, 4},
                {3, 4, 2, 4, 5, 2, 2, 3},
                {3, 4, 2, 5},
                {4, 1, 3, 2, 2, 2, 3}
        };
        System.out.println(studentsMarks.length);

        for (int i = 0; i < studentsMarks.length; i++) {
            System.out.println("Class " + i + " (" + studentsMarks[i].length + " students):");
            for(int j = 0; j < studentsMarks[i].length; j++){
                System.out.println("\t Student " + j + " mark - " + studentsMarks[i][j]);
            }
        }
    }
}
