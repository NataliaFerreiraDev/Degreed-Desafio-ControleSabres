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
import model.services.ManutencaoService;

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
		loadView("/gui/telas/CadastroSabres.fxml", x -> {});
	}

	@FXML
	public void onMenuItemAtualizarSabresAction() {
		loadView("/gui/telas/AtualizaSabres.fxml", x -> {});
	}

	@FXML
	public void onMenuItemCadastrarManutencoesAction() {
		loadView("/gui/telas/CadastroManutencao.fxml", x -> {});
	}

	@FXML
	public void onMenuItemAtualizarManutencoesAction() {
		loadView("/gui/telas/AtualizaManutencao.fxml", x -> {});
	}

	@FXML
	public void onMenuItemPesquisarSabresAction() {
		loadView("/gui/telas/PesquisaSabres.fxml", x -> {});
	}

	@FXML
	public void onMenuItemListarSabresAction() {
		loadView("/gui/telas/ListaManutencoes.fxml", x -> {});
	}

	@FXML
	public void onMenuItemPesquisarManutencoesAction() {
		loadView("/gui/telas/PesquisaManutencao.fxml", x -> {});
	}

	@FXML
	public void onMenuItemListarManutencoesAction() {
		loadView("/gui/telas/ListaManutencoes.fxml", (ListaManutencaoController controller) -> {
			controller.setManutencaoService(new ManutencaoService());
			controller.updateTableViewManutencoes();
		});
	}

	@FXML
	public void onMenuItemSobreAction() {
		loadView("/gui/telas/Sobre.fxml", x -> {});
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
