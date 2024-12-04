package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;
import br.com.loja.assistec.view.CadastrarUsuariosView;
import br.com.loja.assistec.view.MensagemView;

public class CadastrarUsuarioController {
	private CadastrarUsuariosView cadastrarView;
	private ListarUsuarioController listarController;
	private Usuario usuarioSelecionado;
	
	public CadastrarUsuarioController( ListarUsuarioController listarUsuariosController,Usuario user) {
		this.usuarioSelecionado = user;
		this.listarController = listarUsuariosController;
		cadastrarView = new CadastrarUsuariosView(user);
		cadastrarView.setLocationRelativeTo(null);
		cadastrarView.setVisible(true);
		configurarListeners();
	}

	private void configurarListeners() {
		cadastrarView.addCadastrarUsuariosListener(new CadastrarUsuariosListener());
		cadastrarView.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				if (usuarioSelecionado != null) {
					cadastrarView.preencherCampos(usuarioSelecionado);
				}
				
			}
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
		});
	}
	
	private class CadastrarUsuariosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "BotaoFecharAction":
				cadastrarView.dispose();
				break;
			case "BotaoExcluirAction":
				Delete();
				break;
			case "BotaoIncluirAction":
				try {
					UpdateOrInsert();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			default:
				break;
			}
		}

		private void UpdateOrInsert() throws SQLException {
			String perfil = (String) cadastrarView.getPerfilSelecionado();
			if(usuarioSelecionado == null) {
				incluir(cadastrarView.getNome(), cadastrarView.getFone(), cadastrarView.getLogin(), cadastrarView.getSenha(), perfil);
				new MensagemView("Registro inserido com sucesso!",3);
				cadastrarView.dispose();
				atualizarTabela();
			}
			
		}

		private void incluir(String nome, String fone, String login, String senha, String perfil) throws SQLException {
			Usuario usuario = new Usuario(nome, fone, login, senha, perfil);
			new UsuarioDAO().salvar(usuario);
		}

		private void Delete(){
			MensagemView mv = new MensagemView("Tem certeza que deseja excluir o usuario?");
			if (mv.getResposta()) {
				try {
				delete(usuarioSelecionado.getIduser());
				new MensagemView("Usuario excluido com sucesso",3);
				cadastrarView.dispose();
				atualizarTabela();
				} catch(SQLException e) {
					new MensagemView("Erro ao excluir usuario!",0);
				}
			}
		}

		private void atualizarTabela() throws SQLException {
			ArrayList<Usuario> novosUsuarios = listarController.listarUsuarios();
			listarController.atualizarTabela(novosUsuarios);
			
		}

		private void delete(long iduser) throws SQLException {
			new UsuarioDAO().excluir(iduser);			
		}
		
	}

}
