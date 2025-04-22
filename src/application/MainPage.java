package application;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//Comic Sans MS
public class MainPage {
	
	private HBox main;
	private BorderPane root;
	private MovieCatalog catalog=new MovieCatalog();
	private AVLTree[] trees=catalog.getTrees();
	private TableView<Movie> table=new TableView<>();
	private ObservableList<String> orederlist = FXCollections.observableArrayList("Ascending","Descending");
	private ObservableList<Movie> moviesInIndexList = FXCollections.observableArrayList();
	private int indexintable=0;
	private Movie tempMovie;
	public MainPage(BorderPane root) {
		main=new HBox(10);
		main.setAlignment(Pos.CENTER_LEFT);
		main.setStyle("-fx-background-color: #040D12;");
		this.root=root;
		setMainPage();
		
	}
	public HBox getMainPage() {
		return main;
	}
	
	private void setMainPage() {
		
		VBox sideBox=new VBox(10);
		sideBox.setAlignment(Pos.TOP_CENTER);
		sideBox.setPadding(new Insets(10));
		sideBox.setStyle("-fx-background-color: #183D3D;");
		
		ImageView logo = new ImageView("logo2.png");
		logo.setScaleX(1);
		logo.setScaleY(1);
		logo.setX(2);
		logo.setY(0);
		logo.setFitWidth(100);
		logo.setFitHeight(70);
		
		Label l1=new Label("Main Page");
		Label l2=new Label("Favorites");
		Label l3=new Label("Romantic");
		Label l4=new Label("Drama");
		Label l5=new Label("Action");
		Label l6=new Label("Horor");
		Label l7=new Label("Hestorical");
		Label l8=new Label("Cartoon");
		Label l9=new Label("Fection");
		Label l10=new Label("Documentry");
		Label l11=new Label("Scientific");
		Label l12=new Label("CountrySide");
		Label l13=new Label("Seriel Killers");
		String style="-fx-text-fill: #93B1A6; -fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 30px;";
		l1.setStyle(style);
		l2.setStyle(style+"-fx-text-fill: yellow");
		l3.setStyle(style);
		l4.setStyle(style);
		l5.setStyle(style);
		l6.setStyle(style);
		l7.setStyle(style);
		l8.setStyle(style);
		l9.setStyle(style);
		l10.setStyle(style);
		l11.setStyle(style);
		l12.setStyle(style);
		l13.setStyle(style);
		
		sideBox.getChildren().addAll(logo,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13);
		//=================================================================================
		
		HBox h=new HBox();
		h.setAlignment(Pos.TOP_RIGHT);
		//h.setPadding(new Insets(20));
		
		Button admin=new Button("Admin");
		admin.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-border-color: white; -fx-font-weight: bold;"
				+ " -fx-font-size: 25px;-fx-background-radius: 30; -fx-border-radius: 30;");
		admin.setMinWidth(150);
		admin.setMinHeight(50);
		admin.setOnMouseEntered(e -> admin.setTranslateY(admin.getTranslateY() - 7));
		admin.setOnMouseExited(e -> admin.setTranslateY(admin.getTranslateY() + 7));
		admin.setOnAction(e->{
			loginPage();
		});
		
		h.getChildren().add(admin);
		//===================================================================================
		ImageView p = new ImageView("p.jpg");
		p.setScaleX(1);
		p.setScaleY(1);
		p.setX(2);
		p.setY(0);
		p.setFitWidth(180);
		p.setFitHeight(270);
		
		ImageView pp = new ImageView("pp.jpg");
		pp.setScaleX(1);
		pp.setScaleY(1);
		pp.setX(2);
		pp.setY(0);
		pp.setFitWidth(180);
		pp.setFitHeight(270);
		
		ImageView ppp = new ImageView("ppp.jpeg");
		ppp.setScaleX(1);
		ppp.setScaleY(1);
		ppp.setX(2);
		ppp.setY(0);
		ppp.setFitWidth(180);
		ppp.setFitHeight(270);
		
		ImageView pppp = new ImageView("pppp.jpeg");
		pppp.setScaleX(1);
		pppp.setScaleY(1);
		pppp.setX(2);
		pppp.setY(0);
		pppp.setFitWidth(180);
		pppp.setFitHeight(270);
		
