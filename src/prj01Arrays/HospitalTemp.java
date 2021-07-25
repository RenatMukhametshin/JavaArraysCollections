package prj01Arrays;

public class HospitalTemp {
    public static final int COUNT_PATIENTS = 90;
    public static final int MIN_TEMP = 32;
    public static final int MAX_TEMP = 40;
    public static final double MIN_TEMP_HEALTHY = 36.2;
    public static final double MAX_TEMP_HEALTHY = 36.9;

    public static void main(String[] args) {
        double[] patientsTemps = new double[COUNT_PATIENTS];
        generateTemps(patientsTemps);
        printTemps(patientsTemps);
        System.out.println("Average temp : " + String.format("%.1f", getAverageTemp(patientsTemps)).replace(',', '.'));
        System.out.println("Healthy patient temp : " + getHealthyPatientTemp(patientsTemps));
        System.out.println("Healhty patient count : " + countHealthyPatient(patientsTemps));
    }

    public static void generateTemps(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double temp = MIN_TEMP + (MAX_TEMP - MIN_TEMP) * Math.random();
            temp = Math.floor(temp * 10) / 10;
            array[i] = temp;
        }
    }

    public static void printTemps(double[] array) {
        int index = 0;
        for (double temp : array) {
            index++;
            System.out.print(temp);
            if (index % 10 == 0 && index != 1) {
                System.out.print("\n");
            } else {
                System.out.print(" ");
            }
        }
    }

    public static double getAverageTemp(double[] array) {
        double sumTemp = 0.0;
        for (double temp : array) {
            sumTemp += temp;
        }
        return sumTemp / array.length;
    }

    public static String getHealthyPatientTemp(double[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (double temp : array) {
            if (temp >= MIN_TEMP_HEALTHY && temp <= MAX_TEMP_HEALTHY) {
                stringBuilder.append(temp + " ");
            }
        }
        return stringBuilder.toString();
    }

    public static int countHealthyPatient(double[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= MIN_TEMP_HEALTHY && array[i] <= MAX_TEMP_HEALTHY) {
                count++;
            }
        }
        return count;
    }
}
