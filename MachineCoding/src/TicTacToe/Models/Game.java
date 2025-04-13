package TicTacToe.Models;

import TicTacToe.Exception.DuplicateSymbolException;
import TicTacToe.Exception.InvaliBotCountException;
import TicTacToe.Exception.InvalidBoardSizeException;
import TicTacToe.Exception.invalidNumberOfPlayersException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private Player winner;
    private List<Move> moves;
    private List<Board> boardStates;
    private WinningStrategy winningStrategy;

    public Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.gameStatus = GameStatus.InProgress;
        this.moves = new ArrayList<Move>();
        this.boardStates = new ArrayList<Board>();
        this.winningStrategy = winningStrategy;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public WinningStrategy getWinningStrategy() {
            return winningStrategy;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validateBotCount() throws InvaliBotCountException {
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.Bot)){
                    botCount++;
                }
            }
            if(botCount>1){
                throw new InvaliBotCountException("Bot count cannot be mre than One, Current Bot Count : " + botCount);
            }
        }
        public void validateBoardSize() throws InvalidBoardSizeException {
            if(dimension<3 || dimension>10){
                throw new InvalidBoardSizeException("Board Size should be greater than 3 and less than 10, Current Board Size : " + dimension);
            }
        }
        public void validatePlayerNumber() throws invalidNumberOfPlayersException {
            if(players.size() != (dimension-1)){
                throw new invalidNumberOfPlayersException("Numbers of Players is invalid, Current number of Players : " + players.size());
            }
        }
        public void validateDuplicateSymbols() throws DuplicateSymbolException {
            HashSet<Character> symbolSet = new HashSet<>();
            for(Player player : players){
                if(symbolSet.contains(player.getSymbol())){
                    throw new DuplicateSymbolException("All players should have unique symbol");
                }
                else{
                    symbolSet.add(player.getSymbol());
                }
            }
        }

        public void validate() throws invalidNumberOfPlayersException, InvalidBoardSizeException, DuplicateSymbolException, InvaliBotCountException {
            validateBoardSize();
            validateBotCount();
            validateDuplicateSymbols();
            validatePlayerNumber();
        }

        public Game build() throws DuplicateSymbolException, invalidNumberOfPlayersException, InvaliBotCountException, InvalidBoardSizeException {
            validate();
            return new Game(new Board(dimension), players, winningStrategy);
        }
    }
}
