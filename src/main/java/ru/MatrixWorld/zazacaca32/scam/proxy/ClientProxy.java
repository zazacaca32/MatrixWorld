package ru.MatrixWorld.zazacaca32.scam.proxy;

import net.minecraftforge.common.MinecraftForge;
import ru.MatrixWorld.zazacaca32.scam.network.EventHandler;

public class ClientProxy extends CommonProxy {
    public void preInit() {

    }

    public void init() {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
