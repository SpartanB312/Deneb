package club.deneb.client.gui.component;

import club.deneb.client.gui.Panel;
import club.deneb.client.utils.ColorUtil;
import club.deneb.client.utils.Utils;
import club.deneb.client.value.ModeValue;
import net.minecraft.client.gui.Gui;

import java.awt.*;

import static club.deneb.client.utils.LambdaUtil.isHovered;

/**
 * Created by B_312 on 01/10/21
 */
public class ModeButton extends ValueButton<ModeValue.Mode> {

    public ModeButton(ModeValue value, int width, int height, Panel father) {
        this.width = width;
        this.height = height;
        this.father = father;
        this.setValue(value);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {

        int fontColor = 0x909090;

        //Background
        Gui.drawRect(x, y, x + width, y + height, 0x85000000);

        //Mode Name
        font.drawString(getAsModeValue().getName(), x + 3, (int) (y + height / 2 - font.getHeight() / 2f ) + 2, ColorUtil.getHoovered(new Color(255,255,255).getRGB(), isHovered(mouseX, mouseY).test(this)));

        //Mode Value
        font.drawString(getAsModeValue().getToggledMode().getName(),
                x + width - 1 - font.getStringWidth(getAsModeValue().getToggledMode().getName()), (int) (y + height / 2 - font.getHeight() / 2f ) + 2,
                ColorUtil.getHoovered(fontColor, isHovered(mouseX, mouseY).test(this)));
    }

    @Override
    public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (!isHovered(mouseX, mouseY).test(this) || !getValue().visible()) return false;
        if (mouseButton == 0) {
            getAsModeValue().forwardLoop();
            Utils.playButtonClick();
        }
        return true;
    }
}
