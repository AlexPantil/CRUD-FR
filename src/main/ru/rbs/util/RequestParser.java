package main.ru.rbs.util;

import main.ru.rbs.dto.CreateAndUpdateRequestDto;
import main.ru.rbs.dto.DeleteRequestDto;
import main.ru.rbs.dto.ReadRequestDto;
import main.ru.rbs.exception.InvalidParamException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static main.ru.rbs.config.ApplicationSettings.DATE_PATTERN;

public class RequestParser {

    private final static SimpleDateFormat dateFormat;

    static {
        dateFormat = new SimpleDateFormat(DATE_PATTERN);
    }

    private RequestParser(){
    }

    public static CreateAndUpdateRequestDto parseCreateAndUpdateRequest(String request) {
        CreateAndUpdateRequestDto requestDto = new CreateAndUpdateRequestDto();
        String[] params = requestStringToArray(request);

        requestDto.setPersonName(params[0])
                .setPersonAge(Integer.parseInt(params[1]))
                .setChildrenNames(params[2])
                .setPassportSeries(params[3])
                .setPassportNumber(params[4])
                .setPassportAdress(params[6]);
        try {
            requestDto.setPassportIssuedDate(dateFormat.parse(params[5]));
        } catch (ParseException e) {
            throw new InvalidParamException(String.format("Passport issued date should be like: [%s]", DATE_PATTERN));
        }
        return requestDto;
    }

    public static DeleteRequestDto parseDeleteRequest(String request) {
        return new DeleteRequestDto().setName(request.replaceAll("[\"]", ""));
    }

    public static ReadRequestDto parseReadRequest(String request) {
        return new ReadRequestDto().setName(request.replaceAll("[\"]", ""));
    }

    private static String[] requestStringToArray(String request) {
        String[] params = request.split("\"\\s");

        for (int i=0; i< params.length; i++) {
            params[i] = params[i].replaceAll("[\"]", "");
        }
        return params;
    }
}
