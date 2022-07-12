package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemCadastrarSabres;
	
	@FXML
	private MenuItem menuItemAtualizarSabres;
	
	@FXML
	private MenuItem menuItemCadastrarManutencoes;
	
	@FXML
	private MenuItem menuItemAtualizarManutencoes;
	
	@FXML
	private MenuItem menuItemPesquisarSabres;
	
	@FXML
	private MenuItem menuItemListarSabres;
	
	@FXML
	private MenuItem menuItemPesquisarManutencoes;
	
	@FXML
	private MenuItem menuItemListarManutencoes;
	
	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	public void onMenuItemCadastrarSabresAction() {
		System.out.println("Cadastro de Sabres");
	}
	
	@FXML
	public void onMenuItemAtualizarSabresAction() {
		System.out.println("Atualização de Sabres");
	}
	
	@FXML
	public void onMenuItemCadastrarManutencoesAction() {
		System.out.println("Cadastro de Manutenções");
	}
	
	@FXML
	public void onMenuItemAtualizarManutencoesAction() {
		System.out.println("Atualização de Manutenções");
	}
	
	@FXML
	public void onMenuItemPesquisarSabresAction() {
		System.out.println("Pesquisa de Sabres");
	}
	
	@FXML
	public void onMenuItemListarSabresAction() {
		System.out.println("Listagem de Sabres");
	}
	
	@FXML
	public void onMenuItemPesquisarManutencoesAction() {
		System.out.println("Pesquisa de Manutenções");
	}
	
	@FXML
	public void onMenuItemListarManutencoesAction() {
		System.out.println("Listagem de Manutenções");
	}
	
	@FXML
	public void onMenuItemSobreAction() {
		System.out.println("Sobre o controle de Sabres");
	}


	@Override
	public void initialize(URL uri, ResourceBundle rb) {		
	}
	
	
	

}
