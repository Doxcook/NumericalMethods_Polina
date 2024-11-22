import java.util.Scanner;

public class PieceLinearInterpolation {

    // Структура хранения точки с координатами
    static class Point {
        double x; //x
        double y; //y

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double interpolate(Point[] points, double x) {
        // Проходим по массиву точек, чтобы найти отрезок, в который попадает x
        for (int i = 0; i < points.length - 1; i++) {
            // Проверяем, находится ли x между x[i] и x[i+1]
            if (x >= points[i].x && x <= points[i + 1].x) {
                // Получаем координаты концов отрезка
                double x0 = points[i].x, y0 = points[i].y;
                double x1 = points[i + 1].x, y1 = points[i + 1].y;

                // Применяем формулу линейной интерполяции
                // y = y0 + (y1 - y0) * (x - x0) / (x1 - x0)
                return y0 + (y1 - y0) * (x - x0) / (x1 - x0);
            }
        }
        // Если x находится за пределами диапазона точек, выбрасываем исключение
        throw new IllegalArgumentException("Значение x вне диапазона точек.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем количество точек
        System.out.print("Введите количество точек: ");
        int n = scanner.nextInt();
        Point[] points = new Point[n];

        // Вводим координаты точек
        for (int i = 0; i < n; i++) {
            System.out.print("Введите x" + i + ": ");
            double x = scanner.nextDouble();
            System.out.print("Введите y" + i + ": ");
            double y = scanner.nextDouble();
            points[i] = new Point(x, y); // Сохраняем точку в массиве
        }

        // Запрашиваем значение x, для которого нужно найти y
        System.out.print("Введите значение x для интерполяции: ");
        double x = scanner.nextDouble();

        try {
            // Выполняем интерполяцию и выводим результат
            double interpolatedY = interpolate(points, x);
            System.out.println("Интерполированное значение y: " + interpolatedY);
        } catch (IllegalArgumentException e) {
            // Выводим сообщение, если x вне диапазона
            System.out.println(e.getMessage());
        }

        scanner.close(); // Закрываем сканер
    }
}
