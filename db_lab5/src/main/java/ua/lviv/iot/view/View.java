package ua.lviv.iot.view;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import ua.lviv.iot.controller.AbonementController;
import ua.lviv.iot.controller.ExerciseController;
import ua.lviv.iot.controller.ExerciseDayController;
import ua.lviv.iot.controller.ExerciseProgramController;
import ua.lviv.iot.controller.ExerciseProgramHasExerciseController;
import ua.lviv.iot.controller.ExerciseScheduleController;
import ua.lviv.iot.controller.PersonController;
import ua.lviv.iot.controller.SalaryController;
import ua.lviv.iot.controller.TrainerController;
import ua.lviv.iot.controller.UserController;
import ua.lviv.iot.model.entity.Abonement;
import ua.lviv.iot.model.entity.Exercise;
import ua.lviv.iot.model.entity.ExerciseDay;
import ua.lviv.iot.model.entity.ExerciseProgram;
import ua.lviv.iot.model.entity.ExerciseProgramHasExercise;
import ua.lviv.iot.model.entity.ExerciseSchedule;
import ua.lviv.iot.model.entity.Person;
import ua.lviv.iot.model.entity.Salary;
import ua.lviv.iot.model.entity.Trainer;
import ua.lviv.iot.model.entity.User;

public class View {

    private final AbonementController abonementController = new AbonementController();
    private final ExerciseController exerciseController = new ExerciseController();
    private final ExerciseDayController exerciseDayController = new ExerciseDayController();
    private final ExerciseScheduleController exerciseScheduleController = new ExerciseScheduleController();
    private final ExerciseProgramController exerciseProgramController = new ExerciseProgramController();
    private final PersonController personController = new PersonController();
    private final SalaryController salaryController = new SalaryController();
    private final UserController userController = new UserController();
    private final TrainerController trainerController = new TrainerController();
    private final ExerciseProgramHasExerciseController exerciseProgramHasExerciseController =
            new ExerciseProgramHasExerciseController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("Q", "Q - exit program");
        menu.put("S", "S - show menu");

        menu.put("1", "1 - Get all users");
        menu.put("2", "2 - Get user by ID");
        menu.put("3", "3 - Create user");
        menu.put("4", "4 - Delete user by ID");
        menu.put("5", "5 - Update user");

        menu.put("6", "6 - Get all trainers");
        menu.put("7", "7 - Get trainer by ID");
        menu.put("8", "8 - Create trainer");
        menu.put("9", "9 - Delete trainer by ID");
        menu.put("10", "10 - Update trainer");

        menu.put("11", "11 - Get all abonements");
        menu.put("12", "12 - Get abonement by ID");
        menu.put("13", "13 - Create abonement");
        menu.put("14", "14 - Delete abonement by ID");
        menu.put("15", "15 - Update abonement");

        menu.put("21", "21 - Get all exercises");
        menu.put("22", "22 - Get exercise by ID");
        menu.put("23", "23 - Create exercise");
        menu.put("24", "24 - Delete exercise by ID");
        menu.put("25", "25 - Update exercise");

        menu.put("26", "26 - Get all exercise days");
        menu.put("27", "27 - Get exercise day by ID");
        menu.put("28", "28 - Create exercise day");
        menu.put("29", "29 - Delete exercise day by ID");
        menu.put("30", "30 - Update exercise day");

        menu.put("31", "31 - Get all exercise programs");
        menu.put("32", "32 - Get exercise program by ID");
        menu.put("33", "33 - Create exercise program");
        menu.put("34", "34 - Delete exercise program by ID");
        menu.put("35", "35 - Update exercise program");

        menu.put("36", "36 - Get all exercise schedules");
        menu.put("37", "37 - Get exercise schedule by ID");
        menu.put("38", "38 - Create exercise schedule");
        menu.put("39", "39 - Delete exercise schedule by ID");
        menu.put("40", "40 - Update exercise schedule");

        menu.put("41", "41 - Get people");
        menu.put("42", "42 - Get person by ID or by name");
        menu.put("43", "43 - Create person");
        menu.put("44", "44 - Delete person by ID");
        menu.put("45", "45 - Update person");

