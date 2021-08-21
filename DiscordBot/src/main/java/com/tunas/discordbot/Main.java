package com.tunas.discordbot;

import com.tunas.discordbot.events.MessageListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args){
        JDABuilder jdaBuilder = JDABuilder.createDefault("ODc4NTE5MjQ4Mzc5NTgwNDU4.YSCWzg.RKQ5JQXWbLFMjpm-cTOKsbdISH4"); //this is the token of the bot.
        jdaBuilder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        jdaBuilder.setActivity(Activity.playing("Minecraft"));

        jdaBuilder.addEventListeners(new MessageListener());

        try{
            jdaBuilder.build();
        } catch (LoginException exception){
            exception.printStackTrace();
        }
    }
}
