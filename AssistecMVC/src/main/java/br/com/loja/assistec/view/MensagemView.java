package br.com.loja.assistec.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MensagemView extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private boolean resposta;
	
	public MensagemView(String mensagem, int tipo) {
		setTitle("Mensagem");
		setModal(true);
		setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		
		JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
		panel.add(lblMensagem, BorderLayout.CENTER);
		
		String iconPath;
		switch(tipo) {
		case 0:
			iconPath = "/br/com/loja/assistec/icones/erro.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 1:
			iconPath = "/br/com/loja/assistec/icones/info.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 2:
			iconPath = "/br/com/loja/assistec/icones/alerta.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 3:
			iconPath = "/br/com/loja/assistec/icones/sucesso.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
		case 10:
			iconPath = "/br/com/loja/assistec/icones/assistec.png";
			lblMensagem.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			break;
			default:
				break;
		}
		
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		painelSul.add(new JPanel());
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		painelSul.add(btnOK);
		painelSul.add(new JPanel());
		panel.add(painelSul, BorderLayout.SOUTH);
		getRootPane().setDefaultButton(btnOK);
		setSize(350,200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public MensagemView(String pergunta) {
		setTitle("Mensagem");
		setModal(true);
		setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		
		JLabel labelPergunta = new JLabel(pergunta, SwingConstants.CENTER);
		String iconPath = "/br/com/loja/assistec/icones/question.png";
		labelPergunta.setIcon(new ImageIcon(getClass().getResource(iconPath)));
		panel.add(labelPergunta,BorderLayout.CENTER);
		
		JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		
		JButton btnSim = new JButton("Sim");
		btnSim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resposta = true;
				setVisible(false);
			}
		});
		
		JButton btnNao = new JButton("Não");
		btnNao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resposta = false;
				setVisible(false);
			}
		});
		painelSul.add(btnSim);
		painelSul.add(btnNao);
		painelSul.add(new JPanel());
		panel.add(painelSul, BorderLayout.SOUTH);
		getRootPane().setDefaultButton(btnSim);
		setSize(350,200);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public boolean getResposta() {
		return resposta;
	}
}
