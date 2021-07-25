package prj01Arrays;

public class HospitalTemp {
    public static void main(String[] args) {
        double[] patientsTemps = new double[90];
        generateTemps(patientsTemps);
        printTemps(patientsTemps);
        System.out.println("Average temp : " + String.format("%.1f", getAverageTemp(patientsTemps)).replace(',', '.'));
        System.out.println("Healthy patient temp : " + getHealthyPatientTemp(patientsTemps));
        System.out.println("Healhty patient count : " + countHealthyPatient(patientsTemps));
    }

    public static void generateTemps(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double temp = 32.0 + 8 * Math.random();
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
            if (temp >= 36.2 && temp <= 36.9) {
                stringBuilder.append(temp + " ");
            }
        }
        return stringBuilder.toString();
    }

    public static int countHealthyPatient(double[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 36.2 && array[i] <= 36.9) {
                count++;
            }
        }
        return count;
    }
}
