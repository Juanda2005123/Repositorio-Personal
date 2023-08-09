package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
		testCases();
	}
	
	public void testCases() {


		Calendar calendarStart = new GregorianCalendar(2023,(3-1),22);
		Calendar start_up_stage_calendar = addDaysCalendar(calendarStart, 25);
		Calendar analysis_stage_calendar = addDaysCalendar(start_up_stage_calendar, 310);
		Calendar design_stage_calendar = addDaysCalendar(analysis_stage_calendar, 400);
		Calendar execution_stage_calendar = addDaysCalendar(design_stage_calendar, 30);
		Calendar closing_stage_calendar = addDaysCalendar(execution_stage_calendar, 27);
		Calendar follow_up_stage_calendar = addDaysCalendar(closing_stage_calendar, 40);
		projects[0] = new Project("Proye", "Francisco", 65, calendarStart, start_up_stage_calendar, analysis_stage_calendar, design_stage_calendar, execution_stage_calendar, closing_stage_calendar, follow_up_stage_calendar);

	}

	/**
	 * @param projectName
	 * @param clientName
	 * @param startDay
	 * @param startMonth
	 * @param startYear
	 * @param budget
	 * @param start_up_stage
	 * @param analysis_stage
	 * @param design_stage
	 * @param execution_stage
	 * @param closing_stage
	 * @param follow_up_stage
	 * @return boolean
	 */
	public boolean registerProject(String projectName, String clientName, int startDay, int startMonth, int startYear, double budget, int start_up_stage, int analysis_stage, int design_stage, int execution_stage, int closing_stage, int follow_up_stage) {

		//Calendario inicio fecha PROYECTO y start_up_stage
		Calendar calendarStart = new GregorianCalendar(startYear,startMonth-1,startDay);
		//Calendario fin start_up_stage e inicio analysis_stage
		Calendar start_up_stage_calendar = addDaysCalendar(calendarStart, start_up_stage*30);
		//Calendario fin analysis_stage e inicio design_stage
		Calendar analysis_stage_calendar = addDaysCalendar(start_up_stage_calendar, analysis_stage*30);
		//Calendario fin design_stage e inicio execution_stage
		Calendar design_stage_calendar = addDaysCalendar(analysis_stage_calendar, design_stage*30);
		//Calendario fin execution_stage e inicio closing_stage
		Calendar execution_stage_calendar = addDaysCalendar(design_stage_calendar, execution_stage*30);
		//Calendario fin closing_stage e inicio follow_up_stage
		Calendar closing_stage_calendar = addDaysCalendar(execution_stage_calendar, closing_stage*30);
		//Calendario fin follow_up_stage y fin de PROYECTO
		Calendar follow_up_stage_calendar = addDaysCalendar(closing_stage_calendar, follow_up_stage*30);


		Project newProject = new Project(projectName, clientName, budget, calendarStart, start_up_stage_calendar, analysis_stage_calendar, design_stage_calendar, execution_stage_calendar, closing_stage_calendar, follow_up_stage_calendar);
		
		for(int i = 0; i<projects.length;i++){
			if(projects[i]==null){
				projects[i] = newProject;
				return true;
			}
		}
		return false;
	}

	/**
	 * @param projectName String
	 * @param day int
	 * @param month int
	 * @param year int
	 * @param decision int
	 * @return boolean
	 */
	public boolean culminateProjectStage(String projectName) {

		Calendar calendarStage = Calendar.getInstance();

		String realProjectName = "";
		for(int i = 0; i < projects.length; i++) {
			realProjectName = projects[i].getProjectName();
			if(realProjectName.equalsIgnoreCase(projectName)) {
				if(projects[i].culminateProjectStage(calendarStage)) {
					return true;
				}
			}
		}

		return false;
	}



	/**
	 * @param projectName String
	 * @param stagePhase String
	 * @param idKU String
	 * @param descriptionKU String
	 * @param type String
	 * @param collaboratorName String
	 * @param collaboratorPosition String
	 * @param learnedLessonsKU String
	 * @return boolean
	 */
	public boolean registerKnowledgeUnit(String projectName, String stagePhase, String idKU, String descriptionKU, String type, String collaboratorName, String collaboratorPosition, String learnedLessonsKU) {

		TypeUnits typeKU = TypeUnits.TECHNICAL;
		if(type.equalsIgnoreCase("EXPERIENCES")){
			typeKU = TypeUnits.EXPERIENCES;
		} else if(type.equalsIgnoreCase("MANAGEMENT")){
			typeKU = TypeUnits.MANAGEMENT;
		} else if(type.equalsIgnoreCase("DOMAIN")){
			typeKU = TypeUnits.DOMAIN;
		}


		for(int i = 0; i < projects.length; i++){
			if(projects[i]!=null){
				String realProjectName = projects[i].getProjectName();
				if(realProjectName.equalsIgnoreCase(projectName)) {
					if(projects[i].registerKnowledgeUnit(stagePhase, idKU, descriptionKU, typeKU, collaboratorName, collaboratorPosition, learnedLessonsKU)) {
						return true;
					}
				}
			}
			
		}
		return false;
	}

	/**
	 * @param projectName String
	 * @param approveInt int
	 * @param idKU String
	 * @return boolean
	 */
	public boolean approveKnowledgeUnit(String projectName, int approveInt, String idKU) {

		Calendar calendarStage = Calendar.getInstance();
		Status approve = Status.NOT_APPROVED;
		if(approveInt==1) {
			approve = Status.APPROVED;
		} 
		String realProjectName = "";
		for(int i = 0; i < projects.length; i++) {
			if(projects[i]!=null){
				realProjectName = projects[i].getProjectName();
				if(realProjectName.equalsIgnoreCase(projectName)) {
					if(projects[i].approveKnowledgeUnit(approve, idKU, calendarStage)) {
						return true;
					}
				}
			}
		}


		return false;
	}

	/**
	 * @param projectName String
	 * @param idUnit String
	 * @param urlUnit String
	 * @return boolean
	 */
	public boolean publishKnowledgeUnit(String projectName, String idUnit, String urlUnit) {
	
		String realProjectName = "";
		for(int i = 0; i < projects.length; i++) {
			if(projects[i]!=null){
				realProjectName = projects[i].getProjectName();
				if(realProjectName.equalsIgnoreCase(projectName)) {
					if(projects[i].publishKnowledgeUnit(idUnit, urlUnit)) {
						return true;
					}
				}
			}
		}


		return false;
	}

	/**
	 * @return boolean
	 */
	public String informTypeUnits() {

		String msg = "";

		int technical = 0;
		int experiences = 0;
		int management = 0;
		int domain = 0;

		int informArray[];
        informArray = new int[4];

		for(int i = 0; i < projects.length; i++) {
			if(projects[i]!=null){
				informArray = projects[i].informTypeUnits();
				
				technical += informArray[0];
				experiences += informArray[1];
				management += informArray[2];
				domain += informArray[3];
			}
		}

		msg = "The number of units ";
		msg += ("\nManagement: "+(management)+"\nDomain: "+(domain));
		msg += ("\nTechnical: "+(technical)+"\nExperiences: "+(experiences));
		
		return msg;
	}

	/**
	 * @param stagePhaseCompare String
	 * @return boolean
	 */
	public String informLearnedLessonsByStage(String stagePhaseCompare) {

		Phase stagePhase = Phase.START_UP;
		if(stagePhaseCompare.equalsIgnoreCase("ANALYSIS")) {
			stagePhase = Phase.ANALYSIS;
		} else if(stagePhaseCompare.equalsIgnoreCase("DESIGN")) {
			stagePhase = Phase.DESIGN;
		} else if(stagePhaseCompare.equalsIgnoreCase("EXECUTION")) {
			stagePhase = Phase.EXECUTION;
		} else if(stagePhaseCompare.equalsIgnoreCase("CLOSING")) {
			stagePhase = Phase.CLOSING;
		} else if(stagePhaseCompare.equalsIgnoreCase("FOLLOW_UP")) {
			stagePhase = Phase.FOLLOW_UP;
		}

		String msg = "";
		for(int i = 0; i < projects.length; i++) {
			if(projects[i]!=null) {
				msg += projects[i].informLearnedLessonsByStage(stagePhase);
			}
		}



		return msg;
	}

	/**
	 * @return boolean
	 */
	public String mostKnowledgeUnitInAProject() {
		
		String msg = "";
		int compare[];
        compare = new int[11];
		for(int p = 0; p < compare.length; p++) {
			compare[p] = 0;
		}
		for(int i = 0; i < projects.length; i++) {
			if(projects[i]!=null) {
				compare[i] = projects[i].mostKnowledgeUnitInAProject();
			}
		}
		int j = 0;
		int contator = 1;
		for(int i = 0; i < 10; i++) {
			if((compare[i]>compare[i+1])&&(compare[i]>=contator)){
				j = i;
				contator = compare[i];
				msg = ("The project name is: "+projects[j].getProjectName());
			}
		}
		int verification = 0;
		for (int i = 0; i < 10; i++) {
			verification += compare[i];
		}
		if(verification==0){
			msg = "";
		}
		
		return msg;
	}

	/**
	 * @param collaboratorName String
	 * @return boolean
	 */
	public String informCollaboratorUnits(String collaboratorName) {

		String msg = "";
		boolean test = false;

		for (int i = 0; i < projects.length; i++) {
			if(projects[i]!=null) {
				test = projects[i].informCollaboratorUnits(collaboratorName);
				if(test==true){
					msg += ("\nA knowledge unit has been registred in: "+projects[i].getProjectName());
				}
			}

		}

		return msg;
	}
	/**
	 * @param keyWord String
	 * @return boolean
	 */
	public String searchDescriptionAndLearnedLessonsByKeyWord(String keyWord) {

		String msg = "";

		for (int i = 0; i < projects.length; i++) {
			if(projects[i]!=null) {
				msg += projects[i].searchDescriptionAndLearnedLessonsByKeyWord(keyWord);
			}
		}

		return msg;
	}
		
	

	/**
	 * @param calendar Calendar
	 * @param num int
	 * @return Calendar
	 */
	public Calendar addDaysCalendar(Calendar calendar, int num) {
		calendar.add(Calendar.DAY_OF_YEAR, num);
		return calendar;
	}
}
