package API.HomeWork.Day2;

import API.HomeWork.Day2.RandomPetNames;

public class Payload {

    public static String getPetPayload(){

        long id = System.currentTimeMillis();
        System.out.println(id);

        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"" + RandomPetNames.getPetNames() + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"Sold\"\n" +
                "}";

    }


}
