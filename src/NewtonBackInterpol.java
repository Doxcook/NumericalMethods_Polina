public class NewtonBackInterpol {
    public static void main(String[] args) {
        // Исходные данные
        double[] x = {1.0, 1.3, 1.6, 1.9, 2.2, 2.5};

        // Значения для первой функции y = 1 / (x^2 + 1)
        double[] y1 = {
                1 / (x[0] * x[0] + 1),
                1 / (x[1] * x[1] + 1),
                1 / (x[2] * x[2] + 1),
                1 / (x[3] * x[3] + 1),
                1 / (x[4] * x[4] + 1),
                1 / (x[5] * x[5] + 1)
        };

        // Значения для второй функции y = x^4
        double[] y2 = {
                Math.pow(x[0], 4),
                Math.pow(x[1], 4),
                Math.pow(x[2], 4),
                Math.pow(x[3], 4),
                Math.pow(x[4], 4),
                Math.pow(x[5], 4)
        };

        double value = 2.1; // Точка, где требуется найти значение
        int n = x.length;

        double h = x[1] - x[0]; // Шаг равномерной сетки

        // Интерполяция для первой функции
        double result1 = interpolateNewton(x, y1, n, value, h);
        System.out.printf("Значение первой функции в точке x = %.2f: %.6f%n", value, result1);

        // Интерполяция для второй функции
        double result2 = interpolateNewton(x, y2, n, value, h);
        System.out.printf("Значение второй функции в точке x = %.2f: %.6f%n", value, result2);
    }

    // Метод интерполяции Ньютона
    private static double interpolateNewton(double[] x, double[] y, int n, double value, double h) {
        double[][] differences = calculateBackwardDifferences(y, n);
        double q = (value - x[n - 1]) / h;

        double result = y[n - 1];
        double qProduct = 1;

        for (int i = 1; i < n; i++) {
            qProduct *= (q + i - 1);
            result += (qProduct / factorial(i)) * differences[n - 1][i];
        }

        return result;
    }

    // Вычисление таблицы конечных разностей
    private static double[][] calculateBackwardDifferences(double[] y, int n) {
        double[][] differences = new double[n][n];
        for (int i = 0; i < n; i++) {
            differences[i][0] = y[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = n - 1; i >= j; i--) {
                differences[i][j] = differences[i][j - 1] - differences[i - 1][j - 1];
            }
        }
        return differences;
    }

    // Вычисление факториала
    private static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
