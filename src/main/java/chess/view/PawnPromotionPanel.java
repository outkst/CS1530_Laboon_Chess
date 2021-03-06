package chess;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  // awt.* does not import Action or Event Listeners
import java.io.*;
import javax.imageio.*;

public class PawnPromotionPanel extends JPanel {

	private JButton queen;
	private JButton rook;
	private JButton knight;
	private JButton bishop;
	
	private JButton title;
	
	protected static String pawnPromotionSelection = "";
	
	//Variables to change the spacing of buttons and title
	private int topSpace = 50;
	private int buttonSpace = 10;

	private int titleTextSize = 48;
	private int buttonTextSize = 24;

	public PawnPromotionPanel() {
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		this.setBackground(Color.WHITE);

		//Add spacing from top of title and top of window
		this.add(Box.createRigidArea(new Dimension(0,topSpace)));

		title = new JButton("");
		//Add Title image here
		try {
			Image img = ImageIO.read(getClass().getResource("/PawnPromotion.png"));
			title.setIcon(new ImageIcon(img));
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			title.setBorder(null);
		} catch (Exception ex) {
			title = new JButton("Pawn Promotion");
			title.setOpaque(true);
			title.setBackground(Color.WHITE);
			title.setBorder(null);
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			//Size of title scales with size of font
			//title.setPreferredSize(new Dimension(500, 300));
			title.setFont(new Font("Arial", Font.BOLD, titleTextSize));
		}
		title.addActionListener(getFeature());
		this.add(title);

		
		//Add spacing between buttons
		this.add(Box.createRigidArea(new Dimension(0,buttonSpace)));

		
		//Add queen piece selection button
		queen = new JButton("");
		try{
			Image img = ImageIO.read(getClass().getResource("/SelectQueen.png"));
			queen.setIcon(new ImageIcon(img));
			queen.setBorder(null);
		} catch(Exception e){
			queen = new JButton("Queen");
			queen.setAlignmentX(Component.CENTER_ALIGNMENT);
			queen.setFont(new Font("Arial", Font.BOLD, buttonTextSize));
		}
		//Set an icon for queen
		queen.setAlignmentX(Component.CENTER_ALIGNMENT);
		queen.addActionListener(pickQueen());
		this.add(queen);

		
		//Add spacing between buttons
		this.add(Box.createRigidArea(new Dimension(0,buttonSpace)));

		
		//Add rook piece selection button
		rook = new JButton("");
		try{
			Image img = ImageIO.read(getClass().getResource("/SelectRook.png"));
			rook.setIcon(new ImageIcon(img));
			rook.setBorder(null);
		} catch(Exception e){
			rook = new JButton("Rook");
			rook.setAlignmentX(Component.CENTER_ALIGNMENT);
			rook.setFont(new Font("Arial", Font.BOLD, buttonTextSize));
		}
		//Set an icon for rook
		rook.setAlignmentX(Component.CENTER_ALIGNMENT);
		rook.addActionListener(pickRook());
		this.add(rook);

		
		//Add spacing between buttons
		this.add(Box.createRigidArea(new Dimension(0,buttonSpace)));
		
		
		//Add rook piece selection button
		knight = new JButton("");
		try{
			Image img = ImageIO.read(getClass().getResource("/SelectKnight.png"));
			knight.setIcon(new ImageIcon(img));
			knight.setBorder(null);
		} catch(Exception e){
			knight = new JButton("Knight");
			knight.setAlignmentX(Component.CENTER_ALIGNMENT);
			knight.setFont(new Font("Arial", Font.BOLD, buttonTextSize));
		}
		//Set an icon for knight
		knight.setAlignmentX(Component.CENTER_ALIGNMENT);
		knight.addActionListener(pickKnight());
		this.add(knight);

		
		//Add spacing between buttons
		this.add(Box.createRigidArea(new Dimension(0,buttonSpace)));
		
		
		//Add bishop piece selection button
		bishop = new JButton("");
		try{
			Image img = ImageIO.read(getClass().getResource("/SelectBishop.png"));
			bishop.setIcon(new ImageIcon(img));
			bishop.setBorder(null);
		} catch(Exception e){
			bishop = new JButton("Bishop");
			bishop.setAlignmentX(Component.CENTER_ALIGNMENT);
			bishop.setFont(new Font("Arial", Font.BOLD, buttonTextSize));
		}
		//Set an icon for bishop
		bishop.setAlignmentX(Component.CENTER_ALIGNMENT);
		bishop.addActionListener(pickBishop());
		this.add(bishop);
	}
	
