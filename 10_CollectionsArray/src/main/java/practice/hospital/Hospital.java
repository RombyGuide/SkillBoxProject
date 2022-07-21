package practice.hospital;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patienceTemperature = new float[patientsCount];

        for (int i = 0; i < patientsCount; i++) {
            patienceTemperature[i] = (float) (Math.round(100.0 * ((((Math.random()
                    * 8)) + 32) * 10) / 10f) / 100.0);
            System.out.println(patienceTemperature[i]);
        }
        return patienceTemperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
        а также температуры всех пациентов.
        Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
        а температуры каждого пациента до 1 знака после запятой
        */

        int count  = 0;
        int healthy = 1;
        String patients = "";
        float temp = 0;
        double middleTemperature = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            patients += temperatureData[i] + " ";
            temp += temperatureData[i];
            if (temperatureData[i] >= 36.2 && temperatureData[i] <= 36.9) {
                healthy += 1;
            }
            count += 1;
        }

        double d = temp / count;
        middleTemperature = Math.round(100.0 * d) / 100.0;

        String report =
                "Температуры пациентов: " + patients.trim() +
                        "\nСредняя температура: " + middleTemperature +
                        "\nКоличество здоровых: " + healthy;

        return report;
    }
}

