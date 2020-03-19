package logic;

import java.io.IOException;
import java.io.PrintWriter;

import gui.MainWindow;

public class ShutdownLogic {

	private MainWindow mainWindow;
	private Runtime runtime;

	public ShutdownLogic(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		runtime = Runtime.getRuntime();
	}

	public int calculateTimeUntilShutdown(int hours, int minutes, int seconds) {
		int hoursToSec = 3600 * hours;
		int minutesToSec = 60 * minutes;
		return hoursToSec + minutesToSec + seconds;
	}

	public void startShutdown(int seconds) {
		mainWindow.getBtnShutdown().setEnabled(false);
		mainWindow.getSpnHours().setEnabled(false);
		mainWindow.getSpnMinutes().setEnabled(false);
		mainWindow.getSpnSeconds().setEnabled(false);
		mainWindow.getBtnAbort().setEnabled(true);

		String secondstoString = String.valueOf(seconds);

		Process p;
		try {
			String command = "cmd /c shutdown -s -t " + secondstoString;
			p = runtime.exec(command);
			p.waitFor();
			p.exitValue();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException();
		}
	}

	public void abortShutdown() {
		mainWindow.getBtnShutdown().setEnabled(true);
		mainWindow.getSpnHours().setEnabled(true);
		mainWindow.getSpnMinutes().setEnabled(true);
		mainWindow.getSpnSeconds().setEnabled(true);
		mainWindow.getBtnAbort().setEnabled(false);

		Process p;
		try {
			p = runtime.exec("cmd /c shutdown -a ");
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			stdin.println("shutdown -a");
			stdin.close();
			p.waitFor();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException();
		}
	}
}
