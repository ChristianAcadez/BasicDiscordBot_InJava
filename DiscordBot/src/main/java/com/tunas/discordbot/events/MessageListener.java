package com.tunas.discordbot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        //This part send a message to the chat if the message starts with ;p with a copy of the text.
        String[] arguments = event.getMessage().getContentRaw().split(" ");
        if(arguments[0].equals(";p")) {
            String message = event.getMessage().getContentRaw().replace(";p", " ");
            event.getChannel().sendMessage(message).queue();
        }
        //This part Reply to a message if the message is Hola.
        String message1 = event.getMessage().getContentRaw();
        if(message1.equals("Hola")){
            event.getMessage().reply("Poco importa el camino que elijas si no sabes hacia donde te diriges.").queue();
        }
        //This part first check if the message wasn't from the bot, and send an embed message to the chat.
        if(!event.getAuthor().isBot()){
            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setColor(0x6A1B4D);
            embedBuilder.setTitle("Christian_ACH");
            embedBuilder.setDescription("We are making a Bot with Java");
            embedBuilder.setImage("https://p4.wallpaperbetter.com/wallpaper/760/459/710/aoi-ogata-anime-girls-wallpaper-preview.jpg");
            embedBuilder.setFooter("THE GAME");
            embedBuilder.setTimestamp(Instant.now());
            embedBuilder.setThumbnail("https://p4.wallpaperbetter.com/wallpaper/115/284/991/anime-girls-anime-kyrie-meii-wallpaper-preview.jpg");

            event.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
        }
    }
}
