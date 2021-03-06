package club.deneb.client.features.modules.client;

import club.deneb.client.gui.guis.ClickGuiScreen;
import club.deneb.client.client.ConfigManager;
import club.deneb.client.features.Category;
import club.deneb.client.features.Module;
import org.lwjgl.input.Keyboard;

@Module.Info(name = "ClickGUI",category = Category.CLIENT,keyCode = Keyboard.KEY_I,visible = false)
public class ClickGui extends Module {
    public static ClickGui INSTANCE;

    @Override
    public void onInit(){
        INSTANCE = this;
    }

    ClickGuiScreen screen;

    @Override
    public void onEnable() {
        if (screen == null){
            setGUIScreen(new ClickGuiScreen());
        }
        if (mc.player != null){
            if (!(mc.currentScreen instanceof ClickGuiScreen)) {
                mc.displayGuiScreen(screen);
            }
        }
    }

    @Override
    public void onDisable() {
        if (mc.currentScreen != null && mc.currentScreen instanceof ClickGuiScreen) {
            mc.displayGuiScreen(null);
        }
        ConfigManager.saveAll();
    }

    private void setGUIScreen(ClickGuiScreen screen){
        this.screen = screen;
    }

}
