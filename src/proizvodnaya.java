//Дифференцирование функции  у=sin(x)

public class proizvodnaya {

    //  шаг h — это расстояние между точками для расчёта
    private static final double h = 0.001;

    // вычисляет значение sin(x) для заданного значения x
    public static double f(double x) {
        return Math.sin(x);
    }

    //
    public static double firstDerivative(double x) {
        // Считаем значение функции в точке x + 2*h
        double y_i2 = f(x + 2 * h);

        // Считаем значение функции в точке x + h
        double y_i1 = f(x + h);

        // Считаем значение функции в точке x
        double y_i = f(x);

        //  подставляем эти значения в формулу для приближённого расчёта первой производной
        return (-y_i2 + 4 * y_i1 - 3 * y_i) / (2 * h);
    }

    public static void main(String[] args) {
        double x = 1.0; // Точка, в которой хотим найти производную

        // результат на экран
        System.out.println("Первая производная в точке x = " + x + ": " + firstDerivative(x));

        int i = 0;
        int max = 90;
        while (i <= max){
            System.out.println("x: " +i);
            System.out.println("Значение по формуле: "+firstDerivative(i));
            System.out.println("значение косинуса: " + Math.cos(i));
            System.out.println("//////////////");
            i +=30;
        }
    }
}
