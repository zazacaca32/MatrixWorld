package ru.MatrixWorld.zazacaca32.scam.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import ru.MatrixWorld.zazacaca32.scam.tile.TileEntityMyMacerator;


public class CommonProxy {
    public void preInit() {

    }

    public void init() {
        GameRegistry.registerTileEntity(TileEntityMyMacerator.class, TileEntityMyMacerator.name);
//        GameRegistry.registerTileEntity(TileEntityStorage.class,TileEntityStorage.name);
    }
}
