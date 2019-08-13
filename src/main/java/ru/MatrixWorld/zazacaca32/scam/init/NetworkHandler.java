package ru.MatrixWorld.zazacaca32.scam.init;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import ru.MatrixWorld.zazacaca32.scam.lib.Constants;
import ru.MatrixWorld.zazacaca32.scam.network.CasePacket;

public class NetworkHandler {
    public static void init() {
        NetworkRegistry.INSTANCE.newSimpleChannel(Constants.ModID_small+"_CaseChanel").registerMessage(CasePacket.Handler.class, CasePacket.class, 0, Side.CLIENT);
    }
}