        menu.put("46", "46 - Get all salaries");
        menu.put("47", "47 - Get salary by ID");
        menu.put("48", "48 - Create salary");
        menu.put("49", "49 - Delete salary by ID");
        menu.put("50", "50 - Update salary");

        menu.put("51", "51 - Get all connections between exercise and exercise program");
        menu.put("52", "52 - Get connection between exercise and exercise program by ID");
        menu.put("53", "53 - Create connection between exercise and exercise program");
        menu.put("54", "54 - Delete connection between exercise and exercise program by ID");
        menu.put("55", "55 - Update connection between exercise and exercise program");

        methodsMenu.put("S", this::showMenu);

        methodsMenu.put("1", this::getAllUsers);
        methodsMenu.put("2", this::getUserById);
        methodsMenu.put("3", this::createUser);
        methodsMenu.put("4", this::deleteUser);
        methodsMenu.put("5", this::updateUser);

        methodsMenu.put("6", this::getAllTrainers);
        methodsMenu.put("7", this::getTrainerById);
        methodsMenu.put("8", this::createTrainer);
        methodsMenu.put("9", this::deleteTrainer);
        methodsMenu.put("10", this::updateTrainer);

        methodsMenu.put("11", this::getAllAbonements);
        methodsMenu.put("12", this::getAbonementById);
        methodsMenu.put("13", this::createAbonement);
        methodsMenu.put("14", this::deleteAbonement);
        methodsMenu.put("15", this::updateAbonement);

        methodsMenu.put("21", this::getAllExercises);
        methodsMenu.put("22", this::getExerciseById);
        methodsMenu.put("23", this::createExercise);
        methodsMenu.put("24", this::deleteExercise);
        methodsMenu.put("25", this::updateExercise);

        methodsMenu.put("26", this::getAllExerciseDays);
        methodsMenu.put("27", this::getExerciseDayById);
        methodsMenu.put("28", this::createExerciseDay);
        methodsMenu.put("29", this::deleteExerciseDay);
        methodsMenu.put("30", this::updateExerciseDay);

        methodsMenu.put("31", this::getAllExercisePrograms);
        methodsMenu.put("32", this::getExerciseProgramById);
        methodsMenu.put("33", this::createExerciseProgram);
        methodsMenu.put("34", this::deleteExerciseProgram);
        methodsMenu.put("35", this::updateExerciseProgram);

        methodsMenu.put("36", this::getAllExerciseSchedules);
        methodsMenu.put("37", this::getExerciseScheduleById);
        methodsMenu.put("38", this::createExerciseSchedule);
        methodsMenu.put("39", this::deleteExerciseSchedule);
        methodsMenu.put("40", this::updateExerciseSchedule);

        methodsMenu.put("41", this::getPeople);
        methodsMenu.put("42", this::getPersonByIdOrInitials);
        methodsMenu.put("43", this::createPerson);
        methodsMenu.put("44", this::deletePerson);
        methodsMenu.put("45", this::updatePerson);

        methodsMenu.put("46", this::getAllSalaries);
        methodsMenu.put("47", this::getSalaryById);
        methodsMenu.put("48", this::createSalary);
        methodsMenu.put("49", this::deleteSalary);
        methodsMenu.put("50", this::updateSalary);

