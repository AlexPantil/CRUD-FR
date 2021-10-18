package main.ru.rbs;

import main.ru.rbs.service.PersonService;
import main.ru.rbs.service.RequestFactoryService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static main.ru.rbs.config.ApplicationSettings.*;

public class main {

    private static List<String> listToCreate = new ArrayList<>();
    private static List<String> listToUpdate = new ArrayList<>();
    private static List<String> listToDelete = new ArrayList<>();
    private static List<String> listToRead = new ArrayList<>();

    public static void main(String[] args) {
        try(BufferedReader createReader = new BufferedReader(new FileReader(PATH_TO_CREATE_FILE));
            BufferedReader deleteReader = new BufferedReader(new FileReader(PATH_TO_DELETE_FILE));
            BufferedReader updateReader = new BufferedReader(new FileReader(PATH_TO_UPDATE_FILE));
            BufferedReader readReader = new BufferedReader(new FileReader(PATH_TO_READ_FILE)) ) {
            while (createReader.ready()) {
                listToCreate.add(createReader.readLine());
            }
            while (updateReader.ready()) {
                listToUpdate.add(updateReader.readLine());
            }
            while (deleteReader.ready()) {
                listToDelete.add(deleteReader.readLine());
            }
            while (readReader.ready()) {
                listToRead.add(readReader.readLine());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        RequestFactoryService factoryService = new RequestFactoryService(PersonService.getInstance());
        factoryService.start(listToCreate, listToUpdate, listToDelete, listToRead);
    }

}
