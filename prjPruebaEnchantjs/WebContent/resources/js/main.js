// 1 - Start enchant.js
enchant();
 
// 2 - On document load 
window.onload = function() {
	 	enchant(); // initialize
	    var game = new Core(320, 320); // game stage
	    game.preload('resources/img/chara1.png'); // preload image
	    game.fps = 20;

	    game.onload = function(){
	        var bear = new Sprite(32, 32);
	        bear.image = game.assets['resources/img/chara1.png'];
	        game.rootScene.addChild(bear);
	        bear.frame = [6, 6, 7, 7];   // select sprite frame
	        
	        bear.tl.moveBy(288, 0, 90)   // move right
	            .scaleTo(-1, 1, 10)      // turn left
	            .moveBy(-288, 0, 90)     // move left
	            .scaleTo(1, 1, 10)       // turn right
	            .loop();                 // loop it
	    };

	    game.start(); // start your game!
};