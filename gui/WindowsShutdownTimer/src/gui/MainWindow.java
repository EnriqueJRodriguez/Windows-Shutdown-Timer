package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import logic.ShutdownLogic;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainWindow {

	private JFrame frmWindowsshutdowntimerByEnriquejrodriguez;
	private JLabel lblHoursUntilShutdown;
	private JSpinner spnHours;
	private JLabel lblMinutesUntilShutdown;
	private JSpinner spnMinutes;
	private JLabel lblSecondsUntilShutdown;
	private JSpinner spnSeconds;
	private JButton btnShutdown;
	private JButton btnAbort;
	private JLabel lblLogo;

	private ShutdownLogic logic;
	private JLabel lblMetMe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmWindowsshutdowntimerByEnriquejrodriguez.setLocationRelativeTo(null);
					window.frmWindowsshutdowntimerByEnriquejrodriguez.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWindowsshutdowntimerByEnriquejrodriguez = new JFrame();
		frmWindowsshutdowntimerByEnriquejrodriguez
				.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/logo.png")));
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().setForeground(new Color(255, 255, 255));
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().setBackground(new Color(51, 51, 51));
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().setLayout(null);
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getLblHoursUntilShutdown());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getSpnHours());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getLblMinutesUntilShutdown());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getSpnMinutes());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getLblSecondsUntilShutdown());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getSpnSeconds());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getBtnShutdown());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getBtnAbort());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getLblLogo());
		frmWindowsshutdowntimerByEnriquejrodriguez.getContentPane().add(getLblMetMe());
		frmWindowsshutdowntimerByEnriquejrodriguez.setResizable(false);
		frmWindowsshutdowntimerByEnriquejrodriguez.setTitle("WindowsShutdownTimer by EnriqueJRodriguez");
		frmWindowsshutdowntimerByEnriquejrodriguez.setBounds(100, 100, 442, 430);
		frmWindowsshutdowntimerByEnriquejrodriguez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.logic = new ShutdownLogic(this);
	}

	private JLabel getLblHoursUntilShutdown() {
		if (lblHoursUntilShutdown == null) {
			lblHoursUntilShutdown = new JLabel("Hours until shutdown:");
			lblHoursUntilShutdown.setToolTipText("Select the number of hours until your desired shutdown");
			lblHoursUntilShutdown.setLabelFor(getSpnHours());
			lblHoursUntilShutdown.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHoursUntilShutdown.setForeground(new Color(255, 255, 255));
			lblHoursUntilShutdown.setBounds(83, 215, 143, 19);
			lblHoursUntilShutdown.setDisplayedMnemonic('H');
		}
		return lblHoursUntilShutdown;
	}

	public JSpinner getSpnHours() {
		if (spnHours == null) {
			spnHours = new JSpinner();
			spnHours.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spnHours.setRequestFocusEnabled(false);
			spnHours.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnHours.setBounds(248, 214, 97, 20);
		}
		return spnHours;
	}

	private JLabel getLblMinutesUntilShutdown() {
		if (lblMinutesUntilShutdown == null) {
			lblMinutesUntilShutdown = new JLabel("Minutes until shutdown:");
			lblMinutesUntilShutdown.setLabelFor(getSpnMinutes());
			lblMinutesUntilShutdown.setToolTipText("Select the number of minutes until your desired shutdown");
			lblMinutesUntilShutdown.setForeground(Color.WHITE);
			lblMinutesUntilShutdown.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblMinutesUntilShutdown.setDisplayedMnemonic('M');
			lblMinutesUntilShutdown.setBounds(70, 245, 156, 19);
		}
		return lblMinutesUntilShutdown;
	}

	public JSpinner getSpnMinutes() {
		if (spnMinutes == null) {
			spnMinutes = new JSpinner();
			spnMinutes.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spnMinutes.setModel(new SpinnerNumberModel(0, 0, 60, 1));
			spnMinutes.setRequestFocusEnabled(false);
			spnMinutes.setBounds(248, 244, 97, 20);
		}
		return spnMinutes;
	}

	private JLabel getLblSecondsUntilShutdown() {
		if (lblSecondsUntilShutdown == null) {
			lblSecondsUntilShutdown = new JLabel("Seconds until shutdown:");
			lblSecondsUntilShutdown.setLabelFor(getSpnSeconds());
			lblSecondsUntilShutdown.setToolTipText("Select the number of seconds until your desired shutdown");
			lblSecondsUntilShutdown.setForeground(Color.WHITE);
			lblSecondsUntilShutdown.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSecondsUntilShutdown.setDisplayedMnemonic('S');
			lblSecondsUntilShutdown.setBounds(67, 275, 159, 19);
		}
		return lblSecondsUntilShutdown;
	}

	public JSpinner getSpnSeconds() {
		if (spnSeconds == null) {
			spnSeconds = new JSpinner();
			spnSeconds.setRequestFocusEnabled(false);
			spnSeconds.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spnSeconds.setBounds(248, 275, 97, 20);
		}
		return spnSeconds;
	}

	public JButton getBtnShutdown() {
		if (btnShutdown == null) {
			btnShutdown = new JButton("Shutdown");
			btnShutdown.setMnemonic('d');
			btnShutdown.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int seconds = logic.calculateTimeUntilShutdown((int) spnHours.getValue(),
							(int) spnMinutes.getValue(), (int) spnSeconds.getValue());
					logic.startShutdown(seconds);
				}
			});
			btnShutdown.setBackground(UIManager.getColor("Button.light"));
			btnShutdown.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnShutdown.setBounds(326, 359, 100, 31);
		}
		return btnShutdown;
	}

	public JButton getBtnAbort() {
		if (btnAbort == null) {
			btnAbort = new JButton("Abort");
			btnAbort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logic.abortShutdown();
				}
			});
			btnAbort.setBackground(UIManager.getColor("Button.darkShadow"));
			btnAbort.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAbort.setEnabled(false);
			btnAbort.setBounds(219, 359, 97, 31);
		}
		return btnAbort;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setBounds(77, 11, 291, 164);
			lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/img/logo_sml.png")));
		}
		return lblLogo;
	}

	private JLabel getLblMetMe() {
		if (lblMetMe == null) {
			lblMetMe = new JLabel("Met the creator of this program on Github");
			lblMetMe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Desktop.getDesktop().browse(new URI("https://github.com/EnriqueJRodriguez"));
					} catch (IOException e) {
						throw new RuntimeException();
					} catch (URISyntaxException e) {
						throw new RuntimeException();
					}
				}
			});
			lblMetMe.setToolTipText("Opens your web browser to the GitHub page of EnriqueJRodriguez");
			lblMetMe.setForeground(SystemColor.textHighlight);
			lblMetMe.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblMetMe.setBounds(70, 317, 275, 19);
		}
		return lblMetMe;
	}
}
