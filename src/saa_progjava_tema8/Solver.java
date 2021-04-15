package saa_progjava_tema8;

import java.util.Arrays; // Библиотека работы с массивами
import static java.lang.Math.*; // Импорт всех математических функций

public class Solver { // КЛАСС ВЫЧИСЛЕНИЯ ЗНАЧЕНИЙ

    double[] inputData; // Переменная для входного массива целых чисел
    double[] outputData; // Переменная для выходного массива вещественных чисел
    int sizeOfArray; // Переменная для длины исходного массива

    public void setData(double[] array) { // МЕТОД ДЛЯ ЗАДАНИЯ ИСХОДНЫХ ДАННЫХ
        sizeOfArray = array.length; // Определяем длину исходного массива
        // Копируем значения из исходного массива во входной массив
        inputData = Arrays.copyOf(array, sizeOfArray);
        outputData = new double[sizeOfArray]; // Создаем выходной массив
    }

    public double[] getSolution() { // МЕТОД ВЫЧИСЛЕНИЯ ЗНАЧЕНИЯ
        double Ki, Kprevious_i, multiplicationKprevious_i = 1, sumKi = 0;
        for (int i = 0; i < sizeOfArray; i++) { // Цикл по элементам входного массива
            try {
                Ki = inputData[i]; // Текущее значение элемента входного массива
                sumKi += Ki; // Расчет суммы элементов входного массив
                Kprevious_i = inputData[i - 1]; // Предыдущее значение элемента входного массива
                multiplicationKprevious_i *= Kprevious_i;
                outputData[i] = (pow((sumKi*sumKi),(1.0/3.0))*pow(((sin(Ki)*sin(Ki))-(cos(Kprevious_i)*cos(Kprevious_i))),3)/(multiplicationKprevious_i));
            } catch (Exception ex) {
                outputData[i] = Double.NaN; // Присваиваем значение элементу "нет решения"
            }
        }
        return outputData; // Возвращаем результирующий массив в программу
    }
}
