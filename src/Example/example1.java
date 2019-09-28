package Example;

import java.awt.EventQueue;

import javax.swing.*;

public class example1 {
	public static void main(String[] args) {
		//better use eventQueue
		EventQueue.invokeLater(()->{
			AlgoFrame frame = new AlgoFrame("Welcome",500,500);
			
		});

	}

}
