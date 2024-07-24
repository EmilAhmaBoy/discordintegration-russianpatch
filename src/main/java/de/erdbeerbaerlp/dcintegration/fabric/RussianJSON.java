package de.erdbeerbaerlp.dcintegration.fabric;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RussianJSON {
    final static public String json;

    static {
        try {
            ModContainer modContainer = FabricLoader.getInstance().getModContainer("dcintegration-fabric").get();
            Path path = modContainer.findPath("assets/dcintegration-fabric/russian_translations.json").get();
            json = Files.readString(path);
        } catch (IOException e) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            System.out.println("AAAAAAAAAAAAAAAAAAAAA");
            throw new RuntimeException(e);
        }
    }

    final static public JsonObject translations = (new Gson()).fromJson(json, JsonObject.class);

    static public String translate(Text text) {
        String translation = text.getString();
        if (text.getContent() instanceof TranslatableTextContent content) {
            if (RussianJSON.translations.has(content.getKey())) { translation = RussianJSON.translations.get(content.getKey()).getAsString(); }
        }
        return translation;
    }
}