	//TODO - Modify fen/send stockfish move of pawn promotion
	
	private ActionListener pickQueen() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get the position of the last moved pawn
				int x = BoardPanel.lastMovePiecePositionX;
				int y = BoardPanel.lastMovePiecePositionY;
				
				//Get current color's turn
				char turn = LaboonChess.getTurn();
				
				//If it was white who just promoted their pawn, then replace pawn with white queen
				if(turn == 'w') {
					//Change the piece from pawn to queen
					BoardPanel.my_storage.setSpace(x, y, 'Q');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "Q";
					System.out.println("Pawn Promoted to: White Queen");
				}
				//Else it was black, replace pawn with black queen
				else if(turn == 'b') {
					//Change the piece from pawn to queen
					BoardPanel.my_storage.setSpace(x, y, 'q');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "q";
					System.out.println("Pawn Promoted to: Black Queen");
				}
				
				//Dispose pawn promotion frame after user picks piece
				JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(queen.getParent());
				dialog.dispose();
			}
		};
		return action;
	}

	private ActionListener pickRook() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get the position of the last moved pawn
				int x = BoardPanel.lastMovePiecePositionX;
				int y = BoardPanel.lastMovePiecePositionY;
				
				//Get current color's turn
				char turn = LaboonChess.getTurn();
				
				//If it was white who just promoted their pawn, then replace pawn with white rook
				if(turn == 'w') {
					//Change the piece from pawn to rook
					BoardPanel.my_storage.setSpace(x, y, 'R');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "R";
					System.out.println("Pawn Promoted to: White Rook");
				}
				//Else it was black, replace pawn with black rook
				else if(turn == 'b') {
					//Change the piece from pawn to rook
					BoardPanel.my_storage.setSpace(x, y, 'r');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "r";
					System.out.println("Pawn Promoted to: Black Rook");
				}

				//Dispose pawn promotion frame after user picks piece
				JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(rook.getParent());
				dialog.dispose();
			}
		};
		return action;
	}
	
	private ActionListener pickKnight() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get the position of the last moved pawn
				int x = BoardPanel.lastMovePiecePositionX;
				int y = BoardPanel.lastMovePiecePositionY;
				
				//Get current color's turn
				char turn = LaboonChess.getTurn();
				
				//If it was white who just promoted their pawn, then replace pawn with white knight
				if(turn == 'w') {
					//Change the piece from pawn to knight
					BoardPanel.my_storage.setSpace(x, y, 'N');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "N";
					System.out.println("Pawn Promoted to: White Knight");
				}
				//Else it was black, replace pawn with black knight
				else if(turn == 'b') {
					//Change the piece from pawn to knight
					BoardPanel.my_storage.setSpace(x, y, 'n');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "n";
					System.out.println("Pawn Promoted to: Black Knight");
				}

				//Dispose pawn promotion frame after user picks piece
				JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(knight.getParent());
				dialog.dispose();
			}
		};
		return action;
	}
	
	private ActionListener pickBishop() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get the position of the last moved pawn
				int x = BoardPanel.lastMovePiecePositionX;
				int y = BoardPanel.lastMovePiecePositionY;
				
				//Get current color's turn
				char turn = LaboonChess.getTurn();
				
				//If it was white who just promoted their pawn, then replace pawn with white bishop
				if(turn == 'w') {
					//Change the piece from pawn to bishop
					BoardPanel.my_storage.setSpace(x, y, 'B');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "B";
					System.out.println("Pawn Promoted to: White Bishop");
				}
				//Else it was black, replace pawn with black bishop
				else if(turn == 'b') {
					//Change the piece from pawn to bishop
					BoardPanel.my_storage.setSpace(x, y, 'b');
					BoardPanel tempBoardPanel = ConsoleGraphics.board;
					tempBoardPanel.setPieces();
					ConsoleGraphics.board = tempBoardPanel;
					
					pawnPromotionSelection = "b";
					System.out.println("Pawn Promoted to: Black Bishop");
				}

				//Dispose pawn promotion frame after user picks piece
				JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(bishop.getParent());
				dialog.dispose();
			}
		};
		return action;
	}

	private ActionListener getFeature() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Placeholder for when we add functionality

			}
		};
		return action;
	}
}
