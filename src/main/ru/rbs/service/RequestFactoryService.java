package main.ru.rbs.service;

import main.ru.rbs.util.RequestParser;

import java.util.List;

public class RequestFactoryService {

    private PersonService personService;

    public RequestFactoryService(PersonService personService) {
        this.personService = personService;
    }

    public void start(List<String> createRequests, List<String> updateRequests, List<String> deleteRequests, List<String> readRequests) {
        createRequests.forEach(request -> {
            try {
                personService.addPerson(RequestParser.parseCreateAndUpdateRequest(request));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });


        updateRequests.forEach(request -> {
            try {
                personService.updatePerson(RequestParser.parseCreateAndUpdateRequest(request));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

        deleteRequests.forEach(request -> {
            try {
                personService.deletePerson(RequestParser.parseDeleteRequest(request));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

        readRequests.forEach(request -> {
            try {
                System.out.println(personService.getPerson(RequestParser.parseReadRequest(request)));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });

    }

}
