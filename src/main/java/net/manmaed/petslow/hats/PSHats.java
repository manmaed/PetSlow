package net.manmaed.petslow.hats;


import net.manmaed.petslow.PetSlowClient;
import net.manmaed.petslow.libs.LogHelper;

import java.net.URL;

/**
 * Created by manmaed on 24/01/2022.
 */
public class PSHats {

    public static boolean christmas = false;
    public static boolean birthday = false;
    public static boolean halloween = false;
    public static boolean loneztar = false;
    public static boolean slowpoke = false;
    private static String usernames = "";

    public static void load() {
        HatData hatData = null;
        birthday = false;
        christmas = false;
        halloween = false;
        try {
            if (!PetSlowClient.iChunHatsLoaded) {
                hatData = HatData.getHatData(new URL("https://raw.githubusercontent.com/manmaed/PetSlow/main/hats.json"));
                //hatData = HatData.getHatData(new URL("file:///G:/Modding/Forge/1_16_5/PetRock/run/hattesting.json"));
                String hat = hatData.isEventActive();
                usernames = hatData.getUsername();
                if (hat.equalsIgnoreCase("christmas")) {
                    christmas = true;
                }
                if (hat.equalsIgnoreCase("halloween")) {
                    halloween = true;
                } else if (hat.equalsIgnoreCase("birthday")) {
                    birthday = true;
                    if (hatData.getUsername().equalsIgnoreCase("manmaed")) {
                        LogHelper.fatal("Please inform manmaed of this error: Happy Birthday!");
                    } else {
                        LogHelper.info("Happy Birthday " + hatData.getUsername());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setHat(String hat) {
        birthday = false;
        christmas = false;
        halloween = false;
        loneztar = false;
        if (hat.equalsIgnoreCase("halloween")) {
            halloween = true;
        }
        if (hat.equalsIgnoreCase("christmas")) {
            christmas = true;
        }
        if (hat.equalsIgnoreCase("birthday")) {
            birthday = true;
        }
        if (hat.equalsIgnoreCase("none")) {
            birthday = false;
            christmas = false;
            halloween = false;
        }
    }

}
