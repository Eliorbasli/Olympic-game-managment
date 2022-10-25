package View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Listeners.ViewListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewOlympic implements AbstractOlympicView  {

	private Spinner<Integer> spnUpdateSeats = new Spinner<Integer>();
	private Spinner<Integer> spnUpdateSeats1 = new Spinner<Integer>();
	private Vector<ViewListener> allListeners = new Vector<ViewListener>();

	public ViewOlympic(Stage theStage) throws Exception {

		allListeners = new Vector<ViewListener>();

		theStage.setTitle("Olympic Manager");

		ComboBox<Integer> cmStadium = new ComboBox<Integer>();

		ComboBox<Integer> cmAllJudges = new ComboBox<Integer>();

		ComboBox<String> cmStadiumState = new ComboBox<String>();

		ComboBox<Integer> cmExistTeam = new ComboBox<Integer>();

		ComboBox<String> cmSJudgeState = new ComboBox<String>();

		ComboBox<String> cmJudgeSport = new ComboBox<String>();
		cmJudgeSport.getItems().addAll("Running", "HighJump", "Both");

		ComboBox<Integer> cmJudge = new ComboBox<Integer>();

		ComboBox<String> cmSport = new ComboBox<String>();
		cmSport.getItems().addAll("Running", "HighJump");

		ComboBox<String> cmState = new ComboBox<String>();

		ComboBox<String> cmState1 = new ComboBox<String>();

		ComboBox<Integer> cmStadiumPerComp = new ComboBox<Integer>();

		ComboBox<Integer> cmJudgePerComp = new ComboBox<Integer>();

		ComboBox<String> cmSportPerComp = new ComboBox<String>();
		cmSportPerComp.getItems().addAll("Running", "HighJump");

		ComboBox<Integer> cmTeamWin1 = new ComboBox<Integer>();
		ComboBox<Integer> cmTeamWin2 = new ComboBox<Integer>();
		ComboBox<Integer> cmTeamWin3 = new ComboBox<Integer>();
		ComboBox<Integer> cmtPerCompWin1 = new ComboBox<Integer>();
		ComboBox<Integer> cmtPerCompWin2 = new ComboBox<Integer>();
		ComboBox<Integer> cmtPerCompWin3 = new ComboBox<Integer>();
		ComboBox<Integer> cmDelAthlete = new ComboBox<Integer>();
		ComboBox<Integer> cmDelTeamAthlete = new ComboBox<Integer>();

		ComboBox<String> cmSportAthlete = new ComboBox<String>();
		cmSportAthlete.getItems().addAll("Running", "HighJump", "Both");

		ComboBox<Integer> cmDelStadium = new ComboBox<Integer>();

		ComboBox<Integer> cmUpStadium = new ComboBox<Integer>();

		ComboBox<Integer> cmUpJudge = new ComboBox<Integer>();

		List<String> countriesList = new ArrayList<String>();

		String[] locales = Locale.getISOCountries();

		for (String countrCode : locales) {
			Locale obj = new Locale("", countrCode);
			countriesList.add(obj.getDisplayCountry(Locale.ENGLISH));
			Collections.sort(countriesList);
		}

		for (int j = 0; j < locales.length; j++) {
			cmState.getItems().add(countriesList.get(j));
			cmState1.getItems().add(countriesList.get(j));
			cmStadiumState.getItems().add(countriesList.get(j));
			cmSJudgeState.getItems().add(countriesList.get(j));
		}

		HBox hbButtomOly = new HBox();
		hbButtomOly.setPadding(new Insets(30));
		hbButtomOly.setSpacing(60);
		hbButtomOly.setAlignment(Pos.TOP_CENTER);

		HBox hbRoot = new HBox();
		hbRoot.setPadding(new Insets(30));
		hbRoot.setSpacing(60);
		hbRoot.setAlignment(Pos.TOP_CENTER);

		HBox hbButtom = new HBox();
		hbButtom.setPadding(new Insets(30));
		hbButtom.setSpacing(60);
		hbButtom.setAlignment(Pos.TOP_CENTER);

		HBox hbCreateTeam = new HBox();
		hbCreateTeam.setPadding(new Insets(30));
		hbCreateTeam.setSpacing(20);
		hbCreateTeam.setAlignment(Pos.TOP_CENTER);

		HBox hbAddAthelteToTeam = new HBox();
		hbAddAthelteToTeam.setPadding(new Insets(30));
		hbAddAthelteToTeam.setSpacing(20);
		hbAddAthelteToTeam.setAlignment(Pos.TOP_CENTER);
		hbAddAthelteToTeam.setVisible(false);

		HBox hbCreateStadium = new HBox();
		hbCreateStadium.setPadding(new Insets(30));
		hbCreateStadium.setSpacing(20);
		hbCreateStadium.setAlignment(Pos.TOP_CENTER);

		HBox hbCreateJudge = new HBox();
		hbCreateJudge.setPadding(new Insets(30));
		hbCreateJudge.setSpacing(20);
		hbCreateJudge.setAlignment(Pos.TOP_CENTER);

		HBox hbCreateAthlete = new HBox();
		hbCreateAthlete.setPadding(new Insets(30));
		hbCreateAthlete.setSpacing(20);
		hbCreateAthlete.setAlignment(Pos.TOP_CENTER);

		VBox vbTeam = new VBox();
		vbTeam.setPadding(new Insets(30));
		vbTeam.setSpacing(20);
		vbTeam.setAlignment(Pos.TOP_CENTER);

		VBox vbJudge = new VBox();
		vbJudge.setPadding(new Insets(30));
		vbJudge.setSpacing(20);
		vbJudge.setAlignment(Pos.TOP_CENTER);

		VBox vbStadium = new VBox();
		vbStadium.setPadding(new Insets(30));
		vbStadium.setSpacing(20);
		vbStadium.setAlignment(Pos.TOP_CENTER);

		VBox vbAthlete = new VBox();
		vbAthlete.setPadding(new Insets(30));
		vbAthlete.setSpacing(20);
		vbAthlete.setAlignment(Pos.TOP_CENTER);

		Button btnStartOlympic = new Button("Start Olympic game");
		Button btnAddRemoveEdit = new Button("Add/Remove/Edit");

		hbRoot.getChildren().addAll(btnAddRemoveEdit, btnStartOlympic);

		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabTeam = new Tab("Team", vbTeam);
		Tab tabAthlete = new Tab("Athlete", vbAthlete);
		Tab tabJudge = new Tab("Judge", vbJudge);
		Tab tabStadium = new Tab("Stadium", vbStadium);

		tabPane.getTabs().add(tabTeam);
		tabPane.getTabs().add(tabJudge);
		tabPane.getTabs().add(tabStadium);
		tabPane.getTabs().add(tabAthlete);

		Button btnBack = new Button("Back");
		Button btnBack1 = new Button("Back");
		Button btnShowAll = new Button("ShowAll");
		Button btnShowAll2 = new Button("show All");

		BorderPane bpRoot = new BorderPane();
		bpRoot.setTop(hbRoot);

		//////////////// Team/////////////////////////////
		// HBox Create Team

		Label lblTeamEdit = new Label("Create Team:");
		lblTeamEdit.setStyle("-fx-font-weight: bold");
		Label lblTeamState = new Label("Insert Team's state : ");
		Button btnSaveTeam = new Button("Create Team");

		// -------------------Hbox del Team---------------------

		HBox hbDelTeam = new HBox();
		hbDelTeam.setPadding(new Insets(30));
		hbDelTeam.setSpacing(20);
		hbDelTeam.setAlignment(Pos.TOP_CENTER);

		Label lblDelTeam = new Label("Delete Team");
		lblDelTeam.setStyle("-fx-font-weight: bold");

		Label lblInsertTeam = new Label("Select Team : ");

		Button btnDelTeam = new Button("Delete");

		Button btnStoptoAdd = new Button("clear");

		hbCreateTeam.getChildren().addAll(lblTeamState, cmState1, btnSaveTeam);

		hbAddAthelteToTeam.getChildren()
				.addAll(/* lblAtheName ,tfAtheName , lblSelectSport ,cmAtheSport , btnAddAtheToTeam , */ btnStoptoAdd);

		hbDelTeam.getChildren().addAll(lblInsertTeam, cmExistTeam, btnDelTeam);

		vbTeam.getChildren().addAll(lblTeamEdit, hbCreateTeam, hbAddAthelteToTeam, lblDelTeam, hbDelTeam);

		/////////////////////////// Stadium/////////////////////////////
		// --------------HBox Create Stadium--------------------------

		Label lblStadiumEdit = new Label("------ Create Stadium: ------");
		lblStadiumEdit.setStyle("-fx-font-weight: bold");
		Label lblStatiumName = new Label("Insert Statium's name : ");
		TextField tfStadiumName = new TextField();
		Label lblStatiumState = new Label("Insert Statium's state : ");
		// TextField tfState = new TextField();
		Label lblStatiumSeats = new Label("seats : ");
		// TextField tfStadiumSeats = new TextField();
		Button btnSaveStadium = new Button("Create Stadium");
		SpinnerValueFactory<Integer> valueFactoryUpdateSeats = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
				500000);

		// --------------------Hbox del Statium--------------------------------
		spnUpdateSeats1.setValueFactory(valueFactoryUpdateSeats);
		spnUpdateSeats.setValueFactory(valueFactoryUpdateSeats);

		HBox hbDelStadium = new HBox();
		hbDelStadium.setPadding(new Insets(30));
		hbDelStadium.setSpacing(20);
		hbDelStadium.setAlignment(Pos.TOP_CENTER);

		Label lblDelStadium = new Label(" ----- Delete Stadium -----");
		lblDelStadium.setStyle("-fx-font-weight: bold");
		Label lblInsertStadium = new Label("Select Stadium : ");

		Button btnDelStadium = new Button("Delete");

		hbCreateStadium.getChildren().addAll(lblStatiumName, tfStadiumName, lblStatiumState, cmStadiumState,
				lblStatiumSeats, spnUpdateSeats1, btnSaveStadium);
		hbDelStadium.getChildren().addAll(lblInsertStadium, cmDelStadium, btnDelStadium);

		vbStadium.getChildren().addAll(lblStadiumEdit, hbCreateStadium, lblDelStadium, hbDelStadium);

		////////////////////// Judge////////////////
		// HBox Create Judge

		Label lblJudgeEdit = new Label("----- Create Judge: -----");
		lblJudgeEdit.setStyle("-fx-font-weight: bold");
		Label lblJudgeName = new Label("Insert Judge's name : ");
		TextField tfJudgeName = new TextField();
		Label lblJudgeState = new Label("Insert Judge's state : ");
		Label lblJudgeSport = new Label("Insert Judge's sport : ");
		Button btnSaveJudge = new Button("Create Judge");

		// Hbox del Judge
		HBox hbDelJudge = new HBox();
		hbDelJudge.setPadding(new Insets(30));
		hbDelJudge.setSpacing(20);
		hbDelJudge.setAlignment(Pos.TOP_CENTER);

		Label lblDelJudge = new Label("----- Delete Judge -----");
		lblDelJudge.setStyle("-fx-font-weight: bold");
		Label lblInsertJudge = new Label("Select Judge : ");
		Button btnDelJudge = new Button("Delete");

		hbCreateJudge.getChildren().addAll(lblJudgeName, tfJudgeName, lblJudgeState, cmSJudgeState, lblJudgeSport,
				cmJudgeSport, btnSaveJudge);
		hbDelJudge.getChildren().addAll(lblInsertJudge, cmAllJudges, btnDelJudge);

		vbJudge.getChildren().addAll(lblJudgeEdit, hbCreateJudge, lblDelJudge, hbDelJudge);

		////////////////////// Athlete////////////////
		// HBox Create Athlete

		TextField tfAthleteName = new TextField();

		Label lblAthleteEdit = new Label(" ------ Create Athlete: ------");
		lblAthleteEdit.setStyle("-fx-font-weight: bold");
		Label lblAthleteName = new Label("Insert Athlete's name : ");
		Label lblAthleteState = new Label("Insert Athlete's state : ");
		Label lblAthleteSport = new Label("Insert Athlete's sport : ");

		ComboBox<String> hbAtheSport = new ComboBox<String>();
		hbAtheSport.getItems().addAll("Running", "Jumping", "Both");

		Button btnSaveAthlete = new Button("Create Athlete");

		// Hbox del Athlete
		HBox hbDelAthlete = new HBox();
		hbDelAthlete.setPadding(new Insets(30));
		hbDelAthlete.setSpacing(20);
		hbDelAthlete.setAlignment(Pos.TOP_CENTER);

		Label lblDelAthlete = new Label(" ------ Delete Athlete ------ ");
		lblDelAthlete.setStyle("-fx-font-weight: bold");
		Label lblInsertTeamToDelA = new Label("Select Team : ");
		Label lblInsertAthlete = new Label("Select Athlete : ");

		Button btnDelAthlete = new Button("Delete");

		hbCreateAthlete.getChildren().addAll(lblAthleteName, tfAthleteName, lblAthleteState, cmState, lblAthleteSport,
				cmSportAthlete, btnSaveAthlete);
		hbDelAthlete.getChildren().addAll(lblInsertTeamToDelA, cmDelTeamAthlete, lblInsertAthlete, cmDelAthlete,
				btnDelAthlete);

		vbAthlete.getChildren().addAll(lblAthleteEdit, hbCreateAthlete, lblDelAthlete, hbDelAthlete);

		// -------------------create comp ----------------------

		VBox vbCompititon = new VBox();
		vbCompititon.setPadding(new Insets(30));
		vbCompititon.setSpacing(20);
		vbCompititon.setAlignment(Pos.TOP_CENTER);

		HBox hbEditPersonalCompition = new HBox();
		hbEditPersonalCompition.setPadding(new Insets(30));
		hbEditPersonalCompition.setSpacing(20);
		hbEditPersonalCompition.setAlignment(Pos.TOP_CENTER);

		HBox hbEditPersonalCompition1 = new HBox();
		hbEditPersonalCompition1.setPadding(new Insets(30));
		hbEditPersonalCompition1.setSpacing(20);
		hbEditPersonalCompition1.setAlignment(Pos.TOP_CENTER);
		hbEditPersonalCompition1.setVisible(false);

		HBox hbEditPersonalCompition2 = new HBox();
		hbEditPersonalCompition2.setPadding(new Insets(30));
		hbEditPersonalCompition2.setSpacing(20);
		hbEditPersonalCompition2.setAlignment(Pos.TOP_CENTER);
		hbEditPersonalCompition2.setVisible(false);

		Label lblCompititionEdit = new Label("---------Create Personal Compitition:---------");
		lblCompititionEdit.setStyle("-fx-font-weight: bold");

		Label lblCompititionStadium = new Label("Select stadium for compitition : ");
		Label lblCompitionJudge = new Label("Select judge for compition : ");
		Label lblCompitionSport = new Label("Select the sport compition : ");
		Label lblCompitionPersonalWin1 = new Label("Select the athlete that win 1 place : ");
		Label lblCompitionPersonalWin2 = new Label("Select the athlete that win 2 place :  ");
		Label lblCompitionPersonalWin3 = new Label("Select the athlete that win 3 place : ");
		Label lblSelectWinners = new Label("Please select winners from 'all Athletes list ' ");

		Button btnSavecompition = new Button("Create Compition");
		Button btnSelectWinners = new Button("Select winners");
		Button btnCreatePerComp = new Button("Create");

		hbEditPersonalCompition.getChildren().addAll(lblCompititionStadium, cmStadiumPerComp, lblCompitionSport,
				cmSportPerComp, lblCompitionJudge, cmJudgePerComp, btnCreatePerComp);

		hbEditPersonalCompition1.getChildren()
				.addAll( btnSelectWinners , lblSelectWinners);

		hbEditPersonalCompition2.getChildren().addAll(lblCompitionPersonalWin1, cmtPerCompWin1,
				lblCompitionPersonalWin2, cmtPerCompWin2, lblCompitionPersonalWin3, cmtPerCompWin3, btnSavecompition);

		HBox hbEditTeamCompition = new HBox();
		hbEditTeamCompition.setPadding(new Insets(30));
		hbEditTeamCompition.setSpacing(20);
		hbEditTeamCompition.setAlignment(Pos.TOP_CENTER);

		HBox hbEditTeamCompition1 = new HBox();
		hbEditTeamCompition1.setPadding(new Insets(30));
		hbEditTeamCompition1.setSpacing(20);
		hbEditTeamCompition1.setAlignment(Pos.TOP_CENTER);

		HBox hbEditTeamCompition2 = new HBox();
		hbEditTeamCompition2.setPadding(new Insets(30));
		hbEditTeamCompition2.setSpacing(20);
		hbEditTeamCompition2.setAlignment(Pos.TOP_CENTER);
		hbEditTeamCompition2.setVisible(false);

		Label lblTeamCompititionEdit = new Label("---------Create Team Compitition:---------");
		lblTeamCompititionEdit.setStyle("-fx-font-weight: bold");
		Label lblTeamCompititionStadium = new Label("Select stadium for compitition : ");
		Label lblTeamCompitionJudge = new Label("Select judge for compition : ");
		Label lblTeamCompitionSport = new Label("Select the sport compition : ");
		// Label lblCompitionTeams = new Label("Select the Teams for the compition : ");
		Label lblCompitionTeamsWin1 = new Label("Select the team that win 1 place : ");
		Label lblCompitionTeamsWin2 = new Label("Select the team that win 2 place :  ");
		Label lblCompitionTeamsWin3 = new Label("Select the team that win 3 place : ");

		Button btnSelectTeamsWinners = new Button("Select Winners Teams");
		Button btnSaveTeamcompition = new Button("Create Compition");
		Button btnEndOlympic = new Button("End Olympic");

		hbEditTeamCompition.getChildren().addAll(lblTeamCompititionStadium, cmStadium, lblTeamCompitionSport, cmSport,
				lblTeamCompitionJudge, cmJudge);

		hbEditTeamCompition1.getChildren()
				.addAll(/* lblTeamCompitionSport,cmSport,lblCompitionTeams, cmTeamComp , */btnSelectTeamsWinners);

		hbEditTeamCompition2.getChildren().addAll(lblCompitionTeamsWin1, cmTeamWin1, lblCompitionTeamsWin2, cmTeamWin2,
				lblCompitionTeamsWin3, cmTeamWin3, btnSaveTeamcompition);

		vbCompititon.getChildren().addAll(lblCompititionEdit, hbEditPersonalCompition, hbEditPersonalCompition1,
				hbEditPersonalCompition2, lblTeamCompititionEdit, hbEditTeamCompition, hbEditTeamCompition1,
				hbEditTeamCompition2);

		// vbCompititon.getChildren().addAll(lblCompititionEdit,hbEditPersonalCompition,hbEditPersonalCompition1
		// ,hbEditPersonalCompition2 , lblTeamCompititionEdit, hbEditTeamCompition ,
		// btnEndOlympic);

		btnAddRemoveEdit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				hbButtom.getChildren().clear();
				hbButtom.getChildren().addAll(btnBack, btnShowAll);
				bpRoot.getChildren().clear();
				bpRoot.setTop(tabPane);

				bpRoot.setBottom(hbButtom);

				for (ViewListener l : allListeners) {
					System.out.println();

					try {
						int numberofTeam = l.getNumberOfTeams();
						int numberOfJudge = l.getNumberOfJudge();

						cmExistTeam.getItems().clear();
						cmAllJudges.getItems().clear();
						cmDelStadium.getItems().clear();
						cmUpStadium.getItems().clear();

						cmExistTeam.getItems()
								.addAll(IntStream.rangeClosed(1, numberofTeam).boxed().collect(Collectors.toList()));
						cmAllJudges.getItems()
								.addAll(IntStream.rangeClosed(1, numberOfJudge).boxed().collect(Collectors.toList()));
						cmDelStadium.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));
						cmUpStadium.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));

						cmDelAthlete.getItems().clear();
						cmDelAthlete.getItems()
								.addAll(IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList()));

						// successfullyMessage();
					} catch (Exception e1) {
						failedMessage();
					}

				}

			}
		});

		btnStartOlympic.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
		
					hbButtomOly.getChildren().clear();
					hbButtomOly.getChildren().addAll(btnBack1, btnShowAll2, btnEndOlympic);
					bpRoot.getChildren().clear();
					bpRoot.setTop(vbCompititon);

					bpRoot.setBottom(hbButtomOly);

					for (ViewListener l : allListeners) {

						cmStadiumPerComp.getItems().clear();
						cmJudgePerComp.getItems().clear();
						cmStadium.getItems().clear();
						cmJudge.getItems().clear();
						cmStadiumPerComp.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));
						cmJudgePerComp.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfJudge()).boxed().collect(Collectors.toList()));
						cmStadium.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));
						cmJudge.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfJudge()).boxed().collect(Collectors.toList()));

					}

			}
		});

		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				bpRoot.getChildren().clear();
				bpRoot.setTop(hbRoot);

			}
		});

		btnBack1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				bpRoot.getChildren().clear();
				bpRoot.setTop(hbRoot);

			}
		});

		btnSaveTeam.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				hbAddAthelteToTeam.setVisible(true);
				cmState1.setDisable(true);
				try {
					String State = cmState1.getValue();

					if (!State.isEmpty()) {
						for (ViewListener l : allListeners) {
							l.createTeam(State);
							cmExistTeam.getItems().clear();
							cmExistTeam.getItems().addAll(IntStream.rangeClosed(1, l.getNumberOfTeams()).boxed()
									.collect(Collectors.toList()));

							cmDelTeamAthlete.getItems().clear();
							cmDelTeamAthlete.getItems().addAll(IntStream.rangeClosed(1, l.getNumberOfTeams()).boxed()
									.collect(Collectors.toList()));

						}

					}

				} catch (Exception e2) {
					System.out.println("You must select state");
					JOptionPane.showMessageDialog(null, "You must select state");
				}

			}
		});

		btnStoptoAdd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				cmState1.setDisable(false);
				hbAddAthelteToTeam.setVisible(false);

			}
		});

		btnSaveStadium.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				String name = tfStadiumName.getText();
				String State = cmStadiumState.getValue();

				int seats = spnUpdateSeats1.getValue();

				for (ViewListener l : allListeners) {
					//try {
						///
						l.createStadium(name, State, seats);
						cmDelStadium.getItems().clear();
						cmDelStadium.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));

						// cmUpStadium
						cmUpStadium.getItems().clear();
						cmUpStadium.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));
						//successfullyMessage();
					//} catch (Exception e1) {
						//failedMessage();
						// e1.printStackTrace();
					//}
				}

			}
		});

		btnDelStadium.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Integer indexTeam = cmDelStadium.getValue();

					for (ViewListener l : allListeners) {

						l.deleteStadium(indexTeam);
						cmDelStadium.getItems().clear();
						cmUpStadium.getItems().clear();
						cmDelStadium.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));
						cmUpStadium.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfStadium()).boxed().collect(Collectors.toList()));
					}
					
			}
		});

		btnDelTeam.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

					Integer indexTeam = cmExistTeam.getValue();
					
					for (ViewListener l : allListeners) {

						l.deleteTeam(indexTeam);
						cmExistTeam.getItems().clear();
						cmExistTeam.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfTeams()).boxed().collect(Collectors.toList()));
					}
			}
		});

		btnSaveJudge.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String judgeName = tfJudgeName.getText();
				String State = cmSJudgeState.getValue();
				String JudgeArea = cmJudgeSport.getValue();

				for (ViewListener l : allListeners) {

						l.createJudge(judgeName, State, JudgeArea);

						cmAllJudges.getItems().clear();
						cmAllJudges.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfJudge()).boxed().collect(Collectors.toList()));

				}

			}
		});

		btnShowAll.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				for (ViewListener viewListener : allListeners) {
					JTextArea textArea = new JTextArea(35, 45);
					String allInfo;

						allInfo = viewListener.showAllJudges() + viewListener.showAllStadium()
								+ viewListener.showAllTeams() + viewListener.printAllAthe();
						textArea.setEditable(false);
						textArea.setText("all Information:\n" + allInfo);
						textArea.setLineWrap(true);
						textArea.setFont(textArea.getFont().deriveFont(20f));
						JScrollPane scrollPane = new JScrollPane(textArea);
						JOptionPane.showMessageDialog(null, scrollPane);
				}

			}
		});

		btnShowAll2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				for (ViewListener viewListener : allListeners) {
					JTextArea textArea = new JTextArea(35, 45);
					String allInfo;

						allInfo = viewListener.showAllJudges() + viewListener.showAllStadium()
								+ viewListener.showAllTeams() + viewListener.printAllAthe();
						textArea.setEditable(false);
						textArea.setText("all Information:\n" + allInfo);
						textArea.setLineWrap(true);
						textArea.setFont(textArea.getFont().deriveFont(20f));
						JScrollPane scrollPane = new JScrollPane(textArea);
						JOptionPane.showMessageDialog(null, scrollPane);
				}

			}
		});

		btnSaveAthlete.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String athelName = tfAthleteName.getText();
				String State = cmState.getValue();
				String Sport = cmSportAthlete.getValue();

				for (ViewListener l : allListeners) {

						l.addNewAtheToTeam(State, athelName, Sport, State);
				}

			}
		});

		btnDelJudge.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

					Integer indexJudge = cmAllJudges.getValue();
					for (ViewListener l : allListeners) {

						l.deleteJudge(indexJudge);

						cmAllJudges.getItems().clear();
						cmAllJudges.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfJudge()).boxed().collect(Collectors.toList()));

						cmUpJudge.getItems().clear();
						cmUpJudge.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberOfJudge()).boxed().collect(Collectors.toList()));
					}

			}
		});

		///////////////////////////////////////
		////// Comption///////
		//////////////////

		btnCreatePerComp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				hbEditPersonalCompition1.setVisible(true);

				cmSportPerComp.setDisable(true);
				cmStadiumPerComp.setDisable(true);

			}
		});

		btnSelectWinners.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				hbEditPersonalCompition2.setVisible(true);
				for (ViewListener l : allListeners) {
					cmtPerCompWin1.getItems().clear();
					cmtPerCompWin1.getItems().addAll(
							IntStream.rangeClosed(1, l.getNumberAllAthlete()).boxed().collect(Collectors.toList()));

					cmtPerCompWin2.getItems().clear();
					cmtPerCompWin2.getItems().addAll(
							IntStream.rangeClosed(1, l.getNumberAllAthlete()).boxed().collect(Collectors.toList()));

					cmtPerCompWin3.getItems().clear();
					cmtPerCompWin3.getItems().addAll(
							IntStream.rangeClosed(1, l.getNumberAllAthlete()).boxed().collect(Collectors.toList()));

				}

			}
		});

		// btnSelectTeamsWinners
		btnSelectTeamsWinners.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				hbEditTeamCompition2.setVisible(true);
				for (ViewListener l : allListeners) {

					cmTeamWin1.getItems().clear();
					cmTeamWin1.getItems().addAll(
							IntStream.rangeClosed(1, l.getNumberOfTeams()).boxed().collect(Collectors.toList()));

					cmTeamWin2.getItems().clear();
					cmTeamWin2.getItems().addAll(
							IntStream.rangeClosed(1, l.getNumberOfTeams()).boxed().collect(Collectors.toList()));

					cmTeamWin3.getItems().clear();
					cmTeamWin3.getItems().addAll(
							IntStream.rangeClosed(1, l.getNumberOfTeams()).boxed().collect(Collectors.toList()));
				}

			}
		});

		btnSavecompition.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				cmSportPerComp.setDisable(false);
				cmStadiumPerComp.setDisable(false);

				for (ViewListener l : allListeners) {

						Integer Stadium = cmStadiumPerComp.getValue();

						String Sport = cmSportPerComp.getValue();

						Integer Judge = cmJudgePerComp.getValue();

						Integer Win1 = cmtPerCompWin1.getValue();
						Integer Win2 = cmtPerCompWin2.getValue();
						Integer Win3 = cmtPerCompWin3.getValue();

						l.winerInPersonalComp(Stadium, Judge, Sport, Win1, Win2, Win3);

						cmtPerCompWin1.getItems().clear();
						cmtPerCompWin1.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberAllAthlete()).boxed().collect(Collectors.toList()));

						cmtPerCompWin2.getItems().clear();
						cmtPerCompWin2.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberAllAthlete()).boxed().collect(Collectors.toList()));

						cmtPerCompWin3.getItems().clear();
						cmtPerCompWin3.getItems().addAll(
								IntStream.rangeClosed(1, l.getNumberAllAthlete()).boxed().collect(Collectors.toList()));

				}

			}
		});

		btnSaveTeamcompition.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

					Integer stadiumIndex = cmStadium.getValue();
					Integer JudgeIndex = cmJudge.getValue();
					String Sport = cmSport.getValue();
					Integer Twin1 = cmTeamWin1.getValue();
					Integer Twin2 = cmTeamWin2.getValue();
					Integer Twin3 = cmTeamWin3.getValue();

					for (ViewListener l : allListeners) {

						l.winerInTeamlComp(stadiumIndex, JudgeIndex, Sport, Twin1, Twin2, Twin3);

					}

			}

		});

		btnDelAthlete.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				Integer indexAthlete = cmDelAthlete.getValue();
				Integer indexTeam = cmDelTeamAthlete.getValue();
				if (indexAthlete != null && indexTeam != null) {
					for (ViewListener l : allListeners) {
						l.deleteAthleteFromATeam(indexTeam, indexAthlete);
					}
				}

			}
		});

		btnEndOlympic.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				for (ViewListener viewListener : allListeners) {
					JTextArea textArea = new JTextArea(35, 45);
					String allInfo;

						allInfo = viewListener.winnersOplympicGame();
						textArea.setEditable(false);
						textArea.setText("" + allInfo);
						textArea.setLineWrap(true);
						textArea.setFont(textArea.getFont().deriveFont(20f));
						JScrollPane scrollPane = new JScrollPane(textArea);
						JOptionPane.showMessageDialog(null, scrollPane);
				}

			}
		});

		theStage.setScene(new Scene(bpRoot, 1500, 1000));
		theStage.show();
	}

	public void failedMessage() {
		JOptionPane.showMessageDialog(null, "Failed!");
	}

	public void successfullyMessage() {
		JOptionPane.showMessageDialog(null, "Success!");
	}

	public void registerListener(ViewListener listener) {
		allListeners.add(listener);
	}

}
