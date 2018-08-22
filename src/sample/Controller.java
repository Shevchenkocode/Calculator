package sample;

/*
 * @Author: Ihor Shevchenko
 * @Date: 22.08.2018
 * @Version: 1.0.0
 * */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    //Variable for first and second value
    public volatile double first, second;
    //Number Button
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    //Button for double value (point)
    @FXML
    private Button buttonPoint;
    //Button for operations
    @FXML
    private Button buttonMul;
    @FXML
    private Button buttonDiv;
    @FXML
    private Button buttonSub;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonPercent;
    @FXML
    private Button buttonSqrt;
    @FXML
    private Button buttonPow;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonEqual;
    //Fields
    @FXML
    private TextField fieldError;
    @FXML
    private TextField fieldResult;
    private short operation = 0;

    @FXML
    private void initialize() {
        //Include Calculate.class
        Calculate calculate = new Calculate();

        //Listener for 0 Button
        button0.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "0");
        });

        //Listener for 1 Button
        button1.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "1");
        });

        //Listener for 2 Button
        button2.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "2");
        });

        //Listener for 3 Button
        button3.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "3");
        });

        //Listener for 4 Button
        button4.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "4");
        });

        //Listener for 5 Button
        button5.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "5");
        });

        //Listener for 6 Button
        button6.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "6");
        });

        //Listener for 7 Button
        button7.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "7");
        });

        //Listener for 8 Button
        button8.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "8");
        });

        //Listener for 9 Button
        button9.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + "9");
        });

        //Listener for Addition Button
        buttonAdd.setOnAction(event -> {
            buttonEqual.fire();
            first = Double.parseDouble(fieldResult.getText());
            operation = 1;
            fieldResult.setText(fieldResult.getText() + "+");
        });

        buttonSub.setOnAction(event -> {
            buttonEqual.fire();
            first = Double.parseDouble(fieldResult.getText());
            operation = 2;
            fieldResult.setText(fieldResult.getText() + "-");
        });

        buttonMul.setOnAction(event -> {
            buttonEqual.fire();
            first = Double.parseDouble(fieldResult.getText());
            operation = 3;
            fieldResult.setText(fieldResult.getText() + "×");
        });

        buttonDiv.setOnAction(event -> {
            buttonEqual.fire();
            first = Double.parseDouble(fieldResult.getText());
            operation = 4;
            fieldResult.setText(fieldResult.getText() + "÷");
        });

        buttonPow.setOnAction(event -> {
            buttonEqual.fire();
            first = Double.parseDouble(fieldResult.getText());
            operation = 5;
            fieldResult.setText(fieldResult.getText() + "²");
        });

        buttonSqrt.setOnAction(event -> {
            if (String.valueOf(fieldResult.getText()).equals("")) {
                fieldResult.setText("√");
                operation = 6;
            } else {
                buttonEqual.fire();
                first = Double.parseDouble(fieldResult.getText());
                fieldResult.setText(fieldResult.getText() + "√");
                operation = 6;
            }
        });

        buttonPercent.setOnAction(event -> {
            if (String.valueOf(fieldResult.getText()).equals("")) {
                fieldResult.setText(fieldResult.getText() + "%");
            } else {
                buttonEqual.fire();
                first = Double.parseDouble(fieldResult.getText());
                operation = 7;
                fieldResult.setText(fieldResult.getText() + "%");
            }
        });

        buttonClear.setOnAction(event -> {
            fieldResult.setText("");
            fieldError.setText("");
            operation = 0;
            first = 0;
            second = 0;
        });

        buttonPoint.setOnAction(event -> {
            fieldResult.setText(fieldResult.getText() + ".");
        });

        buttonEqual.setOnAction(event -> {
            String s;
            String parts[];
            double res;
            try {
                switch (operation) {
                    //Addition
                    case 1:
                        s = fieldResult.getText();
                        parts = s.split("[+]");
                        second = Double.parseDouble(parts[1]);
                        res = calculate.Add(first, second);
                        if ((res % 1) == 0) {
                            s = String.valueOf(res);
                            parts = s.split("[.]");
                            fieldResult.setText(parts[0]);
                        } else {
                            fieldResult.setText(String.valueOf(res));
                        }
                        operation = 0;
                        first = 0;
                        second = 0;
                        s = "";
                        fieldError.setText("");
                        break;

                    //Substration
                    case 2:
                        s = fieldResult.getText();
                        parts = s.split("[-]");
                        second = Double.parseDouble(parts[1]);
                        res = calculate.Sub(first, second);
                        if ((res % 1) == 0) {
                            s = String.valueOf(res);
                            parts = s.split("[.]");
                            fieldResult.setText(parts[0]);
                        } else {
                            fieldResult.setText(String.valueOf(res));
                        }
                        operation = 0;
                        first = 0;
                        second = 0;
                        s = "";
                        break;

                    //Multiplication
                    case 3:
                        s = fieldResult.getText();
                        parts = s.split("[×]");
                        second = Double.parseDouble(parts[1]);
                        res = calculate.Mul(first, second);
                        if ((res % 1) == 0) {
                            s = String.valueOf(res);
                            parts = s.split("[.]");
                            fieldResult.setText(parts[0]);
                        } else {
                            fieldResult.setText(String.valueOf(res));
                        }
                        break;
                    //Division
                    case 4:
                        s = fieldResult.getText();
                        parts = s.split("[÷]");
                        second = Double.parseDouble(parts[1]);
                        if (second == 0) {
                            operation = 0;
                            first = 0;
                            second = 0;
                            fieldResult.setText(" ");
                            fieldError.setText("You can not divide by zero!");
                            break;
                        }
                        res = calculate.Div(first, second);
                        if ((res % 1) == 0) {
                            s = String.valueOf(res);
                            parts = s.split("[.]");
                            fieldResult.setText(parts[0]);
                        } else {
                            fieldResult.setText(String.valueOf(res));
                        }
                        operation = 0;
                        first = 0;
                        second = 0;
                        s = "";
                        fieldError.setText("");
                        break;
                    //Rise to the square
                    case 5:
                        res = calculate.X2(first);
                        if ((res % 1) == 0) {
                            s = String.valueOf(res);
                            parts = s.split("[.]");
                            fieldResult.setText(parts[0]);
                        } else {
                            fieldResult.setText(String.valueOf(res));
                        }
                        operation = 0;
                        first = 0;
                        second = 0;
                        s = "";
                        fieldError.setText("");
                        break;
                    //SQRT
                    case 6:
                        s = fieldResult.getText();
                        parts = s.split("[√]");
                        second = Double.parseDouble(String.valueOf(parts[1]));
                        if (first == 0) {
                            res = calculate.Sqrt(second);
                        } else {
                            res = calculate.Mul(first, calculate.Sqrt(second));
                        }
                        if ((res % 1) == 0) {
                            s = String.valueOf(res);
                            parts = s.split("[.]");
                            fieldResult.setText(parts[0]);
                        } else {
                            fieldResult.setText(String.valueOf(res));
                        }
                        operation = 0;
                        first = 0;
                        second = 0;
                        s = "";
                        fieldError.setText("");
                        break;
                    //Percent from value
                    case 7:
                        res = calculate.Percent(first);
                        if (second != 0) {
                            fieldError.setText("Incorrect expression.");
                        }
                        if ((res % 1) == 0) {
                            s = String.valueOf(res);
                            parts = s.split("[.]");
                            fieldResult.setText(parts[0]);
                        } else {
                            fieldResult.setText(String.valueOf(res));
                        }
                        operation = 0;
                        first = Double.parseDouble(fieldResult.getText());
                        second = 0;
                        s = "";
                        fieldError.setText("");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
