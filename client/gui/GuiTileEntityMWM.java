package com.puppydemon.MoreWithersMod.client.gui;

import org.lwjgl.opengl.GL11;

import com.puppydemon.MoreWithersMod.guicontainer.ContainerTileEntityMWM;
import com.puppydemon.MoreWithersMod.tileentity.TileEntityMWM;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiTileEntityMWM extends GuiContainer
{
	private IInventory playerInv;
	private TileEntityMWM te;
	public String GuiName;
	
	public GuiTileEntityMWM(IInventory playerInv, TileEntityMWM te)
	{
	    super(new ContainerTileEntityMWM(playerInv, te));

	    this.playerInv = playerInv;
	    this.te = te;

	    this.xSize = 176;
	    this.ySize = 166;
	}
	public GuiTileEntityMWM(ContainerTileEntityMWM containerTileEntityMWM)
	{
		super(containerTileEntityMWM);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.mc.getTextureManager().bindTexture(new ResourceLocation("tutorial:textures/gui/container/GuiTemplate.png"));
	    this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	    String s = this.GuiName;
	    this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //#404040
	    this.fontRendererObj.drawString(this.GuiName, 8, 72, 4210752);      //#404040
	}
}
