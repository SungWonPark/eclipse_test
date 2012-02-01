package com.wingsinus.cocos2d.spriteMethod;

import java.util.ArrayList;

import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGSize;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import android.graphics.BitmapFactory;
import android.util.Log;

public class SwSpriteCharacterAnimation{
	
	protected int playerIndex;
	protected ArrayList<CCSprite> playerSpriteList = new ArrayList<CCSprite>();
	protected ArrayList<CCAnimate> playerAnimateList = new ArrayList<CCAnimate>();
	
	//protected CCSprite[] playerSprite = new CCSprite[100];
	//protected CCAnimate[] playerAnimate = new CCAnimate[100];
	
	/** Get Bitmap's Width **/
	public static int getBitmapOfWidth( String fileName ){
	   try {
	       BitmapFactory.Options options = new BitmapFactory.Options();
	       options.inJustDecodeBounds = true;
	       BitmapFactory.decodeFile(fileName, options);
	       return options.outWidth;
	   } catch(Exception e) {
	   return 0;
	   }
	}
	 
	 /** Get Bitmap's height **/
	public static int getBitmapOfHeight( String fileName ){
	  
	   try {
	       BitmapFactory.Options options = new BitmapFactory.Options();
	       options.inJustDecodeBounds = true;
	       BitmapFactory.decodeFile(fileName, options);
	  	   return options.outHeight;
	   } catch(Exception e) {
		   return 0;
	   }
	}
	
//	void addBoxBodyForSprite(CCSprite sprite){
//		BodyDef spriteBodyDef = new BodyDef();
//		
//		spriteBodyDef.type = BodyType.DYNAMIC;
//		Log.i("addbox", "type");
//		spriteBodyDef.position.set(sprite.getPosition().x / PTM_RATIO
//				, sprite.getPosition().y / PTM_RATIO);
//		spriteBodyDef.userData = sprite;
//		Log.i("addbox", "userdata");
//		Body spriteBody = _world.createBody(spriteBodyDef);
//		
//		PolygonShape spriteShape = new PolygonShape();
//		Log.i("addbox", "createpolygon");
//		spriteShape.setAsBox(sprite.getContentSize().width / PTM_RATIO / 2
//				, sprite.getContentSize().height / PTM_RATIO / 2);
//		Log.i("addbox", "setasbox");
//		FixtureDef spriteShapeDef = new FixtureDef();
//		spriteShapeDef.shape = spriteShape;
//		spriteShapeDef.density = 10.0f;
//		spriteShapeDef.isSensor = true;
//		spriteBody.createFixture(spriteShapeDef);
//	}
	
	public CCSprite tileMapSprite(String fileName){
		//texture input image
		CCTexture2D playerTex = CCTextureCache.sharedTextureCache().addImage(fileName);
		
		float fileWidth = playerTex.getWidth();
		float fileHeight = playerTex.getHeight();
		
//		Log.i("tag", "width = " + fileWidth);
//		Log.i("tag", "height = " + fileHeight);
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		//CCSprite player = CCSprite.sprite("snow_w.png");
		CCSprite player = CCSprite.sprite(fileName, 
				CGRect.make(0, 0, fileWidth, fileHeight));
				
		player.setPosition(CGPoint.ccp(winSize.width / 2.0f + 50.0f
				, winSize.height / 2.0f + 50.0f));

		
		return player;
	}
	
	public CCSprite characterAnimate(String fileName, int fileFrame, float filePerFrame){
		//texture input image
		CCTexture2D playerTex = CCTextureCache.sharedTextureCache().addImage(fileName);
		
		float fileWidth = playerTex.getWidth();
		float fileHeight = playerTex.getHeight();
		
//		Log.i("tag", "width = " + fileWidth);
//		Log.i("tag", "height = " + fileHeight);
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		//CCSprite player = CCSprite.sprite("snow_w.png");
		CCSprite player = CCSprite.sprite(fileName, 
				CGRect.make(0, 0, fileWidth/fileFrame, fileHeight));
				
		player.setPosition(CGPoint.ccp(winSize.width / 2.0f, winSize.height / 2.0f));
		
		int i;
		
//		if(getChild(fileTag) == null){
		//	insertLayer.addChild(player);
//		}
		
		//create animation fileName + '_animate'
		CCAnimation playerWalk = CCAnimation.animation(fileName+"_animate", 0.0f);
	
		//spriteframe input texture
		for(i=0; i<fileWidth; i+=(fileWidth/fileFrame)){
			CCSpriteFrame playerFrame = CCSpriteFrame.frame(playerTex,
			CGRect.make(i, 0, fileWidth/fileFrame, fileHeight),
			CGPoint.ccp(0.0f, 0.0f));
		
			//animation add spriteframe
			playerWalk.addFrame(playerFrame);
		}
		
		//return CCAnimate.action(fileFrame/filePerFrame, playerWalk, false);
		playerAnimateList.add(
				CCAnimate.action(fileFrame * filePerFrame, playerWalk, false));
		//playerIndex++;
		return player;
	}
	
	public void characterActionStart(CCNode character, CCAnimate characterAnimate){
		
		CCRepeatForever walkRepeat = CCRepeatForever.action(characterAnimate);
		character.runAction(walkRepeat);
	}
	
	public void characterRemove(){
		
	}
}