        methodsMenu.put("51", this::getAllExerciseProgramHasExercises);
        methodsMenu.put("52", this::getExerciseProgramHasExerciseById);
        methodsMenu.put("53", this::createExerciseProgramHasExercise);
        methodsMenu.put("54", this::deleteExerciseProgramHasExercise);
        methodsMenu.put("55", this::updateExerciseProgramHasExercise);

    }

    private void getAllAbonements() throws SQLException {
        System.out.println("\nAbonements:");
        System.out.println(abonementController.findAll());
    }

    private void getAbonementById() throws SQLException {
        System.out.println("\nEnter ID for an abonement you want to find");
        int id = INPUT.nextInt();
        System.out.println(abonementController.find(id));
    }

    private void deleteAbonement() throws SQLException {
        System.out.println("\nEnter ID for an abonement you want to delete");
        int id = INPUT.nextInt();
        abonementController.delete(id);
        System.out.println("Abonement deleted!");
    }

    private void createAbonement() throws SQLException {
        System.out.println("\nEnter price");
        int price = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        Abonement abonement = new Abonement(price, name);
        abonementController.create(abonement);
        System.out.println("Abonement created!");
    }

    private void updateAbonement() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter price");
        int price = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        Abonement abonement = new Abonement(id, price, name);
        abonementController.update(abonement);
        System.out.println("Abonement updated!");
    }

    private void getAllExercises() throws SQLException {
        System.out.println("\nAbonements:");
        System.out.println(exerciseController.findAll());
    }

    private void getExerciseById() throws SQLException {
        System.out.println("\nEnter ID for an abonement you want to find");
        int id = INPUT.nextInt();
        System.out.println(exerciseController.find(id));
    }

    private void deleteExercise() throws SQLException {
        System.out.println("\nEnter ID for an abonement you want to delete");
        int id = INPUT.nextInt();
        exerciseController.delete(id);
        System.out.println("Exercise deleted!");
    }

    private void createExercise() throws SQLException {
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter duration in minutes");
        Double duration = INPUT.nextDouble();
        System.out.println("\nEnter muscle group");
        String muscleGroup = INPUT.next();
        System.out.println("\nEnter number of repeats");
        int repeats = INPUT.nextInt();
        System.out.println("\nEnter number of burned calories");
        int calories = INPUT.nextInt();
        Exercise exercise = new Exercise(name, duration, muscleGroup, repeats, calories);
        exerciseController.create(exercise);
        System.out.println("Exercise created!");
    }

    private void updateExercise() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter duration in minutes");
        Double duration = INPUT.nextDouble();
        System.out.println("\nEnter muscle group");
        String muscleGroup = INPUT.next();
        System.out.println("\nEnter number of repeats");
        int repeats = INPUT.nextInt();
        System.out.println("\nEnter number of burned calories");
        int calories = INPUT.nextInt();
        Exercise exercise = new Exercise(id, name, duration, muscleGroup, repeats, calories);
        exerciseController.update(exercise);
        System.out.println("Exercise updated!");
    }

    private void getAllExerciseDays() throws SQLException {
        System.out.println("\nExercise Days:");
        System.out.println(exerciseDayController.findAll());
    }

    private void getExerciseDayById() throws SQLException {
        System.out.println("\nEnter ID for an exercise day you want to find");
        int id = INPUT.nextInt();
        System.out.println(exerciseDayController.find(id));
    }

    private void deleteExerciseDay() throws SQLException {
        System.out.println("\nEnter ID for an exercise day you want to delete");
        int id = INPUT.nextInt();
        exerciseDayController.delete(id);
        System.out.println("Exercise day deleted!");
    }

    private void createExerciseDay() throws SQLException {
        System.out.println("\nEnter exercise program ID");
        int exerciseProgramId = INPUT.nextInt();
        ExerciseProgram exerciseProgram = exerciseProgramController.find(exerciseProgramId);
        System.out.println("\nEnter day name");
        String dayName = INPUT.next();
        ExerciseDay exerciseDay = new ExerciseDay(dayName, exerciseProgram);
        exerciseDayController.create(exerciseDay);
        System.out.println("Exercise day created!");
    }

    private void updateExerciseDay() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter exercise program ID");
        int exerciseProgramId = INPUT.nextInt();
        ExerciseProgram exerciseProgram = exerciseProgramController.find(exerciseProgramId);
        System.out.println("\nEnter day name");
        String dayName = INPUT.next();
        ExerciseDay exerciseDay = new ExerciseDay(id, dayName, exerciseProgram);
        exerciseDayController.update(exerciseDay);
        System.out.println("Exercise day updated!");
    }

    private void getAllExercisePrograms() throws SQLException {
        System.out.println("\nExercise Programs:");
        System.out.println(exerciseProgramController.findAll());
    }

    private void getExerciseProgramById() throws SQLException {
        System.out.println("\nEnter ID for an exercise program you want to find");
        int id = INPUT.nextInt();
        System.out.println(exerciseProgramController.find(id));
    }

    private void deleteExerciseProgram() throws SQLException {
        System.out.println("\nEnter ID for an exercise program you want to delete");
        int id = INPUT.nextInt();
        exerciseProgramController.delete(id);
        System.out.println("Exercise program deleted!");
    }

    private void createExerciseProgram() throws SQLException {
        System.out.println("\nEnter name");
        String name = INPUT.next();
        ExerciseProgram exerciseProgram = new ExerciseProgram(name);
        exerciseProgramController.create(exerciseProgram);
        System.out.println("Exercise program created!");
    }

    private void updateExerciseProgram() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        ExerciseProgram exerciseProgram = new ExerciseProgram(id, name);
        exerciseProgramController.update(exerciseProgram);
        System.out.println("Exercise program updated!");
    }

    private void getAllExerciseSchedules() throws SQLException {
        System.out.println("\nExercise Schedules:");
        System.out.println(exerciseScheduleController.findAll());
    }

    private void getExerciseScheduleById() throws SQLException {
        System.out.println("\nEnter ID for an exercise schedule you want to find");
        int id = INPUT.nextInt();
        System.out.println(exerciseScheduleController.find(id));
    }

    private void deleteExerciseSchedule() throws SQLException {
        System.out.println("\nEnter ID for an exercise schedule you want to delete");
        int id = INPUT.nextInt();
        exerciseScheduleController.delete(id);
        System.out.println("Exercise schedule deleted!");
    }

    private void createExerciseSchedule() throws SQLException {
        System.out.println("\nEnter user ID");
        int userId = INPUT.nextInt();
        User user = userController.find(userId);
        System.out.println("\nEnter exercise day ID");
        int exerciseDayId = INPUT.nextInt();
        ExerciseDay exerciseDay = exerciseDayController.find(exerciseDayId);
        System.out.println("\nEnter appointment date (yyyy-[m]m-[d]d format)");
        String appointmentDate = INPUT.next();
        System.out.println("\nEnter ending date (yyyy-[m]m-[d]d format)");
        String endingDate = INPUT.next();
        ExerciseSchedule exerciseSchedule = new ExerciseSchedule(user, exerciseDay, appointmentDate,
                endingDate);
        exerciseScheduleController.create(exerciseSchedule);
        System.out.println("Exercise schedule created!");
    }

    private void updateExerciseSchedule() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter user ID");
        int userId = INPUT.nextInt();
        User user = userController.find(userId);
        System.out.println("\nEnter exercise day ID");
        int exerciseDayId = INPUT.nextInt();
        ExerciseDay exerciseDay = exerciseDayController.find(exerciseDayId);
        System.out.println("\nEnter appointment date (yyyy-[m]m-[d]d format)");
        String appointmentDate = INPUT.next();
        System.out.println("\nEnter ending date (yyyy-[m]m-[d]d format)");
        String endingDate = INPUT.next();
        ExerciseSchedule exerciseSchedule = new ExerciseSchedule(id, user, exerciseDay,
                appointmentDate, endingDate);
        exerciseScheduleController.update(exerciseSchedule);
        System.out.println("Exercise schedule updated!");
    }

    private void getPeople() throws SQLException {
        System.out.println("\nDeclared People:");
        System.out.println(personController.findAll());
    }

    private void getPersonByIdOrInitials() throws SQLException {
        System.out.println("\nDo you want to find a person by id or by initials?");
        System.out.println("1-Initials, 2-ID");
        int flag = INPUT.nextInt();
        if (flag == 1) {
            System.out.println("\nEnter name of the person you want to find)");
            String name = INPUT.next();
            System.out.println("\nEnter surname of the person you want to find)");
            String surname = INPUT.next();
            System.out.println(personController.findByInitials(name, surname));
        } else if (flag == 2) {
            System.out.println("\nEnter ID for the person you want to find");
            int id = INPUT.nextInt();
            System.out.println(personController.find(id));
        } else {
            System.out.println("\nData you entered is wrong");
        }
    }

    private void deletePerson() throws SQLException {
        System.out.println("\nEnter ID for the person you want to delete");
        int id = INPUT.nextInt();
        personController.delete(id);
        System.out.println("Person deleted!");
    }

    private void createPerson() throws SQLException {
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter surname");
        String surname = INPUT.next();
        System.out.println("\nEnter gender");
        String gender = INPUT.next();
        System.out.println("\nEnter age");
        int age = INPUT.nextInt();
        Person person = new Person(name, surname, age, gender);
        personController.create(person);
        System.out.println("Person created!");
    }

    private void updatePerson() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter name");
        String name = INPUT.next();
        System.out.println("\nEnter surname");
        String surname = INPUT.next();
        System.out.println("\nEnter gender");
        String gender = INPUT.next();
        System.out.println("\nEnter age");
        int age = INPUT.nextInt();
        Person person = new Person(id, name, surname, age, gender);
        personController.update(person);
        System.out.println("Person updated!");
    }

    private void getAllSalaries() throws SQLException {
        System.out.println("\nSalaries:");
        System.out.println(salaryController.findAll());
    }

    private void getSalaryById() throws SQLException {
        System.out.println("\nEnter ID for the salary you want to find");
        int id = INPUT.nextInt();
        System.out.println(salaryController.find(id));
    }

    private void deleteSalary() throws SQLException {
        System.out.println("\nEnter ID for the salary you want to delete");
        int id = INPUT.nextInt();
        salaryController.delete(id);
        System.out.println("Salary deleted!");
    }

    private void createSalary() throws SQLException {
        System.out.println("\nEnter salary");
        Double salary = INPUT.nextDouble();
        System.out.println("\nEnter bonus");
        Double bonus = INPUT.nextDouble();
        Salary salaryEntity = new Salary(salary, bonus);
        salaryController.create(salaryEntity);
        System.out.println("Salary created!");
    }

    private void updateSalary() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter salary");
        Double salary = INPUT.nextDouble();
        System.out.println("\nEnter bonus");
        Double bonus = INPUT.nextDouble();
        Salary salaryEntity = new Salary(id, salary, bonus);
        salaryController.update(salaryEntity);
        System.out.println("Salary updated!");
    }

    private void getAllTrainers() throws SQLException {
        System.out.println("\nTrainers:");
        System.out.println(trainerController.findAll());
    }

    private void getTrainerById() throws SQLException {
        System.out.println("\nEnter ID for the trainer you want to find");
        int id = INPUT.nextInt();
        System.out.println(trainerController.find(id));
    }

    private void deleteTrainer() throws SQLException {
        System.out.println("\nEnter ID for the trainer you want to delete");
        int id = INPUT.nextInt();
        trainerController.delete(id);
        System.out.println("Trainer deleted!");
    }

    private void createTrainer() throws SQLException {
        System.out.println("\nEnter person ID");
        int personId = INPUT.nextInt();
        Person person = personController.find(personId);
        System.out.println("\nEnter salary ID");
        int salaryId = INPUT.nextInt();
        Salary salary = salaryController.find(salaryId);
        Trainer trainer = new Trainer(person, salary);
        trainerController.create(trainer);
        System.out.println("Trainer created!");
    }

    private void updateTrainer() throws SQLException {
        System.out.println("\nEnter person ID");
        int personId = INPUT.nextInt();
        Person person = personController.find(personId);
        System.out.println("\nEnter salary ID");
        int salaryId = INPUT.nextInt();
        Salary salary = salaryController.find(salaryId);
        Trainer trainer = new Trainer(person, salary);
        trainerController.update(trainer);
        System.out.println("Trainer updated!");
    }

    private void getAllUsers() throws SQLException {
        System.out.println("\nUsers:");
        System.out.println(userController.findAll());
    }

    private void getUserById() throws SQLException {
        System.out.println("\nEnter ID for the user you want to find");
        int id = INPUT.nextInt();
        System.out.println(userController.find(id));
    }

    private void deleteUser() throws SQLException {
        System.out.println("\nEnter ID for the user you want to delete");
        int id = INPUT.nextInt();
        userController.delete(id);
        System.out.println("User deleted!");
    }

    private void createUser() throws SQLException {
        System.out.println("\nEnter person ID");
        int personId = INPUT.nextInt();
        Person person = personController.find(personId);
        System.out.println("\nEnter abonement ID");
        int abonementId = INPUT.nextInt();
        Abonement abonement = abonementController.find(abonementId);
        System.out.println("\nEnter trainer ID");
        int trainertId = INPUT.nextInt();
        Trainer trainer = trainerController.find(trainertId);
        User user = new User(person, abonement, trainer);
        userController.create(user);
        System.out.println("User created!");
    }

    private void updateUser() throws SQLException {
        System.out.println("\nEnter person ID");
        int personId = INPUT.nextInt();
        Person person = personController.find(personId);
        System.out.println("\nEnter abonement ID");
        int abonementId = INPUT.nextInt();
        Abonement abonement = abonementController.find(abonementId);
        System.out.println("\nEnter trainer ID");
        int trainertId = INPUT.nextInt();
        Trainer trainer = trainerController.find(trainertId);
        User user = new User(person, abonement, trainer);
        userController.update(user);
        System.out.println("User updated!");
    }

    private void getAllExerciseProgramHasExercises() throws SQLException {
        System.out.println("\nConnections between exercise program and exercise:");
        System.out.println(exerciseProgramHasExerciseController.findAll());
    }

    private void getExerciseProgramHasExerciseById() throws SQLException {
        System.out.println(
                "\nEnter ID for the connection between exercise program and exercise you want to find");
        int id = INPUT.nextInt();
        System.out.println(exerciseProgramHasExerciseController.find(id));
    }

    private void deleteExerciseProgramHasExercise() throws SQLException {
        System.out.println(
                "\nEnter ID for the connection between exercise program and exercise you want to delete");
        int id = INPUT.nextInt();
        exerciseProgramHasExerciseController.delete(id);
        System.out.println("Connection between exercise program and exercise deleted!");
    }

    private void createExerciseProgramHasExercise() throws SQLException {
        System.out.println("\nEnter exercise program ID");
        int exerciseProgramId = INPUT.nextInt();
        ExerciseProgram exerciseProgram = exerciseProgramController.find(exerciseProgramId);
        System.out.println("\nEnter exercise ID");
        int exerciseId = INPUT.nextInt();
        Exercise exercise = exerciseController.find(exerciseId);
        ExerciseProgramHasExercise exerciseProgramHasExercise = new ExerciseProgramHasExercise(
                exerciseProgram, exercise);
        exerciseProgramHasExerciseController.create(exerciseProgramHasExercise);
        System.out.println("Connection between exercise program and exercise created!");
    }

    private void updateExerciseProgramHasExercise() throws SQLException {
        System.out.println("\nEnter id of the connection you want to update ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter exercise program ID");
        int exerciseProgramId = INPUT.nextInt();
        ExerciseProgram exerciseProgram = exerciseProgramController.find(exerciseProgramId);
        System.out.println("\nEnter exercise ID");
        int exerciseId = INPUT.nextInt();
        Exercise exercise = exerciseController.find(exerciseId);
        ExerciseProgramHasExercise exerciseProgramHasExercise = new ExerciseProgramHasExercise(id,
                exerciseProgram, exercise);
        exerciseProgramHasExerciseController.update(exerciseProgramHasExercise);
        System.out.println("Connection between exercise program and exercise updated!");
    }

    private final void showMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private final void showSmallMenu() {
        System.out.println(menu.get("S"));
        System.out.println(menu.get("Q"));
        System.out.println("Please, select menu point.");
    }

    public void show() {
        String keyMenu;
        showSmallMenu();
        while (true) {
            keyMenu = INPUT.next().toUpperCase();
            if (keyMenu.equals("Q")) {
                System.out.println("\nProgram closed!");
                break;
            }
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
            showSmallMenu();
        }
    }
}