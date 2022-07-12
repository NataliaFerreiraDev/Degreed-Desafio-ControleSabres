package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

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
		loadView("/gui/Sobre.fxml", x -> {});
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

	private synchronized<T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVbox.getChildren().get(0);
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
			
		} catch(IOException ex) {
			Alerts.showAlert("IO Exception", "Error loading view", ex.getMessage(), AlertType.ERROR);
		}
	}

}
