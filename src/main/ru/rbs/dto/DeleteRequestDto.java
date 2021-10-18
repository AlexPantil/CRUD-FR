package main.ru.rbs.dto;

public class DeleteRequestDto {
    private String name;

    public String getName() {
        return name;
    }

    public DeleteRequestDto setName(String name) {
        this.name = name;
        return this;
    }
}
