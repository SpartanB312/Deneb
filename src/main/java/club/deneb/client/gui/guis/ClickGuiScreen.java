package club.deneb.client.gui.guis;

import club.deneb.client.client.GuiManager;
import club.deneb.client.features.ModuleManager;
import club.deneb.client.Deneb;
import club.deneb.client.gui.component.ActionButton;
import club.deneb.client.utils.Wrapper;
import club.deneb.client.utils.particles.ParticleSystem;
import club.deneb.client.value.ButtonValue;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

/**
 * Created by B_312 on 01/10/21
 */
public class ClickGuiScreen extends GuiScreen {


    private final ParticleSystem particleSystem = new ParticleSystem(100);

    public static ActionButton actionButton;

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void initGui() {

        if (GuiManager.getINSTANCE().getBackground().equals(GuiManager.Background.Blur) || GuiManager.getINSTANCE().getBackground().equals(GuiManager.Background.Both)) {
            if(Wrapper.getMinecraft().entityRenderer.getShaderGroup() != null) {
                Wrapper.getMinecraft().entityRenderer.getShaderGroup().deleteShaderGroup();
            }
            Wrapper.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
    }


    @Override
    public void onGuiClosed() {
        if(Wrapper.getMinecraft().entityRenderer.getShaderGroup() != null) {
            Wrapper.getMinecraft().entityRenderer.getShaderGroup().deleteShaderGroup();
        }
        if (ModuleManager.getModuleByName("ClickGUI").isEnabled()) {
            ModuleManager.getModuleByName("ClickGUI").disable();
        }
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (GuiManager.getINSTANCE().getBackground().equals(GuiManager.Background.Shadow) || GuiManager.getINSTANCE().getBackground().equals(GuiManager.Background.Both)) {
            drawDefaultBackground();
        }
        if(mc.player == null) Gui.drawRect(0,0,9999,9999,new Color(0,0,0,255).getRGB());
        if (GuiManager.getINSTANCE().isParticle()) {
            particleSystem.tick(10);
            particleSystem.render();
        }

        Deneb.getINSTANCE().getGuiRender().drawScreen( mouseX,  mouseY,  partialTicks);

        if(actionButton !=null){
            actionButton.runRender(mouseX,mouseY);
            actionButton = null;
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        Deneb.getINSTANCE().getGuiRender(). mouseClicked( mouseX,  mouseY,  mouseButton);
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        Deneb.getINSTANCE().getGuiRender().keyTyped( typedChar,  keyCode);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        Deneb.getINSTANCE().getGuiRender().mouseReleased( mouseX,  mouseY,  state);
    }
}
