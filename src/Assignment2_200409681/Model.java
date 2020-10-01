/**
 * Author: Lei Han 200409681
 * Date: 2020-03-24;
 */
package Assignment2_200409681;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Model {
    int points = 0;

    //letter array
    char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    //letter's point array
    int[] letterPoints = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    //previous words array list
    ArrayList<String> previousWords = new ArrayList<String>();
    //numbers of letters array
    int[] numbersOfLetters = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 8, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};

    //HashMap, key value pair, like dictionary in Python.
    Map<Character, Integer> letterAndNumber;

    {
        letterAndNumber = new TreeMap<Character, Integer>();

        letterAndNumber.put('a', 9);
        letterAndNumber.put('b', 2);
        letterAndNumber.put('c', 2);
        letterAndNumber.put('d', 4);
        letterAndNumber.put('e', 12);
        letterAndNumber.put('f', 2);
        letterAndNumber.put('g', 3);
        letterAndNumber.put('h', 2);
        letterAndNumber.put('i', 8);
        letterAndNumber.put('j', 1);
        letterAndNumber.put('k', 1);
        letterAndNumber.put('l', 4);
        letterAndNumber.put('m', 2);
        letterAndNumber.put('n', 6);
        letterAndNumber.put('o', 8);
        letterAndNumber.put('p', 2);
        letterAndNumber.put('q', 1);
        letterAndNumber.put('r', 6);
        letterAndNumber.put('s', 4);
        letterAndNumber.put('t', 6);
        letterAndNumber.put('u', 4);
        letterAndNumber.put('v', 2);
        letterAndNumber.put('w', 2);
        letterAndNumber.put('x', 1);
        letterAndNumber.put('y', 2);
        letterAndNumber.put('z', 1);
    }

    /**
     * method: return points that can be used in the controller
     *
     * @return int points
     * package protected default
     */
    int getPoints() {
        return points;
    }

    /**
     * method: return numbers of letters that can be used in the controller
     *
     * @return int[]
     * package protected default
     */
    int[] getNumbersOfLetters() {
        return numbersOfLetters;
    }

    /**
     * method that check if the word is available. if not, show an error message box and give error details
     * --1. word should more than 1 letter
     * --2. word should less than 9 letters
     * --3. word should have at least one vowel(a e i o u y)
     * --4. word cannot repeat.
     * --5. word should only with letters, cannot have number of symbol
     *
     * @param word, user's input
     * @return boolean, true means valid word, false requests another input
     * package protected default
     */
    boolean wordCheck(String word) {
        boolean wordAvailable = false;
        word = word.toLowerCase();
        if (word.length() >= 2 && word.length() <= 8
                && word.matches("\\w*([aeiouy])\\w*")
                && !previousWords.contains(word)
                && word.matches("^[a-z]+$")
        ) {
            wordAvailable = true;
        } else {
            if (word.length() == 0) {
                errorAlert("Blank! Please type something!");
            } else if (word.length() > 8) {
                errorAlert("This word is too long, cannot more than 8 letters");
            } else if (word.length() < 2) {
                errorAlert("This word is too short, should more than 1 letter");
            } else if (previousWords.contains(word)) {
                errorAlert("Please type something new! This word is already used");
            } else if (!word.matches("^[a-z]+$")) {
                errorAlert("Please enter word with only letters");
            } else {
                errorAlert("This word should have at least one vowel letter");
            }
        }
        return wordAvailable;
    }

    /**
     * method that check if letters enough for this word, if enough (not 0), number of this letter minus 1
     * if not, show an error message box and give error details.
     *
     * @param word, user's input
     * @return boolean, true means valid word, false request another input
     * package protected default
     */
    boolean wordEnough(String word) {
        word = word.toLowerCase();
        //numbers of letters, how many of this letter remain
        int numbers = 0;

        boolean wordAvailable = true;

        //create a HashMap use in this method
        Map<Character, Integer> letterAndNumber1 = letterAndNumber;

        char[] letterInWord = word.toCharArray();

        //for loop, check each letter of the word. once check false, break immediately
        for (char letter : letterInWord) {
            if (letterAndNumber1.containsKey(letter)) {
                numbers = letterAndNumber1.get(letter);
                if (numbers < 1) {
                    wordAvailable = false;
                    errorAlert(letter + " is not available");
                    break;
                } else
                    letterAndNumber1.put(letter, numbers - 1);
            }
        }
        return wordAvailable;
    }

    /**
     * method: calculate total points and the remain numbers of letters
     *
     * @param word, user's input
     *              package protected default
     */
    void getNumberOfLetters(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < letters.length; j++) {
                if (word.charAt(i) == letters[j]) {
                    points += letterPoints[j];
                    numbersOfLetters[j]--;
                }
            }
        }
    }

    /**
     * method that show the previous words, there is a comma between each word.
     *
     * @return String, the previous words
     * package protected default
     */
    String showPreviousWords(String word) {
        previousWords.add(word);
        return String.join(", ", previousWords);
    }

    /**
     * method: check if game is over
     * package protected default
     */
    void isGameOver() {
        int sum = 0;
        for (int number : numbersOfLetters) {
            sum += number;
        }
        if (sum == 1) {
            gameOverAlert("No more letter, game over");
        } else if (numbersOfLetters[0] == 0 && numbersOfLetters[4] == 0 && numbersOfLetters[8] == 0 && numbersOfLetters[14] == 0 && numbersOfLetters[20] == 0 && numbersOfLetters[24] == 0) {
            gameOverAlert("No more vowels, game over");
        }
    }

    /**
     * method: show an error message box, and give error details
     *
     * @param errorMessage error message
     */
    private void errorAlert(String errorMessage) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText(errorMessage);
        errorAlert.showAndWait();
    }

    private void gameOverAlert(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Game Over");
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }
}
