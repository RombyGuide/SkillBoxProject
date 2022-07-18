package BasketProducts_10;
/*
 Задание 1
 Создайте класс Arithmetic с двумя переменными — числами типа int.
 Создайте в этом классе конструктор, принимающий два параметра — тоже числа типа int. В конструкторе сохраняйте
 переданные параметры в переменных класса.
 В созданном классе реализуйте методы, вычисляющие различные величины (значения) на основе переменных класса,
 а именно:
 сумму чисел;
 произведения чисел;
 максимальное из двух чисел;
 минимальное из двух чисел.
 Имена методов придумайте самостоятельно.

 Задание 2
 Допишите в класс Basket
 Переменную “totalWeight”, которая будет содержать общую массу всех товаров, добавленных в корзину:
 Начальное значение переменной должно быть равно 0.
 При добавлении в корзину товара методом add() с параметром веса (см. ниже описание этого метода) добавляйте
 переданный в метод вес к этой переменной.
 Если вызывается уже существующий в классе метод add(), не содержащий параметр веса (weight), эта переменная
 не должна изменяться.
 Метод add с дополнительным параметром веса (weight):
 public void add(String name, int price, int count, double weight)
 Метод должен переиспользовать существующие методы добавления и добавлять указанный в их параметрах вес товаров
 к общему весу корзины.
 Метод, который будет возвращать значение массы всех товаров в корзине:
 public double getTotalWeight()
 */
