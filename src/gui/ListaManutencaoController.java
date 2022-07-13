package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Manutencao;
import model.services.ManutencaoService;

public class ListaManutencaoController implements Initializable{
	
	private ManutencaoService service;

	@FXML
	private TableView<Manutencao> tableViewManutencoes;
	
	@FXML
	private TableColumn<Manutencao, Integer> tableColumnIdManutencao;
	
	@FXML
	private TableColumn<Manutencao, String> tableColumnDataManutencao;
	
	@FXML
	private TableColumn<Manutencao, String> tableColumnResponsavel;
	
	@FXML
	private TableColumn<Manutencao, Integer> tableColumnIdSabre;
	
	private ObservableList<Manutencao> manutencaoList;
	
	public void setManutencaoService(ManutencaoService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		tableColumnIdManutencao.setCellValueFactory(new PropertyValueFactory<>("idManutencao"));
		tableColumnDataManutencao.setCellValueFactory(new PropertyValueFactory<>("dataManutencao"));
		tableColumnResponsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
		tableColumnIdSabre.setCellValueFactory(new PropertyValueFactory<>("idSabre"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewManutencoes.prefHeightProperty().bind(stage.heightProperty());
		tableViewManutencoes.prefWidthProperty().bind(stage.widthProperty());
	}
	
	public void updateTableViewManutencoes() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Manutencao> list = service.findAll();
		manutencaoList = FXCollections.observableArrayList(list);
		tableViewManutencoes.setItems(manutencaoList);
	}

}