		ImageView ppppp = new ImageView("ppppp.jpg");
		ppppp.setScaleX(1);
		ppppp.setScaleY(1);
		ppppp.setX(2);
		ppppp.setY(0);
		ppppp.setFitWidth(180);
		ppppp.setFitHeight(270);
		
		ImageView pppppp = new ImageView("pppppp.jpg");
		pppppp.setScaleX(1);
		pppppp.setScaleY(1);
		pppppp.setX(2);
		pppppp.setY(0);
		pppppp.setFitWidth(180);
		pppppp.setFitHeight(270);
		
		ImageView a = new ImageView("a.jpg");
		a.setScaleX(1);
		a.setScaleY(1);
		a.setX(2);
		a.setY(0);
		a.setFitWidth(180);
		a.setFitHeight(270);
		
		ImageView aa = new ImageView("aa.jpg");
		aa.setScaleX(1);
		aa.setScaleY(1);
		aa.setX(2);
		aa.setY(0);
		aa.setFitWidth(180);
		aa.setFitHeight(270);
		
		ImageView aaa = new ImageView("aaa.jpg");
		aaa.setScaleX(1);
		aaa.setScaleY(1);
		aaa.setX(2);
		aaa.setY(0);
		aaa.setFitWidth(180);
		aaa.setFitHeight(270);
		
		ImageView aaaa = new ImageView("aaaa.jpg");
		aaaa.setScaleX(1);
		aaaa.setScaleY(1);
		aaaa.setX(2);
		aaaa.setY(0);
		aaaa.setFitWidth(180);
		aaaa.setFitHeight(270);
		
		ImageView aaaaa = new ImageView("aaaaa.jpg");
		aaaaa.setScaleX(1);
		aaaaa.setScaleY(1);
		aaaaa.setX(2);
		aaaaa.setY(0);
		aaaaa.setFitWidth(180);
		aaaaa.setFitHeight(270);
		
		ImageView aaaaaa = new ImageView("aaaaaa.jpg");
		aaaaaa.setScaleX(1);
		aaaaaa.setScaleY(1);
		aaaaaa.setX(2);
		aaaaaa.setY(0);
		aaaaaa.setFitWidth(180);
		aaaaaa.setFitHeight(270);
		
		GridPane gpane=new GridPane();
		gpane.add(ppp, 0, 0);
		gpane.add(p, 1, 0);
		gpane.add(pp, 2, 0);
		gpane.add(pppp, 3, 0);
		gpane.add(ppppp, 4, 0);
		gpane.add(pppppp, 5, 0);
		gpane.add(a, 0, 1);
		gpane.add(aa, 1, 1);
		gpane.add(aaa, 2, 1);
		gpane.add(aaaa, 3, 1);
		gpane.add(aaaaa, 4, 1);
		gpane.add(aaaaaa, 5, 1);

		gpane.setAlignment(Pos.CENTER);
		gpane.setVgap(30);
		gpane.setHgap(30);
		gpane.setPadding(new Insets(30,0,30,0));
		
		Label copyrights=new Label("All @Copyrights Are Preserved !");
		copyrights.setStyle(style+"-fx-font-size: 20px;");
		
		VBox v=new VBox();
		v.setAlignment(Pos.TOP_CENTER);
		v.setPadding(new Insets(20));
		v.getChildren().addAll(h,gpane,copyrights);
		
