package SylkBot.Commands.Core;

import SylkBot.Commands.Command;
import SylkBot.Main;

import SylkBot.Permissons.PermType;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Info extends Command {

    @Override
    public String getTrigger() {
        return "info";
    }

    @Override
    public String getHelpInfo() {
        return Main.prefix + this.getTrigger() + " Use to get info about the bot\n";
    }

    @Override
    public PermType getPermLevel() {
        return PermType.BANNED;
    }

    @Override
    public void run(String[] args, GuildMessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("SylkBot Info");
        info.setDescription("Info about SylkBot! \n" +
                "Use .help to learn about the commands this bot can do. \n" +
                "TBD"); //TODO Write this info command
        info.setColor(0xff97cb);
        info.setFooter("Created by Sylkos", event.getMember().getUser().getAvatarUrl());

        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
        info.clear();
    }
}