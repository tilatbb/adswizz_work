package com.ex.utils;

import com.ex.data.Records;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UtilsFunctions {
    public UtilsFunctions() {
    }

    public List<Records> getAllRecords() {
        String filePath = "src/test/resources/data.txt";
        List<Records> records = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> {
                try {
                    Records record = objectMapper.readValue(line, Records.class);
                    records.add(record);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<Records> getFilteredListByCity(String cityName){
        List<Records> records = getAllRecords();
        return records.stream().filter(rc ->rc.getCity().equals(cityName)).toList();
    }
}
