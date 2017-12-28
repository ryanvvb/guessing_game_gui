import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numTries = 10;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		if (numTries > 0) {
			try {
				numTries--;
				if (guess < theNumber) {
					message = guess + " is too low. Try again!";
				}
				else if (guess > theNumber) {
					message = guess + " is too high. Try again!";
				}
				else {
					message = guess + " is correct! Congratulations, you completed the game with " + numTries + " remaining.";
					newGame();
				}
			} catch (Exception e){
				message = "Please enter a whole number between 1 and 100.";

			} finally {
				lblOutput.setText(message);
				txtGuess.requestFocus();
				txtGuess.selectAll();
			}
		}
		else {
			message = "Sorry, you did not guess the correct number.";
			lblOutput.setText(message);
		}
	}

	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);

	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ryan's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblRyansHiloGuessing = new JLabel("Ryan's Hi-Lo Guessing Game");
		lblRyansHiloGuessing.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblRyansHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		lblRyansHiloGuessing.setBounds(6, 57, 438, 16);
		getContentPane().add(lblRyansHiloGuessing);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setBounds(6, 130, 288, 16);
		getContentPane().add(lblGuessANumber);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(308, 125, 73, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(166, 162, 117, 29);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(6, 203, 438, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(500, 350));
		theGame.setVisible(true);

	}
}
