package com.wingsinus.cocos2d.spriteMethod;

import java.util.logging.Level;

import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.ccColor4B;
import org.cocos2d.types.ccVertex2F;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.pooling.arrays.Vec2Array;

import android.util.Log;
import android.view.MotionEvent;

public class SpriteScene extends CCLayer{
//	protected ArrayList<CCSprite> _targets;
//	protected ArrayList<CCSprite> _projectiles;
//	protected int _projectilesDestroyed;
	protected float PTM_RATIO = 32.0f;
	
	public static CCScene scene()
	{	
		CCScene scene = CCScene.node();
		CCLayer layer = new SpriteScene();
		//CCLayer backgroudLayer = new TiledTest();
		
		//scene.addChild(backgroudLayer);
		scene.addChild(layer);
		
		return scene;
	}
	
	protected SpriteScene()
	{
		//super(color);
		
		//touch on
		this.setIsTouchEnabled(true);
		//removeChild(player, true);
		
		
		SwSpriteCharacterAnimation swanimate = new SwSpriteCharacterAnimation();
		
		
		
		
		/****************animation*****************/
		
		//swanimate.playerIndex = 1;
		//snow_w animation create _ index 0
//		swanimate.playerSpriteList.add(swanimate.characterAnimate("snow_w.png", 6, 0.2f));
		//snow_w sprite add to layer
//		addChild(swanimate.playerSpriteList.get(0));
		//snow_w animation run
//		swanimate.characterActionStart(swanimate.playerSpriteList.get(0), swanimate.playerAnimateList.get(0));
		
		
		
		
		//kang2_a animation play _ index 1
//		swanimate.playerSpriteList.add(
//				swanimate.characterAnimate("kang2_a.png", 4, 0.2f));
//		addChild(swanimate.playerSpriteList.get(1));
//		swanimate.characterActionStart(swanimate.playerSpriteList.get(1), swanimate.playerAnimateList.get(1));

		/******************************************/
		
		//land tile sprite add to layer
		CCSprite spriteTile = swanimate.tileMapSprite("land_03.png");
		
		addChild(spriteTile);
//		
		Log.i("anchorpointinpixcels", "width = " + spriteTile.getContentSize().width);
		Log.i("anchorpointinpixcels", "height = " + spriteTile.getContentSize().height);
		Log.i("anchorpointinpixcels", "x = " + spriteTile.getAnchorPointInPixels().x);
//		Log.i("touchbegan", "start");
//		Vec2 gravity = new Vec2(0.0f, -10.0f);
//		boolean doSleep = true;
//		World world = new World(gravity, doSleep);
//		
//		Log.i("touchbegan", "create world");
//		
//		BodyDef groundbodyDef = new BodyDef();
//		groundbodyDef.position.set(70 / 2, 100 / 2);
//		Body groundBody = world.createBody(groundbodyDef);
//		Log.i("touchbegan", "set def");
		
		//tool cutting
		//row 1, col 1
		int num = 15;
		Vec2[] verts = {
		    new Vec2(-3.0f / PTM_RATIO, -22.5f / PTM_RATIO),
		    new Vec2(-22.0f / PTM_RATIO, -13.5f / PTM_RATIO),
		    new Vec2(-31.0f / PTM_RATIO, -7.5f / PTM_RATIO),
		    new Vec2(-32.0f / PTM_RATIO, -6.5f / PTM_RATIO),
		    new Vec2(-31.0f / PTM_RATIO, 4.5f / PTM_RATIO),
		    new Vec2(-29.0f / PTM_RATIO, 6.5f / PTM_RATIO),
		    new Vec2(-2.0f / PTM_RATIO, 20.5f / PTM_RATIO),
		    new Vec2(2.0f / PTM_RATIO, 20.5f / PTM_RATIO),
		    new Vec2(29.0f / PTM_RATIO, 6.5f / PTM_RATIO),
		    new Vec2(30.0f / PTM_RATIO, 5.5f / PTM_RATIO),
		    new Vec2(31.0f / PTM_RATIO, 1.5f / PTM_RATIO),
		    new Vec2(31.0f / PTM_RATIO, -6.5f / PTM_RATIO),
		    new Vec2(30.0f / PTM_RATIO, -8.5f / PTM_RATIO),
		    new Vec2(27.0f / PTM_RATIO, -11.5f / PTM_RATIO),
		    new Vec2(1.0f / PTM_RATIO, -22.5f / PTM_RATIO)
		};
		
//		verts[0].equals(verts);
		
			//not auto
			//row 1, col 1
//				int num = 7;
//				Vec2[] verts = {
//					new Vec2(-29.9f / PTM_RATIO, 5.6f / PTM_RATIO),
//					new Vec2(-29.9f / PTM_RATIO, -6.6f / PTM_RATIO),
//					new Vec2(-0.2f / PTM_RATIO, -21.1f / PTM_RATIO),
//					new Vec2(30.2f / PTM_RATIO, -8.9f / PTM_RATIO),
//					new Vec2(30.6f / PTM_RATIO, 6.1f / PTM_RATIO),
//					new Vec2(0.0f / PTM_RATIO, 21.7f / PTM_RATIO),
//					new Vec2(-29.9f / PTM_RATIO, 5.9f / PTM_RATIO)
//				};
		//spriteShape.Set(verts, num);
		
		
//		PolygonShape spriteShadow = new PolygonShape();
//		Log.i("touchbegan", "create polygon");
//		
//		spriteShadow.setAsBox(70 / PTM_RATIO / 2
//				, 100 / PTM_RATIO / 2);
//		Log.i("touchbegan", "set as box");
//		
//		spriteShadow.set(verts, num);
//		Log.i("touchbegan", "polygon set verts");
		//swanimate.addBoxBodyForSprite(SpriteTile);
	}
	
	
	CCNode objectMoveNode = null;
	
	public boolean ccTouchesBegan(MotionEvent event){
		
		//Choose one of the touches to work with
		CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(
				event.getX()
				, event.getY()));
		
		
		/*spriteShape.SetAsBox(sprite.contentSize.width/PTM_RATIO/2,
        sprite.contentSize.height/PTM_RATIO/2);*/
		
		/////////////////
		Log.i("mouse Point", "x = " + location.x / 32 / 2 + ", y = " + location.y);
		
		
		
		return CCTouchDispatcher.kEventHandled;
	}
	
	public boolean ccTouchesMoved(MotionEvent event){
		//Choose one of the touches to work with
		CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(
				event.getX()
				, event.getY()));

		return CCTouchDispatcher.kEventHandled;
	}
	
	public boolean ccTouchesEnded(MotionEvent event){
		//Choose one of the touches to work with
		CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(
				event.getX()
				, event.getY()));
				
		return CCTouchDispatcher.kEventHandled;
	}
}
