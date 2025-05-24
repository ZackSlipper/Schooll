package com.kitm;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

	private int maxOutputLength = 16;

	@FXML
	private TextField output;

	@FXML
	private Button btn_1;

	@FXML
	private Button btn_2;

	@FXML
	private Button btn_3;

	@FXML
	private Button btn_4;

	@FXML
	private Button btn_5;

	@FXML
	private Button btn_6;

	@FXML
	private Button btn_7;

	@FXML
	private Button btn_8;

	@FXML
	private Button btn_9;

	@FXML
	private Button btn_0;

	@FXML
	private Button btn_equals;

	@FXML
	private Button btn_clear;

	@FXML
	private Button btn_add;

	@FXML
	private Button btn_sub;

	@FXML
	private Button btn_mul;

	@FXML
	private Button btn_div;

    @FXML
	private void actionBtn1() throws IOException {
		addToken('1');
	}
	
	@FXML
	private void actionBtn2() throws IOException {
		addToken('2');
	}

	@FXML
	private void actionBtn3() throws IOException {
		addToken('3');
	}

	@FXML
	private void actionBtn4() throws IOException {
		addToken('4');
	}

	@FXML
	private void actionBtn5() throws IOException {
		addToken('5');
	}

	@FXML
	private void actionBtn6() throws IOException {
		addToken('6');
	}

	@FXML
	private void actionBtn7() throws IOException {
		addToken('7');
	}

	@FXML
	private void actionBtn8() throws IOException {
		addToken('8');
	}

	@FXML
	private void actionBtn9() throws IOException {
		addToken('9');
	}

	@FXML
	private void actionBtn0() throws IOException {
		addToken('0');
	}

	@FXML
	private void actionAdd() {
		addToken('+');
	}

	@FXML
	private void actionSub() {
		addToken('-');
	}

	@FXML
	private void actionMul() {
		addToken('x');
	}

	@FXML
	private void actionDiv() {
		addToken('/');
	}

	@FXML
	private void actionEquals() {
		String expression = output.getText();
		if (expression.equals("Error")) {
			return;
		}

		Token[] tokens = Calculator.tokenizeExpression(expression);
		if (!Calculator.validateTokenSequence(tokens)) {
			setOutput("Error");
			return;
		}

		setOutput(Calculator.evaluateTokens(tokens));
	}

	@FXML
	private void actionClear() {
		output.setText("");
	}

	private void addToken(Character token) {
		if (output.getText().equals("Error")) {
			setOutput("");
		}

		if (output.getText().length() < maxOutputLength) {
			setOutput(output.getText() + token);
		}
	}

	private void setOutput(String text) {
		output.setText(text);
	}

	private void setOutput(Integer number) {
		output.setText(number.toString());
	}
}
