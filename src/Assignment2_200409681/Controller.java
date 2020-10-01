/**
 * Author: Lei Han 200409681
 * Date: 2020-03-24;
 */

package Assignment2_200409681;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Controller {
    //create FXML elements
    @FXML
    Label A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, point,
            numberA, numberB, numberC, numberD, numberE, numberF, numberG, numberH, numberI, numberJ, numberK, numberL, numberM, numberN, numberO, numberP, numberQ, numberR, numberS, numberT, numberU, numberV, numberW, numberX, numberY, numberZ;
    @FXML
    TextField word;
    @FXML
    TextArea previousWord;

    Model model = new Model();

    int[] numbers;

    ArrayList<String> letterClick = new ArrayList<String>();

    /**
     * method: when user click submit button, valid user's word and check if letters are enough, calculate points,
     * show remain numbers of letters, check if game over.
     *
     * @param e
     */
    @FXML
    private void submit(ActionEvent e) {
        String userWord = word.getText();
        if (model.wordCheck(userWord)) {

            if (model.wordEnough(userWord)) {
                //System.out.println("success");
                previousWord.setText(model.showPreviousWords(userWord));

                model.getNumberOfLetters(userWord);

                numbers = model.getNumbersOfLetters();

                point.setText(valueOf(model.getPoints()));
                showNumberOfLetters();

                model.isGameOver();

                //clear the input area
                word.clear();
                letterClick.clear();
            }
        }
    }

    /**
     * method: show the remain numbers of each letter, and if one letter is 0, then disappear.
     */
    private void showNumberOfLetters() {
        numberA.setText(valueOf(numbers[0]));
        numberB.setText(valueOf(numbers[1]));
        numberC.setText(valueOf(numbers[2]));
        numberD.setText(valueOf(numbers[3]));
        numberE.setText(valueOf(numbers[4]));
        numberF.setText(valueOf(numbers[5]));
        numberG.setText(valueOf(numbers[6]));
        numberH.setText(valueOf(numbers[7]));
        numberI.setText(valueOf(numbers[8]));
        numberJ.setText(valueOf(numbers[9]));
        numberK.setText(valueOf(numbers[10]));
        numberL.setText(valueOf(numbers[11]));
        numberM.setText(valueOf(numbers[12]));
        numberN.setText(valueOf(numbers[13]));
        numberO.setText(valueOf(numbers[14]));
        numberP.setText(valueOf(numbers[15]));
        numberQ.setText(valueOf(numbers[16]));
        numberR.setText(valueOf(numbers[17]));
        numberS.setText(valueOf(numbers[18]));
        numberT.setText(valueOf(numbers[19]));
        numberU.setText(valueOf(numbers[20]));
        numberV.setText(valueOf(numbers[21]));
        numberW.setText(valueOf(numbers[22]));
        numberX.setText(valueOf(numbers[23]));
        numberY.setText(valueOf(numbers[24]));
        numberZ.setText(valueOf(numbers[25]));
        if (numberA.getText().equals("0")) {
            A.setVisible(false);
        }
        if (numberB.getText().equals("0")) {
            B.setVisible(false);
        }
        if (numberC.getText().equals("0")) {
            C.setVisible(false);
        }
        if (numberD.getText().equals("0")) {
            D.setVisible(false);
        }
        if (numberE.getText().equals("0")) {
            E.setVisible(false);
        }
        if (numberF.getText().equals("0")) {
            F.setVisible(false);
        }
        if (numberG.getText().equals("0")) {
            G.setVisible(false);
        }
        if (numberH.getText().equals("0")) {
            H.setVisible(false);
        }
        if (numberI.getText().equals("0")) {
            I.setVisible(false);
        }
        if (numberJ.getText().equals("0")) {
            J.setVisible(false);
        }
        if (numberK.getText().equals("0")) {
            K.setVisible(false);
        }
        if (numberL.getText().equals("0")) {
            L.setVisible(false);
        }
        if (numberM.getText().equals("0")) {
            M.setVisible(false);
        }
        if (numberN.getText().equals("0")) {
            N.setVisible(false);
        }
        if (numberO.getText().equals("0")) {
            O.setVisible(false);
        }
        if (numberP.getText().equals("0")) {
            P.setVisible(false);
        }
        if (numberQ.getText().equals("0")) {
            Q.setVisible(false);
        }
        if (numberR.getText().equals("0")) {
            R.setVisible(false);
        }
        if (numberS.getText().equals("0")) {
            S.setVisible(false);
        }
        if (numberT.getText().equals("0")) {
            T.setVisible(false);
        }
        if (numberU.getText().equals("0")) {
            U.setVisible(false);
        }
        if (numberV.getText().equals("0")) {
            V.setVisible(false);
        }
        if (numberW.getText().equals("0")) {
            W.setVisible(false);
        }
        if (numberX.getText().equals("0")) {
            X.setVisible(false);
        }
        if (numberY.getText().equals("0")) {
            Y.setVisible(false);
        }
        if (numberZ.getText().equals("0")) {
            Z.setVisible(false);
        }
    }

    /**
     * method: if user click on the GUI letter, the letter will add to the input area
     */
    @FXML
    private void addA() {
        letterClick.add("a");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addB() {
        letterClick.add("b");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addC() {
        letterClick.add("c");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addD() {
        letterClick.add("d");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addE() {
        letterClick.add("e");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addF() {
        letterClick.add("f");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addG() {
        letterClick.add("g");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addH() {
        letterClick.add("h");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addI() {
        letterClick.add("i");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addJ() {
        letterClick.add("j");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addK() {
        letterClick.add("k");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addL() {
        letterClick.add("l");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addM() {
        letterClick.add("m");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addN() {
        letterClick.add("n");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addO() {
        letterClick.add("o");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addP() {
        letterClick.add("p");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addQ() {
        letterClick.add("q");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addR() {
        letterClick.add("r");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addS() {
        letterClick.add("s");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addT() {
        letterClick.add("t");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addU() {
        letterClick.add("u");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addV() {
        letterClick.add("v");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addW() {
        letterClick.add("w");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addX() {
        letterClick.add("x");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addY() {
        letterClick.add("y");
        word.setText(String.join("", letterClick));
    }

    @FXML
    private void addZ() {
        letterClick.add("z");
        word.setText(String.join("", letterClick));
    }

}
