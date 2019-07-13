package game;

import java.util.*;

import map.*;
import pet.*;
import java.io.*;

public class Data implements Serializable{
	private ArrayList<Player> players;
	private Player currentPlayer;
	
	
	
	private Pet currentPet;
	private int j, i, runs, currentRun, numOfCus, actionDone, stage, noGamesPlayed;
	private Store[] stores = new Store[7];
	
	/**
	 * This method returns stores.
	 * @return stores
	 */
	public Store[] getStores() {
		return stores;
	}
	
	/**
	 * This method set returned stores.
	 * @param stores
	 */
	public void setStores(Store[] stores) {
		this.stores = stores;
	}
	
	/**
	 * This method returns current player.
	 * @return currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * This method set returned current player.
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public int getNoGamesPlayed() {
		return noGamesPlayed;
	}
	public void setNoGamesPlayed(int noGamePlayed) {
		this.noGamesPlayed = noGamePlayed;
	}
	
	/**
	 * This method returns stage.
	 * @return stage
	 */
	public int getStage() {
		return stage;
	}
	
	/**
	 * This method set the returned stage.
	 * @param stage
	 */
	public void setStage(int stage) {
		this.stage = stage;
	}
	private Date date;
	private ArrayList<Pet> petsDone;
	
	
	public ArrayList<Pet> getPetsDone() {
		return petsDone;
	}
	public void setPetsDone(ArrayList<Pet> petsDone) {
		this.petsDone = petsDone;
	}
	public Data(){
		
	}
	
	/**
	 * This method returns done actions.
	 * @return actionDone
	 */
	public int getActionDone() {
		return actionDone;
	}
	
	/**
	 * This method stores done actions.
	 * @param actionDone
	 */
	public void storeActionDone(int actionDone) {
		this.actionDone = actionDone;
	}
	
	/**
	 * This method returns the date.
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * This method stores the returned date.
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * This method stores returned players
	 * @param players
	 */
	public void storePlayers(ArrayList<Player> players){
		this.players=players;
	}
	
	/**
	 * This method returns players.
	 * @return players
	 */
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	/**
	 * This method stores returned current pet.
	 * @param pet
	 */
	public void storeCurrentPet(Pet pet){
		this.currentPet=pet;
	}
	
	/**
	 * This method returns current pet.
	 * @return
	 */
	public Pet getCurrentPet(){
		return currentPet;
	}
	
	/**
	 * This method stores two integers.
	 * @param i
	 * @param j
	 */
	public void storeIAndJ(int i, int j){
		this.i=i;
		this.j=j;
	}
	
	/**
	 * This method returns two integers
	 * @return num
	 */
	public int[] getIAndJ(){
		int[] num = new int[] {i, j};
		return num;
	}
	public int getRuns(){
		return runs;
	}
	public void storeRuns(int runs){
		this.runs = runs;
	}
	public void storeCurrentRun(int run){
		this.currentRun=run;
	}
	public int getCurrentRun(){
		return currentRun;
	}
	public int getNumOfCus(){
		return numOfCus;
	}
	public void storeNumOfCus(int cus){
		this.numOfCus=cus;
	}
	

}
