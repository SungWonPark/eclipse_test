package com.wingsinus.cocos2d.spriteMethod;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCTMXLayer;
import org.cocos2d.layers.CCTMXTiledMap;

import org.cocos2d.nodes.CCTileMapAtlas;
import org.cocos2d.types.ccColor4B;

public class TiledTest extends CCLayer{
	protected TiledTest(){
		CCTMXTiledMap tileMap;
		CCTMXLayer backgroudLayer;
		
		tileMap = CCTMXTiledMap.tiledMap("tiled_test.tmx");
		backgroudLayer = tileMap.layerNamed("backgroudLayer");
		addChild(tileMap);
	}
}
