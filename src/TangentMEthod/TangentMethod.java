package TangentMEthod;

public class TangentMethod {
    //функция f(x) = x^4 + x - 4
    public static double f(double x) {
        return Math.pow(x, 4) + x - 4;
    }

    // Производная f'(x) = 4x^3 + 1
    public static double fDerivative(double x) {
        return 4 * Math.pow(x, 3) + 1;
    }

    //метод касательных
    public static double tangentMethod(double x0, double epsilon) {
        double x1; // cледующее приближение (просто объявление переменной)
        int maxIterations = 1000; // Лимит итераций (для исключения зацикливания)
        int iteration = 0; //счётчик итераций

        while (true) {
            double fValue = f(x0);//значение функции в точке
            double fDerivativeValue = fDerivative(x0); //значение производной в точке

            // Формула метода касательных
            x1 = x0 - fValue / fDerivativeValue;

            // поверка на достижение точности
            if (Math.abs(x1 - x0) < epsilon) {
                System.out.println("Корень найден (" + iteration + " итераций)");
                return x1;
            }

            x0 = x1;

            iteration++;
            if (iteration > maxIterations) {
                throw new ArithmeticException("превышает, установленное количество итераций");
            }
        }
    }

    public static void main(String[] args) {
        double x0 = 1.5; // начальное приближение по формуле (a+b)/2
        double epsilon = 1e-6; // Точность

        double root = tangentMethod(x0, epsilon);
        System.out.printf("Найденный корень: %.6f%n", root);
    }
}
