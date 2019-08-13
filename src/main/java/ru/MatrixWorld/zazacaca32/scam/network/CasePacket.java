package ru.MatrixWorld.zazacaca32.scam.network;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class CasePacket implements IMessage {

    private String text;

    public CasePacket() {

    }

    public CasePacket(String text) {
        this.text = text;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        text = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, text);
    }

    public static class Handler implements IMessageHandler<CasePacket, IMessage> {

        @Override
        public IMessage onMessage(CasePacket message, MessageContext ctx) {
            FMLLog.getLogger().info(message.text);
            return null;
        }
    }
}
