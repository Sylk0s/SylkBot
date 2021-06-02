package SylkBot.Commands.Minecraft;

import SylkBot.Commands.Command;
import SylkBot.Commands.Permissons.PermType;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.shanerx.mojang.Mojang;

public class UUID extends Command {

    @Override
    public String getHelpInfo() {
        return "Input player name and this command will give the UUID";
    }

    @Override
    public String getTrigger() {
        return "uuid";
    }

    @Override
    public PermType getPermLevel() {
        return PermType.EVERYONE;
    }

    @Override
    public boolean hasNoArgs() { return false; }

    @Override
    public void run(String[] args, GuildMessageReceivedEvent event) {
        Mojang api = new Mojang().connect();
        event.getChannel().sendMessage(api.getUUIDOfUsername(args[1])).queue();
    }
}
