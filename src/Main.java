import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import character.AgilityMonster;
import character.IntelligenceMonster;
import character.Karakter;
import character.Monster;
import character.MonsterGenerator;
import character.StrengthMonster;
import model.AgilityType;
import model.IntelligenceType;
import model.StrenghtType;
import model.UserTurn;
import models.BoughtList;
import models.BoughtListPrint;
import models.DefensiveItem;
import models.Item;
import models.ItemReader;
import models.OffensiveItem;
import models.SpellItem;

public class Main {
	
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	boolean penentuan=false;
	public static int row=300;
	public static int col=300;
	char[][] map = new char[row][col];
	int totalCoin=100;
	int exit=0;
	
	private String username;
	private int health;
	private int money;
	private int mana;
	private int damage;
	
	char[][] pattern1 = {
			{'V',' ','V'},
			{'v', 'V', 'v'},
			{'v', 'v', 'V'}
	};
	
	char[][] pattern2 = {
			{'#',' ','#'},
			{'#', '#', '#'},
			{' ', '#', ' '}
	};
	
	char[][] pattern3 = {
			{'V',' ',' '},
			{'v', ' ', 'V'},
			{'V', 'V', 'V'}
	};
	
	char[][] pattern4 = {
			{'#','#','#'},
			{'#', '#', ' '},
			{' ', '#', ' '}
	};
	
	char[][] pattern5 = {
			{'v',' ','V'},
			{'V', ' ', ' '},
			{'v', 'v', ' '}
	};
	
	char[][] pattern6 = {
			{'v',' ','V'},
			{' ', ' ', ' '},
			{'v', 'v', ' '}
	};
	
	char[][] pattern7 = {
			{' ',' ',' '},
			{' ', ' ', ' '},
			{' ', ' ', ' '}
	};
	
	
	int yKamera=15;
	int xKamera=35;
	
	int yPos=100;
	int xPos=100; //1,1
	//p +- size/2, p titik si xpos
	
	final char wall ='#';
	final char coin ='0';
	final char grass ='V';
	public boolean validMove=false;
	
	List<Item> items = new ArrayList<>();
	List<BoughtList> boughtList ;
	ItemReader bought=new ItemReader();
	ItemReader itemReader = new ItemReader();
	
	
    public Main() {
       

        System.out.println("Welcome To DOTW");
        System.out.println("Enter to continue");
        scan.nextLine(); 

        int choice = 0;
        while (choice != 3) {
        	exit=0;
            System.out.println("\nMenu:");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("3. Log Out");
            System.out.println("Choose an option:");


            choice = scan.nextInt();
            scan.nextLine(); 


            switch (choice) {
                case 1:
                    System.out.println("You chose: Log In");
                    loginUser();
                    int gameChoice=0;
                    if(penentuan) {
                    	do {
                    		gamePage();
                    		gameChoice=scan.nextInt();scan.nextLine();
                    		
                    		switch (gameChoice) {
							case 1:
								generateMap(map);
								int apalah=0;
								while(apalah==0) {
									printCamera();
									move();
									if(exit==1) {
										break;
									}
									if(apalah==1) {
										break;
									}
								}
								
								break;
								
							case 2:
								gameGuide();
								break;
							case 3:
								System.out.println("Redirecting you to login page...");
								break;
							default:
								System.out.println("Please enter between 1-3");
								System.out.println("Press enter to continue");
								scan.nextLine();
								break;
							}
                    		
                    	}while(gameChoice!=3);
                    	
                    	
                    }
                    break;
                case 2:
                    System.out.println("You chose: Register");
                    registerUser();
                    break;
                case 3:
                    System.out.println("You chose: Log Out");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                    System.out.println("Press Enter to Continue");
                    scan.nextLine();
                    break;
            }
        }

        scan.close();
    }
    
    private void registerUser() {
        String email1 = "";
        String password = "";
        
        System.out.println("Input 'Exit' to Quit From Menu");
        while (true) {
            System.out.println("Please enter your new email:");
            email1 = scan.nextLine();
            
            if (email1.equalsIgnoreCase("Exit")) {
                System.out.println("Redirecting to the Login Menu.");
                return;
            }

            if (!isValidEmail(email1)) {
                System.out.println("Error: Invalid email format. The email must contain '@' and '.' after '@'.");
                continue;
            }
            break; 
        }
        
        while (true) {
            System.out.println("Please enter your new password:");
            password = scan.nextLine();

            if (password.equalsIgnoreCase("Exit")) {
                System.out.println("Redirecting to the Login Menu.");
                return;
            }
            if (password.length() < 8 || password.length() > 30) {
                System.out.println("Error: Password length must be between 8 and 30 characters.");
                continue;
            }
            break; 
        }


        registerUserToFile(email1, password);
        System.out.println("Registration successful! You can now log in.");
        System.out.println("Enter to back");
        scan.nextLine();
    }