		//======================================================
		
		
		main.getChildren().addAll(sideBox,v);
	}
	
	////////////////// Login page/////////////////////
    private void loginPage() {
		
		Stage stage = new Stage();

		VBox vbox=new VBox(20);
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.setStyle("-fx-background-color: #183D3D;");
		
		Label header=new Label("Login As Admin");
		header.setStyle("-fx-text-fill: #183D3D; -fx-font-weight: bold;");
		header.setFont(Font.font("elephant", 20));
		
		ImageView logo = new ImageView("logo2.png");
		logo.setScaleX(1);
		logo.setScaleY(1);
		logo.setX(2);
		logo.setY(0);
		logo.setFitWidth(50);
		logo.setFitHeight(35);
		
		HBox hbox=new HBox(40);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(10));
		hbox.getChildren().addAll(header);
		hbox.setStyle("-fx-background-color:#93B1A6");
		
		String style="-fx-text-fill: #93B1A6; -fx-font-weight: bold;-fx-font-size: 15px;";
		Label username = new Label("User Name :");
        TextField unamef=new TextField();
        Label password = new Label("Password :");
        PasswordField passwordf=new PasswordField();
        username.setStyle(style);
        password.setStyle(style);
        unamef.setStyle("-fx-border-color: #93B1A6;");
        passwordf.setStyle("-fx-border-color: #93B1A6;");
        GridPane gpane=new GridPane();
		gpane.add(username, 0, 0);
		gpane.add(password, 0, 1);
		gpane.add(unamef, 1, 0);
		gpane.add(passwordf, 1, 1);
		gpane.setAlignment(Pos.CENTER);
		gpane.setVgap(10);
		gpane.setHgap(10);
		
		Button login=new Button("Login");
		login.setStyle("-fx-background-color: #040D12; -fx-text-fill: white; -fx-border-color: white; -fx-font-weight: bold; -fx-font-size: 15px;-fx-background-radius: 30; -fx-border-radius: 30;");
		login.setPrefWidth(70);
		login.setPrefHeight(30);
		login.setOnMouseEntered(e -> login.setTranslateY(login.getTranslateY() - 7));
		login.setOnMouseExited(e -> login.setTranslateY(login.getTranslateY() + 7));
		login.setOnAction(e->{
			if(!unamef.getText().isEmpty()&&!passwordf.getText().isEmpty()) {
				String un="amal.zaben";
				String pass="12345";
				if(unamef.getText().equalsIgnoreCase(un)&&passwordf.getText().equalsIgnoreCase(pass)) {
					root.setCenter(adminPage());
					stage.close();
				}
				else
					getAlert("CAN NOT LOGIN :( MAKE SURE THE USERNAME AND PASSWORD YOU ENTERED ARE VALID !!");
			}
			else
				getAlert("CAN NOT LOGIN :( MAKE SURE THE USERNAME AND PASSWORD YOU ENTERED ARE VALID !!");
				
		});
        
		vbox.getChildren().addAll(hbox,gpane,login);
		BorderPane borderpane=new BorderPane();
		borderpane.setCenter(vbox);
		Scene scene=new Scene(borderpane,300,200); 
		stage.setTitle("Login As Admin");
		stage.getIcons().add(new Image("logo2.png"));
		stage.setScene(scene);
		stage.show();
		
		
	}
    
    ////////////////// Admin Page///////////////////////////////
    private HBox adminPage() {
    	HBox adminbox=new HBox();
    	
    	VBox vbox1=new VBox(20);
    	vbox1.setAlignment(Pos.TOP_CENTER);
    	vbox1.setPadding(new Insets(30));
    	vbox1.setStyle("-fx-background-color: #183D3D;");
    	vbox1.setPrefWidth(600);
    	vbox1.setMinWidth(550);
    	
    	VBox vbox2=new VBox(15);
    	//vbox2.setAlignment(Pos.TOP_CENTER);
    	vbox2.setPadding(new Insets(30));
    	vbox2.setStyle("-fx-background-color: #040D12;");
    	
    	
    	String style="-fx-text-fill:yellow; -fx-font-weight: bold;-fx-font-family: 'Comic Sans MS';-fx-font-weight: bold;-fx-font-size: 23px;";
		String stylef="-fx-min-width: 250px;-fx-min-height: 40px;-fx-border-color: #040D12;-fx-font-size: 20px;-fx-border-Width:3;";
		Button search=new Button("Search");
		TextField searchf=new TextField();
		Label title=new Label("Title:");
		TextField titlef=new TextField();
		Label year=new Label("Released in:");
		DatePicker yearf=new DatePicker();
		Label rating=new Label("Rating:");
		TextField ratingf=new TextField();
		Label description=new Label("Description:");
		TextArea descriptionf=new TextArea();
		
		search.setStyle("-fx-background-color: #040D12; -fx-text-fill: white; -fx-border-color: white; "
				+ "-fx-font-weight: bold; -fx-font-size: 20px;-fx-background-radius: 30; -fx-border-radius: 30;");
		search.setPrefWidth(150);
		search.setPrefHeight(50);
		title.setStyle(style);
		year.setStyle(style);
		rating.setStyle(style);
		searchf.setStyle(stylef);
		titlef.setStyle(stylef);
		yearf.setStyle(stylef);
		ratingf.setStyle(stylef);
		description.setStyle(style);
		descriptionf.setStyle("-fx-max-width: 320px;-fx-max-height: 100px;-fx-border-color: #040D12;-fx-font-size: 20px;-fx-border-Width:3;");
		descriptionf.setWrapText(true);
		searchf.setPromptText("Release year/Title");
		titlef.setPromptText("Title of the movie");
		descriptionf.setPromptText("Description of the movie");
		ratingf.setPromptText("Rating of the movie");
		
		// Convert and display only the year
        yearf.setConverter(new javafx.util.StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return String.valueOf(date.getYear());
                }
                return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    try {
                        return LocalDate.of(Integer.parseInt(string), 1, 1); // Default to January 1st
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
                return null;
            }
        });
		
		search.setOnMouseEntered(e -> search.setTranslateY(search.getTranslateY() - 7));
		search.setOnMouseExited(e -> search.setTranslateY(search.getTranslateY() + 7));
		
	
		GridPane gpane=new GridPane();
		gpane.add(search, 0, 0);
		gpane.add(title, 0, 1);
		gpane.add(year, 0, 2);
		gpane.add(description, 0, 3);
		gpane.add(rating, 0, 4);
		gpane.add(searchf, 1, 0);
		gpane.add(titlef, 1, 1);
		gpane.add(yearf, 1, 2);
		gpane.add(descriptionf, 1, 3);
		gpane.add(ratingf, 1, 4);
		gpane.setAlignment(Pos.CENTER);
		gpane.setVgap(30);
		gpane.setHgap(20);
		
		ImageView star=new ImageView("5stars.png");
		
		Button add=new Button("Add new Movie");
		Button update=new Button("Update");
		Button remove=new Button("Remove");
		Button open=new Button("Open");
		Button save=new Button("Save");
		Button exit=new Button("Exit");
		Button deallocate=new Button("Deallocate");
		String styleb="-fx-background-color: #040D12;-fx-font-family: 'Comic Sans MS'; -fx-text-fill: white; -fx-border-color: white; -fx-font-weight: bold;"
				+ " -fx-font-size: 25px;-fx-background-radius: 30; -fx-border-radius: 30;-fx-pref-width: 150; -fx-pref-height: 60;";
		update.setStyle(styleb);
		remove.setStyle(styleb);
		open.setStyle(styleb);
		save.setStyle(styleb);
		deallocate.setStyle(styleb+"-fx-pref-width: 200;");
		exit.setStyle(styleb+"-fx-background-color: yellow;-fx-text-fill: black;-fx-border-color: black;");
		add.setStyle(styleb+"-fx-pref-width: 300;");
		
		update.setOnMouseEntered(e -> update.setTranslateY(update.getTranslateY() - 7));
		update.setOnMouseExited(e -> update.setTranslateY(update.getTranslateY() + 7));
		remove.setOnMouseEntered(e -> remove.setTranslateY(remove.getTranslateY() - 7));
		remove.setOnMouseExited(e -> remove.setTranslateY(remove.getTranslateY() + 7));
		open.setOnMouseEntered(e -> open.setTranslateY(open.getTranslateY() - 7));
		open.setOnMouseExited(e -> open.setTranslateY(open.getTranslateY() + 7));
		save.setOnMouseEntered(e -> save.setTranslateY(save.getTranslateY() - 7));
		save.setOnMouseExited(e -> save.setTranslateY(save.getTranslateY() + 7));
		exit.setOnMouseEntered(e -> exit.setTranslateY(exit.getTranslateY() - 7));
		exit.setOnMouseExited(e -> exit.setTranslateY(exit.getTranslateY() + 7));
		add.setOnMouseEntered(e -> add.setTranslateY(add.getTranslateY() - 7));
		add.setOnMouseExited(e -> add.setTranslateY(add.getTranslateY() + 7));
		deallocate.setOnMouseEntered(e -> deallocate.setTranslateY(deallocate.getTranslateY() - 7));
		deallocate.setOnMouseExited(e -> deallocate.setTranslateY(deallocate.getTranslateY() + 7));
		
		ImageView nimg = new ImageView("next.png");
		nimg.setRotate(180);
		nimg.setFitWidth(50); 
		nimg.setFitHeight(50); 
		nimg.setPreserveRatio(true);
		ImageView pimg = new ImageView("next.png");
		pimg.setFitWidth(50); 
		pimg.setFitHeight(50); 
		pimg.setPreserveRatio(true);
		String unrestyle="-fx-background-color: transparent;";
		Button next=new Button("",nimg);
		Button prev=new Button("",pimg);
		next.setStyle(unrestyle);
		prev.setStyle(unrestyle);
		prev.setOnMouseEntered(e -> prev.setTranslateY(prev.getTranslateY() - 7));
		prev.setOnMouseExited(e -> prev.setTranslateY(prev.getTranslateY() + 7));
		next.setOnMouseEntered(e -> next.setTranslateY(next.getTranslateY() - 7));
		next.setOnMouseExited(e -> next.setTranslateY(next.getTranslateY() + 7));
		
		Label index=new Label("Index");
		index.setStyle(style);
		
		table.setStyle("-fx-border-color:yellow;-fx-border-Width:3;-fx-text-fill: white;-fx-font-weight: bold;-fx-min-width: 750px; -fx-min-height: 400px;");
		TableColumn<Movie, Integer> yearColumn = new TableColumn<>("Release Year");
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		yearColumn.setMinWidth(230); 
		yearColumn.setStyle("-fx-alignment: CENTER;");
		TableColumn<Movie, String> titleColumn = new TableColumn<>("Movie Title");
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		titleColumn.setMinWidth(230); 
		titleColumn.setStyle("-fx-alignment: CENTER;");
		TableColumn<Movie, Double> ratingColumn = new TableColumn<>("Rating");
		ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
		ratingColumn.setMinWidth(230); 
		ratingColumn.setStyle("-fx-alignment: CENTER;");
		TableColumn<Movie, String> descColumn = new TableColumn<>("Description");
		descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		descColumn.setMinWidth(230); 
		descColumn.setStyle("-fx-alignment: CENTER;");
		table.getColumns().addAll(titleColumn,yearColumn,ratingColumn,descColumn);
		table.setItems(moviesInIndexList);
		
		ComboBox<?> order=new ComboBox(orederlist);
		order.setStyle(stylef+"-fx-border-color:yellow;-fx-alignment: center-left;-fx-min-width: 170px;");
		order.setPromptText("ORDER");
		
		Label height=new Label ("Tree Height:");
		height.setStyle(style);
		Label heightf=new Label ("??");
		heightf.setStyle(style);
		Label top=new Label ("Top Ranked:");
		top.setStyle(style);
		Label topname=new Label ("Movie Name");
		topname.setStyle(style);
		Label toprank=new Label ("??");
		toprank.setStyle(style);
		ImageView topstar=new ImageView("5stars.png");
		Label least=new Label ("Least Ranked:");
		least.setStyle(style);
		Label leastname=new Label ("Movie Name");
		leastname.setStyle(style);
		Label leastrank=new Label ("??");
		leastrank.setStyle(style);
		ImageView leaststar=new ImageView("halfstar.png");
		
		
		//================ set on actions=================================
		exit.setOnAction(e->{
			root.setCenter(getMainPage());
		});
		
		open.setOnAction(e->{
			try {
			catalog.loadMoviesFromFile();
			indexintable=0;
			index.setText(indexintable+"");
			heightf.setText(trees[indexintable].getRoot().getHeight()+"");
			Movie h=trees[indexintable].getHighestRankedMovie();
			topname.setText(h.getTitle());
			toprank.setText(h.getRating()+"");
			topstar.setImage(getStarRating(h.getRating()));
			Movie l=trees[indexintable].getLowestRankedMovie();
			leastname.setText(l.getTitle());
			leastrank.setText(l.getRating()+"");
			leaststar.setImage(getStarRating(l.getRating()));
			updateobservableList();
			}catch(NullPointerException i) {
				
			}
		});
		
		save.setOnAction(e->{
			catalog.saveMoviesToFile();
		});
		
		order.setOnAction(e -> {
            String selectedItem = (String) order.getValue();
            if(selectedItem.equals("Descending")) {
            	moviesInIndexList.clear();
            	moviesInIndexList=trees[indexintable].getMoviesInAscendingOrder();
            	table.getItems().clear();
            	table.getItems().addAll(moviesInIndexList);
            }
            if(selectedItem.equals("Ascending")) {
            	moviesInIndexList.clear();
            	moviesInIndexList=trees[indexintable].getMoviesInDescendingOrder();
            	table.getItems().clear();
            	table.getItems().addAll(moviesInIndexList);
            }
        });
		
		deallocate.setOnAction(e->{
			try {
			catalog.deallocate();
			updateobservableList();
			}catch(NullPointerException i) {
				topname.setText("");
				toprank.setText("");
				topstar.setImage(getStarRating(10));
				
				leastname.setText("");
				leastrank.setText("");
				leaststar.setImage(getStarRating(1));
				titlef.setText("");
                descriptionf.setText("");
                ratingf.setText("");
                LocalDate dateToSet = LocalDate.of(2025, 1, 1);  // Year , with default January 1st
                yearf.setValue(null);
                star.setImage(getStarRating(10));
                tempMovie=null;
			}
		});
		
		prev.setOnAction(e->{
			try {
			if(indexintable<trees.length) {
				indexintable++;
				index.setText(indexintable+"");
				heightf.setText(trees[indexintable].getRoot().getHeight()+"");
				Movie h=trees[indexintable].getHighestRankedMovie();
				topname.setText(h.getTitle());
				toprank.setText(h.getRating()+"");
				topstar.setImage(getStarRating(h.getRating()));
				Movie l=trees[indexintable].getLowestRankedMovie();
				leastname.setText(l.getTitle());
				leastrank.setText(l.getRating()+"");
				leaststar.setImage(getStarRating(l.getRating()));
				updateobservableList();
			}
			}catch(NullPointerException i) {
				
			}
		});
		
		next.setOnAction(e->{
			if(indexintable>0) {
				try {
				indexintable--;
				index.setText(indexintable+"");
				heightf.setText(trees[indexintable].getRoot().getHeight()+"");
				Movie h=trees[indexintable].getHighestRankedMovie();
				topname.setText(h.getTitle());
				toprank.setText(h.getRating()+"");
				topstar.setImage(getStarRating(h.getRating()));
				Movie l=trees[indexintable].getLowestRankedMovie();
				leastname.setText(l.getTitle());
				leastrank.setText(l.getRating()+"");
				leaststar.setImage(getStarRating(l.getRating()));
				updateobservableList();
				}catch(NullPointerException i) {
					
				}
			}
		});
		table.setOnMouseClicked(event -> {
	        if (event.getClickCount() == 2) {
	            Movie selectedF = table.getSelectionModel().getSelectedItem();
	            if (selectedF != null) {
	            	tempMovie=catalog.get(selectedF.getTitle());
	                titlef.setText(tempMovie.getTitle());
	                descriptionf.setText(tempMovie.getDescription());
	                ratingf.setText(tempMovie.getRating()+"");
	                LocalDate dateToSet = LocalDate.of(tempMovie.getYear(), 1, 1);  // Year , with default January 1st
	                yearf.setValue(dateToSet);
	                star.setImage(getStarRating(tempMovie.getRating()));
	                searchf.clear();
	            }
	        }
	    });
		
		search.setOnAction(e->{
			try {
			if(!searchf.getText().isEmpty()) {
				String searchwith=searchf.getText().charAt(0)+"";
				if(searchwith.matches("\\d+")) {
					moviesInIndexList.clear();
					moviesInIndexList=catalog.searchForYear(Integer.parseInt(searchf.getText()));
			    	table.getItems().clear();
			    	table.getItems().addAll(moviesInIndexList);
			    	table.refresh();
			    	index.setText("Movies in "+searchf.getText());
				}
				else {
					tempMovie=catalog.get(searchf.getText());
	                titlef.setText(tempMovie.getTitle());
	                descriptionf.setText(tempMovie.getDescription());
	                ratingf.setText(tempMovie.getRating()+"");
	                LocalDate dateToSet = LocalDate.of(tempMovie.getYear(), 1, 1);  // Year , with default January 1st
	                yearf.setValue(dateToSet);
	                star.setImage(getStarRating(tempMovie.getRating()));
	                indexintable=catalog.hashFunction(tempMovie.getTitle());
	                updateobservableList();
				}
			}
			}catch(NullPointerException u) {
				getAlert("THERE IS NO MOVIES IN THE YEAR YOU ARE SEARCHING FOR !!");
			}
		});
		
		remove.setOnAction(e->{
			if(tempMovie!=null) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("WARNING");
				alert.setContentText("YOU ARE TRYING TO REMOVE THIS Movie FROM THE SYSTEM , PRESS CONFIRM TO PROCEED !");
				alert.setHeaderText("Please Pay Attention !!");
				ButtonType confirm= new ButtonType("confirm");
				alert.getDialogPane().getButtonTypes().clear();
				alert.getDialogPane().getButtonTypes().add(confirm);
				alert.setResultConverter(dialogButton -> {
		            if (dialogButton == confirm) {
		            
		            	catalog.erase(tempMovie.getTitle());
		            	titlef.setText("");
		                descriptionf.setText("");
		                ratingf.setText("");
		                LocalDate dateToSet = LocalDate.of(2025, 1, 1);  // Year , with default January 1st
		                yearf.setValue(null);
		                star.setImage(getStarRating(10));
		                tempMovie=null;
		                Movie h=trees[indexintable].getHighestRankedMovie();
		    			topname.setText(h.getTitle());
		    			toprank.setText(h.getRating()+"");
		    			topstar.setImage(getStarRating(h.getRating()));
		    			Movie l=trees[indexintable].getLowestRankedMovie();
		    			leastname.setText(l.getTitle());
		    			leastrank.setText(l.getRating()+"");
		    			leaststar.setImage(getStarRating(l.getRating()));
		    			updateobservableList();
		            }
				return null;
			    });
				alert.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
				alert.showAndWait();
			}
		});
		
		update.setOnAction(e->{
			
			if(tempMovie!=null) {
				Alert alert=new Alert(Alert.AlertType.WARNING);
				alert.setTitle("WARNING");
				alert.setContentText("YOU ARE TRYING TO UPDATE THIS Movie INFORMATION , PRESS CONFIRM TO PROCEED !");
				alert.setHeaderText("Please Pay Attention !!");
				ButtonType confirm= new ButtonType("confirm");
				alert.getDialogPane().getButtonTypes().clear();
				alert.getDialogPane().getButtonTypes().add(confirm);
				alert.setResultConverter(dialogButton -> {
		            if (dialogButton == confirm) {
		    			if(!titlef.getText().isEmpty()&&!descriptionf.getText().isEmpty()&&!ratingf.getText().isEmpty()&&yearf.getValue()!=null){

		            	if(Integer.parseInt(ratingf.getText())<=10&&Integer.parseInt(ratingf.getText())>0) {
		            	Movie m=new Movie(titlef.getText(),descriptionf.getText(),yearf.getValue().getYear(),Double.parseDouble(ratingf.getText()));
		            	catalog.put(m);
		            	star.setImage(getStarRating(m.getRating()));
		            	Movie h=trees[indexintable].getHighestRankedMovie();
		    			topname.setText(h.getTitle());
		    			toprank.setText(h.getRating()+"");
		    			topstar.setImage(getStarRating(h.getRating()));
		    			Movie l=trees[indexintable].getLowestRankedMovie();
		    			leastname.setText(l.getTitle());
		    			leastrank.setText(l.getRating()+"");
		    			leaststar.setImage(getStarRating(l.getRating()));
		    			updateobservableList();
		            	}
		    			else
		    				getAlert("Rating should be between 0 and 10");
		    			}
		    			else
		    				getAlert("NO EMPTY FIELDS ARE ALLOWED !!");
		            }
				return null;
			    });
				alert.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
				alert.showAndWait();
			}
		});
		
		add.setOnAction(e->{
			if(!titlef.getText().isEmpty()&&!descriptionf.getText().isEmpty()&&!ratingf.getText().isEmpty()&&yearf.getValue()!=null){
			if(Integer.parseInt(ratingf.getText())<=10&&Integer.parseInt(ratingf.getText())>0) {
					Movie m=new Movie(titlef.getText(),descriptionf.getText(),yearf.getValue().getYear(),Double.parseDouble(ratingf.getText()));
	            	catalog.put(m);
	            	indexintable=catalog.hashFunction(m.getTitle());
					index.setText(indexintable+"");
					heightf.setText(trees[indexintable].getRoot().getHeight()+"");
	            	star.setImage(getStarRating(m.getRating()));
	            	Movie h=trees[indexintable].getHighestRankedMovie();
	    			topname.setText(h.getTitle());
	    			toprank.setText(h.getRating()+"");
	    			topstar.setImage(getStarRating(h.getRating()));
	    			Movie l=trees[indexintable].getLowestRankedMovie();
	    			leastname.setText(l.getTitle());
	    			leastrank.setText(l.getRating()+"");
	    			leaststar.setImage(getStarRating(l.getRating()));
	    			titlef.setText("");
	                descriptionf.setText("");
	                ratingf.setText("");
	                LocalDate dateToSet = LocalDate.of(2025, 1, 1);  // Year , with default January 1st
	                yearf.setValue(null);
	                star.setImage(getStarRating(10));
	                tempMovie=null;
	                
					
	    			updateobservableList();
				}
				else {
					getAlert("Rating should be between 0 and 10");
				}
			}
			else
				getAlert("NO EMPTY FIELDS ARE ALLOWED !!");
		});

		//=================================================================
		HBox lbox=new HBox(10);
		lbox.setAlignment(Pos.CENTER_LEFT);
		//lbox.setPadding(new Insets(10));
		lbox.getChildren().addAll(least,leastname,leastrank,leaststar);
		
		HBox tbox=new HBox(10);
		tbox.setAlignment(Pos.CENTER_LEFT);
		//tbox.setPadding(new Insets(10));
		tbox.getChildren().addAll(top,topname,toprank,topstar);
		
		HBox h=new HBox(10);
		h.setAlignment(Pos.CENTER_LEFT);
		//h.setPadding(new Insets(10));
		h.getChildren().addAll(height,heightf);
		
		HBox nip=new HBox(10);
		nip.setAlignment(Pos.CENTER);
		//nip.setPadding(new Insets(10));
		nip.getChildren().addAll(next,index,prev);
		
		HBox ur=new HBox(10);
		ur.setAlignment(Pos.CENTER);
		ur.setPadding(new Insets(10));
		ur.getChildren().addAll(update,remove,deallocate);
		
		HBox ose=new HBox(10);
		ose.setAlignment(Pos.CENTER);
		ose.setPadding(new Insets(10));
		ose.getChildren().addAll(open,save,exit);
		
		vbox1.getChildren().addAll(gpane,star,ur,add,ose);
		vbox2.getChildren().addAll(nip,table,order,h,tbox,lbox);
    	
    	
    	adminbox.getChildren().addAll(vbox1,vbox2);
    	return adminbox;
    	
    }
    /////////////////// star rating/////////////////////////
    private  Image getStarRating(double score) {
        // Convert the score from 0-10 to a scale of 0-5
        double starRating = (score / 10) * 5;
        
        // Round to the nearest 0.5
        starRating = Math.round(starRating * 2) / 2.0;
        
        if (starRating == 0.5) {
            return new Image("halfstar.png");
        } else if (starRating == 1.0) {
        	return new Image("1stars.png");
        } else if (starRating == 1.5) {
        	return new Image("1andhalfstars.png");
        } else if (starRating == 2.0) {
        	return new Image("2stars.png");
        } else if (starRating == 2.5) {
        	return new Image("2andhalfstars.png");
        } else if (starRating == 3.0) {
        	return new Image("3stars.png");
        } else if (starRating == 3.5) {
        	return new Image("3andhalfstars.png");
        } else if (starRating == 4.0) {
        	return new Image("4stars.png");
        } else if (starRating == 4.5) {
        	return new Image("4andhalfstars.png");
        } else if (starRating == 5.0) {
        	return new Image("5stars.png");
        }
        return null;
    }
    
    ///////////// update the observable list/////////////////
    private void updateobservableList() {
    	moviesInIndexList.clear();
    	moviesInIndexList=trees[indexintable].getMoviesInDescendingOrder();
    	table.getItems().clear();
    	table.getItems().addAll(moviesInIndexList);
    	table.refresh();
    }
    
    ///////////////// getAlert//////////////////////////////////

	private void getAlert(String str) {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("ERORR");
		alert.setContentText(str);
		alert.setHeaderText("ERROR ALERT");
		alert.showAndWait();
	}
	

}
