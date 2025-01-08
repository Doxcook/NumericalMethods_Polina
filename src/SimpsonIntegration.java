import static java.lang.Math.pow;

public class SimpsonIntegration {

    // Метод Симпсона для вычисления интеграла
    public static double simpsonPervaya(double a, double b, int n) {
        double h = (b - a) / n;
        double result = pervaya(a) + pervaya(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            result += (i % 2 == 0 ? 2 : 4) * pervaya(x);
        }

        return (h / 3) * result;
    }

    public static double simpsonVtoraya(double a, double b, int n) {
        double h = (b - a) / n;
        double result = vtoraya(a) + vtoraya(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            result += (i % 2 == 0 ? 2 : 4) * vtoraya(x);
        }

        return (h / 3) * result;
    }

    // Первая функция: 8x^3 - 2x
    public static double pervaya(double x) {
        return 8 * x * x * x - 2 * x;
    }

    // Вторая функция: x * sin(x)
    public static double vtoraya(double x) {
        return x * Math.sin(x);
    }

    // Оценка погрешности по правилу Рунге
    public static double rungeError(double I1, double I2) {
        return Math.abs(I2 - I1) / pow(2.,4.); //15 2^K k = 4
    }

    public static void main(String[] args) {
        double a1 = 3, b1 = 6, a2 = 0, b2 = 2 * Math.PI;
        int n = 6;

        // Первый интеграл
        double integral1 = simpsonPervaya(a1, b1, n);
        double integral1Fine = simpsonPervaya(a1, b1, 2 * n);
        double error1 = rungeError(integral1, integral1Fine);
        double exact1 = 2403.0; // Аналитическое значение

        // Второй интеграл
        double integral2 = simpsonVtoraya(a2, b2, n);
        double integral2Fine = simpsonVtoraya(a2, b2, 2 * n);
        double error2 = rungeError(integral2, integral2Fine);
        double exact2 = -6.28319; // Аналитическое значение

        // Вывод
        System.out.printf("Интеграл 1: Численно = %.6f, Аналитически = %.6f, Погрешность = %.6f\n", integral1, exact1, error1);
        System.out.printf("Интеграл 2: Численно = %.6f, Аналитически = %.6f, Погрешность = %.6f\n", integral2, exact2, error2);
    }
}