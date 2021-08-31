package sample;

public class NumberGenerator {

    private int size, start, end;
    int[] numberArray;
    public int numberToHide;
    // Constructor
    public NumberGenerator(int levelNumber){
       // new NumberGenerator(levelNumber+3,10+levelNumber,60+levelNumber);
        setSize(levelNumber+3);
        setEnd(60+levelNumber);
        setStart(10+levelNumber);
        numberArray = new int[this.size];
        ArrayGenerator();
    }
    public NumberGenerator(int size, int start, int end) {
        setSize(size);
        setEnd(end);
        setStart(start);
        numberArray = new int[this.size];
        ArrayGenerator();
    }
    //
    public int getSize() {
        return size;
    }

    public void setSize(int size) {

        if (size >= 0)
            this.size = size;
        else {
            System.out.println("Wrong Size");
            this.size = 0;
        }
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if (start >= 0)
            this.start = start;
        else {
            System.out.println("Wrong Start");
            this.start = 0;
        }
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        if (end >= 0)
            this.end = end;
        else {
            System.out.println("Wrong End");
            this.end = 0;
        }
    }

    // Private Method that generates an array
    // according to given parameters
    private void ArrayGenerator() {
        for (int i = 0; i < size; i++) {
            boolean isDuplicate = true;
            while (isDuplicate) {
                int number = ((int) (Math.random() * (end-start))) + start;

                for (int j = 0; j <= i; j++) {
                    if (numberArray[j] == number) {
                        isDuplicate = true;
                        break;
                    } else isDuplicate = false;
                }
                if (!isDuplicate) {
                    numberArray[i] = number;
                }
            }
        }
       // Arrays.sort(numberArray);
        int sum = 0;
        for (int number : numberArray) {
            sum += number;
        }
        numberArray[0] = sum/size;
        if (numberArray[0] == numberArray[3])
            numberArray[0
                    ]++;
    }
}
