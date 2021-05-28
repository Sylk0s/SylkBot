package SylkBot.Commands;

import SylkBot.Main;
import SylkBot.Permissons.PermType;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public abstract class Command extends ListenerAdapter {

    public abstract String getHelpInfo();
    public abstract String getTrigger();
    public abstract PermType getPermLevel();
    public abstract void run(String[] args, GuildMessageReceivedEvent event);

    //todo add in perms?

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Main.prefix + this.getTrigger())) {
            run(args, event);
        }
    }
}