#Creates a Main Menu Page

MainMenu Image

<img src="C:\Users\User\eclipse-workspace\COMP2042_CW_sayjl12\Images\MainMenu.jpg" alt="drawing" width="400"/>

The main menu page consists of start game button which lead to the game page, how to play button which shows the information of the game and an exit button. Main Menu page created in another java class independently. The start game button will change the stage of the screen to the game page. In the meanwhile, how to play button will show a subscene of the screen and display the information of the game. All these buttons contain a set of function including design and sound effect.  

**see MainMenu.java**

# Screenshot of Game
Level 1 Game Image

<img src="C:\Users\User\eclipse-workspace\COMP2042_CW_sayjl12\Images\GamePage.jpg" alt="drawing" width="400"/> 

####Add background image
A background image is added to the game page. 

**see Main.java line 497-498**
#### Pause Button
Pause button will pause the game and shows a list of function which the player could view the information of the game, high score of past records and exit the game. 

**see Main.java line 68-69, 71, 510, line 87-190, 293-325**
#### New sprite and changes on sprite
Moreover, a bunch of new sprites is added such as a female frog, bugs and crocodile which each of the sprite play different roles to the game. A new set of obstacles and turtle are added as well, new type of obtacles are added to make the game more interesting whereas the turtle images are changed to png file with transparent background.

**see Bug.java, Crocodile.java, CrocodileHead.java, FemaleFrog.java, Snake.java**<br>
**see Animal.java line 153-178, 208-235, 242-253, 258-267, 280-287**<br>
**see Turtle.java line 57-67**<br>
**see WetTurtle.java line 64-76**<br>
**see Level.java line 125, 161, 163**<br>
#### High Score List
A permanent high score subscene is added to the game, player can always check on it in pause button in game page. A new high score list will also display after the player insert their name.

**see Main.java line 71, 178-215, 319-325, 366-371**<br>
**see Score.java**<br>
**see ScoreComparator.java**<br>
**see ScoreManager.java**<br>
#### Frog's House
The pictures are changed to transparent pictures and merge to the game pictures. Occupied house will not allow to enter. The barrier between the house will not allow the frog to jump through it.

**see End.java line 33, 41**<br>
**see Animal.java line 124, 277-278, 321-366**
#### Additional Levels
Ten levels of the game is created with different speed and number of sprite in each level.

**see Main.java line 64, 457-491**<br>
**see Level.java**<br>
#### Frog's lives
Each level consists of 3 frog lives, finishing all 3 lives will lead to game over.

**see Main.java 392-450, 511-521**<br>
**see Animal.java 142-143, 168-169, 197-198, 226-227, 375-377, 420-427**<br>
**see Lives.java**<br>
#### Countdown Timer
Countdown is created to make the game more challenging. Each level will have 30 seconds, every time the frog enter one house, the timer will reset, if the frog does not make it on time, one frog live will be deducted.

**see Main.java line 47, 99, 105, 389-391, 508, 528**<br>
**see Animal.java line 297, 406-413**<br>
**see Countdown.java**<br>
## Screen of the Game
A screen size is fixed in 600*650. Thus in the animal class, the movement range and the location of the frog including all the sprites are changed.

**see MainMenu.java line 34, 39-40**<br>
**see Animal.java line 19-20, 34-35, 144-145, 170-171, 199-200, 228-229, 295-296, 311-320**<br>
**see Level.java**<br>

