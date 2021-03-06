package club.deneb.client.command.commands;

import club.deneb.client.Deneb;
import club.deneb.client.utils.ChatUtil;
import club.deneb.client.utils.Utils;
import club.deneb.client.command.Command;

/**
 * Created by killRED on 2020
 * Updated by B_312 on 01/15/21
 */
@Command.Info(command = "prefix", description = "Set command prefix.")
public class Prefix extends Command {

    @Override
    public void onCall(String s, String[] args) {
        if (args.length <= 0) {
            ChatUtil.sendNoSpamErrorMessage("Please specify a new prefix!");
            return;
        }
        if (args[0] != null) {
            Deneb.getINSTANCE().getCommandManager().setCmdPrefix(args[0]);
            ChatUtil.sendNoSpamMessage("Prefix set to " + ChatUtil.SECTIONSIGN + "b" + args[0] + "!");
            Utils.playAnvilHit();
        }
    }

    @Override
    public String getSyntax() {
        return "prefix <char>";
    }

}
