# RoyalConflict
Repo for team: rEach 4 help

# Description
RoyalConflict is a class team project developed to simulate the card game War. 
The app currently has four functioning pages: the main menu page, the rules page, the play page, and the credits page.  The main menu page allows users to go to the rules, play, or credits page.  The rules page tells the rules of the card game of war.  The play page allows the user to play the card game of war.  Lastly, the credits page displays the team members who developed the Royal Conflict application.

# Cloning / Importing 
To clone in the GitHub Desktop App: git clone https://github.com/UTSA-CS-3443/RoyalConflict.git 

To Import the file directly to Eclipse: 
- Open the RoyalConflict github page (https://github.com/UTSA-CS-3443/RoyalConflict)
     - Click the green "Code" button
     - Select the HTTPS option, then click the nested boxes after the URL to copy the provided URL(https://github.com/UTSA-CS-3443/RoyalConflict.git) to your clipboard
- Open the Eclipse Import wizard (e.g. File => Import)
- *Select:* 
     - select Git => Projects from Git
     - Click Next
- *Select Repository Source:* 
     - Select “Clone URI”
     - Click Next
- *Source Git Repository:*
     - Update the repository’s location by pasting the URL previously copied
          - The URI field should auto-populate the URI from your clipboard, but if it doesn’t you can paste it in now  
          - Some of the other fields will also auto-populate 
     - Click Next
- *Branch Selection:*  
     - Deselect “main” but leave “master” checked
     - Click Next
- *Local Destination:* 
     - Update the Directory where you want to store the file
     - Click Next
     - The file will now do its cloning
- *Select a wizard to use for importing projects:*
     - Pick “Import existing Eclipse projects”
     - Click Next
- *Import Projects:*
     - Click Finish

# Running
Royal Conflict is now loaded in your Eclipse Package Explorer as “War” and ready to run. 
- Open the War folder by double clicking it
- Double click the War folder to open it
- To Begin the program you can use any of the following three methods:
     - 1) First Method:
          - Simultaneously Press “Ctrl + F11” keys 
     - 2) Second Method: 
          - Go to the top of the page, click “Run”
          - Select “Run As => Java Application”
     - 3) Third Method:
          - Navigate to src/application/Main 
          - Right click the Main.java file
          - Select “Run As => 2 Java Application”
-	Enjoy your game 😊 

# Known Bugs
- When clicking the deck to start the game, click on the top half of the deck (known issue).  If the bottom half is clicked, there is a Label GUI element blocking the deck from being clicked on. 
- During game play, the player can click on theirs or the Computer’s cards, either stack or Deck, to Draw a Card.  This has no negative impacts on game play.

# Requirements and Compatibility
This app was coded with Java 9 and Scenebuilder 2.0. We recommend compiling with Java 9.  If there are compiler/IDE issues after import, confirm your clone has the correct build path, compiler settings, and libraries in the ClassPath. \
\
Tools used:
- SceneBuilder 2.0
- Eclipse IDE
- Java SE-9
- JavaFX 
 
# Copyright and Legal disclaimer
This app is a project in an educational environment.  It is not being shared, offered, sold for profit, or provided for any purpose other than grading/evaluation and other personal learning modalities. \
\
Image Credits:
- Playing card images: https://code.google.com/archive/p/vector-playing-cards/downloads
