package Main;

import java.io.IOException;

import controller.Read;
import view.Main_Frame;

public class My_app {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Read.read();
		Main_Frame mf = Main_Frame.getInstance();
		mf.setVisible(true);
	}

}
