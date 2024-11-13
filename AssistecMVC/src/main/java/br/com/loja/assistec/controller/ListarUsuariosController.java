package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import br.com.loja.assistec.model.LoginDAO;
import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.ListarUsuariosView;

public class ListarUsuariosController {
	LoginDAO LDAO = new LoginDAO();
	ListarUsuariosView LUV;
	
	private class ListarUsuariosListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String comando = e.getActionCommand();
			switch (comando) {
			case "BotaoCadastrarAction":
				abrirCadastrarUsuario(null);
				break;
			case "BotaoFecharAction":
				LUV.dispose();
				break;
			default:
				break;
			}
		}

		private void abrirCadastrarUsuario(Usuario usuarioSelecionado) {
			// TODO Auto-generated method stub
//			new CadastrarUsuarioController(this, usuarioSelecionado);
		}
		
	}
	
	public void ListarUsuarios() throws SQLException {
		ArrayList<Usuario> usuarios = LDAO.ListarUsuarios();
		
		DefaultTableModel tableModel = (DefaultTableModel) LUV.getTable().getModel();
        tableModel.setRowCount(0);
        
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[]{
            	usuario.getIduser(),
            	usuario.getLogin(),
            	usuario.getNome(),
            	usuario.getFone(),
            	usuario.getPerfil()
            });
        }
	}
}