    private boolean isValidEmail(String email) {

        if (email.indexOf('@') < 1 || email.indexOf('@') == email.length() - 1) {
            return false;
        }


        if (email.indexOf('.', email.indexOf('@')) == -1) {
            return false;
        }

        return true;
    }


    private void registerUserToFile(String email, String password) {
        String fileName = "credentials.txt";
        int health1=300;
        int money1=100;
        int mana1=30;
        int basedamage1=30;
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) {
            br.write(email + "," + password + "," + health1 + "," + money1 + "," + mana1 + "," + basedamage1 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loginUser() {
        while (!penentuan) {
            System.out.println("Please enter your email:");
             String email = scan.nextLine();
            if (email.equalsIgnoreCase("Exit")) {
                System.out.println("Redirecting to the Login Menu.");
                return;
            }
            

            System.out.println("Please enter your password:");
            String password = scan.nextLine();
            
            if (password.equalsIgnoreCase("Exit")) {
                System.out.println("Redirecting to the Login Menu.");
                return;
            }


            if (isValidCredentials(email, password)) {
                System.out.println("Login successful! Redirecting to the Game Menu.");
                penentuan=true;
                
                
            } else {
                System.out.println("Incorrect credentials! Please try again.");
            }
        }
    }

    
    private boolean isValidCredentials(String emailInput, String passwordInput) {
        String fileName = "credentials.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                String username = temp[0];
                String password = temp[1];
                if (emailInput.equals(username) && passwordInput.equals(password)) {
                    initializeGlobalVariables(temp);
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void initializeGlobalVariables(String[] credentials) {
        // [email, password, health, money, mana, damage]
        if (credentials.length == 6) {
            username = credentials[0];
            health = Integer.parseInt(credentials[2]);
            money = Integer.parseInt(credentials[3]);
            mana = Integer.parseInt(credentials[4]);
            damage = Integer.parseInt(credentials[5]);
        }
    }

    
    private void gamePage() {
    	System.out.println("  _      __    __                      ______        ________          _____");
        System.out.println(" | | /| / /__ / /______  __ _  ___    /_  __/__     /_  __/ /  ___    / ___/__ ___ _  ___");
        System.out.println(" | |/ |/ / -_) / __/ _ \\/  ' \\/ -_)    / / / _ \\     / / / _ \\/ -_)  / (_ / _ `/  ' \\/ -_)");
        System.out.println(" |__/|__/\\__/_/\\__/\\___/_/_/_/\\__/    /_/  \\___/    /_/ /_//_/\\__/   \\___/\\_,_/_/_/_/\\__/");
    	System.out.println("1. Start Game");
    	System.out.println("2. Game Guide");
    	System.out.println("3. Exit Game");
    	System.out.println(">> ");
    }
    
    private void gameGuide() {
    	System.out.println("  _____                  _____     _    __ ");
        System.out.println(" / ___/__ ___ _  ___    / ___/_ __(_)__/ /__");
        System.out.println("/ (_ / _ `/  ' \\/ -_)  / (_ / // / / _  / -_)");
        System.out.println("\\___/\\_,_/_/_/_/\\__/   \\___/\\_,_/_/\\_,_/\\__/");
        System.out.println("");
        System.out.println("Hello this is the case maker writing, this game is inspired by my favorite game of all time that is DOTA the game \nis really simple where you move inside the game using general controls. In the game you can collect coins as you move. \nYou can also meet enemies while going through the grass in the game. If you have killed an enemy you will be rewarded \nmoney that you can use again to buy the item\n");
        System.out.println("");
        System.out.println("Character Informations\n");
        System.out.println("Coin: 0");
        System.out.println("Grass: v | V");
        System.out.println("Character: X");
        System.out.println("Wall: #\n");
        System.out.println("");
        System.out.println("Keybind Information\n");
        System.out.println("w : Move character up");
        System.out.println("a : Move character left");
        System.out.println("s : Move character down");
        System.out.println("d : Move character right");
        System.out.println("i : Show all character's item");
        System.out.println("z : Shop Menu");
        System.out.println("e : Exit game and save your information\n");
        System.out.println("");
        System.out.println("Enter To Continue....");
        scan.nextLine();
    }
    
    void generateMap(char[][] map) {
    	
        for(int i=0;i<row;i+=3) {
            for(int j=0;j<col;j+=3) {
                int acak = rand.nextInt(7);
                char[][] temp=null;

                if(dempetGak(map, i, j)) {
                    temp=pattern7;
                }else {

                    if(acak==0) {
                        temp=pattern1;
                    } else if(acak==1) {
                        temp=pattern2;
                    } else if(acak==2) {
                        temp=pattern3;
                    } else if(acak==3) {
                        temp=pattern4;
                    }else if(acak==4) {
                        temp=pattern5;
                    }else if(acak==5) {
                        temp=pattern6;
                    }else if(acak==6) {
                        temp=pattern7;
                    } else {
                        temp=pattern7;
                    }
                }
                fillMap(map, i , j, temp);
            }
        }
        generateCoins();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void printCamera() {
    	
        int yAngle = yKamera / 2;
        int xAngle = xKamera / 2;
        int startY = Math.max(0, yPos - yAngle);
        int endY = Math.min(row - 1, yPos + yAngle);
        int startX = Math.max(0, xPos - xAngle);
        int endX = Math.min(col - 1, xPos + xAngle);
        

        for (int i = 0; i < xKamera + 2; i++) {
            System.out.print("#");
        }
        System.out.println();
        

        for (int i = startY; i <= endY; i++) {
            System.out.print("#");
            for (int j = startX; j <= endX; j++) {
                if (i == yPos && j == xPos) {
                    System.out.print("X");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.print("#");
            System.out.println();
            
        }
        
        //buat bawahny
        for (int i = 0; i < xKamera + 2; i++) {
            System.out.print("#");
        }
        System.out.println();
        System.out.println("Player Information "+username);
        System.out.println("Health      : "+health);
        System.out.println("Money       : "+money);
        System.out.println("Mana        : "+mana);
        System.out.println("Base Damage : "+damage);
    }



    public void move() {
    	
        String input;
        System.out.print(">> ");
        input = scan.nextLine();
        
        int shadowX = 0;
        int shadowY = 0;
        
        switch (input) {
            case "w":
                shadowY = -1;
                break;
            case "d":
                shadowX = 1;
                break;
            case "a":
                shadowX = -1;
                break;
            case "s":
                shadowY = 1;
                break;
            case "e":
                updatePlayerData("credentials.txt", username, health, money, mana,damage );
                exit=1;
                return;
            case "i":
            	itemReader.printBoughtList(boughtList);
            	System.out.println("Press Enter To Continue");
            	scan.nextLine();
                break;
            case "z":
            	int shopChoice;
//            	List<BoughtList> boughtList ;
//            	ItemReader bought=new ItemReader();
//            	ItemReader itemReader = new ItemReader();
            	do {
            		shopMenu();
            		shopChoice=scan.nextInt(); scan.nextLine();
            		
            		 int exitShop=0;
            	        try {
            	            if (shopChoice == 1) {
            	                items = itemReader.readItemsFromFile("item.txt");
            	                itemReader.printItems(items, money, "Offensive");
            	            } else if (shopChoice == 2) {
            	                items = itemReader.readItemsFromFile("item.txt");
            	                itemReader.printItems(items, money, "Defensive");
            	            } else if (shopChoice == 3) {
            	                items = itemReader.readItemsFromFile("item.txt");
            	                itemReader.printItems(items, money, "Spell");
            	            } else if (shopChoice == 4) {
            	                System.out.println("You Are Exiting Shop");
            	                exitShop=1;
            	            } else {
            	                System.out.println("Please input between 1-4");
            	            }
            	        } catch (IOException e) {
            	            System.err.println("Error reading items from file: " + e.getMessage());
            	        }            	        
            	        if(exitShop==1) {
            	        	return;
            	        }
            	        
						String inputID;
            	        System.out.println("INPUT ID : ");
            	        inputID=scan.nextLine();
            	        
            	        	try {
								boughtList = bought.shopView("item.txt", inputID);
								itemReader.printBoughtList(boughtList);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
            	       
//            	        
            	     
          
      
            		
            	}while(shopChoice!=4);
            	
            	
            	
            	
            	
            	
            	break;
            default:
                System.out.println("Invalid input! Please enter 'w', 'a', 's', or 'd'.");
                move(); 
                return;
        }
        
        int newYPos = yPos + shadowY;
        int newXPos = xPos + shadowX;
        
        if (newYPos >= 0 && newYPos < row && newXPos >= 0 && newXPos < col) {

            validMove = checkCol(newYPos, newXPos);
            
            if (validMove) {
                yPos = newYPos;
                xPos = newXPos;
            } else {
                System.out.println("Collision detected! Cannot move.");
            }
        } else {
            System.out.println("Cannot move outside the map!");
        }
    }

    
    public boolean checkCol(int y, int x) {
    	if(map[y][x] !=wall) {
    		if(map[y][x]==coin) {
    			System.out.println("YEY DPT KOIN");
    			money+=5;
    			map[y][x]=' ';
    			totalCoin+=5;
    		} else if(map[y][x]==grass || map[y][x]=='v') {
    			int chance = rand.nextInt(100)+1;
    			if(chance<=30) {



    				while (true) {
    		            String randomName = getRandomHeroName();
    		            String randomRole = getRandomRole();

    		            AgilityType agilityMonster = null;
    		            StrenghtType strengthMonster = null;
    		            IntelligenceType intelligenceMonster = null;
    		            UserTurn userTurn = new UserTurn(30, 300, 30);

    		            int siapaAttackDuluan = rand.nextInt(100) + 1;
    		            if (siapaAttackDuluan <= 50) {
    		                System.out.println("Player attacks first.\n");
    		            } else {
    		                System.out.println("Monster attacks first.\n");
    		            }

    		            while (userTurn.getHealth() > 0 && (agilityMonster == null || agilityMonster.getHealth() > 0) &&
    		                    (strengthMonster == null || strengthMonster.getHealth() > 0) &&
    		                    (intelligenceMonster == null || intelligenceMonster.getHealth() > 0)) {
    		                if (randomRole.equals("Strength")) {
    		                    if (strengthMonster == null) {
    		                        strengthMonster = new StrenghtType(randomName);
    		                    }
    		                    strengthMonster.monsterInformation();
    		                    userTurn.monsterInformation(username, money);
    		                    strengthMonster.attackPlayer(userTurn);
    		                    strengthMonster.monsterInformation();
    		                    userTurn.monsterInformation(username, money);
    		                    userTurn.attackStrenght(strengthMonster, itemReader, boughtList, items);
    		                   
    		                } else if (randomRole.equals("Agility")) {
    		                    if (agilityMonster == null) {
    		                        agilityMonster = new AgilityType(randomName);
    		                    }
    		                    agilityMonster.monsterInformation();
    		                    userTurn.monsterInformation(username, money);
    		                    agilityMonster.attackPlayer(userTurn);
    		                    agilityMonster.monsterInformation();
    		                    userTurn.monsterInformation(username, money);
    		                    userTurn.attackAgility(agilityMonster, itemReader, boughtList, items);
    		                   
    		                } else {
    		                    if (intelligenceMonster == null) {
    		                        intelligenceMonster = new IntelligenceType(randomName);
    		                    }
    		                    intelligenceMonster.monsterInformation();
    		                    userTurn.monsterInformation(username, money);
    		                    intelligenceMonster.attackPlayer(userTurn);
    		                    intelligenceMonster.monsterInformation();
    		                    userTurn.monsterInformation(username, money);
    		                    userTurn.attackIntellegence(intelligenceMonster, itemReader, boughtList, items);

    		                }
    		            }

    		            System.out.println("Player's health or all monsters' health has dropped to 0. Game over.");
    		            
    		            if (userTurn.getHealth() <= 0) {
    		                System.out.println("\n   ___  _        __");
    		                System.out.println("  / _ \\/ /_ ___  / /_");
    		                System.out.println(" / // / / -_) _ \\/ __/");
    		                System.out.println("/____/_/\\__/\\_,_/\\__/");
    		                System.out.println("\nYou have been killed\n");
    		                
    		                System.out.println("Resetting your player information...");
    		                userTurn.setHealth(300);
    		                money = 100;
    		                userTurn.monsterInformation(username, money);
    		            } else {
    		                System.out.println("\n   __  ___              __             ___  _        __");
    		                System.out.println("  /  |/  /__  ___  ___ / /____ ____   / _ \\/ /_ ___  / /_");
    		                System.out.println(" / /|_/ / _ \\/ _ \\/_-</ __/ -_) __/  / // / / -_) _ \\/ __/");
    		                System.out.println("/_/  /_/\\___/_//_/___/\\__/\\__/_/    /____/_/\\__/\\_,_/\\__/");
    		                System.out.println("\n"+ randomName+ " has been killed\n");
    		            }
    		            
    		            System.out.println("\nEnter To Continue....\n");
    		            scan.nextLine();
    		        }
    		    

    			    	  
    			       
    				
    		        
    			}else {
    				System.out.println("");
    			}
    			
    		}
    		return true;
    	}
    	return false;
    }

    
    public void fillMap(char[][] map, int row, int col, char[][] pattern) {
    	
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                map[row + i][col + j]=pattern[i][j];
            }
        }
    }
    
    public boolean dempetGak(char[][] map, int row, int col) {
    	
        int range = 4; 
        
        for(int i = Math.max(0, row - range); i < Math.min(map.length, row + range); i++) {
            for(int j = Math.max(0, col - range); j < Math.min(map[0].length, col + range); j++) {
                if(map[i][j] == 'v' || map[i][j] == 'V' || map[i][j] == '0' || map[i][j]=='#') {
                    return true;
                }
            }
        }
            return false;
    }
    
    public void generateCoins() {
    	
        int coinsGenerated = 0;

        while (coinsGenerated < 200) {
            int x = rand.nextInt(map.length);
            int y = rand.nextInt(map[0].length);

            if (map[x][y] == ' ') {
                map[x][y] = '0';
                coinsGenerated++;
            }
        }
    }
    
    
    public void shopMenu() {
    	System.out.println("1. Buy Offensive Item\n" + 
    			"2. Buy Defensive Item\n" + 
    			"3. Buy Spells Item\n" + 
    			"4. Exit\n");
    	System.out.print(">> ");
    }
    
    
    

    private static void printItemHeader() {
        System.out.println("=======================================================================================================");
        System.out.printf("|%-10s|%-30s|%-15s|%-10s|%-10s|%-12s|%-10s|%n", "ID", "Name", "Type", "Price", "Damage", "Max Use/Mana", "Use Left");
        System.out.println("=======================================================================================================");
    }

    public void printItems(List<BoughtList> items) {
        System.out.println("============================================================================================");
        System.out.printf("|%-10s|%-30s|%-15s|%-10s|%-10s|%-10s|\n", "ID", "Name", "Type", "Price", "Damage", "Max Use");
        System.out.println("============================================================================================");
        for (BoughtList boughtList : items) {
            System.out.printf("|%-10s|%-30s|%-15s|%-10d|%-10d|%-10d|\n",
                    boughtList.getId(), boughtList.getName(), boughtList.getType(), boughtList.getDamage(), boughtList.getPrice(), boughtList.getMaxUseMana(), boughtList.getUseLeft());
        }
        System.out.println("============================================================================================");
    }

    public void buyItem(String input, List<BoughtList> boughtList) {
        for (BoughtList item : boughtList) {
            if (item.getId().equals(input)) {
                System.out.println("You already have this item.");
                return;
            }
        }

        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("item.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 6 && parts[0].equals(input)) {
                    found = true;
                    String id = parts[0];
                    String name = parts[1];
                    String type = parts[2];
                    int price = Integer.parseInt(parts[3]);
                    int damage = Integer.parseInt(parts[4]);
                    int mana = Integer.parseInt(parts[5]);
                    int useleft;
                    if(type.equals("Spells")) {
                    	useleft=0;
                    }else {
                    	useleft=mana;
                    }
                    
                    boughtList.add(new BoughtList(id, name, type, price, damage, mana, useleft));
                    System.out.println("Bought The Item");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            System.out.println("Invalid Item ID. Please try again.");
        }
    }


    
    
    

    private static String getRandomHeroName() {
        List<String> heroNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("hero.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] names = line.split("#");
                for (String name : names) {
                    heroNames.add(name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        return heroNames.get(random.nextInt(heroNames.size()));
    }

    private static String getRandomRole() {
        String[] roles = {"Agility", "Intelligence", "Strength"};
        Random random = new Random();
        return roles[random.nextInt(roles.length)];
    }


    public static void updatePlayerData(String filename, String email, int newHealth, int newMoney, int newMana, int newDamage) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6 && parts[0].equals(email)) {
                    parts[2] = Integer.toString(newHealth);
                    parts[3] = Integer.toString(newMoney);
                    parts[4] = Integer.toString(newMana);
                    parts[5] = Integer.toString(newDamage);
                    line = String.join(",", parts);
                }
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
            
            System.out.println("   ____      _ __");
            System.out.println("  / __/_ __ (_) /_");
            System.out.println(" / _/ \\ \\ // / __/");
            System.out.println("/___//\\_\\/_/\\__/");
            System.out.println("\nSaving your progress....");
            System.out.println("Enter To Continue....");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
        } catch (IOException e) {
            System.out.println("An error occurred while updating player data: " + e.getMessage());
        }
    }


    



    public static void main(String[] args) {
        new Main();
    }
}

