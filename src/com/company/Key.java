package com.company;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Key {
    public Key() {
    }

    Shapes s1 = new Shapes();
    Shape[] shapeKey = {s1.polygon(Color.YELLOW, Color.GOLD),
            s1.circle(Color.MAGENTA, Color.PURPLE), s1.circle(Color.CYAN,
            Color.DARKCYAN), s1.polygon(Color.BLUE, Color.DARKBLUE),
            s1.rectangle(Color.GREEN, Color.DARKGREEN), s1.rectangle(Color.CYAN,
            Color.DARKCYAN), s1.rectangle(Color.ORANGE, Color.DARKORANGE),
            s1.rectangle(Color.BLUE, Color.DARKBLUE), s1.polygon(Color.CYAN,
            Color.DARKCYAN), s1.polygon(Color.BROWN, Color.DARKORANGE),
            s1.circle(Color.BROWN, Color.DARKORANGE), s1.circle(Color.BLUE,
            Color.DARKBLUE), s1.polygon(Color.GREEN, Color.DARKGREEN),
            s1.polygon(Color.ORANGE, Color.DARKORANGE), s1.circle(Color.GREEN,
            Color.DARKGREEN), s1.circle(Color.ORANGE, Color.DARKORANGE),
            s1.rectangle(Color.DARKGRAY, Color.BLACK), s1.circle(Color.YELLOW,
            Color.GOLD), s1.polygon(Color.DARKGRAY, Color.BLACK),
            s1.rectangle(Color.MAGENTA, Color.PURPLE), s1.polygon(Color.MAGENTA,
            Color.PURPLE), s1.rectangle(Color.DARKRED, Color.RED),
            s1.polygon(Color.BROWN, Color.DARKORANGE), s1.circle(Color.DARKRED,
            Color.RED), s1.rectangle(Color.YELLOW, Color.GOLD),
            s1.polygon(Color.DARKRED, Color.RED)};
    String word = workPicked();
    char[] arr = word.toCharArray();
    char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z'};
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
    char[] ascii = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    int[] asciikey = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77,
            78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101,
            102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116,
            117, 118, 119, 120, 121, 122};
    int[] ebckey = {193, 194, 195, 196, 197, 198, 199, 200, 201, 209, 210,
            211, 212, 213, 214, 215, 216, 217, 226, 227, 228, 229, 230, 231, 232, 233,
            129, 130, 131, 132, 133, 134, 135, 136, 137, 145, 146, 147, 148, 149, 150,
            151, 152, 153, 162, 163, 164, 165, 166, 167, 168, 169};

    //method to pick a word from the filed
    public String workPicked() {

        String wordString;
        String word = "";
        try {
            URL path = Key.class.getResource("wordlist.txt");
            File f = new File("src/com/company/wordlist.txt");
            Scanner input = new Scanner(f);
            int count = 0;
            while (input.hasNext()) {
                wordString = input.next();
                count = count + 1;
            }
            int picked = (int) (Math.random() * count) + 1;
            Scanner input2 = new Scanner(f);
            count = 0;
            while (input2.hasNext()) {
                wordString = input2.next();
                count = count + 1;
                if (count == picked) {
                    word = wordString;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return word;
    }

    public Shape randomShape(int codeInt, Shape[] code3) {
        Line l1 = new Line();
        Shape pickedShape = Shape.union(code3[codeInt], l1);
        pickedShape.setFill(code3[codeInt].getFill());
        pickedShape.setStroke(code3[codeInt].getStroke());
        pickedShape.setStrokeWidth(code3[codeInt].getStrokeWidth());
        return pickedShape;

    }

    public String[] ebcCode() {

        int addedCode = (int) (Math.random() * ascii.length) - 1;
        if (addedCode == -1) addedCode = 0;
        String randomChar = Character.toString(ascii[addedCode]);
        String ans = Integer.toString(ebckey[addedCode]);
        String[] arr = {randomChar, ans};
        return arr;

    }

    public String getAns(int codeInt, String word) {
        char[] arr = word.toCharArray();
        return Character.toString(arr[codeInt]);

    }

    public String reverseCode(String word) {
        char[] oppAlphabet = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R',
                'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C',
                'B', 'A'};
        char[] arr = word.toCharArray();
        char[] code = new char[arr.length];
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == arr[j]) {
                    code[j] = oppAlphabet[i];
                }
            }
        }
        return String.valueOf(code);
    }

    public String code2(String word) {
        char[] arr = word.toCharArray();
        int[] code2 = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == arr[j]) {
                    code2[j] = numbers[i];
                }
            }
        }
        return Arrays.toString(code2);
    }

    public String randomChar(String word) {
        char[] arr = word.toCharArray();
        int picked = (int) (Math.random() * arr.length);
        return Character.toString(arr[picked]);
    }

    public String code2ans(String character) {
        char c1 = character.charAt(0);
        int index = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (c1 == alphabet[i]) {
                index = i;
            }
        }
        return Integer.toString(numbers[index]);

    }

    public HBox pane(String word) {
        char[] arr = word.toCharArray();
        //      System.out.println(arr);
        Line l1 = new Line();
        l1.setStartX(0.0f);
        l1.setStartY(0.0f);
        l1.setEndX(0.0f);
        l1.setEndY(0.0f);
        l1.setStrokeWidth(0.0);
        l1.setStroke(null);
        Shape[] code3 = new Shape[arr.length];
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == arr[j]) {
                    code3[j] = Shape.union(shapeKey[i], l1);
                    code3[j].setFill(shapeKey[i].getFill());
                    code3[j].setStroke(shapeKey[i].getStroke());
                    code3[j].setStrokeWidth(shapeKey[i].getStrokeWidth());
                }
            }
        }
        HBox pane1 = new HBox();
        for (Shape shape : code3) {
            pane1.getChildren().addAll(shape);
        }
        return pane1;
    }

    public Shape[] code1(String word) {
        char[] arr = word.toCharArray();
        Shape[] code3 = new Shape[arr.length];
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < 25; i++) {
                if (alphabet[i] == arr[j]) {
                    code3[j] = shapeKey[i];
                }


            }
        }
        return code3;
    }

    public String randomCharecter() {
        int addedCode = (int) (Math.random() * ascii.length - 1);
        return Character.toString(ascii[addedCode]);
    }

    public String asciiAnswer(String character) {
        return Integer.toString(character.charAt(0));
    }

    public String ebcAns() {
        int addedCode = (int) (Math.random() * ebckey.length - 1);
        String ebcAns = Integer.toString(ebckey[addedCode]);
        return ebcAns;
    }
}
