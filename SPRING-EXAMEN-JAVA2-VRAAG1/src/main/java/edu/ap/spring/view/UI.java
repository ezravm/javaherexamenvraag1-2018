package edu.ap.spring.view;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;



@Component
public class UI implements InitializingBean {

	@Autowired
	EventHandler eventHandler;


	private JFrame jFrame;
	private JLabel label1, quotelabel;
	private JTextField zoekwoord;
	private JPanel controlpanel;
	private JButton btnsavequotes,btngetallquotes,btnsearch;
	private JTextArea allequotes;

	public UI() {}

	public void setupUI() {
		jFrame = new JFrame("QuotesApp");
		jFrame.setLayout(new FlowLayout());

		controlpanel = new JPanel();
		controlpanel.setLayout(new GridLayout(3,2));

		label1 = new JLabel("zoekwoord: ");
		zoekwoord = new JTextField(15);

		allequotes = new JTextArea();

		quotelabel = new JLabel("");

		btnsavequotes = new JButton();
		btnsavequotes.setText("alles opslaan");
		btnsavequotes.addActionListener(eventHandler::whenSaveButtonClicked);

		btngetallquotes = new JButton();
		btngetallquotes.setText("alles ophalen");
		btngetallquotes.addActionListener(eventHandler::whenGetButtonClicked);


		controlpanel.add(label1);
		controlpanel.add(zoekwoord);
		controlpanel.add(quotelabel);
		controlpanel.add(btnsavequotes);
		controlpanel.add(allequotes);
		controlpanel.add(btngetallquotes);

		jFrame.add(controlpanel);

		jFrame.setSize(800,800);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	public EventHandler getEventHandler() {
		return eventHandler;
	}

	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JLabel getQuotelabel() {
		return quotelabel;
	}

	public void setQuotelabel(JLabel quotelabel) {
		this.quotelabel = quotelabel;
	}

	public JTextField getZoekwoord() {
		return zoekwoord;
	}

	public void setZoekwoord(JTextField zoekwoord) {
		this.zoekwoord = zoekwoord;
	}

	public JPanel getControlpanel() {
		return controlpanel;
	}

	public void setControlpanel(JPanel controlpanel) {
		this.controlpanel = controlpanel;
	}

	public JButton getBtnsavequotes() {
		return btnsavequotes;
	}

	public void setBtnsavequotes(JButton btnsavequotes) {
		this.btnsavequotes = btnsavequotes;
	}

	public JButton getBtngetallquotes() {
		return btngetallquotes;
	}

	public void setBtngetallquotes(JButton btngetallquotes) {
		this.btngetallquotes = btngetallquotes;
	}

	public JButton getBtnsearch() {
		return btnsearch;
	}

	public void setBtnsearch(JButton btnsearch) {
		this.btnsearch = btnsearch;
	}

	public JTextArea getAllequotes() {
		return allequotes;
	}

	public void setAllequotes(JTextArea allequotes) {
		this.allequotes = allequotes;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
