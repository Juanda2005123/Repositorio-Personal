package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	public Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Executable executable = new Executable();
		executable.menu();
	}

	
	/**
	 * Menu
	 */
	public void menu() {
		System.out.println("Menu:");
		boolean menuB = true;
		while (menuB) {
			System.out.println("1. Register Project");
			System.out.println("2. Culminate Project Stage");
			System.out.println("3. Register Knowledge Unit");
			System.out.println("4. Approve Knowledge Unit");
			System.out.println("5. Publish knowledge unit");
			System.out.println("6. Inform number of Knowledge unit of every type");
			System.out.println("7. Inform knowledge unit learned lessons, searched by stage");
			System.out.println("8. Inform most Knowledge units in a project");
			System.out.println("9. Inform if a collaborator has register knowledge units");
			System.out.println("10. Search description and learned lessons by key word\n11. Exit");
			int menu = reader.nextInt();
			switch(menu){
				
				case 1:
				registerProject();
				break;
				case 2:
				culminateStage();
				break;
				case 3:
				registerUnits();
				break;
				case 4:
				approveUnits();
				break;
				case 5: 
				publishUnits();
				break;
				case 6:
				informTypeUnits();
				break;
				case 7:
				informLearnedLessonsByStage();
				break;
				case 8:
				mostUnitsInAProject();
				break;
				case 9:
				informCollaboratorUnits();
				break;
				case 10:
				searchDescriptionAndLearnedLessonsByKeyWord();
				break;
				case 11:
					menuB = false;
				break;
			}
		}
	}

	
	/**
	 * registra proyectos
	 */
	public void registerProject() {
		reader.nextLine();

		System.out.println("Type project name");
		String projectName = reader.nextLine();
		
		System.out.println("Type the client name");
		String clientName = reader.nextLine();

		System.out.println("Type project start date \n--------------------");
		System.out.println("Type the start day date");
		int startDay = reader.nextInt();
		System.out.println("Type the start month date");
		int startMonth = reader.nextInt();
		System.out.println("Type the start year date");
		int startYear = reader.nextInt();
		System.out.println("--------------------");
		System.out.println("The project End date will be taken off with the planned completion date of the last stage");

		reader.nextLine();
		System.out.println("Type the budget");
		double budget = reader.nextDouble();

		System.out.println("Enter the number of months the 1.Start-up phase is planned to last");
		int start_up_stage = reader.nextInt();
		System.out.println("Enter the number of months the 2.Analysis phase is planned to last");
		int analysis_stage = reader.nextInt();
		System.out.println("Enter the number of months the 3.Design phase is planned to last");
		int design_stage = reader.nextInt();
		System.out.println("Enter the number of months the 4.Execution phase is planned to last");
		int execution_stage = reader.nextInt();
		System.out.println("Enter the number of months the 5.Closing phase is planned to last");
		int closing_stage = reader.nextInt();
		System.out.println("Enter the number of months the 6.Follow_up phase is planned to last");
		int follow_up_stage = reader.nextInt();





		if(controller.registerProject(projectName, clientName, startDay, startMonth, startYear, budget,start_up_stage, analysis_stage, design_stage, execution_stage, closing_stage, follow_up_stage)) {
			System.out.println("Project registered correctly");
		} else {
			System.out.println("Could not register the project");
		}
	}


	/**
	 * culmina etapas
	 */
	public void culminateStage(){

		reader.nextLine();
		System.out.println("Type the project name");
		String projectName = reader.nextLine();
		if(controller.culminateProjectStage(projectName)) {
			System.out.println("The completion of the stage was performed correctly");
		} else {
			System.out.println("The completion of the stage could not be carried out");
		}
		
	}

	/**
	 * registra capsulas
	 */
	public void registerUnits(){

		reader.nextLine();
		System.out.println("Type the project name");
		String projectName = reader.nextLine();
		System.out.println("Enter the stage: \n<<START_UP>>, <<ANALYSIS>>, <<DESIGN>>, \n<<EXECUTION>>, <<CLOSING>>, <<FOLLOW_UP>>");
		String stagePhase = reader.nextLine();


		System.out.println("Type the unique identifier of the knowledge unit");
		String idKU = reader.nextLine();
		System.out.println("Type the description of the situation. Type a # at the start and at the final of the key words. Must type the key words at the start");
		System.out.println("Example: <<#Pruebas funcionales# Se encontro que en la etapa...>>");
		String descriptionKU = reader.nextLine();
		System.out.println("Type the knowledge unit type: \n<<TECHNICAL>>, <<EXPERIENCES>>, <<MANAGEMENT>>, <<DOMAIN>>");
		String type = reader.nextLine();
		System.out.println("Type the learned lessons. Type a # at the start and at the final of the key words. Must type the key words at the start");
		System.out.println("Example: <<#Pruebas funcionales# Se encontro que en la etapa...>>");
		String learnedLessonsKU = reader.nextLine();
	
		System.out.println("Type the collaborator name");
		String collaboratorName = reader.nextLine();
		System.out.println("Type the collaborator position");
		String collaboratorPosition = reader.nextLine();
		
		
		if(controller.registerKnowledgeUnit(projectName, stagePhase, idKU, descriptionKU, type, collaboratorName, collaboratorPosition, learnedLessonsKU)){	
			System.out.println("Knowledge unit registered correctly");
		} else {
			System.out.println("Could not register the knowledge unit");
		}
	}

	/**
	 * Aprueba capsulas
	 */
	public void approveUnits(){
		
		reader.nextLine();
		System.out.println("Type the project name");
		String projectName = reader.nextLine();
		System.out.println("Enter the knowledge unit unique identifier");
		String idKU = reader.nextLine();

		System.out.println("Type 1. approve 2. Not approve");
		int approve = reader.nextInt();
		if(controller.approveKnowledgeUnit(projectName, approve, idKU)) {
			System.out.println("Knowledge unit approved correctly");
		}else {
			System.out.println("Could not approve the Knowledge unit");
		}
	}
	
	/**
	 * Publica las capuslas de conocimiento
	 */
	public void publishUnits(){

		reader.nextLine();
		System.out.println("Type the project name");
		String projectName = reader.nextLine();
		System.out.println("Enter the knowledge unit unique identifier");
		String idUnit = reader.nextLine();
		System.out.println("Type the URL");
		String urlUnit = reader.nextLine();

		if(controller.publishKnowledgeUnit(projectName, idUnit, urlUnit)) {
			System.out.println("Knowledge unit published correctly");
		}else {
			System.out.println("Could not publish the Knowledge unit");
		}

	}

	/**
	 * Informa las capsulas por el tipo de ellas
	 */
	public void informTypeUnits() {
		
		System.out.println(controller.informTypeUnits());
	}

	/**
	 * Infora las learned lessons buscadas por etapas
	 */
	public void informLearnedLessonsByStage() {
		
		reader.nextLine();
		System.out.println("Enter the stage: \n<<START_UP>>, <<ANALYSIS>>, <<DESIGN>>, \n<<EXECUTION>>, <<CLOSING>>, <<FOLLOW_UP>>");
		String stagePhase = reader.nextLine();
		String inform = controller.informLearnedLessonsByStage(stagePhase);
		if(inform.equalsIgnoreCase("")) {
			System.out.println("There are not learned lessons in the knowledge units");
		} else {
			System.out.println("These are the learned lessons in the knowledge units:");
			System.out.println(inform);

		}
	}

	/**
	 * muestra cual es el proyecto con mas capsulas
	 */
	public void mostUnitsInAProject() {

		String comprobation = controller.mostKnowledgeUnitInAProject();
		if (comprobation.equalsIgnoreCase("")){
			System.out.println("There are no knowledge units");
		} else {
			System.out.println(comprobation);
		}
		
	}

	/**
	 * informa si un colaborador ha registrado una capsula de conocimiento
	 */
	public void informCollaboratorUnits() {

		reader.nextLine();
		System.out.println("Type the collaborator name");
		String collaboratorName = reader.nextLine();

		String comprobation = controller.informCollaboratorUnits(collaboratorName);
		if (comprobation.equalsIgnoreCase("")){
			System.out.println("This collaborator has not register a knowledge unit");
		} else {
			System.out.println(comprobation);
		}
	}

	/**
	 * busca en las capsulas publicadas, en las descripciones y learned lessons por palabras clave
	 */
	public void searchDescriptionAndLearnedLessonsByKeyWord() {
		reader.nextLine();

		System.out.println("Type the key word to search in the description and learned lessons of the knowledge units");
		String keyWord = reader.nextLine(); 

		String comprobation = controller.searchDescriptionAndLearnedLessonsByKeyWord(keyWord);
		if (comprobation.equalsIgnoreCase("")){
			System.out.println("Could not found descriptions or learned lessons with that key word");
		} else {
			System.out.println(comprobation);
		}
	}
	
	
	
}