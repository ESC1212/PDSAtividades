package br.com.loja.assistec.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioTableModel;
import net.miginfocom.swing.MigLayout;

public class ListarUsuariosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLocalizar;
	private JTable tabela;
	private ArrayList<Usuario> usuariosList;
	private UsuarioTableModel usuarioTableModel;
	private JButton btnFechar;
	private JButton btnCadastrar;

	public ListarUsuariosView(){
		usuariosList = new ArrayList<>();
		
		setTitle("Listagem de usuários");
		setBounds(100, 100, 679, 506);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		getContentPane().add(btnCadastrar, "cell 0 0,growx,aligny top");
		
		txtLocalizar = new JTextField();
		getContentPane().add(txtLocalizar, "cell 1 0 2 1,growx,aligny center");
		txtLocalizar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "cell 0 1 3 1,grow");
		
		usuarioTableModel = new UsuarioTableModel(usuariosList);
		tabela = new JTable();
		tabela.setModel(usuarioTableModel);
		scrollPane.setViewportView(tabela);
		
		btnFechar = new JButton("Fechar");
		getContentPane().add(btnFechar, "cell 0 2 3 1,alignx center,aligny center");

	}
	public JTable getTable() {
		return tabela;
	}
	public void addListarUsuariosListener(ActionListener listener) {
		btnFechar.addActionListener(listener);
		btnCadastrar.addActionListener(listener);
	}
	
}