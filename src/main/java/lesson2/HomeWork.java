package lesson2;

public class HomeWork {

    public static void main(String[] args) {

        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"0", "0", "0", "0"}};
        try {
            int result = summarize(arr);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива не 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Неверный тип данных");
            System.out.println("Ошибка в ячейке " + e.i + ":" + e.j);
        }
    }

    public static int summarize(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;
    }
}
