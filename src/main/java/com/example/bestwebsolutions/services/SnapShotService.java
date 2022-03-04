package com.example.bestwebsolutions.services;

import com.example.bestwebsolutions.model.Photo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SnapShotService {

    final ObjectMapper objectMapper = new ObjectMapper();

    public List<Photo> getAll(String name) {
        List<Photo> photos = new ArrayList<>();
        String firstPart = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=636e1481b4f3c446d26b8eb6ebfe7127&tags=";
        String secondPart = "&per_page=24&format=json&nojsoncallback=1";
        String url = firstPart.concat(name.concat(secondPart));
        try {
            JSONArray jsonPhotos = readJsonFromUrl(url).getJSONObject("photos").getJSONArray("photo");
            photos = Arrays.asList(objectMapper.readValue(jsonPhotos.toString(), Photo[].class));
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return photos;
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
