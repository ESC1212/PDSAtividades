package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.CadastrarUsuariosView;

public class CadastrarUsuarioController {
	private CadastrarUsuariosView cadastrarView;
	private ListarUsuariosController LUC;
	private Usuario usuarioSelecionado;
	
	public CadastrarUsuarioController(ListarUsuariosController LUC, Usuario user) {
				this.usuarioSelecionado = user;
				this.LUC = LUC;
				cadastrarView = new CadastrarUsuariosView(user);
				cadastrarView.setLocationRelativeTo(null);
				cadastrarView.setVisible(true);
				configurarListeners();
	}

	private void configurarListeners() {
		CadastrarUsuariosView cadastrarUsuariosView = new CadastrarUsuariosView(null);
		// TODO Auto-generated method stub
		cadastrarUsuariosView.addCadastrarUsuariosListener(new CadastrarUsuariosListener());
	}
	private class CadastrarUsuariosListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()) {
			case "BotaoFecharAction":
				cadastrarView.dispose();
				break;
			case "BotaoExcluirAction":
//				metodoExcluir();
				break;
			case "BotaoIncluirAction":
//				metodoAlterarOuIncluir();
			}
		}
		
	}

}
