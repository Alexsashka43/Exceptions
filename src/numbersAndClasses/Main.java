package numbersAndClasses;

public class Main {
    public static void main(String[] args) {
//        String[][] matrix = new String[][]{{"5", "7", "8"}, {"5", "7", "0", "1"}, {"23", "8", "1", "2"}, {"4", "3", "5", "6"}};
        String[][] matrix = new String[][]{{"5", "h", "7", "8"}, {"5", "7", "0", "1"}, {"23", "8", "1", "2"}, {"4", "3", "5", "6"}};
//        String[][] matrix = new String[][]{{"4", "5", "7", "8"}, {"5", "7", "0", "1"}, {"23", "8", "1", "2"}, {"4", "3", "5", "6"}};
        try {
            try {
                int result = matrixToInt(matrix);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        }
        catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static int matrixToInt(String[][] correctMatrix) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (correctMatrix.length != 4) {
            throw new MyArraySizeException("Number of rows in the matrix incorrect");
        }
        for (int i = 0; i < correctMatrix.length; i++) {
            if (correctMatrix[i].length != 4) {
                throw new MyArraySizeException("Number in columns in the matrix incorrect");
            }
            for (int j = 0; j < correctMatrix[i].length; j++) {
                try {
                    count = count + Integer.parseInt(correctMatrix[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, "The data type is incorrect. Error index: " + i + j);

                }
            }

        }
        return count;
    }

}

