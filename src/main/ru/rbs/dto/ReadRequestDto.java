package main.ru.rbs.dto;

public class ReadRequestDto {
    private String name;

    public String getName() {
        return name;
    }

    public ReadRequestDto setName(String name) {
        this.name = name;
        return this;
    }
}
