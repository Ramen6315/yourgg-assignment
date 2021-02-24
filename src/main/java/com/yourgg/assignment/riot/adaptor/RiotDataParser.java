package com.yourgg.assignment.riot.adaptor;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
@Component
public class RiotDataParser {

    public String championIdParser(final int championId) {
        String championImageUrl = "";
        Gson gson = new Gson();
        try{
            JsonReader jsonReader = new JsonReader(new FileReader("src/main/resources/static/champion.json"));
            JsonObject allChampionAsJsonObject = gson.fromJson(jsonReader, JsonObject.class);
            JsonObject data = allChampionAsJsonObject.getAsJsonObject("data");
            JsonObject championsAsJsonObject = data.getAsJsonObject();
            for (String string : championsAsJsonObject.keySet()) {
                JsonObject championAsJsonObject = championsAsJsonObject.getAsJsonObject(string);
                JsonElement key = championAsJsonObject.get("key");
                if(key.getAsInt() == championId) {
                    JsonObject image = championAsJsonObject.getAsJsonObject("image");
                    JsonElement url = image.get("full");
                    championImageUrl = url.getAsString();
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("file does not exist");
        }
        return championImageUrl;
    }

    public String spellIdParser(final int spellId) {
        String runeUrl = "";
        Gson gson = new Gson();

        try{
            JsonReader jsonReader = new JsonReader(new FileReader("src/main/resources/static/summoner.json"));
            JsonObject obj = gson.fromJson(jsonReader, JsonObject.class);
            JsonObject data = obj.getAsJsonObject("data");
            JsonObject asJsonObject = data.getAsJsonObject();
            for (String spellName: asJsonObject.keySet()) {
                JsonObject asJsonObject1 = asJsonObject.getAsJsonObject(spellName);
                JsonElement key = asJsonObject1.get("key");
                String spell = String.valueOf(spellId);
                if(spell.equals(key.getAsString())) {
                    JsonObject image = asJsonObject1.getAsJsonObject("image");
                    JsonElement url = image.get("full");
                    runeUrl = url.getAsString();
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("file does not exist");
        }

        return runeUrl;
    }

    public String subRuneIdParser(final int subRuneId) {
        String runeUrl = "";
        Gson gson = new Gson();
        try{
            JsonReader jsonReader = new JsonReader(new FileReader("src/main/resources/static/runesReforged.json"));
            JsonArray obj = gson.fromJson(jsonReader, JsonArray.class);
            for (JsonElement runeAsJsonElement: obj) {
                JsonObject runeAsJsonObject = runeAsJsonElement.getAsJsonObject();
                JsonElement runeIdAsJsonElement = runeAsJsonObject.get("id");
                if(runeIdAsJsonElement.getAsInt() == subRuneId) {
                    JsonElement icon = runeAsJsonObject.get("icon");
                    runeUrl = icon.getAsString();
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("file does not exist");
        }
        return runeUrl;
    }

    public String perkZeroIdParser(final int perkZeroId) {
        String runeUrl = "";
        Gson gson = new Gson();
        try{
            JsonReader jsonReader = new JsonReader(new FileReader("src/main/resources/static/runesReforged.json"));
            JsonArray obj = gson.fromJson(jsonReader, JsonArray.class);
            for (JsonElement runeAsJsonElement: obj) {
                JsonObject runeAsJsonObject = runeAsJsonElement.getAsJsonObject();
                JsonElement runeSlotAsJsonElement = runeAsJsonObject.get("slots");
                for (JsonElement runeElement : runeSlotAsJsonElement.getAsJsonArray()) {
                    JsonObject eachRuneAsJsonObject = runeElement.getAsJsonObject();
                    JsonElement runes = eachRuneAsJsonObject.get("runes");
                    for (JsonElement runeInfos :runes.getAsJsonArray()) {
                        JsonObject runeInfoAsJsonObject = runeInfos.getAsJsonObject();
                        JsonElement id = runeInfoAsJsonObject.get("id");
                        if(String.valueOf(perkZeroId).equals(id.getAsString())) {
                            JsonElement icon = runeInfoAsJsonObject.get("icon");
                            runeUrl = icon.getAsString();
                        }
                    }
                }

            }
        } catch(FileNotFoundException e) {
            System.out.println("file does not exist");
        }
        return runeUrl;
    }
}
