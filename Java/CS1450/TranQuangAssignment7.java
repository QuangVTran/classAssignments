/*
 * Name: Quang Tran
 * CS1450
 * Due April 8th 2020
 * Assignment: 
 * 
 */


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


public class TranQuangAssignment7 {

	public static void main(String[] args) throws IOException {

		//Reading the file
		Player[] seats = new Player[25];

		File playerFile = new File("players.txt");

		Scanner readFile = new Scanner(playerFile);


		while(readFile.hasNext()) {

			String name = readFile.next();

			int rankingNumber = readFile.nextInt();

			int seatNumber = readFile.nextInt();

			seats[seatNumber] = new Player(name, rankingNumber, seatNumber);


		}//while

		readFile.close();

		EscapeGameController myEscapeGameController = new EscapeGameController();

		EscapeGame myEscapeGame = new EscapeGame();

		myEscapeGameController.movePlayerIntoEscapeGame(seats, myEscapeGame);

		myEscapeGameController.simulateGame(myEscapeGame);

	}

}

class Player implements Comparable<Player>{
	private String name;
	private int ranking;
	private int seat;
	private int score;

	public Player(String name, int ranking, int seat) {
		this.name = name;
		this.ranking = ranking;
		this.seat = seat;
		this.score = 0;

	}

	public String getName() {
		return name;
	}

	public int getRanking() {
		return ranking;
	}

	public int getSeat() {
		return seat;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Player otherPlayer) {

		if(this.score < otherPlayer.score) {
			return -1;
		}

		else if (this.score > otherPlayer.score) {
			return 1;
		}

		else{
			return 0 ;
		}

	}

}

class EscapeRoom{

	private int hash(String key) {
		int hash = 0;

		for (int i = 0; i < key.length(); i++) {
			hash += key.charAt(i);
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}

		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 15);

		return Math.abs(hash);	
	}//hash

	public int tryToEscape(String playerName, int playerRanking) {
		String key = playerName + playerRanking;

		int score = hash(key) % (101) ;

		return score;

	}

}
class EscapeGame{

	private Queue <Player> waitingQueue = new LinkedList<>();

	private PriorityQueue resultsQueue = new PriorityQueue();	

	private EscapeRoom escapeRoom = new EscapeRoom();

	public EscapeGame() {
		//allocate memory for 3 queues
		resultsQueue = new PriorityQueue();

		escapeRoom = new EscapeRoom();

	}

	public boolean isWaitingQueueEmpty() {
		if( waitingQueue.isEmpty() ) {
			return true;
		}
		else {
			return false;
		}
	}

	public void addPlayerToWaitingQueue(Player player) {
		waitingQueue.offer(player);
	}

	public Player removePlayerFromWaitingQueue() {
		Player removedPlayer = waitingQueue.remove();
		return removedPlayer;
	}

	public boolean isResultsQueueEmpty() {
		return resultsQueue.isEmpty();
	}

	public void addPlayerToResultsQueue(Player player) {
		resultsQueue.offer(player);
	}

	public Player removePlayerFromResultsQueue() {
		Player removedPlayer = resultsQueue.remove();
		return removedPlayer;
	}	

	public Player peekResultsQueue() {
		Player peekedPlayer = resultsQueue.peek();
		return peekedPlayer;
	}

	public int tryToEscape(String playerName,int playerRanking) {
		int score = escapeRoom.tryToEscape(playerName, playerRanking);
		return score;
	}

}

class EscapeGameController{
	public void movePlayerIntoEscapeGame(Player[] seats,EscapeGame escapeGame) {

		int i = 0;

		System.out.println("Controller: Moving players from outside seats into escape game\n");

		while(i < seats.length){

			if(seats[i] != null) {

				escapeGame.addPlayerToWaitingQueue(seats[i]);
				System.out.println("Moved into escape Game " + " " + seats[i].getName() + " " + " from outside seat "+ seats[i].getSeat() );
				i++;

			}

			else {
				i++;
			}

		}

	}

	public void simulateGame (EscapeGame escapeGame) {

		System.out.println("Controller: Starting Escape Game - moving players in line into escape room: ");
		System.out.println("\n=============================================================================\n");
		System.out.println("Players \t Score \t Current Leader");
		System.out.println("\n=============================================================================\n");


		int highestScore = 0;

		String highestScorePlayer = "";

		int size = 10;

		int counter = 0;

		Player playersWhoHavePlayed [] = new Player[size];

		while(escapeGame.isWaitingQueueEmpty() == false) {
			Player nextPlayer = escapeGame.removePlayerFromWaitingQueue();

			String playerName = nextPlayer.getName();

			int playerRanking = nextPlayer.getRanking();

			escapeGame.tryToEscape(playerName, playerRanking);

			int score = escapeGame.tryToEscape(playerName, playerRanking);

			if(highestScore < score) {
				highestScore = score;
				highestScorePlayer = playerName;
			}



			System.out.println(playerName + "\t\t " + score + "\t\t " + highestScorePlayer);

			playersWhoHavePlayed[counter] = nextPlayer;

			counter++;



		}

		for(int i = 0 ; i < playersWhoHavePlayed.length ; i ++) {
			if(playersWhoHavePlayed[i] != null) {
				System.out.println(i);
				System.out.println(playersWhoHavePlayed[i].getName());
				escapeGame.addPlayerToResultsQueue(playersWhoHavePlayed[i]);
			}
		}



	}

	public void displayResults(EscapeGame escapeGame) {

	}
}


class PriorityQueue{
	private Player[] list;
	private int numPlayers; 


	public PriorityQueue() {
		list = new Player[30];
		this.numPlayers = 0;
	}

	public boolean isEmpty() {
		if(numPlayers == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public Player peek() {
		if(numPlayers == 0) {
			return null;
		}
		else {
			return list[numPlayers-1];
		}

	}

	public boolean offer(Player player) {


		if(numPlayers == 30 ) {
			return false;
		}
		else if(player == null) {
			return false;
		}
		else{
			//addPlayer
			list[numPlayers] = player;
			numPlayers++;
			//sortArray
			selectionSort(list,numPlayers);
			return true;
		}

	}

	public Player remove() {

		/*
		Player playerToRemove = list[numPlayers-1];
		list[list.length-1] = null;
		return playerToRemove;
*/
		
		Player playerRemove = list[numPlayers-1];
		list[numPlayers-1] = null;
		numPlayers --;
		return playerRemove;
		
	}

	private void selectionSort(Player[] list, int numPlayers) {	
		
		for (int i = 0 ; i < numPlayers-1; i ++) {

			Player smallest = list[i];
			int smallestIndex = i;

			if((list[i]) != null) { 

				for(int j = i + 1; j< numPlayers; j ++) {
					if(smallest.compareTo(list[j]) < 0 ) {
						smallest = list[j];
						smallestIndex = j;
					}
				}

				if(smallestIndex != i ) {
					list[smallestIndex] = list[i];
					list[i] = smallest;
				}

			}

		}

	}
}

