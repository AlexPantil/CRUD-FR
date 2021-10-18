package main.ru.rbs.service;

import main.ru.rbs.dto.CreateAndUpdateRequestDto;
import main.ru.rbs.dto.DeleteRequestDto;
import main.ru.rbs.dto.ReadRequestDto;
import main.ru.rbs.entity.Person;
import main.ru.rbs.exception.PersonNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PersonService {

    private static PersonService INSTANCE;

    private HashMap<String, Person> repository = new HashMap<>();

    private PersonService() {

    }

    public static PersonService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersonService();
        }

        return INSTANCE;
    }

    public void addPerson(CreateAndUpdateRequestDto requestDto) {
        Person.Passport passport = new Person.Passport();
        passport.setSeries(requestDto.getPassportSeries())
                .setNumber(requestDto.getPassportNumber())
                .setIssuedDate(requestDto.getPassportIssuedDate())
                .setAddress(requestDto.getPassportAdress());
        Person person = new Person();
        person.setName(requestDto.getPersonName())
                .setAge(requestDto.getPersonAge())
                .setPassport(passport);
        addChildren(person, requestDto.getChildrenNames());
        repository.put(person.getName(), person);
    }

    public Person getPerson(ReadRequestDto requestDto) {
        if (!repository.containsKey(requestDto.getName())) {
            throw new PersonNotFoundException(String.format("Person [%s] not found", requestDto.getName()));
        }
        return repository.get(requestDto.getName());
    }

    public void updatePerson(CreateAndUpdateRequestDto requestDto) {
        if (repository.containsKey(requestDto.getPersonName())) {
            Person person = repository.get(requestDto.getPersonName());
            person.getPassport().setSeries(requestDto.getPassportSeries())
                    .setNumber(requestDto.getPassportNumber())
                    .setIssuedDate(requestDto.getPassportIssuedDate())
                    .setAddress(requestDto.getPassportAdress());
            person.setAge(requestDto.getPersonAge());
            addChildren(person, requestDto.getChildrenNames());
        }
    }

    public void deletePerson(DeleteRequestDto requestDto) {
        if (!repository.containsKey(requestDto.getName())) {
            throw new PersonNotFoundException(String.format("Person [%s] not found", requestDto.getName()));
        }
        Person personForDeleting = repository.get(requestDto.getName());
        repository.forEach((name, person) -> person.getChildren().remove(personForDeleting));
        repository.remove(requestDto.getName());
    }

    public void printAll() {
        repository.forEach((name, person) -> System.out.println(person));
    }

    private void addChildren(Person person, String stringOfChildren) {
        ArrayList<String> childrenNames = new ArrayList<>(Arrays.asList(stringOfChildren.split("[,]")));
        if (!childrenNames.isEmpty()) {
            childrenNames.stream().filter(name -> repository.containsKey(name)).forEach(name -> person.getChildren().add(repository.get(name)));
        }
    }
}
